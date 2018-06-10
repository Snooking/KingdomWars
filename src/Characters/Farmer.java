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
public class Farmer extends Worker {
    
    public Farmer(int time, int amount, Material _material, Kingdom _kingdom) {
        super(time, amount, _material, _kingdom);
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                startTime = System.nanoTime();
                Thread.sleep(workingTime);
            } catch (InterruptedException e) {
            }
            collectMaterial();
        }
    }
}
