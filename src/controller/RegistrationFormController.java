package controller;

import bo.BoFactory;
import bo.SuperBO;
import bo.custom.ProgramBO;
import bo.custom.RegistrationBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import dto.ProgramDTO;
import dto.RegistrationDTO;
import dto.StudentDTO;
import entity.Program;
import entity.Registration;
import entity.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistrationFormController {
    public TextField txtSearchID;
    public ComboBox<String> cmbProgram;
    public Label lblStudentID;
    public Label lblStudentName;
    public Label lblAddress;
    public Label lblMobile;
    public Label lblProgramID;
    public Label lblProgramName;
    public Label lblDuration;
    public Label lblFee;
    public Label lblRegisteredProgram;
    public JFXButton btnRegister;


    ProgramBO programBOImpl = (ProgramBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.PROGRAM);
    StudentBO studentBO = (StudentBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.STUDENT);
    RegistrationBO registrationBOImpl = (RegistrationBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.REGISTRATION);


    public void initialize(){
        cmbProgram.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-background-color:  #c3cbd2;");

        loadCmb();
        cmbProgram.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setProgram(newValue);
        });
    }

    private void setProgram(String program) {
        ArrayList<ProgramDTO> allPrograms = programBOImpl.getAllPrograms();
        for (ProgramDTO p:allPrograms){
            if(p.getProgram().equals(program)){
                setProgramDetail(p);
                btnRegister.setDisable(checkAlreadyRegisteredPrograms(p.getProgramID()));
            }
        }
    }

    private boolean checkAlreadyRegisteredPrograms(String programID) {
        for (String id:proList){
            if (id.equals(programID)){
                return true;
            }
        }
        return false;
    }

    private void setProgramDetail(ProgramDTO p) {
        lblProgramID.setText(p.getProgramID());
        lblProgramName.setText(p.getProgram());
        lblDuration.setText(p.getDuration());
        lblFee.setText(p.getFee());
    }

    private void loadCmb() {
        ArrayList<ProgramDTO> allPrograms = programBOImpl.getAllPrograms();
        ArrayList<String> program = new ArrayList<>();
        for (ProgramDTO p : allPrograms) {
            program.add(p.getProgram());
        }
        cmbProgram.getItems().addAll(program);
    }

    public void registerOnAction(ActionEvent actionEvent) {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String rDate = f.format(date);
        RegistrationDTO registrationDTO = new RegistrationDTO(
                registrationBOImpl.getNewID(),
                studentBO.getStudent(lblStudentID.getText()),
                programBOImpl.getProgram(lblProgramID.getText()),
                rDate
        );
        registrationBOImpl.addRegistration(registrationDTO);
        clearTexts();
    }

    private void clearTexts() {
        txtSearchID.clear();
        lblStudentID.setText("-");
        lblStudentName.setText("-");
        lblAddress.setText("-");
        lblMobile.setText("-");
        lblRegisteredProgram.setText("-");
        lblProgramID.setText("-");
        lblProgramName.setText("-");
        lblDuration.setText("-");
        lblFee.setText("-");
    }


    Student student;
    public void searchStudentOnAction(ActionEvent actionEvent) {
        student = studentBO.getStudent(txtSearchID.getText());
        if(student!=null) {
            setStudentDetail(student);
            checkAlreadyRegistered(txtSearchID.getText());
        }else{
            System.out.println("not found");
        }
    }

    List<String> proList=new ArrayList<>();
    private void checkAlreadyRegistered(String id) {
        ArrayList<RegistrationDTO> allRegistrations = registrationBOImpl.getAllRegistrations();
        List<String> list=new ArrayList<>();

        for (RegistrationDTO r:allRegistrations){
            if(id.equals(r.getStID().getStudentID())){
                list.add(r.getProgramID().getProgramID());
            }
        }
        proList=list;
        String l=" ";
        for (String program:list){
            l=l+getProgramsName(program)+", ";
        }
        lblRegisteredProgram.setText(l);
    }

    private String getProgramsName(String programID) {
        Program program = programBOImpl.getProgram(programID);
        return program.getProgram();
    }

    private void setStudentDetail(Student s) {
        lblStudentID.setText(s.getStudentID());
        lblStudentName.setText(s.getStudentName());
        lblAddress.setText(s.getAddress());
        lblMobile.setText(s.getMobile());
    }

    public void cancelOnAActionn(ActionEvent actionEvent) {
        clearTexts();
    }
}
