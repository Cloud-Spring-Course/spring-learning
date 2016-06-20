package spring.hometask.service.impl;

import spring.hometask.dao.EventDAO;
import spring.hometask.domain.Event;
import spring.hometask.service.EventService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.List;

public class EventServiceImpl implements EventService {

    protected EventDAO eventDAO;

    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        return eventDAO.getByName(name);
    }

    @Nonnull
    @Override
    public List<Event> getForDateRange(@Nonnull LocalDateTime from, @Nonnull LocalDateTime to) {
        return eventDAO.getByRange(from, to);
    }

    @Nonnull
    @Override
    public List<Event> getNextEvents(@Nonnull LocalDateTime to) {
        return eventDAO.getByRange(LocalDateTime.now(), to);
    }

    @Override
    public void save(@Nonnull Event object) {
        eventDAO.saveOrUpdate(object);
    }

    @Override
    public void remove(@Nonnull Event object) {
        eventDAO.remove(object);
    }

    @Nullable
    @Override
    public Event getByID(long id) {
        return eventDAO.getById(id);
    }

    @Nonnull
    @Override
    public List<Event> getAll() {
        return eventDAO.getAll();
    }

    public void setEventDAO(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }
}