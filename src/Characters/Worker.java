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
public abstract class Worker extends Thread{
    protected int workingTime;
    protected int amountOfMaterial;
    protected Material material;
    
    Worker(int time, int amount, Material _material) {
        workingTime = time;
        amountOfMaterial = amount;
        material = _material;
    }
    
    @Override
    public void run() {
        
    }
}
