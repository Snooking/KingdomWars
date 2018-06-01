/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Characters;

import GameManagement.*;

/**
 *
 * @author Snooking
 */
public class Farmer extends Worker {
    
    private Miner miner;
    
    public Farmer(int time, int amount, Material _material, Miner _miner, Kingdom _kingdom) {
        super(time, amount, _material, _kingdom);
        miner = _miner;
    }
    
    @Override
    public void run() {
        while(!GameManager.getIsGameEnded()) {
            synchronized(this) {
                try {
                    Thread.sleep(workingTime);
                }
                catch (InterruptedException e) {
                }
                
                synchronized(this.miner){
                    this.miner.notify();
                    kingdom.setMeat(kingdom.getMeat() + amountOfMaterial);
                }
            }
        }
    }
}
