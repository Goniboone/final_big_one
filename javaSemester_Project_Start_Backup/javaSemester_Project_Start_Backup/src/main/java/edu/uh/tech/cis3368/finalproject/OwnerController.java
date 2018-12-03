package edu.uh.tech.cis3368.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;

@Component
public class OwnerController {

    @FXML
   public TextField t1;
   public TextField t2;
   public GridPane gridPane1;
   public TextField profitability;

   ArrayList<SaleChartEntity> ae = new ArrayList<>();
   Date d;
   private SaleChartEntity sample1 = new SaleChartEntity();
    private SaleChartEntity sample2 = new SaleChartEntity();
    private SaleChartEntity sample3 = new SaleChartEntity();
    private SaleChartEntity sample4 = new SaleChartEntity();
    private SaleChartEntity sample5 = new SaleChartEntity();

    public void reportButton(ActionEvent actionEvent) {
        sample1.setSale(32.6); d = new Date(12/11/2); sample1.setSaleDate(d);
        ae.add(sample1);
        sample2.setSale(12.5); d = new Date(12/11/7); sample2.setSaleDate(d);
        ae.add(sample2);
        sample3.setSale(11.99); d = new Date(12/11/22); sample3.setSaleDate(d);
        ae.add(sample3);
        sample4.setSale(39.4); d = new Date(12/12/5); sample4.setSaleDate(d);
        ae.add(sample4);
        sample5.setSale(5.99); d = new Date(12/12/21); sample5.setSaleDate(d);
        ae.add(sample5);

        int i;
        Label l;
        long lo = 0;
        Date dd = new Date(1);
        String si = t2.getText();

        try {
            if (!t2.getText().equals(""))
                d = new Date(Long.getLong(t2.getText()));
            if (!t1.getText().equals(""))
                dd = new Date(Long.getLong(t1.getText()));
        }catch(Exception e){e.printStackTrace(); System.out.println("Input a date" +
                "with the format */*/* please.");}

        double b = 0;
        if(!t1.getText().equals("")) {
            if (!t2.getText().equals("")) {
                for (i = 0; i < ae.size(); i++) {

                    if (ae.get(i).getSaleDate().before(d) &&
                            ae.get(i).getSaleDate().after(dd)) {
                        l = new Label("" + ae.get(i).getSale() + "  " + ae.get(i).getSaleDate());
                        gridPane1.addRow(i, l);
                        b += ae.get(i).getSale();
                    } // Would also add current kanban board information into the gridPane,
                    // but the database can't be pulled from
                }
            } else
                System.out.println("Input a Date Please.");
        }
        b /= .034; // Taking off the tax price from the sales
        profitability.setText("" + b);
        ae.clear();
    }

    public void employeePageButton(ActionEvent actionEvent) {
        Parent rt = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("employeePage.fxml"));
            rt = fxmlLoader.load();
        }catch(Exception e){System.out.println("There's a possible error.");}
        Stage belayer = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        belayer.setScene(new Scene(rt,600,400));
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
}
