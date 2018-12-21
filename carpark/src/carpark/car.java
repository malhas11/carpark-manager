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
public class car extends Vehicle{
protected String Colour;
    protected int NoDoors;
    

    

    car(String IDplate, String Brand, int NoDoors, String Colour, DateTime time) {
        super(IDplate, Brand, time);
        this.NoDoors = NoDoors;
        this.Colour = Colour;
    }

    // public method to set the number of doors
    public void setNoDoors(int NoDoors) {
        this.NoDoors = NoDoors;
    }

    public int getNoDoors() {  // public method to retrive the number of doors
        return NoDoors;
    }
    
    public void setColour(){ // set method
        this.Colour = "Colour";
    }
    // public method to retrieve colour
    public String getColour(){
        return Colour;
    }
    
    
      public String EntryDateTime(String dateStr){ // returns the date and time 
        
        return dateStr;
    }

    
    public String getV(){
        return "Car";
    }
    
    
}
