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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Snooking
 */
public class MainWindowController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    Kingdom firstKingdom;
    
    @FXML Label firstKingdomCoalValue;
    @FXML Label firstKingdomGoldValue;
    @FXML Label firstKingdomOreValue;
    
    @FXML Label firstKingdomGrainValue;
    @FXML Label firstKingdomMeatValue;
    
    @FXML Label firstKingdomSwordsValue;
    @FXML Label firstKingdomJewelryValue;
    
    @FXML Label firstKingdomKnightsValue;
    @FXML Label firstKingdomMoraleValue;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        firstKingdom = new Kingdom();
        
        firstKingdomCoalValue.setText(Integer.toString(firstKingdom.getCoal()));
        firstKingdomGoldValue.setText(Integer.toString(firstKingdom.getGold()));
        firstKingdomOreValue.setText(Integer.toString(firstKingdom.getOre()));
        
        firstKingdomGrainValue.setText(Integer.toString(firstKingdom.getGrain()));
        firstKingdomMeatValue.setText(Integer.toString(firstKingdom.getMeat()));
        
        firstKingdomSwordsValue.setText(Integer.toString(firstKingdom.getSwords()));
        firstKingdomJewelryValue.setText(Integer.toString(firstKingdom.getJewelry()));
        
        firstKingdomKnightsValue.setText(Integer.toString(firstKingdom.getKnights()));
        firstKingdomMoraleValue.setText(Integer.toString(firstKingdom.getMorale()));
    }    
    
}
