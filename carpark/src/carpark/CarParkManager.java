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
public interface CarParkManager {
    public abstract void addVehicle(Vehicle Vehicle);
     public abstract void deleteVehicle();
     public abstract void printVehicleList();
     public abstract boolean runMenu();
     public abstract void printStats();
     public abstract void EntryDateTime();
     public abstract void printParkingCharges();
     


}
