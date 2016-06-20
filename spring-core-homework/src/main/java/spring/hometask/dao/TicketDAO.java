package spring.hometask.dao;

import spring.hometask.domain.Event;
import spring.hometask.domain.Ticket;

import java.time.LocalDateTime;
import java.util.Set;

public interface TicketDAO extends DAO<Ticket> {

    Set<Ticket> getPurchased(Event event, LocalDateTime dateTime);
}