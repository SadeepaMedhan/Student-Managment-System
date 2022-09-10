package dto;

import entity.Program;
import entity.Student;

public class RegistrationDTO {
    private String rId;
    private Student stID;
    private Program programID;
    private String date;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String rId, Student stID, Program programID, String date) {
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
        return "RegistrationDTO{" +
                "rId='" + rId + '\'' +
                ", stID=" + stID +
                ", programID=" + programID +
                ", date='" + date + '\'' +
                '}';
    }
}
