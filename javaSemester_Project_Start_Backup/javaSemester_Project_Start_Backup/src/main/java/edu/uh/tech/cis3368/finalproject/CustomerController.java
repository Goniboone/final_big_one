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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

@Controller
public class CustomerController {

    @FXML
    public TextField t1;
    public TextField t2;
    public TextField t3;
    public GridPane gridPane;


    //@Autowired
    //private ApplicationContext appCont;



    @Autowired
    private CustRepository cres;

    @Autowired
    private DesignRepository dres;

    @Autowired
    private PartRepository partRepository;


    public void submitButton(ActionEvent actionEvent) {
        DesignEntity d = new DesignEntity();
        CustomerEntity c = new CustomerEntity();
        if(t1.getText().equals("") || t2.getText().equals("")
                || t3.getText().equals("")){
            System.out.println("Missing field"); }
                else {
                    try {
                        c.setLastName(t2.getText());
                        c.setFirstName(t1.getText());

                        d.setDesignName(t3.getText());
                        d.setCustomer(c);

                        cres.save(c);
                        dres.save(d);
                    }catch(Exception e){e.printStackTrace();}
        }
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

    public void addParts() {

        Set<Node> deleteNodes = new HashSet<>();
        for (Node child : gridPane.getChildren()) {

            Integer rowIndex = GridPane.getRowIndex(child);

            int r = rowIndex == null ? 0 : rowIndex;

            if (r > gridPane.getRowCount()) {

                GridPane.setRowIndex(child, r-1);
            } else if (r == gridPane.getRowCount()) {

                deleteNodes.add(child);
            }
        }
        // Removes all nodes in the table
        gridPane.getChildren().removeAll(deleteNodes);

        int i;
        PartEntity p = new PartEntity();
        Label la = null;

        //Iterator<PartEntity> iterator = pres.findAll().iterator();

        for(i=1;i<=15;i++) {

            //appCont.getAutowireCapableBeanFactory();
            p = partRepository.findByPartId(i);
            //p = iterator.next();
            //pres.findAll().forEach()

             //   p = pres.findById(ii).get();

            la = new Label(p.getComponentName() + " & $" + p.getCost());
            gridPane.addRow(i-1, la);
        }

    }

}
