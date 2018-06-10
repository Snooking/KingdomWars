/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomwars;

import Characters.*;
import GameManagement.Kingdom;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Snooking
 */
public class StatsWindowController implements Initializable {

    
    private @FXML TextField FarmerTime;
    private @FXML TextField MinerTime;
    private @FXML TextField ArmorerTime;
    private @FXML TextField JewellerTime;
    private @FXML TextField KingTime;
    private @FXML TextField QueenTime;
    
    private @FXML TextField FarmerAmount;
    private @FXML TextField MinerAmount;
    private @FXML TextField ArmorerAmount;
    private @FXML TextField JewellerAmount;
    private @FXML TextField KingAmount;
    private @FXML TextField QueenAmount;
    
    private @FXML Button Start;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Start.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                try {
                    prepareFirstKingdom();
                } catch (Exception ex) {
                    Logger.getLogger(StatsWindowController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
});
    }   
    
    public void prepareFirstKingdom() throws Exception{
        
        Kingdom kingdom = new Kingdom();

        Farmer farmer = new Farmer(Integer.parseInt(FarmerTime.textProperty().getValue()) * 1000, 
                Integer.parseInt(FarmerAmount.textProperty().getValue()), Material.Meat, kingdom);
 
        Miner miner = new Miner(Integer.parseInt(MinerTime.textProperty().getValue()) * 1000, 
                Integer.parseInt(MinerAmount.textProperty().getValue()), Material.Coal, kingdom);
        
        Armorer armorer = new Armorer(Integer.parseInt(ArmorerTime.textProperty().getValue()) * 1000, 
                Integer.parseInt(ArmorerAmount.textProperty().getValue()), Material.Swords, kingdom);
        
        Jeweller jeweller = new Jeweller(Integer.parseInt(JewellerTime.textProperty().getValue()) * 1000, 
                Integer.parseInt(JewellerAmount.textProperty().getValue()), Material.Jewelry, kingdom);
        
        King king = new King(Integer.parseInt(KingTime.textProperty().getValue()) * 1000, 
                Integer.parseInt(KingAmount.textProperty().getValue()), Material.Knights, kingdom);
                
        Queen queen = new Queen(Integer.parseInt(QueenTime.textProperty().getValue()) * 1000, 
                Integer.parseInt(QueenAmount.textProperty().getValue()), Material.Morale, kingdom);
        
        kingdom.setArmorer(armorer);
        kingdom.setFarmer(farmer);
        kingdom.setMiner(miner);
        kingdom.setJeweller(jeweller);
        kingdom.setKing(king);
        kingdom.setQueen(queen);
        
        KingdomWars main = new KingdomWars();
        main.showMainWindow(kingdom);
    }
}
