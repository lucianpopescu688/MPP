package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.User;
import model.DatabaseConnection;

public class UserRepository {
    private Connection connection;

    public UserRepository() {
        connection = DatabaseConnection.getConnection();
    }

    private boolean userExists(int IDUser, String username) {
        String sql = "SELECT 1 FROM users WHERE IDUser = ? OR username = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, IDUser);
            pstmt.setString(2, username);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addUser(User user) {
        if (userExists(user.getIDUser(), user.getUsername())) {
            System.out.println("User with ID " + user.getIDUser() + " or username " + user.getUsername() + " already exists.");
            return false;
        }
        String sql = "INSERT INTO users(IDUser, username, password) VALUES(?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, user.getIDUser());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());
            pstmt.executeUpdate();
            System.out.println("Added user: " + user.getUsername());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void updateUserPassword(int idUser, String newPassword) {
        String sql = "UPDATE users SET password = ? WHERE IDUser = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, newPassword);
            pstmt.setInt(2, idUser);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getUsersByUsername(String usernameCriteria) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE username LIKE ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "%" + usernameCriteria + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User(
                        rs.getInt("IDUser"),
                        rs.getString("username"),
                        rs.getString("password")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}