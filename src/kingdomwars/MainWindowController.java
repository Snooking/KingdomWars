/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomwars;

import Characters.Kingdom;
import Characters.Material;
import Characters.Miner;
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
    
    @FXML Label firstKingdomCoalValue;
    @FXML Label firstKingdomGoldValue;
    @FXML Label firstKingdomOreValue;
    
    @FXML Label firstKingdomGrainValue;
    @FXML Label firstKingdomMeatValue;
    
    @FXML Label firstKingdomSwordsValue;
    @FXML Label firstKingdomJewelryValue;
    
    @FXML Label firstKingdomKnightsValue;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        firstKingdomCoalValue.setText("50");
        firstKingdomGoldValue.setText("60");
        firstKingdomOreValue.setText("70");
        
        firstKingdomGrainValue.setText("80");
        firstKingdomMeatValue.setText("90");
        
        firstKingdomSwordsValue.setText("100");
        firstKingdomJewelryValue.setText("110");
        
        firstKingdomKnightsValue.setText("120");
    }    
    
}
