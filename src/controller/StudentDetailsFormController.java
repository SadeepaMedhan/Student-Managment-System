package controller;

import bo.BoFactory;
import bo.custom.StudentBO;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.StudentTM;

import java.util.ArrayList;

public class StudentDetailsFormController {
    public TableView<StudentTM> tblStudent;
    public TableColumn colStID;
    public TableColumn colAddress;
    public TableColumn colName;
    public TableColumn colMobile;
    public TableColumn colUpdate;
    public TableColumn colRemove;

    StudentBO studentBO = (StudentBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.STUDENT);

    public void initialize(){
        loadAllStudents();

        colStID.setCellValueFactory(new PropertyValueFactory("id"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colMobile.setCellValueFactory(new PropertyValueFactory("mobile"));
        colUpdate.setCellValueFactory(new PropertyValueFactory("update"));
        colRemove.setCellValueFactory(new PropertyValueFactory("delete"));
    }

    private void loadAllStudents() {
        ObservableList<StudentTM> tmList = FXCollections.observableArrayList();
        ArrayList<StudentDTO> allStudents = studentBO.getAllStudents();


        for(StudentDTO dto : allStudents){
            Button update = new Button("Update");
            update.setStyle("-fx-background-color: #359a35; -fx-text-fill: white");
            Button delete = new Button("Delete");
            delete.setStyle("-fx-background-color: #e34040; -fx-text-fill: white");
            StudentTM tm = new StudentTM(
                    dto.getStudentID(),
                    dto.getStudentName(),
                    dto.getAddress(),
                    dto.getMobile(),
                    update,
                    delete
            );
            tmList.add(tm);
        }
        tblStudent.setItems(tmList);
    }
}
