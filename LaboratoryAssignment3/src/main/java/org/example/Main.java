package org.example;

import model.User;
import repository.UserRepository;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        User newUser = new User(1, "john_doe", "secret123");
        userRepository.addUser(newUser);
        System.out.println("Added new user: " + newUser.getUsername() + "\n");

        User newUser2 = new User(2, "john_doe_2", "secretPassword");
        userRepository.addUser(newUser2);
        userRepository.addUser(newUser2);
        System.out.println("Added new user: " + newUser2.getUsername() + "\n");

        User newUser3 = new User();
        newUser3.setUsername("jon_doe_3");
        newUser3.setPassword("secretPassword");
        userRepository.addUser(newUser3);
        List<User> users = userRepository.getUsersByUsername("john");
        System.out.println("Users matching 'john':");
        for (User user : users) {
            System.out.println(user);
        }

        System.out.println("\n");
        if (!users.isEmpty()) {
            User userToUpdate = users.get(0);
            userRepository.updateUserPassword(userToUpdate.getIDUser(), "newSecret456");
            System.out.println("Updated password for user: " + userToUpdate.getUsername());
        }
    }
}