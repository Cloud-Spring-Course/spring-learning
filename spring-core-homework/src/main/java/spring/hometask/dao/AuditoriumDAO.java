package spring.hometask.dao;

import com.sun.istack.internal.NotNull;
import spring.hometask.domain.Auditorium;

public interface AuditoriumDAO extends DAO<Auditorium> {

    Auditorium getByName(@NotNull String name);
}