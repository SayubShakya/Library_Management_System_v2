package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import util.JDBCUtil;

public class ReturnBooksClass {

    public String bookReturn(int sid, int bid) {
        String delBstatus = "failure";
        String query = "DELETE FROM issuebook WHERE sid = ? AND bid = ?";
        
        try (Connection conn = new JDBCUtil().connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setInt(1, sid);
            ps.setInt(2, bid);
            
            int rowAffected = ps.executeUpdate();
            if (rowAffected == 1) {
                delBstatus = "success";
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
        }
        
        return delBstatus;
    }
}