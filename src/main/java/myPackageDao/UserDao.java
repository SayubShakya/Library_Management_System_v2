package myPackageDao;

public interface UserDao {
    boolean isValidUser(String username, String password);
    boolean addUser(User user);
    boolean updateUser(User user);
    User getUserByUsername(String username);
    boolean changeUserPassword(String username, String oldPassword, String newPassword);
    boolean updateUserProfile(String username, String email);
}
