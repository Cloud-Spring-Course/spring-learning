package spring.hometask.dao.inmemory;

import com.sun.istack.internal.NotNull;
import spring.hometask.dao.EventDAO;
import spring.hometask.domain.Event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class EventInMemoryDAO extends AbstractInMemoryDAO<Event> implements EventDAO {

    @Override
    public Event getByName(@NotNull String name) {
        return data.values().stream()
                .filter(event -> event.getName().equals(name))
                .findFirst().get();
    }

    @Override
    public List<Event> getByRange(LocalDateTime from, LocalDateTime to) {
        return data.values().stream()
            .filter(event -> event.getAirDates().stream()
                                .filter(date -> date.isAfter(from))
                                .filter(date -> date.isBefore(to))
                                .findAny().isPresent())
                .collect(Collectors.toList());
    }
}