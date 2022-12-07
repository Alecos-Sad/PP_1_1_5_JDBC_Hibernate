package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Alex", "SadovNick", (byte) 42);
        userService.saveUser("KAtya", "SadovNick", (byte) 7);
        System.out.println("Add 2 users");
        userService.getAllUsers().forEach(System.out::println);
        System.out.println("Remove id 1");
        userService.removeUserById(1);
        userService.getAllUsers().forEach(System.out::println);
        System.out.println("table truncate");
        userService.cleanUsersTable();
        userService.getAllUsers().forEach(System.out::println);
        System.out.println("table delete");
        userService.dropUsersTable();
    }
}
