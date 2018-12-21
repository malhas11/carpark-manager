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
public class van extends Vehicle {
    protected int sizeOfCargo;
    
    public van(String IDplate, String Brand, int sizeOfCargo, DateTime time){
        super(IDplate, Brand, time);
        sizeOfCargo = 0; // default constructor with no arguments 
    }
    
    public void Van(int cargo){
        
        this.sizeOfCargo= cargo;
    }
    
    public void setCargo (int m){ //set and get methods 
        this.sizeOfCargo = m;
        
    }
    
    public int getCargo(){
        return sizeOfCargo;
    }
    
    public String getV(){
        return "Van";
    }
    
       public String EntryDateTime(String dateStr){ // returns the date and time 
        
        return dateStr;
    }
}
