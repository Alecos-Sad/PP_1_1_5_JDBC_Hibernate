package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/kata_test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()){
                System.out.println("Соединение с БД установленно!");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка соединения!");
        }
        return connection;
    }

    public static SessionFactory getSession(){
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        return sessionFactory;
    }
}
