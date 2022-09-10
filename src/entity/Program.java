package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Program {
    @Id
    private String programID;
    private String program;
    private String duration;
    private String fee;
    @OneToMany(mappedBy = "programID", cascade = CascadeType.ALL)
    private List<Registration> registrationList = new ArrayList<>();

    public Program() {
    }

    public Program(String programID, String program, String duration, String fee) {
        this.programID = programID;
        this.program = program;
        this.duration = duration;
        this.fee = fee;
    }

    public Program(String programID, String program, String duration, String fee, List<Registration> registrationList) {
        this.programID = programID;
        this.program = program;
        this.duration = duration;
        this.fee = fee;
        this.registrationList = registrationList;
    }

    public String getProgramID() {
        return programID;
    }

    public void setProgramID(String programID) {
        this.programID = programID;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }


    public List<Registration> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<Registration> registrationList) {
        this.registrationList = registrationList;
    }

    @Override
    public String toString() {
        return "Program{" +
                "programID='" + programID + '\'' +
                ", program='" + program + '\'' +
                ", duration='" + duration + '\'' +
                ", fee='" + fee + '\'' +
                ", registrationList=" + registrationList +
                '}';
    }
}
