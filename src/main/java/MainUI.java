package main.java;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainUI extends Application {

    Stage window;
    String user = "user";
    String pw = "pass";
    String checkUser, checkPw, checkName, checkAge;
    Scene login;
    Scene welcome;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        primaryStage.setTitle("Prism");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // BLOCK 1: LOGIN PAGE  --------------------------------------------------

        Text welcomeScene1 = new Text("Welcome");
        welcomeScene1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(welcomeScene1, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label password = new Label("Password:");
        grid.add(password, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        final Label lblMessage = new Label();
        grid.add(lblMessage, 1, 3);


        //Action for btn
        btn.setOnAction(e -> {
                checkUser = userTextField.getText();
                checkPw = pwBox.getText();
                System.out.println(checkUser);
                System.out.println(checkPw);
                if(checkUser.equals(user) && checkPw.equals(pw)){
//                    lblMessage.setText("Congratulations!");
//                    lblMessage.setTextFill(Color.GREEN);
                    window.setScene(welcome);
                }
                else{
                    lblMessage.setText("Incorrect user or pw.");
                    lblMessage.setTextFill(Color.RED);
                }
                userTextField.setText("");
                pwBox.setText("");
        });
        login = new Scene(grid, 300, 275);

        // BLOCK 1: LOGIN PAGE -------------------------------------


        // BLOCK2:  WELCOME SCREEN  ----------------------------------------------

        BorderPane bp1 = new BorderPane();

        // TOP
        Text welcomeScene2 = new Text("Hello and welcome to Prism - a budgeting software designed for students");

        // LEFT
        HBox welcomeHBox = new HBox(20);
        welcomeHBox.setPadding(new Insets(20, 20, 20, 20));
        // name input
        Label name = new Label("Name: ");
        TextField namePrompt = new TextField();
        namePrompt.setPromptText("Name");
        // age input
        Label age = new Label("Age: ");
        TextField agePrompt = new TextField();
        agePrompt.setPromptText("YYYY-MM-DD");
        // initilizing Hbox
        welcomeHBox.getChildren().addAll(name, namePrompt, age, agePrompt);

        // BOTTOM
        Button nextPageButton = new Button("Next page");
        nextPageButton.setOnAction(e -> {
            checkName = namePrompt.getText();
            checkAge = agePrompt.getText();
//            if(!checkName.equals(null)) // left off here
        });

        // Border pane locations
        bp1.setPadding(new Insets(20, 20, 20, 20));
        bp1.setLeft(welcomeHBox);
        bp1.setTop(welcomeScene2);

        //Layout 2
        welcome = new Scene(bp1, 1280, 720);

        primaryStage.setScene(login);
        primaryStage.show();
    }
}