package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Librarian;
import dto.ValidateLibrarian;
import util.JDBCUtil;

public class LibrarianDAOImp implements LibrarianDAO {

    @Override
    public String save(Librarian librarian) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String deleteById(int lid) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String findById(int lid) {
        String query = "SELECT lname FROM librarian WHERE lid=?";
        try (Connection conn = JDBCUtil.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, lid);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("lname");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int librarianValidate(ValidateLibrarian validateLib) {
        String sql = "SELECT lid FROM logindetails WHERE username = ? AND password = ?";
        try (Connection conn = JDBCUtil.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, validateLib.getLusername());
            pstmt.setString(2, validateLib.getLpassword());
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("lid"); // Ensure 'lid' is the correct column name
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}