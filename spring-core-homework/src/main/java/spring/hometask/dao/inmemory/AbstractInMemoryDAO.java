package spring.hometask.dao.inmemory;

import com.sun.istack.internal.NotNull;
import spring.hometask.dao.DAO;
import spring.hometask.domain.DomainObject;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class AbstractInMemoryDAO<T extends DomainObject> implements DAO<T> {

    protected Map<Long, T> data = new ConcurrentHashMap<>();
    protected AtomicLong ids = new AtomicLong(0);

    @Nullable
    @Override
    public T getById(long id) {
        return data.get(id);
    }

    @Override
    public void saveOrUpdate(@NotNull T object) {
        if (object.getId() == null) {
            object.setId(ids.incrementAndGet());
        }
        data.put(object.getId(), object);
    }

    @Override
    public void remove(@NotNull T object) {
        data.remove(object.getId());
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(data.values());
    }
}