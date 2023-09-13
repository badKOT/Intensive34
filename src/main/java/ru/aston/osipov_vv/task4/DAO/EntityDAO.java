package ru.aston.osipov_vv.task4.DAO;

import java.util.List;

public interface EntityDAO<T> {
    List<T> findAll();
    T findById(int id);
    boolean save(T t);
    T update(T t);
    boolean delete(int id);
}
