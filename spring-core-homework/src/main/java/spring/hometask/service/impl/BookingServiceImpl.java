package spring.hometask.service.impl;

import spring.hometask.dao.TicketDAO;
import spring.hometask.domain.*;
import spring.hometask.service.BookingService;
import spring.hometask.service.DiscountService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {

    protected TicketDAO ticketDAO;
    protected DiscountService discountService;

    @Override
    public double getTicketsPrice(@Nonnull Event event, @Nonnull LocalDateTime dateTime, @Nullable User user, @Nonnull Set<Long> seats) {
        Set<Ticket> availableTickets = getTickets(event, dateTime, user, seats);

        double totalPrice = availableTickets.stream()
                .mapToDouble(ticket -> getPrice(ticket.getEvent(), dateTime, ticket.getSeat()))
                .sum();

        // Apply discount
        int discountPercent = discountService.getDiscount(user, event, dateTime, availableTickets.size());
        double discountValue = totalPrice / 100 * discountPercent;
        return totalPrice - discountValue;
    }

    @Override
    public Set<Ticket> getTickets(@Nonnull Event event, @Nonnull LocalDateTime dateTime, @Nullable User user, @Nonnull Set<Long> seats) {
        Set<Ticket> availableTicketsAtEventAndDate = getAvailableTickets(event, dateTime, user);

        return availableTicketsAtEventAndDate.stream()
                .filter(ticket -> seats.contains(ticket.getSeat()))
                .collect(Collectors.toSet());
    }

    @Override
    public void bookTickets(@Nonnull Set<Ticket> tickets) {
        for (Ticket ticket : tickets) {
            ticketDAO.saveOrUpdate(ticket);
        }
    }

    @Nonnull
    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime) {
        return ticketDAO.getPurchased(event, dateTime);
    }

    protected Set<Ticket> getAvailableTickets(Event event, LocalDateTime dateTime, User user) {
        Set<Ticket> purchasedTickets = ticketDAO.getPurchased(event, dateTime);

        List<Long> purchasedSeats = purchasedTickets.stream()
            .map(ticket -> ticket.getSeat())
            .collect(Collectors.toList());

        Auditorium auditorium = event.getAuditoriums().get(dateTime);

        Set<Long> availableSeats = auditorium.getAllSeats().stream()
                .filter(seat -> !purchasedSeats.contains(seat))
                .collect(Collectors.toSet());

        return availableSeats.stream()
                .map(seat -> new Ticket(user, event, dateTime, seat))
                .collect(Collectors.toSet());
    }

    protected double getPrice(Event event, LocalDateTime dateTime, long seat) {
        double resultPrice = event.getBasePrice();

        // Is VIP seat
        if (event.getAuditoriums().get(dateTime).getVipSeats().contains(seat)) {
            resultPrice = resultPrice * 2;
        }

        // Is featured event
        if (event.getRating() == EventRating.HIGH) {
            resultPrice = resultPrice * 1.2;
        }

        return resultPrice;
    }

    public void setTicketDAO(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }
}