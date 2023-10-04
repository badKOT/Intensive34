package ru.aston.osipov_vv.task9.single_table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.aston.osipov_vv.task9.single_table.models.Teacher;
import ru.aston.osipov_vv.task9.single_table.models.Person;
import ru.aston.osipov_vv.task9.single_table.models.Student;

public class Main {
    public static void main(String[] args) {
        // schema = task9/single_table
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Teacher.class);

        try (SessionFactory factory = configuration.buildSessionFactory();
             Session session = factory.openSession()) {
            session.beginTransaction();

//            Student st = new Student(1, "Thomas", 8);
//            session.persist(st);
//            Teacher teacher = new Teacher(2, "Amala", "Math");
//            session.persist(teacher);

            Person person = new Person(3, "Somebody");
            session.persist(person);

            session.getTransaction().commit();
        }
    }
}
