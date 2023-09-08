package com.example.numberguessing;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button confirmBtn;

    @FXML
    private TextField fromText;

    @FXML
    private Label showMess;

    @FXML
    private TextField toText;

    @FXML
    private TextField userNum;

    @FXML
    private Button yesBtn;

    @FXML
    private Button noBtn;

    @FXML
    private Button setBtn;

    public int userFrom;
    public int userTo;
    public int answer;
    public int getUserNum;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        yesBtn.setVisible(false);
        noBtn.setVisible(false);
        confirmBtn.setVisible(false);
    }

    @FXML
    public void set() {
        try {
            Random random = new Random();
            userFrom = Integer.parseInt(fromText.getText());
            userTo = Integer.parseInt(toText.getText());
            if (userFrom >= userTo) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("An error occurred");
                alert.setContentText("The \"From\" number must be less than the \"To\" number.");
                alert.show();
                Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
                stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
                stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
            } else {
                answer = random.nextInt(userTo - userFrom) + (userFrom);
                System.out.println(answer);
                confirmBtn.setVisible(true);
                setBtn.setVisible(false);
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("An error occurred");
            alert.setContentText("All number fields should not be blank and should be inputted as number.");
            alert.show();

            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
            stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
        }

    }

    @FXML
    public void check() {
        try {
            getUserNum = Integer.parseInt(userNum.getText());
            if (answer == getUserNum) {
                showMess.setText("YOU WON! Would you like to play again?");
                yesBtn.setVisible(true);
                noBtn.setVisible(true);
            } else {
                System.out.println(answer);
                userNum.setText("");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Wrong");
                alert.setHeaderText("Wrong Number");
                alert.setContentText("Please try again");
                alert.show();
                Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
                stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
                stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("An error occurred");
            alert.setContentText("All number fields should not be blank and should be inputted as numbers.");
            alert.show();

            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
            stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
        }

    }

    @FXML
    public void yes() {
        fromText.setText("");
        toText.setText("");
        userNum.setText("");
        showMess.setText("");

        yesBtn.setVisible(false);
        noBtn.setVisible(false);
        confirmBtn.setVisible(false);
        setBtn.setVisible(true);
    }

    public void no() {
        Stage stage = (Stage) noBtn.getScene().getWindow();
        stage.close();
    }
}