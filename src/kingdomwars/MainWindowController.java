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
import javafx.scene.control.ProgressBar;
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
    
    public void setKingdom(Kingdom kingdom) {
        this.firstKingdom = kingdom;
    }
    
    private @FXML Label firstKingdomCoalValue;
    private @FXML Label firstKingdomGoldValue;
    private @FXML Label firstKingdomOreValue;
    private @FXML ProgressBar firstKingdomMinerProgress;
    
    private @FXML Label firstKingdomGrainValue;
    private @FXML Label firstKingdomMeatValue;
    
    private @FXML ProgressBar firstKingdomFarmerProgress;
    
    private @FXML Label firstKingdomSwordsValue;
    private @FXML ProgressBar firstKingdomArmorerProgress;
    
    private @FXML Label firstKingdomJewelryValue;
    private @FXML ProgressBar firstKingdomJewellerProgress;
    
    private @FXML Label firstKingdomKnightsValue;
    private @FXML ProgressBar firstKingdomKingProgress;
    
    private @FXML Label firstKingdomMoraleValue;
    private @FXML ProgressBar firstKingdomQueenProgress;
    private @FXML Label firstKingdomEvents;
    
    private Kingdom secondKingdom;
    
    private @FXML Label secondKingdomCoalValue;
    private @FXML Label secondKingdomGoldValue;
    private @FXML Label secondKingdomOreValue;
    private @FXML ProgressBar secondKingdomMinerProgress;
    
    private @FXML Label secondKingdomGrainValue;
    private @FXML Label secondKingdomMeatValue;
    private @FXML ProgressBar secondKingdomFarmerProgress;
    
    private @FXML Label secondKingdomSwordsValue;
    private @FXML ProgressBar secondKingdomArmorerProgress;
    
    private @FXML Label secondKingdomJewelryValue;
    private @FXML ProgressBar secondKingdomJewellerProgress;
    
    private @FXML Label secondKingdomKnightsValue;
    private @FXML ProgressBar secondKingdomKingProgress;
    
    private @FXML Label secondKingdomMoraleValue;
    private @FXML ProgressBar secondKingdomQueenProgress;
    
    private @FXML Label secondKingdomEvents;
    
    private Timeline refresher;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //firstKingdom = new Kingdom();        
        secondKingdom = new Kingdom();
    }    
    
    public void startSimulation() {
        refresher = new Timeline(new KeyFrame(Duration.seconds(0.1), new EventHandler<ActionEvent>() {

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
                
                firstKingdomMinerProgress.setProgress(firstKingdom.getMiner().getProgress());
                firstKingdomFarmerProgress.setProgress(firstKingdom.getFarmer().getProgress());
                firstKingdomArmorerProgress.setProgress(firstKingdom.getArmorer().getProgress());
                firstKingdomJewellerProgress.setProgress(firstKingdom.getJeweller().getProgress());
                firstKingdomKingProgress.setProgress(firstKingdom.getKing().getProgress());
                firstKingdomQueenProgress.setProgress(firstKingdom.getQueen().getProgress());
                
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
                
                secondKingdomMinerProgress.setProgress(secondKingdom.getMiner().getProgress());
                secondKingdomFarmerProgress.setProgress(secondKingdom.getFarmer().getProgress());
                secondKingdomArmorerProgress.setProgress(secondKingdom.getArmorer().getProgress());
                secondKingdomJewellerProgress.setProgress(secondKingdom.getJeweller().getProgress());
                secondKingdomKingProgress.setProgress(secondKingdom.getKing().getProgress());
                secondKingdomQueenProgress.setProgress(secondKingdom.getQueen().getProgress());
                
                secondKingdomEvents.setText(secondKingdom.getEvents());
    }
}
