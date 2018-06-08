/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameManagement;

import Characters.Material;

/**
 *
 * @author Snooking
 */
public class Simulator {
    private Kingdom kingdom;
    
    public Simulator(Kingdom _kingdom) {
        kingdom = _kingdom;
    }
    
    private void changeFarmerMaterial() {
        if(kingdom.getMeat()>30 && kingdom.getGrain()<100){
            kingdom.getFarmer().changeMaterial(Material.Grain);
        }
        else kingdom.getFarmer().changeMaterial(Material.Meat);
    }
    
    private void notifyMiner() {
        if (kingdom.getMeat()>=5&&!kingdom.getMiner().getIsNotified()) {
            kingdom.notifyWorker(kingdom.getMiner());
            kingdom.setMeat(kingdom.getMeat()-5);
        }
    }
    
    private void changeMinerMaterial() {
        if(kingdom.getCoal()>10){
            kingdom.getMiner().changeMaterial(Material.Ore);
        }
        if (kingdom.getOre()>10){
            kingdom.getMiner().changeMaterial(Material.Gold);
        }
        if(kingdom.getCoal()<10){
            kingdom.getMiner().changeMaterial(Material.Coal);
        }
    }
    
    private void notifyArmorer() {
        if (kingdom.getCoal()>=10&&kingdom.getOre()>=10&&kingdom.getGrain()>=10&&!kingdom.getArmorer().getIsNotified()){
            kingdom.notifyWorker(kingdom.getArmorer());
            kingdom.setCoal(kingdom.getCoal()-10);
            kingdom.setOre(kingdom.getOre()-10);
            kingdom.setGrain(kingdom.getGrain()-10);
        }
    }
    
    private void notifyJeweller() {
        if (kingdom.getCoal()>=10&&kingdom.getGold()>=10&&kingdom.getGrain()>=10&&!kingdom.getJeweller().getIsNotified()){
            kingdom.notifyWorker(kingdom.getJeweller());
            kingdom.setCoal(kingdom.getCoal()-10);
            kingdom.setGold(kingdom.getGold()-10);
            kingdom.setGrain(kingdom.getGrain()-10);
        }
    }
    
    private void notifyKing() {
        if (kingdom.getSwords()>=20&&kingdom.getMeat()>=50&&!kingdom.getKing().getIsNotified()){
            kingdom.notifyWorker(kingdom.getKing());
            kingdom.setSwords(kingdom.getSwords()-20);
            kingdom.setMeat(kingdom.getMeat()-50);
        }
    }
    
    private void notifyQueen() {
        if (kingdom.getJewelry()>=10&&kingdom.getMeat()>=5&&!kingdom.getQueen().getIsNotified()){
            kingdom.notifyWorker(kingdom.getQueen());
            kingdom.setJewelry(kingdom.getJewelry()-10);
            kingdom.setMeat(kingdom.getMeat()-5);
        }
    }
    
    public void simulate() {
        while(true){
            synchronized(this){
                changeFarmerMaterial();
                notifyMiner();
                changeMinerMaterial();
                notifyArmorer();
                notifyJeweller();
                notifyKing();
                notifyQueen();
                try{
                    wait(100);
                }
                catch (InterruptedException e){}
            }
        }
    }
}
