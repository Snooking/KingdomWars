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
    
    private @FXML Label firstKingdomEvents;
    
    private Kingdom secondKingdom;
    
    private @FXML Label secondKingdomCoalValue;
    private @FXML Label secondKingdomGoldValue;
    private @FXML Label secondKingdomOreValue;
    
    private @FXML Label secondKingdomGrainValue;
    private @FXML Label secondKingdomMeatValue;
    
    private @FXML Label secondKingdomSwordsValue;
    private @FXML Label secondKingdomJewelryValue;
    
    private @FXML Label secondKingdomKnightsValue;
    private @FXML Label secondKingdomMoraleValue;
    
    private @FXML Label secondKingdomEvents;
    
    private Timeline refresher;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        firstKingdom = new Kingdom();        
        secondKingdom = new Kingdom();

        refresher = new Timeline(new KeyFrame(Duration.seconds(0.5), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                prepareFirstKingdomUI();
                prepareSecondKingdomUI();
            }
        }));
        refresher.setCycleCount(Timeline.INDEFINITE);
        firstKingdom.start();
        secondKingdom.start();
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
                
                firstKingdomEvents.setText(firstKingdom.getEvents());
    }
    
    private void prepareSecondKingdomUI() {
                secondKingdomGrainValue.setText(Integer.toString(secondKingdom.getGrain()));
                secondKingdomMeatValue.setText(Integer.toString(secondKingdom.getMeat()));
                
                secondKingdomCoalValue.setText(Integer.toString(secondKingdom.getCoal()));
                secondKingdomGoldValue.setText(Integer.toString(secondKingdom.getGold()));
                secondKingdomOreValue.setText(Integer.toString(secondKingdom.getOre()));

                secondKingdomSwordsValue.setText(Integer.toString(secondKingdom.getSwords()));
                secondKingdomJewelryValue.setText(Integer.toString(secondKingdom.getJewelry()));

                secondKingdomKnightsValue.setText(Integer.toString(secondKingdom.getKnights()));
                secondKingdomMoraleValue.setText(Integer.toString(secondKingdom.getMorale()));
                
                secondKingdomEvents.setText(secondKingdom.getEvents());
    }
}
