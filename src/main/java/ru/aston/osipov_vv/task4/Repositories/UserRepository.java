package ru.aston.osipov_vv.task4.Repositories;

import ru.aston.osipov_vv.task4.DAO.UserDAO;
import ru.aston.osipov_vv.task4.Entities.User;

import java.util.List;

public class UserRepository {
    private final UserDAO userDAO;

    public UserRepository(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public User findById(int id) {
        return userDAO.findById(id);
    }

    public boolean save(User user) {
        return userDAO.save(user);
    }

    public User update(User user) {
        return userDAO.update(user);
    }

    public boolean delete(int id) {
        return userDAO.delete(id);
    }

    public List<String> join() {
        return userDAO.joinUsersWithOrders();
    }
}
