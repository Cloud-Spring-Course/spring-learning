package spring.hometask.service.impl;

import spring.hometask.dao.UserDAO;
import spring.hometask.domain.User;
import spring.hometask.service.UserService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class UserServiceImpl implements UserService {

    protected UserDAO userDAO;

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        return userDAO.getUserByEmail(email);
    }

    @Override
    public void save(@Nonnull User object) {
        userDAO.saveOrUpdate(object);
    }

    @Override
    public void remove(@Nonnull User object) {
        userDAO.remove(object);
    }

    @Nullable
    @Override
    public User getByID(long id) {
        return userDAO.getById(id);
    }

    @Nonnull
    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}