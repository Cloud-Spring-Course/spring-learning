package spring.hometask.dao;

import spring.hometask.domain.User;

public interface UserDAO extends DAO<User> {

    User getUserByEmail(String email);
}
