package edu.uh.tech.cis3368.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class MainController {
    public Button cb;
    public Label la;

    public void customerButton(ActionEvent actionEvent) {
        Stage belayer = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        belayer.setScene(new Scene(transition("Customer"),600,400));
    }

    public void ownerButton(ActionEvent actionEvent) {
        Stage belayer = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        belayer.setScene(new Scene(transition("owner"),600,400));
    }

    public void managerButton(ActionEvent actionEvent) {
        Stage belayer = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        belayer.setScene(new Scene(transition("Manager"),800,400));
    }

    public void workmanButton(ActionEvent actionEvent) {
        Stage belayer = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        belayer.setScene(new Scene(transition("Kanban"),800,600));
    }

    public void kanbanButton(ActionEvent actionEvent) {
        Stage belayer = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        belayer.setScene(new Scene(transition("Kanban"),800,600));
    }

    public Parent transition(String xx){
        Parent rt = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(xx +".fxml"));
            rt = fxmlLoader.load();
        }catch(Exception e){System.out.println("There's a possible error.");}
        return rt;
    }
}
