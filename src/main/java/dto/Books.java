package dto;

public class Books {
    public Books() {
        super();
    }

    // Fields
    private String bid; 
    private String bname;
    private String bautho;
    private String bsubject;

    // Getters and Setters
    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getbautho() {
        return bautho;
    }

    public void setbautho(String bautho) {
        this.bautho = bautho;  // Fixed typo here
    }

    public String getBsubject() {
        return bsubject;
    }

    public void setBsubject(String bsubject) {
        this.bsubject = bsubject;
    }

    @Override
    public String toString() {
        return "Books [bid=" + bid + ", bname=" + bname + ", bautho=" + bautho + ", bsubject=" + bsubject + "]";
    }

    // Constructor with parameters
    public Books(String bid, String bname, String bautho, String bsubject) {
        super();
        this.bid = bid;
        this.bname = bname;
        this.bautho = bautho;  // Fixed typo here
        this.bsubject = bsubject;
    }
}
