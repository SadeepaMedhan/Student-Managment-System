package controller;

import bo.BoFactory;
import bo.custom.ProgramBO;
import com.jfoenix.controls.JFXTextField;
import dto.ProgramDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.ProgramTM;

import java.util.ArrayList;

public class AddProgramController {
    public JFXTextField txtProgramID;
    public JFXTextField txtProgram;
    public JFXTextField txtDuration;
    public JFXTextField txtFee;
    public TableView<ProgramTM> tblProgram;
    public TableColumn colProgramID;
    public TableColumn colProgram;
    public TableColumn colDuration;
    public TableColumn colFee;

    ProgramBO programBOImpl = (ProgramBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.PROGRAM);

    public void initialize(){
        loadAllPrograms();

        colProgramID.setCellValueFactory(new PropertyValueFactory("programID"));
        colProgram.setCellValueFactory(new PropertyValueFactory("program"));
        colDuration.setCellValueFactory(new PropertyValueFactory("duration"));
        colFee.setCellValueFactory(new PropertyValueFactory("fee"));
    }

    private void loadAllPrograms() {
        ObservableList<ProgramTM> tmList = FXCollections.observableArrayList();
        ArrayList<ProgramDTO> allPrograms = programBOImpl.getAllPrograms();

        for(ProgramDTO dto : allPrograms){
            ProgramTM tm = new ProgramTM(
                    dto.getProgramID(),
                    dto.getProgram(),
                    dto.getDuration(),
                    dto.getFee()
            );
            tmList.add(tm);
        }
        tblProgram.setItems(tmList);
    }

    public void addOnAction(ActionEvent actionEvent) {
        boolean added = programBOImpl.addProgram(new ProgramDTO(
                txtProgramID.getText(),
                txtProgram.getText(),
                txtDuration.getText(),
                txtFee.getText())
        );
        if(added){
            textClear();
            loadAllPrograms();
        }
    }

    public void clearOnAction(ActionEvent actionEvent) {
        textClear();
    }

    private void textClear() {
        txtProgramID.clear();
        txtProgram.clear();
        txtDuration.clear();
        txtFee.clear();
    }
}
