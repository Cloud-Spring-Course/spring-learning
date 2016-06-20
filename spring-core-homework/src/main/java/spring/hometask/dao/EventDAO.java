package spring.hometask.dao;

import com.sun.istack.internal.NotNull;
import spring.hometask.domain.Event;

import java.time.LocalDateTime;
import java.util.List;

public interface EventDAO extends DAO<Event> {

    Event getByName(@NotNull String name);

    List<Event> getByRange(LocalDateTime from, LocalDateTime to);
}