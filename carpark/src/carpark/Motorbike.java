/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpark;

/**
 *
 * @author w1621095
 */
public class Motorbike extends Vehicle {
    protected int sizeOfEngine;
    
    public Motorbike(String IDplate, String Brand, int sizeOfEngine, DateTime time){
        super(IDplate, Brand, time);
        sizeOfEngine = 0; // default constructor with no arguments 
    }
    
    public void Motorbike(int engine){
        
        this.sizeOfEngine= engine;
    }
    
    public void setEngine (int s){ //set and get methods 
        
        this.sizeOfEngine= s;
    }
    
    public int getEngine(){
        return sizeOfEngine;
    }
    
    public String getV(){
        return "Motorbike";
    }
    
       public String EntryDateTime(String dateStr){ // returns the date and time 
        
        return dateStr;
    }
}
