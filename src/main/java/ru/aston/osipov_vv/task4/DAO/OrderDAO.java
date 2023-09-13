package ru.aston.osipov_vv.task4.DAO;

import ru.aston.osipov_vv.task4.Connector;
import ru.aston.osipov_vv.task4.Entities.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements EntityDAO<Order> {

    @Override
    public List<Order> findAll() {
        List<Order> res = new ArrayList<>();
        try {
            Connection connection = Connector.connect();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from orders");
            while (rs.next()) {
                Order temp = new Order();
                temp.setId(rs.getInt("id"));
                temp.setDescription(rs.getString("description"));
                temp.setTotal(rs.getDouble("total"));
                res.add(temp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public Order findById(int id) {
        Order res = new Order();
        try {
            Connection connection = Connector.connect();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from orders where id=" + id);

            res.setId(rs.getInt("id"));
            res.setDescription(rs.getString("description"));
            res.setTotal(rs.getDouble("total"));

            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean save(Order order) {
        String query = "insert into orders(description, total) values (?, ?);";
        try {
            Connection c = Connector.connect();
            PreparedStatement st = c.prepareStatement(query);

            st.setString(1, order.getDescription());
            st.setDouble(2, order.getTotal());

            return st.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Order update(Order order) {
        String query = "update orders set description=?, total=? where id=?;";
        try {
            Connection c = Connector.connect();
            PreparedStatement st = c.prepareStatement(query);

            st.setString(1, order.getDescription());
            st.setDouble(2, order.getTotal());

            if (st.executeUpdate() > 0)
                return findById(order.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Order();
    }

    @Override
    public boolean delete(int id) {
        String query = "delete from orders where id=?;";
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

}
