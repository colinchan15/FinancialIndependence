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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainUI extends Application {

    Stage window;
    String user = "user";
    String pw = "pass";
    String checkUser, checkPw;
    Scene login;
    Scene welcome;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        primaryStage.setTitle("JavaFX Welcome");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

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

//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent e) {
//                actiontarget.setFill(Color.FIREBRICK);
//                actiontarget.setText("Sign in button pressed");
//            }
//        });

        //Action for btn
        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
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
            }
        });
        login = new Scene(grid, 300, 275);

        //Button 2
        Button button2 = new Button("This sucks, go back to scene 1");
        button2.setOnAction(e -> window.setScene(login));

        //Layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        welcome = new Scene(layout2, 1280, 720);

        primaryStage.setScene(login);
        primaryStage.show();
    }
}