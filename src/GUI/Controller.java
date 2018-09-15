package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML private TextField cheqAccountNum;
    @FXML private TextField savingsAccountNum;
    @FXML private TextField HISAAccountNum;
    @FXML private TextField GICAccountNum;
    @FXML private TextField TFSAAccountNum;
    @FXML private TextField RRSPAccountNum;
    @FXML private Hyperlink assetsLink;

    int chequingsNum, savingsNum, HISANum, GICNum, TFSANum, RRSPNum;

    public void assetsInfo() {
        System.out.println("Assets button clicked");
    }

    public void assetsButtonPushed(ActionEvent event) throws IOException {
        Parent assetsMenu = FXMLLoader.load(getClass().getResource("AssetsMenu.fxml"));
        Scene assetsMenuScene = new Scene(assetsMenu);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(assetsMenuScene);
        window.show();
    }

    public void assetsMenuSubmitButtonPushed(ActionEvent event) throws IOException {

        chequingsNum = nullOrNot(cheqAccountNum);
        savingsNum = nullOrNot(savingsAccountNum);
        HISANum = nullOrNot(HISAAccountNum);
        GICNum = nullOrNot(GICAccountNum);
        TFSANum = nullOrNot(TFSAAccountNum);
        RRSPNum = nullOrNot(RRSPAccountNum);
    }

    public int nullOrNot (TextField accountNum){
        int localAccountNum;
        if (!accountNum.getText().equals("")){
            localAccountNum = Integer.parseInt(accountNum.getText());
        }else {
            localAccountNum = 0;
        }
        return localAccountNum;
    }

//    public void initialize (URL url, ResourceBundle rb){
//        System.out.println(cheqAccountNum.getText());
//    }


}
