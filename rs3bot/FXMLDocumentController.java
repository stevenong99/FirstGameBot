/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs3bot;

import java.awt.AWTException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import scripts.RunescapeBot;

/**
 *
 * @author Crimson
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextArea conOut;
    
    
    @FXML
    private void start(ActionEvent event) throws AWTException, InterruptedException, IOException {
        RunescapeBot RSBot = new RunescapeBot(this);
    }
    
    @FXML
    private void stop(ActionEvent event) {
        display("Program aborting");
        System.out.println("Stop button pressed. Program terminating.");
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    public void display(String text){
        conOut.setText(conOut.getText() + "\n" + text);
    }
    
}
