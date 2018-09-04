package main.java;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.format.DateTimeParseException;

public class MainUIMod extends Application {



    Stage window;
    String user = "user";
    String pw = "pass";
    String checkUser, checkPw, checkName, checkAge;
    Scene login;
    Scene welcome;
    Scene mainMenu;
    Scene assets;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        primaryStage.setScene(assets(primaryStage));
        primaryStage.show();
    }

    private Scene login(Stage primaryStage){
        window = primaryStage;

        primaryStage.setTitle("Prism");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

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

        return login;
    }

    private Scene welcome (Stage primaryStage){

        BorderPane bp1 = new BorderPane();
        GridPane gp1 = new GridPane();

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
        nextPageButton.setPadding(new Insets(5, 5, 5, 5));
        gp1.add(nextPageButton, 0, 0);
        final Label welcomeIncorrect = new Label();
        gp1.add(welcomeIncorrect, 5, 0);

        AgeCalculator ageCalculator = new AgeCalculator();
        boolean executed = false;
        do {
            nextPageButton.setOnAction(e -> {
                try {
                    checkName = namePrompt.getText();
                    checkAge = agePrompt.getText();
                    int clientAge = ageCalculator.getAge(checkAge);
                    System.out.println(clientAge);
                    if (!checkName.equals(null) && clientAge > 0) {
                        window.setScene(mainMenu(primaryStage));
                    } else {
                        welcomeIncorrect.setText("The information you have entered is incorrect or invalid");
                        welcomeIncorrect.setTextFill(Color.RED);
                    }
                } catch (DateTimeParseException e1) {
                    welcomeIncorrect.setText("You did not enter the date in the correct format.");
                    welcomeIncorrect.setTextFill(Color.RED);
                }
            });
            executed = true;
        } while (executed == false);

        // Border pane locations
        bp1.setPadding(new Insets(20, 20, 20, 20));
        bp1.setLeft(welcomeHBox);
        bp1.setTop(welcomeScene2);
//        bp1.setBottom(nextPageButton);
        bp1.setBottom(gp1);
//        bp1.setBottom(welcomeIncorrect);

        // Alignments
//        BorderPane.setAlignment(nextPageButton, Pos.TOP_RIGHT);
//        BorderPane.setAlignment(welcomeIncorrect, Pos.TOP_LEFT);

        //Layout 2
        welcome = new Scene(bp1, 1280, 720);

        return welcome;
    }

    private Scene mainMenu (Stage primaryStage){
        // initializing layouts
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();
        VBox vb = new VBox();
        boolean executed = false;

        // set layout margins
        vb.setPadding(new Insets(10, 10, 10, 10));
        vb.setSpacing(8);

        // setting titles and labels
        Text title = new Text("Data Input");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vb.getChildren().add(title);

        // initializing hyperlinks
        Hyperlink options[] = new Hyperlink[] {
                new Hyperlink("Assets"),
                new Hyperlink("Liabilities"),
                new Hyperlink("Budget"),
                new Hyperlink("Costs")};

        // initializing hyperlink layouts
        for (int i=0; i<4; i++) {
            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
            vb.getChildren().add(options[i]);
        }

        options[0].setOnAction(e -> {
            window.setScene(welcome(primaryStage));
        });



        mainMenu = new Scene (vb, 1280, 720);

        return mainMenu;
    }

    private Scene assets (Stage primaryStage){
        VBox vb = new VBox();
        vb.setPadding(new Insets(10, 10, 10, 10));
        vb.setSpacing(10);

        HBox checkboxes = new HBox();
        checkboxes.setPadding(new Insets(10, 10, 10, 10));

        HBox chequingsSelection = new HBox(20);

        HBox savingsSelection = new HBox(20);


        GridPane gp = new GridPane();
        gp.setVgap(5);
        gp.setPadding(new Insets(25, 25, 25, 25));

        Text title = new Text("Assets");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        gp.add(title, 0, 0);

        Text description = new Text("Please select all assets you would like to include in your budget");
        gp.add(description, 0, 3);

        CheckBox [] options = new CheckBox[]{
                new CheckBox("Chequings"),
                new CheckBox("Savings"),
                new CheckBox("High-Interest Savings"),
                new CheckBox("GIC"),
                new CheckBox("TFSA"),
                new CheckBox("RRSP")
        };

        for (int i = 0; i < options.length; i++){
            HBox.setMargin(options[i], new Insets(20, 30, 0, 0));
            checkboxes.getChildren().add(options[i]);
        }
        gp.add(checkboxes, 0, 6);

        // after clicking chequings checkbox

        options[0].setOnAction(e -> {
            ChoiceBox <Integer> chequingsChoice = new ChoiceBox<>();
            Label chequingsLabel = new Label ("How many chequings accounts do you have?");
            chequingsChoice.getItems().addAll(1,2,3,4,5);
            chequingsChoice.setValue(1);
            chequingsSelection.setAlignment(Pos.BOTTOM_LEFT);
            chequingsSelection.getChildren().addAll(chequingsLabel, chequingsChoice);
            gp.add(chequingsSelection, 0, 8);
        });

        options[1].setOnAction(e -> {
            ChoiceBox <Integer> savingsChoice = new ChoiceBox<>();
            Label savingsLabel = new Label ("How many savings accounts do you have?");
            savingsChoice.getItems().addAll(1,2,3,4,5);
            savingsChoice.setValue(1);
            savingsSelection.setAlignment(Pos.BOTTOM_LEFT);
            savingsSelection.getChildren().addAll(savingsLabel, savingsChoice);
            gp.add(savingsSelection, 0, 9);
        });


        assets = new Scene (gp, 1280, 720);

        return assets;
    }

}