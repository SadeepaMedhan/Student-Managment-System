package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import static javafx.scene.paint.Color.TRANSPARENT;

public class DashboardFormController {
    public StackPane dashBoardContext;
    public AnchorPane loadContext;
    public AnchorPane homeContext;
    public Label lblDate;
    public Label lblTime;

    public void initialize() {
        loadDateAndTime();
    }

    private void loadDateAndTime() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));

        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) dashBoardContext.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml")));
        scene.setFill(TRANSPARENT);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    public void viewProgramOnAction(ActionEvent actionEvent) throws IOException {
        loadForm("../view/ProgramDetails.fxml");
    }

    public void addProgramOnAction(ActionEvent actionEvent) throws IOException {
        loadForm("../view/AddProgram.fxml");
    }

    public void registerDetailOnAction(ActionEvent actionEvent) throws IOException {
        loadForm("../view/RegistrationDetails.fxml");
    }

    public void registerOnAction(ActionEvent actionEvent) throws IOException {
        loadForm("../view/RegistrationForm.fxml");
    }

    public void viewStudentOnAction(ActionEvent actionEvent) throws IOException {
        loadForm("../view/StudentDetailsForm.fxml");
    }

    public void addStudentOnAction(ActionEvent actionEvent) throws IOException {
        loadForm("../view/AddStudentForm.fxml");
    }

    private void loadForm(String url) throws IOException {
        loadContext.getChildren().clear();
        loadContext.getChildren().add(FXMLLoader.load(getClass().getResource(url)));
    }

    public void homeOnAction(MouseEvent mouseEvent) {
        loadContext.getChildren().clear();
        loadContext.getChildren().add(homeContext);
    }
}
