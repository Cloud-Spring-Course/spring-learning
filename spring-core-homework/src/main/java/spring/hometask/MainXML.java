package spring.hometask;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.hometask.dao.TicketDAO;
import spring.hometask.domain.*;
import spring.hometask.service.AuditoriumService;
import spring.hometask.service.BookingService;
import spring.hometask.service.EventService;
import spring.hometask.service.UserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class MainXML {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("xml/movie-theater-xml.xml");

        AuditoriumService auditoriumService = context.getBean(AuditoriumService.class);
        EventService eventService = context.getBean(EventService.class);
        UserService userService = context.getBean(UserService.class);
        BookingService bookingService = context.getBean(BookingService.class);
        TicketDAO ticketDAO = context.getBean(TicketDAO.class);

        // Fill data
        fillUsers(userService);
        fillAuditory(auditoriumService);
        fillEvent(eventService, auditoriumService);

        // Print all data
        printAllData(auditoriumService, eventService, userService, ticketDAO);

        // Work with services
        User user1 = userService.getUserByEmail("user1@gmail.com");
        System.out.println("User1 login");
        System.out.println(user1);

        System.out.println("User 1 searches for events");
        List<Event> events = eventService.getForDateRange(
                LocalDateTime.of(2016, 06, 4, 00, 00, 00),
                LocalDateTime.of(2016, 06, 6, 00, 00, 00));
        events.stream().forEach(System.out::println);

        System.out.println("User 1 checks price for 2 vip seats for event");
        Event event = events.get(0);
        LocalDateTime airDate = event.getAirDates().first();
        Set<Long> seats = new HashSet<>(Arrays.asList(1l, 2l));

        Set<Ticket> tickets = bookingService.getTickets(event, airDate, user1, seats);
        System.out.println("Tickets selected: ");
        tickets.stream().forEach(System.out::println);

        double price = bookingService.getTicketsPrice(event, event.getAirDates().first(), user1, seats);
        System.out.println(price + " is price for ticket to " + event + " date " + event.getAirDates().first());

        System.out.println("Purchased tickets");
        bookingService.getPurchasedTicketsForEvent(event, airDate).stream().forEach(System.out::println);

        System.out.println("User 1 books tickets");
        bookingService.bookTickets(tickets);

        System.out.println("Purchased tickets");
        bookingService.getPurchasedTicketsForEvent(event, airDate).stream().forEach(System.out::println);

        context.close();
    }

    public static void printAllData(AuditoriumService auditoriumService, EventService eventService,
            UserService userService, TicketDAO ticketDAO) {
        System.out.println("Users");
        userService.getAll().forEach(System.out::println);

        System.out.println("Auditory");
        auditoriumService.getAll().forEach(System.out::println);

        System.out.println("Events");
        eventService.getAll().forEach(System.out::println);

        System.out.println("Booked tickets");
        ticketDAO.getAll().stream().forEach(System.out::println);
    }

    public static void fillEvent(EventService eventService, AuditoriumService auditoriumService) {
        // Event 1
        Event event1 = new Event();
        event1.setName("Music concert");
        event1.setBasePrice(100);
        event1.setRating(EventRating.MID);

        LocalDateTime firstAir = LocalDateTime.of(2016, 06, 10, 18, 0);
        LocalDateTime secondAir = LocalDateTime.of(2016, 06, 20, 18, 0);
        event1.setAirDates(new TreeSet<>(Arrays.asList(firstAir, secondAir)));

        TreeMap<LocalDateTime, Auditorium> auditoriums = new TreeMap<>();
        auditoriums.put(firstAir, auditoriumService.getByName("aud1"));
        auditoriums.put(secondAir, auditoriumService.getByName("aud2"));
        event1.setAuditoriums(auditoriums);

        eventService.save(event1);

        // Event 2
        Event event2 = new Event();
        event2.setName("Broadway show");
        event2.setBasePrice(500);
        event2.setRating(EventRating.HIGH);

        firstAir = LocalDateTime.of(2016, 06, 5, 12, 0);
        secondAir = LocalDateTime.of(2016, 06, 15, 12, 0);
        event2.setAirDates(new TreeSet<>(Arrays.asList(firstAir, secondAir)));

        auditoriums = new TreeMap<>();
        auditoriums.put(firstAir, auditoriumService.getByName("aud1"));
        auditoriums.put(secondAir, auditoriumService.getByName("aud2"));
        event2.setAuditoriums(auditoriums);

        eventService.save(event2);
    }

    public static void fillAuditory(AuditoriumService auditoriumService) {
        Auditorium aud1 = new Auditorium();
        aud1.setName("aud1");
        aud1.setNumberOfSeats(10);
        aud1.setVipSeats(new HashSet<>(Arrays.asList(1l,2l,3l,4l)));

        auditoriumService.save(aud1);

        Auditorium aud2 = new Auditorium();
        aud2.setName("aud2");
        aud2.setNumberOfSeats(6);
        aud2.setVipSeats(new HashSet<>(Arrays.asList(1l,2l)));

        auditoriumService.save(aud2);
    }

    public static void fillUsers(UserService userService) {
        User user1 = new User();
        user1.setEmail("user1@gmail.com");
        user1.setFirstName("Alexander");
        user1.setLastName("Ivanov");
        user1.setBirthday(LocalDate.of(1975, 06, 11));
        userService.save(user1);

        User user2 = new User();
        user2.setEmail("user2@gmail.com");
        user2.setFirstName("Vladimir");
        user2.setLastName("Petrov");
        user2.setBirthday(LocalDate.of(1980, 06, 22));
        userService.save(user2);
    }
}