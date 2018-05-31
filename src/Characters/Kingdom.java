/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Characters;

/**
 *
 * @author Snooking
 */
public class Kingdom {
    private Farmer farmer;
    private Miner miner;
    private Jeweller jeweller;
    private Armorer armorer;
    private King king;
    private Queen queen;
    
    public Kingdom(Farmer _farmer, Miner _miner, Jeweller _jeweller, Armorer _armorer, King _king, Queen _queen) {
        farmer = _farmer;
        miner = _miner;
        jeweller = _jeweller;
        armorer = _armorer;
        king = _king;
        queen = _queen;
    }
    
    public Kingdom() {
        farmer = new Farmer(10, 10, Material.Meat);
        miner = new Miner(10, 10, Material.Coal);
        jeweller = new Jeweller(10, 10, Material.Jewelry);
        armorer = new Armorer(10, 10, Material.Swords);
    }
}
