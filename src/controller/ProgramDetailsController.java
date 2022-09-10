package controller;

import bo.BoFactory;
import bo.custom.ProgramBO;
import dto.ProgramDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.ProgramTM;

import java.util.ArrayList;

public class ProgramDetailsController {
    public TableView<ProgramTM> tblProgram;
    public TableColumn colID;
    public TableColumn colProgram;
    public TableColumn colDuration;
    public TableColumn colFee;
    public TableColumn colUpdate;
    public TableColumn colDelete;

    ProgramBO programBOImpl = (ProgramBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.PROGRAM);

    public void initialize(){
        loadAllPrograms();

        colID.setCellValueFactory(new PropertyValueFactory("programID"));
        colProgram.setCellValueFactory(new PropertyValueFactory("program"));
        colDuration.setCellValueFactory(new PropertyValueFactory("duration"));
        colFee.setCellValueFactory(new PropertyValueFactory("fee"));
        colUpdate.setCellValueFactory(new PropertyValueFactory("update"));
        colDelete.setCellValueFactory(new PropertyValueFactory("delete"));
    }

    private void loadAllPrograms() {
        ObservableList<ProgramTM> tmList = FXCollections.observableArrayList();
        ArrayList<ProgramDTO> allPrograms = programBOImpl.getAllPrograms();

        for(ProgramDTO dto : allPrograms){
            Button update = new Button("Update");
            update.setStyle("-fx-background-color: #359a35; -fx-text-fill: white");
            Button delete = new Button("Delete");
            delete.setStyle("-fx-background-color: #e34040; -fx-text-fill: white");
            ProgramTM tm = new ProgramTM(
                    dto.getProgramID(),
                    dto.getProgram(),
                    dto.getDuration(),
                    dto.getFee(),
                    update,
                    delete
            );
            tmList.add(tm);
        }
        tblProgram.setItems(tmList);
    }
}
