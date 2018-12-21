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
abstract class Vehicle {
    protected String IDplate;
   protected String Brand;
   protected DateTime entryTime;
   
   public Vehicle(String IDplate, String Brand, DateTime entryTime){
       this.IDplate = IDplate;
       this.Brand = Brand;
       this.entryTime = entryTime;
   }
   
    public void setIDplate(String IDplate) {
        this.IDplate = IDplate;
    }

    public String getIDplate() {  // public method to retrive ID plate
        return IDplate;
    }
 
    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public String getBrand() {  // public method to retrive the Brand
        return Brand;
    }
  
    
     public void setEntryDateTime(DateTime entryDate){
        
          this.entryTime = entryDate;
    }
       
     public DateTime getEntryDateTime(){
        
          
          return entryTime;
    }
    @Override
    public String toString(){
        return IDplate + Brand + entryTime;
    }

   public abstract String getV();
}
