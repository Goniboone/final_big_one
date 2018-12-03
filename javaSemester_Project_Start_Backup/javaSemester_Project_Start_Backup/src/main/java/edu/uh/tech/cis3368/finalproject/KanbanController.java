package edu.uh.tech.cis3368.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;

@Component
public class KanbanController {

    @FXML
    public Label lbl;
    public GridPane gridPane1;
    public GridPane gridPane2;
    public GridPane gridPane3;

    @Autowired
    public JobFormRepository jres;

    private static ArrayList<Label> laA = new ArrayList<>();

    public KanbanController(){}

    // For putting new jobs into pre-production
    public void addJob(JobFormEntity jf){

        int i = 0;
        Label la = null;


        //jres.save(jf);

        la = new Label(jf.getJobName());
        laA.add(la);
        gridPane1.addRow(gridPane1.getRowCount(), laA.get(laA.indexOf(la)));
    }


    public void homeButton(ActionEvent actionEvent) {
        Parent rt = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
            rt = fxmlLoader.load();
        }catch(Exception e){System.out.println("There's a possible error.");}
        Stage belayer = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        belayer.setScene(new Scene(rt,600,400));
    }



    public void onDragDetected(MouseEvent mouseEvent) {
        if(!laA.contains(lbl))
            laA.add(0,lbl);

        System.out.println("Drag.");

            Dragboard dragboard = laA.get(laA.size()-1).startDragAndDrop(TransferMode.MOVE);
            ClipboardContent clipboardContent = new ClipboardContent();
            clipboardContent.putString(laA.get(laA.size()-1).getText());
            System.out.println("Dragged from pane one.");
            dragboard.setContent(clipboardContent);
            mouseEvent.consume();

    }

    public void onDragOver(DragEvent dragEvent) {
        System.out.println("Drag in Progress.");
        Dragboard dragboard = dragEvent.getDragboard();
        dragEvent.acceptTransferModes(TransferMode.MOVE);
        dragEvent.consume();

    }

    public void dragDropped(DragEvent dragEvent) {
        Dragboard dragboard = dragEvent.getDragboard();
        String s = dragboard.getString();

        if(dragEvent.getTarget().equals(gridPane2)) {
            gridPane2.addRow(gridPane2.getRowCount(),laA.get(0));

            gridPane1.getChildren().remove(laA.get(0));
            gridPane3.getChildren().remove(laA.get(0));
        }
        else if(dragEvent.getTarget().equals(gridPane3)) {
            gridPane3.addRow(gridPane2.getRowCount(), laA.get(0));

            gridPane1.getChildren().remove(laA.get(0));
            gridPane2.getChildren().remove(laA.get(0));
        }
        dragEvent.consume();
    }
}
