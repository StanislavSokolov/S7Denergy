package org.example;


import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Person.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Person person0 = new Person("Hibernate0", 15, "email1@mail.ru", "SPb");
            Person person1 = new Person("Hibernate1", 16, "email2@mail.ru", "SPb");
            Person person2 = new Person("Hibernate2", 17, "email3@mail.ru", "SPb");
            session.save(person0);
            session.save(person1);
            session.save(person2);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
