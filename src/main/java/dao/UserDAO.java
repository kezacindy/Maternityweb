package dao;

import model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;

    public UserDAO() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cli_app", "root", "");
    }

    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO users (name, dob, email, gender, phone_number, province, title, district, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, user.getName());
        stmt.setDate(2, new java.sql.Date(user.getDob().getTime()));
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getGender());
        stmt.setString(5, user.getPhoneNumber());
        stmt.setString(6, user.getProvince());
        stmt.setString(7, user.getTitle());
        stmt.setString(8, user.getDistrict());
        stmt.setString(9, user.getPassword());
        stmt.executeUpdate();
        stmt.close();
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            User user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setName(rs.getString("name"));
            user.setDob(rs.getDate("dob"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setPhoneNumber(rs.getString("phone_number"));
            user.setProvince(rs.getString("province"));
            user.setTitle(rs.getString("title"));
            user.setDistrict(rs.getString("district"));
            user.setPassword(rs.getString("password"));
            users.add(user);
        }
        rs.close();
        stmt.close();
        return users;
    }

    public User getUser(int userId) throws SQLException {
        String query = "SELECT * FROM users WHERE user_id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();
        User user = null;
        if (rs.next()) {
            user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setName(rs.getString("name"));
            user.setDob(rs.getDate("dob"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setPhoneNumber(rs.getString("phone_number"));
            user.setProvince(rs.getString("province"));
            user.setTitle(rs.getString("title"));
            user.setDistrict(rs.getString("district"));
            user.setPassword(rs.getString("password"));
        }
        rs.close();
        stmt.close();
        return user;
    }

    public void updateUser(User user) throws SQLException {
        String query = "UPDATE users SET name = ?, dob = ?, email = ?, gender = ?, phone_number = ?, province = ?, title = ?, district = ?, password = ? WHERE user_id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, user.getName());
        stmt.setDate(2, new java.sql.Date(user.getDob().getTime()));
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getGender());
        stmt.setString(5, user.getPhoneNumber());
        stmt.setString(6, user.getProvince());
        stmt.setString(7, user.getTitle());
        stmt.setString(8, user.getDistrict());
        stmt.setString(9, user.getPassword());
        stmt.setInt(10, user.getUserId());
        stmt.executeUpdate();
        stmt.close();
    }

    public void deleteUser(int userId) throws SQLException {
        String query = "DELETE FROM users WHERE user_id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, userId);
        stmt.executeUpdate();
        stmt.close();
    }
}
