package controller;

import bo.BoFactory;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.StudentTM;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddStudentFormController {
    public JFXButton btnAdd;
    public JFXButton btnClear;
    public JFXTextField txtStudentID;
    public JFXTextField txtStudentName;
    public JFXTextField txtAddress;
    public JFXTextField txtEmail;
    public JFXTextField txtNic;
    public JFXTextField txtBirthDay;
    public JFXTextField txtGender;
    public JFXTextField txtMobile;
    public TableView<StudentTM> tblStudent;
    public TableColumn colStID;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colMobile;

    StudentBO studentBO = (StudentBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.STUDENT);

    public void initialize(){
        loadAllStudents();
        setStID();

        colStID.setCellValueFactory(new PropertyValueFactory("id"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colMobile.setCellValueFactory(new PropertyValueFactory("mobile"));
    }

    private void setStID() {
        txtStudentID.setText(studentBO.getNewID());
    }

    private void loadAllStudents() {
        ObservableList<StudentTM> tmList = FXCollections.observableArrayList();
        ArrayList<StudentDTO> allStudents = studentBO.getAllStudents();

        for(StudentDTO dto : allStudents){
            StudentTM tm = new StudentTM(
                    dto.getStudentID(),
                    dto.getStudentName(),
                    dto.getAddress(),
                    dto.getMobile()
            );
            tmList.add(tm);
        }
        tblStudent.setItems(tmList);
    }

    public void addOnAction(ActionEvent actionEvent) {
        boolean added = studentBO.addStudent(new StudentDTO(
                txtStudentID.getText(),
                txtStudentName.getText(),
                txtAddress.getText(),
                txtEmail.getText(),
                txtNic.getText(),
                txtBirthDay.getText(),
                txtGender.getText(),
                txtMobile.getText()
        ));

        if(added){
            textClear();
            loadAllStudents();
        }
    }

    private void textClear() {
        txtStudentID.clear();
        txtStudentName.clear();
        txtAddress.clear();
        txtEmail.clear();
        txtNic.clear();
        txtBirthDay.clear();
        txtGender.clear();
        txtMobile.clear();
        setStID();
    }

    public void clearOnAction(ActionEvent actionEvent) {
        textClear();
    }
}
