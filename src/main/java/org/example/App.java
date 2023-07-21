package org.example;


import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Person.class).
                addAnnotatedClass(Item.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();


            Person person = session.get(Person.class, 2011);
            Item item = new Item("Brothers Karamazovs 2", person);

            person.setItems(new ArrayList<>(Collections.singletonList(item)));

            session.save(person);

            session.save(item);


//            Person person = new Person("Name", 30, "email@mail.ru", "Kudrovo");
//            Item item = new Item("Test cascading item", person);
//            person.setItems(new ArrayList<>(Collections.singletonList(item)));

//            List<Person> people = session.createQuery("FROM Person WHERE name LIKE 'T%'").getResultList();
//            session.createQuery("update Person set name = 'Test' WHERE age > 30").executeUpdate();
//            for (Person p : people) {
//                System.out.println(p.getName());
//            }
//            session.createQuery("delete from Person where age > 30").executeUpdate();


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
