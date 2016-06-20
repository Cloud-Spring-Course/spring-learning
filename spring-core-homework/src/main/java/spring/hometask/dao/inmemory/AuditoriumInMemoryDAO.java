package spring.hometask.dao.inmemory;

import com.sun.istack.internal.NotNull;
import spring.hometask.dao.AuditoriumDAO;
import spring.hometask.domain.Auditorium;

public class AuditoriumInMemoryDAO extends AbstractInMemoryDAO<Auditorium> implements AuditoriumDAO {

    @Override
    public Auditorium getByName(@NotNull String name) {
        return data.values().stream()
                .filter(auditorium -> auditorium.getName().equals(name))
                .findFirst().get();
    }
}
