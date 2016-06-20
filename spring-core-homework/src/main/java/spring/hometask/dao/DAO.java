package spring.hometask.dao;

import com.sun.istack.internal.NotNull;
import spring.hometask.domain.DomainObject;

import javax.annotation.Nullable;
import java.util.List;

public interface DAO<T extends DomainObject> {

    @Nullable T getById(long id);

    void saveOrUpdate(@NotNull T object);

    void remove(@NotNull T object);

    @NotNull List<T> getAll();
}
