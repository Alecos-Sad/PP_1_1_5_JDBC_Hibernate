package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    private final SessionFactory sessionFactory;
    public UserDaoHibernateImpl() {
        sessionFactory = Util.getSession();
    }


    @Override
    public void createUsersTable() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("CREATE TABLE IF NOT EXISTS kata_test.users (" +
                "id bigint(20) NOT NULL AUTO_INCREMENT, " +
                "name varchar(50) DEFAULT NULL, " +
                "lastname varchar(255) DEFAULT NULL, " +
                "age int(11) DEFAULT NULL, " +
                "PRIMARY KEY (id))").addEntity(User.class).executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void dropUsersTable() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("DROP TABLE IF EXISTS kata_test.users").addEntity(User.class).executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(new User(name, lastName, age));
        session.getTransaction().commit();
    }

    @Override
    public void removeUserById(long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(session.get(User.class, id));
        session.getTransaction().commit();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<User> userList = session.createQuery("SELECT u FROM User u", User.class).getResultList();
        session.getTransaction().commit();
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("TRUNCATE TABLE kata_test.users").addEntity(User.class).executeUpdate();
        session.getTransaction().commit();
    }
}
