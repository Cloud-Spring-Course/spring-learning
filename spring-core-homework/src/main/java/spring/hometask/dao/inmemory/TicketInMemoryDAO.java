package spring.hometask.dao.inmemory;

import spring.hometask.dao.TicketDAO;
import spring.hometask.domain.Event;
import spring.hometask.domain.Ticket;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TicketInMemoryDAO extends AbstractInMemoryDAO<Ticket> implements TicketDAO {

    @Override
    public Set<Ticket> getPurchased(Event event, LocalDateTime dateTime) {
        return getTicketsForEventAndDate(event, dateTime)
                .filter(ticket -> ticket.getUser() != null)
                .collect(Collectors.toSet());
    }

    protected Stream<Ticket> getTicketsForEventAndDate(Event event, LocalDateTime dateTime) {
        return data.values().stream()
                .filter(ticket -> ticket.getEvent().equals(event))
                .filter(ticket -> ticket.getDateTime().equals(dateTime));
    }
}