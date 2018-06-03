/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomwars;

import GameManagement.Kingdom;
import Characters.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Snooking
 */
public class MainWindowController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private Kingdom firstKingdom;
    
    private @FXML Label firstKingdomCoalValue;
    private @FXML Label firstKingdomGoldValue;
    private @FXML Label firstKingdomOreValue;
    
    private @FXML Label firstKingdomGrainValue;
    private @FXML Label firstKingdomMeatValue;
    
    private @FXML Label firstKingdomSwordsValue;
    private @FXML Label firstKingdomJewelryValue;
    
    private @FXML Label firstKingdomKnightsValue;
    private @FXML Label firstKingdomMoraleValue;
    
    private Timeline refresher;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        firstKingdom = new Kingdom();
        
        refresher = new Timeline(new KeyFrame(Duration.seconds(0.5), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                prepareFirstKingdomUI();
            }
        }));
        refresher.setCycleCount(Timeline.INDEFINITE);
        firstKingdom.start();
        refresher.play();
        
    }    
    
    private void prepareFirstKingdomUI() {
                firstKingdomGrainValue.setText(Integer.toString(firstKingdom.getGrain()));
                firstKingdomMeatValue.setText(Integer.toString(firstKingdom.getMeat()));
                
                firstKingdomCoalValue.setText(Integer.toString(firstKingdom.getCoal()));
                firstKingdomGoldValue.setText(Integer.toString(firstKingdom.getGold()));
                firstKingdomOreValue.setText(Integer.toString(firstKingdom.getOre()));

                firstKingdomSwordsValue.setText(Integer.toString(firstKingdom.getSwords()));
                firstKingdomJewelryValue.setText(Integer.toString(firstKingdom.getJewelry()));

                firstKingdomKnightsValue.setText(Integer.toString(firstKingdom.getKnights()));
                firstKingdomMoraleValue.setText(Integer.toString(firstKingdom.getMorale()));
    }
}
