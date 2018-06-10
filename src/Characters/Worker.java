/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Characters;

import GameManagement.Kingdom;

/**
 *
 * @author Snooking
 */
public abstract class Worker extends Thread{
    protected int workingTime;
    protected int amountOfMaterial;
    protected Material material;
    protected Kingdom kingdom;
    protected boolean isNotified;
    protected long startTime;
    
    protected Worker(int time, int amount, Material _material, Kingdom _kingdom) {
        workingTime = time;
        amountOfMaterial = amount;
        material = _material;
        kingdom = _kingdom;
        isNotified = false;
        startTime = 0;
    }
    
    public void changeMaterial(Material _material) {
        material = _material;
    }
    
    public void setIsNotified(boolean _isNotified) {
        isNotified = _isNotified;
    }
    
    public Boolean getIsNotified() {
        return isNotified;
    }
    
    public double getProgress(){
        double value = ((double)System.nanoTime() - (double)startTime)/((double)workingTime*1000000.0);
        if (value<=1)
            return value;
        return 0;
    }
    
    protected void collectMaterial() {
        switch(material) {
            case Meat:
                kingdom.setMeat(kingdom.getMeat() + amountOfMaterial);
                break;
            case Grain:
                kingdom.setGrain(kingdom.getGrain() + amountOfMaterial);
                break;
            case Coal:
                kingdom.setCoal(kingdom.getCoal() + amountOfMaterial);
                break;
            case Ore:
                kingdom.setOre(kingdom.getOre() + amountOfMaterial);
                break;
            case Gold:
                kingdom.setGold(kingdom.getGold() + amountOfMaterial);
                break;
            case Jewelry:
                kingdom.setJewelry(kingdom.getJewelry()+ amountOfMaterial);
                break;
            case Swords:
                kingdom.setSwords(kingdom.getSwords() + amountOfMaterial);
                break;
            case Knights:
                kingdom.setKnights(kingdom.getKnights()+ amountOfMaterial);
                break;
            case Morale:
                kingdom.setMorale(kingdom.getMorale() + amountOfMaterial);
                break;
        }
    }
    
    public String tellWhatStarted() {
        String started = this.getClass().getSimpleName();
        started += " started collecting ";
        started += (material);
        started += (" in amount ");
        started += (amountOfMaterial);
        started += '\n';
        return started;
    }

        @Override
        public void run() {
        while (true) {
            synchronized (this) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                }
            }

            try {
                startTime = System.nanoTime();
                Thread.sleep(workingTime);
            } catch (InterruptedException e) {
            }

            collectMaterial();
            isNotified = false;
        }
    }
}