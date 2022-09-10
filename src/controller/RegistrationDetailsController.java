package controller;

import bo.BoFactory;
import bo.custom.ProgramBO;
import bo.custom.RegistrationBO;
import bo.custom.StudentBO;
import dto.ProgramDTO;
import dto.RegistrationDTO;
import dto.StudentDTO;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.StudentTM;

import java.util.ArrayList;

public class RegistrationDetailsController {
    public TableView<StudentTM> tblStudents;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colMobile;
    public TableColumn colDate;
    public ComboBox<String> cmbProgram;
    public Label lblDuration;
    public Label lblStCount;

    ProgramBO programBOImpl = (ProgramBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.PROGRAM);
    StudentBO studentBO = (StudentBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.STUDENT);
    RegistrationBO registrationBOImpl = (RegistrationBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.REGISTRATION);

    ArrayList<ProgramDTO> allPrograms = programBOImpl.getAllPrograms();

    public void initialize(){
        cmbProgram.setStyle("-fx-font-size: 18; -fx-font-weight: bold; -fx-background-color:  #c3cbd2;");
        ArrayList<String> programs = new ArrayList<>();
        for (ProgramDTO p:allPrograms){
            programs.add(p.getProgram());
        }
        cmbProgram.getItems().addAll(programs);
        cmbProgram.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setProgram(newValue);
        });

        colID.setCellValueFactory(new PropertyValueFactory("id"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colMobile.setCellValueFactory(new PropertyValueFactory("mobile"));
        colDate.setCellValueFactory(new PropertyValueFactory("date"));
    }

    private void setProgram(String program) {
        for (ProgramDTO p:allPrograms){
            if(p.getProgram().equals(program)){
                lblDuration.setText(p.getDuration());
                loadTable(p.getProgramID());
            }
        }
    }


    private void loadTable(String programID) {
        ObservableList<StudentTM> tmList = FXCollections.observableArrayList();
        ArrayList<RegistrationDTO> allRegistrations = registrationBOImpl.getAllRegistrations();

        for(RegistrationDTO r:allRegistrations){
            if(r.getProgramID().getProgramID().equals(programID)) {
                Student student = studentBO.getStudent(r.getStID().getStudentID());
                StudentTM tm = new StudentTM(
                        student.getStudentID(),
                        student.getStudentName(),
                        student.getAddress(),
                        student.getMobile(),
                            r.getDate()
                    );
                    tmList.add(tm);
            }
        }
        tblStudents.setItems(tmList);
        lblStCount.setText(String.valueOf(tmList.size()));
    }

}
