/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameManagement;

import Characters.*;

/**
 *
 * @author Snooking
 */

public class Kingdom extends Thread {
    private Farmer farmer;
    private Miner miner;
    private Jeweller jeweller;
    private Armorer armorer;
    private King king;
    private Queen queen;

    public Farmer getFarmer() {
        return farmer;
    }

    public Miner getMiner() {
        return miner;
    }

    public Jeweller getJeweller() {
        return jeweller;
    }

    public Armorer getArmorer() {
        return armorer;
    }

    public King getKing() {
        return king;
    }

    public Queen getQueen() {
        return queen;
    }
    
    private Simulator simulator;
    
    private int coal;
    private int ore;
    private int gold;
    
    private int meat;
    private int grain;
    
    private int swords;
    private int jewelry;
    
    private int knights;
    private int morale;

    public int getCoal() {
        return coal;
    }

    public int getOre() {
        return ore;
    }

    public int getGold() {
        return gold;
    }

    public int getMeat() {
        return meat;
    }

    public void setMeat(int meat) {
        this.meat = meat;
    }

    public void setCoal(int coal) {
        this.coal = coal;
    }

    public void setOre(int ore) {
        this.ore = ore;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setGrain(int grain) {
        this.grain = grain;
    }

    public void setSwords(int swords) {
        this.swords = swords;
    }

    public void setJewelry(int jewelry) {
        this.jewelry = jewelry;
    }

    public void setMorale(int morale) {
        this.morale = morale;
    }
    
    public int getGrain() {
        return grain;
    }

    public void setKnights(int knights) {
        this.knights = knights;
    }

    public int getSwords() {
        return swords;
    }

    public int getJewelry() {
        return jewelry;
    }

    public int getKnights() {
        return knights;
    }

    public int getMorale() {
        return morale;
    }
    
    public Kingdom(Farmer _farmer, Miner _miner, Jeweller _jeweller, Armorer _armorer, King _king, Queen _queen) {
        farmer = _farmer;
        miner = _miner;
        jeweller = _jeweller;
        armorer = _armorer;
        king = _king;
        queen = _queen;
        resetValues();
        simulator = new Simulator(this);
    }
    
    public Kingdom() {        
        jeweller = new Jeweller(10000, 10, Material.Jewelry, this);
        armorer = new Armorer(10000, 10, Material.Swords, this);
        king = new King(10000, 1, Material.Knights, this);
        queen = new Queen(10000, 1, Material.Morale, this);
        miner = new Miner(2500, 10, Material.Coal, this);
        farmer = new Farmer(1500, 10, Material.Meat, this);
        resetValues();
        simulator = new Simulator(this);
    }
    
    private void resetValues() {
        coal = 0;
        gold = 0;
        ore = 0;
        meat = 0;
        grain = 0;
        swords = 0;
        jewelry = 0;
        knights = 0;
        morale = 0;
    }
    
    public void startSimulation() {
        farmer.start();
        miner.start();
        armorer.start();
        jeweller.start();
        notifyWorker(farmer);        
    }
    
    public void notifyWorker(Worker workerToNotify) {
        synchronized (workerToNotify) {
            workerToNotify.notify();
            workerToNotify.setIsNotified(true);
        }
    }
    
    @Override
    public void run() {
        startSimulation();
        simulator.simulate();
    }
}
