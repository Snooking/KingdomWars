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
    }
    
    public Kingdom() {        
        jeweller = new Jeweller(10000, 10, Material.Jewelry, this);
        armorer = new Armorer(10000, 10, Material.Swords, this);
        king = new King(10000, 1, Material.Coal, this);
        queen = new Queen(10000, 1, Material.Coal, this);
        miner = new Miner(2500, 10, Material.Coal, this);
        farmer = new Farmer(1500, 10, Material.Meat, this);
        resetValues();
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
    
    private void notifyWorker(Worker workerToNotify) {
        synchronized (workerToNotify) {
            workerToNotify.notify();
            workerToNotify.setIsNotified(true);
        }
    }
    
    private void simulate() {
        if (meat>5&&!miner.getIsNotified()) {
            notifyWorker(miner);
            meat -= 5;
        }
        if (grain > 10 && coal > 10 && ore > 10 && !armorer.getIsNotified()){
            notifyWorker(armorer);
            grain-=10;
            coal-=10;
            ore-=10;
        }
        if(grain > 5 && gold > 5 && coal > 5) {
            notifyWorker(jeweller);
            grain-=5;
            coal-=5;
            gold-=5;
        }
    }
    
    @Override
    public void run() {
        startSimulation();
        while(true) {
            simulate();
        }
    }
}
