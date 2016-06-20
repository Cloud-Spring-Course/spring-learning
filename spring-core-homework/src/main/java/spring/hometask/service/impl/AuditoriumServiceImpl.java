package spring.hometask.service.impl;

import spring.hometask.dao.AuditoriumDAO;
import spring.hometask.domain.Auditorium;
import spring.hometask.service.AuditoriumService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class AuditoriumServiceImpl implements AuditoriumService {

    protected AuditoriumDAO auditoriumDAO;

    @Override
    public void save(@Nonnull Auditorium object) {
        auditoriumDAO.saveOrUpdate(object);
    }

    @Override
    public void remove(@Nonnull Auditorium object) {
        auditoriumDAO.remove(object);
    }

    @Nullable
    @Override
    public Auditorium getByID(long id) {
        return auditoriumDAO.getById(id);
    }

    @Nonnull
    @Override
    public List<Auditorium> getAll() {
        return auditoriumDAO.getAll();
    }

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        return auditoriumDAO.getByName(name);
    }

    public void setAuditoriumDAO(AuditoriumDAO auditoriumDAO) {
        this.auditoriumDAO = auditoriumDAO;
    }
}