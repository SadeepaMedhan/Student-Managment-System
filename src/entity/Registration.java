package entity;

import javax.persistence.*;

@Entity
public class Registration {
    @Id
    private String rId;
    @ManyToOne
    @JoinColumn(name = "studentID")
    private Student stID;
    @ManyToOne
    @JoinColumn(name = "programID")
    private Program programID;
    private String date;

    public Registration() {
    }

    public Registration(String rId, Student stID, Program programID, String date) {
        this.rId = rId;
        this.stID = stID;
        this.programID = programID;
        this.date = date;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public Student getStID() {
        return stID;
    }

    public void setStID(Student stID) {
        this.stID = stID;
    }

    public Program getProgramID() {
        return programID;
    }

    public void setProgramID(Program programID) {
        this.programID = programID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "rId='" + rId + '\'' +
                ", stID=" + stID +
                ", programID=" + programID +
                ", date='" + date + '\'' +
                '}';
    }
}
