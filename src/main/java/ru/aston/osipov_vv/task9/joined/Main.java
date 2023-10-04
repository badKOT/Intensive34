package ru.aston.osipov_vv.task9.joined;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.aston.osipov_vv.task9.joined.models.Person;
import ru.aston.osipov_vv.task9.joined.models.Student;
import ru.aston.osipov_vv.task9.joined.models.Teacher;

public class Main {
    public static void main(String[] args) {
        // schema = task9/joined
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Teacher.class);

        try (SessionFactory factory = configuration.buildSessionFactory();
             Session session = factory.openSession()) {
            session.beginTransaction();
//            Student student = new Student(1, "Thomas", 8);
//            Teacher teacher = new Teacher(2, "Amala", "Math");
            Person person = new Person(3, "Somebody");
//            session.persist(student);
//            session.persist(teacher);
            session.persist(person);
            session.getTransaction().commit();
        }
    }
}
