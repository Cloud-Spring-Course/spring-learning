package spring.hometask.dao.inmemory;

import spring.hometask.dao.UserDAO;
import spring.hometask.domain.User;

public class UserInMemoryDAO extends AbstractInMemoryDAO<User> implements UserDAO {

    @Override
    public User getUserByEmail(String email) {
        return data.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst().get();
    }
}