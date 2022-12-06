package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = Util.getSession();

        Session session = null;
        // === CREATE ===
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        User user = new User("Alex", "Sadovnick", (byte) 42);
        System.out.println(user);
        session.save(user);
        System.out.println(user);
        session.getTransaction().commit();

        sessionFactory.close();
    }
}
