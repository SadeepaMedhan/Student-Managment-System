package dto;

public class StudentDTO {
    private String studentID;
    private String studentName;
    private String address;
    private String email;
    private String nic;
    private String birthDay;
    private String gender;
    private String mobile;

    public StudentDTO() {
    }

    public StudentDTO(String studentID, String studentName, String address, String email, String nic, String birthDay, String gender, String mobile) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.address = address;
        this.email = email;
        this.nic = nic;
        this.birthDay = birthDay;
        this.gender = gender;
        this.mobile = mobile;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
