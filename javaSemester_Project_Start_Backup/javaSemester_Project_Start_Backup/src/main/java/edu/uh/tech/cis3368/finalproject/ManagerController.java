package edu.uh.tech.cis3368.finalproject;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ManagerController {

    @FXML
    public GridPane gridPane1;
    public GridPane gridPane2;
    public ComboBox<DesignEntity> designBox;
    public ComboBox<PartEntity> partOne;
    public ComboBox<PartEntity> partTwo;
    public ComboBox<PartEntity> partThree;
    public TextField totalcostField;

    @Autowired
    public PartRepository pres;

    @Autowired
    public DesignRepository dres;

    @Autowired
    public SaleChartRepository sres;


    public void submitButton(ActionEvent actionEvent) {
        if((!totalcostField.getText().equals("")) && (partOne.isArmed() ||
                partTwo.isArmed() || partThree.isArmed())) {
            KanbanController kc = new KanbanController();

            Date da = new Date(11/5/12);
            JobFormEntity j = new JobFormEntity(designBox.getValue().getDesignName());
            SaleChartEntity sc = new SaleChartEntity("Sale" + designBox.getValue().getDesignName(),
                    Double.parseDouble(totalcostField.getText()),da);
            sres.save(sc);
            kc.addJob(j);
        } else System.out.println("Please calculate your total or choose a part.");
    }

    public void calcTotal(ActionEvent actionEvent) {
        double dd = 0;
        if(partOne.isArmed() && partTwo.isArmed() && partThree.isArmed()) {
            dd = (partOne.getValue().getCost() + partTwo.getValue().getCost()
                    + partThree.getValue().getCost());
        }
        else if(partOne.isArmed() && partTwo.isArmed()){
            dd = (partOne.getValue().getCost() + partTwo.getValue().getCost());
        } else if(partOne.isArmed() && partThree.isArmed()){
            dd = (partOne.getValue().getCost() + partThree.getValue().getCost());
        } else if(partTwo.isArmed() && partThree.isArmed()){
            dd = (partTwo.getValue().getCost() + partThree.getValue().getCost());
        }
        dd += dd * .134;
        totalcostField.setText("" + dd);
    }

    public void kanbanLink(ActionEvent actionEvent) {
        Parent rt = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Kanban.fxml"));
            rt = fxmlLoader.load();
        }catch(Exception e){System.out.println("There's a possible error.");}
        Stage belayer = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        belayer.setScene(new Scene(rt,800,600));
    }

    public void loadButton(ActionEvent actionEvent) {
        Set<Node> delet = new HashSet<>();
        for (Node child : gridPane1.getChildren()) {

            Integer rowIndex = GridPane.getRowIndex(child);
            int r = rowIndex == null ? 0 : rowIndex;

            if (r > gridPane1.getRowCount()) {
                GridPane.setRowIndex(child, r-1);
            } else if (r == gridPane1.getRowCount()) {
                delet.add(child);
            }
        }
        // Removes all nodes in the table
        gridPane1.getChildren().removeAll(delet);

        int i;
        PartEntity p = null;
        Label la = null;
        for(i=1; i<=15; i++) {

                p = pres.findByPartId(i);

            la = new Label(p.getComponentName() + " & $" + p.getCost());
            gridPane1.addRow(i-1, la);
        }
    }


    public void loadPartThree(ActionEvent actionEvent) {
        Label l = new Label(partThree.getAccessibleText());
        gridPane2.addRow(gridPane2.getRowCount(), l);
    }

    public void loadPartOne(ActionEvent actionEvent) {
        Label l = new Label(partOne.getAccessibleText());
        gridPane2.addRow(gridPane2.getRowCount(), l);
    }

    public void loadPartTwo(ActionEvent actionEvent) {
        Label l = new Label(partTwo.getAccessibleText());
        gridPane2.addRow(gridPane2.getRowCount(), l);
    }

    public void clickDesign(ContextMenuEvent contextMenuEvent) {
        int i;
        for(i=1; i<=dres.count(); i++) {
            designBox.getItems().add(dres.findDesignEntityByDesignId(i));
        }
    }

    public void clickPartOne(ContextMenuEvent contextMenuEvent) {
        int i;
        for(i=1; i<=15; i++) {
            partOne.getItems().add(pres.findByPartId(i));
        }
    }

    public void clickPartTwo(ContextMenuEvent contextMenuEvent) {
        int i;
        for(i=1; i<=15; i++) {
            partTwo.getItems().add(pres.findByPartId(i));
        }
    }

    public void clickPartThree(ContextMenuEvent contextMenuEvent) {
        int i;
        for(i=1; i<=15; i++) {
            partThree.getItems().add(pres.findByPartId(i));
        }
    }
}
