package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.JDBCUtil;

public class IssueBookImp implements IssueBookDAO {

    @Override
    public String issuebook(int sid, int bid, String issuedate, String duedate) {
        String issuestatus = null;
        String query = "INSERT INTO issuebook(bid, sid, issuedate, duedate) VALUES(?, ?, ?, ?)";
        try (Connection conn = new JDBCUtil().connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setInt(1, bid);
            ps.setInt(2, sid);
            ps.setString(3, issuedate);
            ps.setString(4, duedate);
            int status = ps.executeUpdate();
            
            issuestatus = (status == 1) ? "success" : "failure";
            
        } catch (Exception e) {
            e.printStackTrace();  // Print stack trace for debugging
            issuestatus = "failure";
        }
        return issuestatus;
    }

    @Override
    public List<List<Object>> checkdue(int sid) {
        List<List<Object>> resultData = new ArrayList<>();
        String query = "SELECT issuebook.sid, student.sname, issuebook.bid, books.bname, issuedate, duedate " +
                       "FROM issuebook " +
                       "INNER JOIN books ON issuebook.bid = books.bid " +
                       "INNER JOIN student ON issuebook.sid = student.sid " +
                       "WHERE issuebook.sid = ?";

        try (Connection conn = new JDBCUtil().connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setInt(1, sid);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    List<Object> row = new ArrayList<>();
                    row.add(rs.getInt("sid"));
                    row.add(rs.getString("sname"));
                    row.add(rs.getInt("bid"));
                    row.add(rs.getString("bname"));
                    row.add(rs.getDate("issuedate"));
                    row.add(rs.getDate("duedate"));
                    resultData.add(row);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();  // Print stack trace for debugging
        }

        return resultData;
    }
}
