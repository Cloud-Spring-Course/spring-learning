package spring.hometask.service;

import spring.hometask.domain.DomainObject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public interface AbstractDomainObjectService<T extends DomainObject> {

    void save(@Nonnull T object);

    void remove(@Nonnull T object);

    @Nullable T getByID(long id);

    @Nonnull List<T> getAll();
}