package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Student;
import util.JDBCUtil;

public class StudentDAOImp implements StudentDAO {

    @Override
    public String save(Student student) {
        String status;
        String query = "INSERT INTO student(sname, sid, scourse, sphone, semail) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = new JDBCUtil().connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setString(1, student.getSname());
            ps.setInt(2, student.getSid());
            ps.setString(3, student.getScourse());
            ps.setString(4, student.getSphone());
            ps.setString(5, student.getSemail());

            int rowAffected = ps.executeUpdate();
            status = (rowAffected == 1) ? "success" : "failure";
        } catch (Exception e) {
            e.printStackTrace();
            status = "failure";
        }
        return status;
    }

    @Override
    public Student findById(int sid) {
        String query = "SELECT sname, sid, scourse, sphone, semail FROM student WHERE sid = ?";
        Student student = null;

        try (Connection conn = new JDBCUtil().connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setInt(1, sid);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    student = new Student();
                    student.setSname(rs.getString("sname"));
                    student.setSid(rs.getInt("sid"));
                    student.setScourse(rs.getString("scourse"));
                    student.setSphone(rs.getString("sphone"));
                    student.setSemail(rs.getString("semail"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public String deleteById(int sid) {
        String query = "DELETE FROM student WHERE sid = ?";
        String delstatus;

        try (Connection conn = new JDBCUtil().connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setInt(1, sid);
            int rowAffected = ps.executeUpdate();
            delstatus = (rowAffected == 1) ? "success" : "failure";
        } catch (Exception e) {
            e.printStackTrace();
            delstatus = "failure";
        }
        return delstatus;
    }

    @Override
    public List<Student> findAll() {
        String query = "SELECT * FROM student";
        List<Student> students = new ArrayList<>();

        try (Connection conn = new JDBCUtil().connect();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student student = new Student();
                student.setSname(rs.getString("sname"));
                student.setSid(rs.getInt("sid"));
                student.setScourse(rs.getString("scourse"));
                student.setSphone(rs.getString("sphone"));
                student.setSemail(rs.getString("semail"));
                students.add(student);
            }
            System.out.println("Fetched " + students.size() + " students from database.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
    
    @Override
    public List<Student> findAllByName(String name) {
        String query = "SELECT * FROM student WHERE sname LIKE ?";
        List<Student> students = new ArrayList<>();

        try (Connection conn = new JDBCUtil().connect();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, "%" + name + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Student student = new Student();
                    student.setSname(rs.getString("sname"));
                    student.setSid(rs.getInt("sid"));
                    student.setScourse(rs.getString("scourse"));
                    student.setSphone(rs.getString("sphone"));
                    student.setSemail(rs.getString("semail"));
                    students.add(student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }


}
