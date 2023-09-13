package ru.aston.osipov_vv.task5.DAO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aston.osipov_vv.task4.DAO.UserDAO;
import ru.aston.osipov_vv.task4.Entities.User;
import ru.aston.osipov_vv.task4.Repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class UserDAOTest {
    @Mock
    UserDAO userDAO;

    @InjectMocks
    UserRepository userRepository;

    @Test
    void findAll() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Thomas", "Frank",
                "89012345678", "thomas@gmail.com", 1));
        userList.add(new User(2, "Elizabeth", "Hudson",
                "89070770707", "liz@gmail.com", 2));

        Mockito.when(userDAO.findAll()).thenReturn(userList);
        Assertions.assertEquals(2, userRepository.findAll().size());
    }

    @Test
    void findById() {
        User user = new User(1, "Thomas", "Frank",
                "89012345678", "thomas@gmail.com", 1);
        Mockito.when(userDAO.findById(user.getId())).thenReturn(user);
        Assertions.assertEquals("Frank",
                userRepository.findById(user.getId()).getLastName());
    }

    @Test
    void save() {
        User user = new User(1, "Thomas", "Frank",
                "89012345678", "thomas@gmail.com", 1);
        Mockito.when(userDAO.save(user)).thenReturn(true);
        Assertions.assertTrue(userRepository.save(user));
    }

    @Test
    void update() {
        User user = new User(1, "Thomas", "Frank",
                "89012345678", "thomas@gmail.com", 1);
        Mockito.when(userDAO.update(user)).thenReturn(user);
        user.setPhoneNumber("89010110101");
        Assertions.assertEquals("89010110101", userRepository.update(user).getPhoneNumber());
    }

    @Test
    void delete() {
        int testId = 8;
        Mockito.when(userDAO.delete(testId)).thenReturn(true);
        Assertions.assertTrue(userRepository.delete(testId));
    }

    @Test
    void joinUsersWithOrders() {
        List<String> listJoin = new ArrayList<>();
        listJoin.add("User: " + "Thomas"
                + ", Order description: " + "Some stuff from target");
        listJoin.add("User: " + "Elizabeth"
                + ", Order description: " + "Some clothes from SHEIN");
        Mockito.when(userDAO.joinUsersWithOrders()).thenReturn(listJoin);
        Assertions.assertEquals(listJoin.get(0), userRepository.join().get(0));
    }
}