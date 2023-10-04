package ru.aston.osipov_vv.task9.superclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.aston.osipov_vv.task9.superclass.models.*;

public class Main {
    public static void main(String[] args) {
        // schema = task9/superclass
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Teacher.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Student st = new Student(1, "Thomas", 8);
            session.persist(st);
            Teacher t = new Teacher(2, "Amala", "Math");
            session.persist(t);

            session.getTransaction().commit();
        }
    }
}

// session.persist()
// session.get(Person.class, id);
// session.remove()
// session.createQuery()
// session.detach() -- приостановить отслеживание изменений
// session.merge() -- возобновить отслеживание изменений
/*
@JoinTable(
        name = "Actor_Movie",
        joinColumns = @JoinColumn(name = "actor_id"),
        inverseJoinColumns = @JoinColumn(name = "movie_id"))

 */
