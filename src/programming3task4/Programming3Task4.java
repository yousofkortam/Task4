/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming3task4;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author ikort
 */
public class Programming3Task4 extends Application {
    
    boolean save(String fName, String lName, String Email) {
        boolean saved = false;
        try {
                    
            FileWriter file = null;
            file = new FileWriter("newfile.csv");
            file.append(fName + " , ");
            file.append(lName + " , ");
            file.append(Email + " , ");
            file.close();
            saved = true;
                    
        }catch(Exception e) {
            System.out.println("Cannot open file");
        }
        return saved;
    }
    
    @Override
    public void start(Stage primaryStage) {
        Label Firstname = new Label("Firstname");
        Label Lastname = new Label("Lastname");
        Label Email = new Label("Email");
        final TextField firstnameText = new TextField();
        final TextField lastnameText = new TextField();
        final TextField emailText = new TextField();
        Button submit = new Button("Submit");
        Button clear = new Button("Clear");
        
        
        
        submit.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String FirstNameInput = firstnameText.getText();
                String LastNameInput = lastnameText.getText();
                String EmailInput = emailText.getText();
                List data = new ArrayList();
                data.add(FirstNameInput); data.add(LastNameInput); data.add(EmailInput);
                if (save(FirstNameInput, LastNameInput, EmailInput) == true) {
                    JOptionPane.showMessageDialog(null, "First name is " + data.get(0) + "\nLast name is " + data.get(1) + "\nEmail is " + data.get(2));
                }
                
            }
        });
        
        clear.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                firstnameText.setText("");
                lastnameText.setText("");
                emailText.setText("");
            }
        });
       
        
        GridPane root = new GridPane();
        
        root.addRow(0, Firstname, firstnameText);
        root.addRow(1, Lastname, lastnameText);
        root.addRow(2, Email, emailText);
        root.addRow(3, submit);
        GridPane.setHalignment(submit, HPos.CENTER);
        root.setHgap(10); root.setVgap(10);
        root.setPadding(new Insets(45));
        
        Scene scene = new Scene(root, 350, 300);
        
        primaryStage.setTitle("Data App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
