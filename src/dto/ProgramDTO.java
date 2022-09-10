package dto;

import com.jfoenix.controls.JFXTextField;

public class ProgramDTO {
    private String programID;
    private String program;
    private String duration;
    private String fee;

    public ProgramDTO() {
    }

    public ProgramDTO(String programID, String program, String duration, String fee) {
        this.programID = programID;
        this.program = program;
        this.duration = duration;
        this.fee = fee;
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
}
