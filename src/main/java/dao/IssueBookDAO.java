package dao;

import java.util.List;

public interface IssueBookDAO {
    String issuebook(int sid, int bid, String issuedate, String duedate);
    List<List<Object>> checkdue(int sid);
}
