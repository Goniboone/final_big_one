package edu.uh.tech.cis3368.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class EmployeePageController {

    @FXML
    public GridPane grid;
    public TextField fName;
    public TextField lName;
    public TextField empId;

    @Autowired
    EmployeeRepository eres;

    private static ArrayList<EmployeeEntity> ee = new ArrayList<>();

    public void homeButton(ActionEvent actionEvent) {
        Parent rt = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
            rt = fxmlLoader.load();
        }catch(Exception e){System.out.println("There's a possible error.");}
        Stage belayer = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        belayer.setScene(new Scene((rt),600,400));
    }

    public void addEmp(ActionEvent actionEvent) {
        Label l;
        EmployeeEntity emp;
        int i;
        /*if(grid.getChildren().isEmpty()) {
            for (i = 0; i < ee.size(); i++){
                l = new Label(ee.get(i).getEmployeeFirstname() + ee.get(i).getEmployeeLastname());
                grid.add(l, 1, grid.getRowCount()+1);
                l = new Label("" + ee.get(i).getEmployeeId());
                grid.add(l, 0, grid.getRowCount()-1);
            }
        }*/ // Code would only be neccessary if the database could be pulled from, code
        // would need to be changed a little as well

        if((!fName.getText().equals("")) && (!lName.getText().equals(""))) {
            emp = new EmployeeEntity(fName.getText(), lName.getText());
            //eres.save(emp);
            l = new Label(fName.getText() + lName.getText());
            grid.add(l, 1, grid.getRowCount()+1);
            l = new Label("" + emp.getEmployeeId());
            grid.add(l, 0, grid.getRowCount()-1);
            ee.add(emp);
        } else System.out.println("Fill out Employee first and last names please.");
    }

    public void deleteEmp(ActionEvent actionEvent) {
        int i = 0;
        try {
            if (!empId.getText().equals("")) {
                i = Integer.parseInt(empId.getText());
                grid.getChildren().remove(ee.get(i));
                ee.remove(i);
            }
        }catch(NumberFormatException e){e.printStackTrace(); System.out.println("Please" +
                "input the id of an employee.");}
    }
}
