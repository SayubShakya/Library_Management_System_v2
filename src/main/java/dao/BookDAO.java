package dao;

import java.sql.ResultSet;
import dto.Books;

public interface BookDAO {

	String save(Books book);
    Books findById(int bid);
    String deleteById(int bid);
    ResultSet findAll();

}
