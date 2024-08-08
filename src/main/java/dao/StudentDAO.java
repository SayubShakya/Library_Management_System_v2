package dao;

import dto.Student;
import java.util.List;

public interface StudentDAO {
    String save(Student student);
    Student findById(int sid);
    String deleteById(int sid);
    List<Student> findAll();
    List<Student> findAllByName(String name); // New method
}
