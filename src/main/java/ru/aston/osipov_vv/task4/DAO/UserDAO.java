package ru.aston.osipov_vv.task4.DAO;

import ru.aston.osipov_vv.task4.Connector;
import ru.aston.osipov_vv.task4.Entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements EntityDAO<User> {

    @Override
    public List<User> findAll() {
        List<User> res = new ArrayList<>();
        try {
            Connection connection = Connector.connect();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from users");
            while (rs.next()) {
                User temp = new User();
                temp.setId(rs.getInt("id"));
                temp.setFirstName(rs.getString("first_name"));
                temp.setLastName(rs.getString("last_name"));
                temp.setPhoneNumber(rs.getString("phone_number"));
                temp.setEmail(rs.getString("email"));
                temp.setOrderId(rs.getInt("order_id"));
                res.add(temp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public User findById(int id) {
        User res = new User();
        try {
            Connection connection = Connector.connect();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from users where id=" + id);

            res.setId(rs.getInt("id"));
            res.setFirstName(rs.getString("first_name"));
            res.setLastName(rs.getString("last_name"));
            res.setPhoneNumber(rs.getString("phone_number"));
            res.setEmail(rs.getString("email"));
            res.setOrderId(rs.getInt("order_id"));

            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean save(User user) {
        String query = "insert into users" +
                "(first_name, last_name, phone_number, email, order_id) " +
                "values (?, ?, ?, ?, ?);";
        try {
            Connection c = Connector.connect();
            PreparedStatement st = c.prepareStatement(query);

            st.setString(1, user.getFirstName());
            st.setString(2, user.getLastName());
            st.setString(3, user.getPhoneNumber());
            st.setString(4, user.getEmail());
            st.setInt(5, user.getOrderId());

            return st.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User update(User user) {
        String query = "update users set first_name=?, last_name=?, phone_number=?, email=?, order_id=? where id=?;";
        try {
            Connection c = Connector.connect();
            PreparedStatement st = c.prepareStatement(query);

            st.setString(1, user.getFirstName());
            st.setString(2, user.getLastName());
            st.setString(3, user.getPhoneNumber());
            st.setString(4, user.getEmail());
            st.setInt(5, user.getOrderId());
            st.setInt(6, user.getId());

            if (st.executeUpdate() > 0)
                return findById(user.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new User();
    }

    @Override
    public boolean delete(int id) {
        String query = "delete from users where id=?;";
        try {
            Connection c = Connector.connect();
            PreparedStatement st = c.prepareStatement(query);
            st.setInt(1, id);

            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<String> joinUsersWithOrders() {
        List<String> res = new ArrayList<>();
        String query = "select users.last_name, orders.description from users inner join orders on users.order_id = orders.id;";
        try {
            Connection c = Connector.connect();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
                res.add("User's last name: " + rs.getString(1) +
                        ", Order's description: " + rs.getString(2));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
