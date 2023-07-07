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
//            Person person = session.get(Person.class, 10);
//            person.setName("Hiber");

//            session.delete(person);

            Person person1 = new Person("SAS", 12, "", "");
            session.save(person1);

            session.getTransaction().commit();

            System.out.println(person1.getId());
        } finally {
            sessionFactory.close();
        }

    }
}
