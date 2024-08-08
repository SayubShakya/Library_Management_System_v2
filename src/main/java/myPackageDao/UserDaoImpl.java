package myPackageDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import myPackageutil.DBUtil;
import myPackageDao.file; // Ensure correct import

public class UserDaoImpl implements UserDao {

    @Override
    public boolean addUser(User user) {
        String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, file.hashPassword(user.getPassword())); // Hash password

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isValidUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, file.hashPassword(password)); // Hash password before checking
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(User user) {
        String query = "UPDATE users SET email = ?, password = ? WHERE username = ?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, file.hashPassword(user.getPassword())); // Hash new password
            preparedStatement.setString(3, user.getUsername());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ?";
        User user = new User();

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password")); // Store hashed password
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    // New method to change the user's password
    public boolean changeUserPassword(String username, String oldPassword, String newPassword) {
        String checkPasswordQuery = "SELECT password FROM users WHERE username = ?";
        String updatePasswordQuery = "UPDATE users SET password = ? WHERE username = ?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement checkStmt = connection.prepareStatement(checkPasswordQuery);
             PreparedStatement updateStmt = connection.prepareStatement(updatePasswordQuery)) {

            checkStmt.setString(1, username);
            ResultSet resultSet = checkStmt.executeQuery();

            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");

                // Check if old password matches
                if (file.hashPassword(oldPassword).equals(storedPassword)) {
                    updateStmt.setString(1, file.hashPassword(newPassword));
                    updateStmt.setString(2, username);

                    int rowsAffected = updateStmt.executeUpdate();
                    return rowsAffected > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // New method to update user profile
    public boolean updateUserProfile(String username, String email) {
        String query = "UPDATE users SET email = ? WHERE username = ?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, username);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
