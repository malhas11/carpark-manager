/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpark;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author w1621095
 */
public class WestminsterCarParkManager {
    private ArrayList<Vehicle> List; // create an array list called VehicleList which holds private variable Vehicle 
     private int numOfVehicles;
     private int FreeLots;
     private Vehicle last;
     private int noCar=0;
     private int noVan=0;
     private int noMotorbike=0;
    Scanner in = new Scanner(System.in);
    public WestminsterCarParkManager() {
        this.last = null;
    }
   
     
     public WestminsterCarParkManager (int listLength){ // public class WestminsterCarparkManager contains the var listLength 
        this.numOfVehicles = listLength;  // the variable numofveh is the list length 
        this.last = null;
        List = new ArrayList<>(); 
        FreeLots= listLength;
     }
      public static void main(String[] args){
        
         //create a parking 
        WestminsterCarParkManager sys = new WestminsterCarParkManager(20);   //20 spaces in list   
        boolean exit = false;
      
        while (!exit){
            exit = sys.mainMenu();
        }
    }
    
       public  void addVehicle(Vehicle Vehicle){
        
        if (List.size() < numOfVehicles){
           List.add(Vehicle);
           if (Vehicle.getV().equals("Car")){
               FreeLots--;
           }
           if (Vehicle.getV().equals("Van")){
               FreeLots=FreeLots-2;
           }
           if (Vehicle.getV().equals("Motorbike")){
               FreeLots--;
           }        
        } 
        else{
            System.out.println("The parking lot is full.");
        }
        
    }
            
    public void deleteVehicle() {
        System.out.println("enter id");
        String kk = in.nextLine();
        
        for (int i = 0; i<List.size(); i++){
            if(((kk).equals(List.get(i).getIDplate())) && (List.get(i).getV().equals("Van"))){
                List.remove(i);
                FreeLots = FreeLots+2;
                System.out.println("number of free lots : " + FreeLots);
            }
            else if (((kk).equals(List.get(i).getIDplate()))){
                        
                    List.remove(i);
                    FreeLots++;
                    System.out.println("number of free lots : " + FreeLots + "type of vehicle is: " + List.get(i).getV());
            }  
               
        
        }
    }
         public void printVehicleList(){
        
        for(int i=0; i < List.size(); i++){
            
            if(List.get(i).getV().equals("Car") ){
                System.out.println("Vehicle = Car, IDplate = " + List.get(i).getIDplate() + ", Brand = " + List.get(i).getBrand() + " entryDate = " + List.get(i).getEntryDateTime().toString());
                
            }
            
            if(List.get(i).getV().equals("Motorbike") ){
                System.out.println("Vehicle = Motorbike, IDplate = " + List.get(i).getIDplate() + ", Brand = " + List.get(i).getBrand() + " entryDate = " +List.get(i).getEntryDateTime().toString());
           
            }
            
            if(List.get(i).getV().equals("Van") ){
                System.out.println("Vehicle = Van, IDplate = " + List.get(i).getIDplate() + ", Brand = " + List.get(i).getBrand()+ " entryDate = " +List.get(i).getEntryDateTime().toString());
            }
        }
        
        
        
        
    }
    
         
    
   




        public boolean mainMenu(){
            
        
        boolean exit = false;
                
        // main menu 
        System.out.println("1 -Add a new vehicle");  
        System.out.println("2 -delete a vehicle");
        System.out.println("3 -print the list of the vehicles");
        System.out.println("4 -print the statistics of the car park");
        System.out.println("5 -print parking charges");
        System.out.println("6 -print the vehicles on a specified date");
        System.out.println("7 -print the vehicle list ordered by time");
            System.out.println("8 -print the last vehicle time/date");
        System.out.println("9 -To exit");
            System.out.println("10 -print the vehicle that spent the most time");
        
        Scanner s = new Scanner (System.in); // scanner creates var s
        int choice = s.nextInt(); // stores user input choice into s
        
        switch(choice){
           case 1:
               System.out.println("1: Car");
               System.out.println("2: Motorbike");
               System.out.println("3: Van"); 
               System.out.println("number of free lots : " + FreeLots);
    
           
                int choice2 = s.nextInt();
                s.nextLine();
                
                System.out.println("Enter your vehicles ID plate");
                String IDplate = s.nextLine();
                
                System.out.println("Enter the brand of your vehicle");
                String Brand = s.nextLine();
                
                System.out.println("Please enter the day of your date");
                int day = s.nextInt();

                System.out.println("Please enter the month of your date");
                int month = s.nextInt();

                System.out.println("Please enter the year of your date");
                int year = s.nextInt();
               
                System.out.println("Please enter the hour of your date");
                int hour = s.nextInt();

                System.out.println("Please enter the minutes of your date");
                int minutes = s.nextInt();
 
                DateTime date = new DateTime(day, month, year, hour, minutes);

                System.out.println("The date you entered is: " + date.toString());
               

               
                switch (choice2){
                
                    case 1:
                        // it is a car 
                        System.out.println("Insert the number of doors ");
                        int NoDoors = s.nextInt();
                        System.out.println("Insert the colour of the Car");
                        String Colour = new Scanner(System.in).nextLine();
                        car c = new car(IDplate, Brand, NoDoors, Colour, date);
                        this.addVehicle(c);
                        noCar++;
                        System.out.println("number of free lots : " + FreeLots);
                        break;
                        
                        
                    case 2:
                        // it is a motorbike
                        System.out.println("Insert the engine size of the motorbike");
                        int sizeOfEngine = s.nextInt();
                        Motorbike m = new Motorbike(IDplate, Brand, sizeOfEngine, date);
                        this.addVehicle(m);
                        noMotorbike++;
                        System.out.println("number of free lots : " + FreeLots);
                        break;
                        
                    case 3:
                        //Van
                        System.out.println("Insert the cargo size of the van");
                        int sizeOfCargo = s.nextInt();
                        van v = new van(IDplate, Brand, sizeOfCargo, date);
                        this.addVehicle(v);
                        noVan++;
                        System.out.println("number of free lots : " + FreeLots);
                        break;
                        
              
        
    } 
        

                break;
    
     
            case 2:
                this.deleteVehicle();
                break;
            
            case 3:
               this.printVehicleList();
               break;
                
            case 4:
                this.printStats();
                
            case 5:
                this.printParkingCharges();
                break;
                
            case 6:
                this.printD();
                break;
            case 7:
                this.orderedList();
                break;
            case 8:
                this.LastEntered();
                break;
            case 9:
                exit = true;
                break;
            case 10:
                this.LongestE();
                break;
        }
        
        
    return exit ;

        }

    private void printStats() {
        for(int i=0; i < List.size(); i++){
            
            if(List.get(i).getV().equals("Car") ){
                System.out.println("Vehicle = Car, IDplate = " + List.get(i).getIDplate() + ", Brand = " + List.get(i).getBrand() + " entryDate = " + List.get(i).getEntryDateTime().toString() + "the percentage of cars in park: " + (noCar*100/20));
            }
            
            if(List.get(i).getV().equals("Motorbike") ){
                System.out.println("Vehicle = Motorbike, IDplate = " + List.get(i).getIDplate() + ", Brand = " + List.get(i).getBrand() + " entryDate = " +List.get(i).getEntryDateTime().toString() + "the percentage of Motorbikes in park: " + (noMotorbike*100/20));
           
            }
            
            if(List.get(i).getV().equals("Van") ){
                System.out.println("Vehicle = Van, IDplate = " + List.get(i).getIDplate() + ", Brand = " + List.get(i).getBrand()+ " entryDate = " +List.get(i).getEntryDateTime().toString() + "the percentage of vans in park: " + (noVan*100/20));
            }
        }
    }

    private void printParkingCharges() {
        int exitHour;
        System.out.println("please enter the idplate of the exiting vehicle: ");
        String ide = in.nextLine();
         System.out.println("Please enter the day of your date");
                int d = in.nextInt();

                System.out.println("Please enter the month of your date");
                int m = in.nextInt();

                System.out.println("Please enter the year of your date");
                int y = in.nextInt();
               
                System.out.println("Please enter the hour of your date");
                int h = in.nextInt();

                System.out.println("Please enter the minutes of your date");
                int min = in.nextInt();
                
                for (int k=0; k<List.size(); k++){
                    
                    if(List.get(k).getIDplate().equals(ide)){
                 
                    if((List.get(k).getEntryDateTime().getYear()) == (y)){
                        if((List.get(k).getEntryDateTime().getMonth()) == (m)){
                            if((List.get(k).getEntryDateTime().getDay()) == (d)){
                                if((List.get(k).getEntryDateTime().getHour()) == h){
                                    if((List.get(k).getEntryDateTime().getMinutes()) == m){
                                        
                                    }else if ((List.get(k).getEntryDateTime().getMinutes()) >= m){
                                        exitHour = h - (List.get(k).getEntryDateTime().getHour());
                                        int exitMinute = m - (List.get(k).getEntryDateTime().getMinutes());
                                        if (exitMinute >= 60){
                                            exitHour++;
                                            if(exitHour >= 3){
                                                System.out.println("the plateID is: " + ide + "the charges for this vehicle is: 3" + (exitHour*3)+1);
                                            }else {
                                                System.out.println("the plateID is: " + ide + "the charges for this vehicle is: 3" + exitHour*3);
                                            }
                                        }
                                    }
                                }else if ((List.get(k).getEntryDateTime().getHour()) >= h){
                                    exitHour = h - (List.get(k).getEntryDateTime().getHour());
                                    if(exitHour >= 3){
                                        System.out.println("the plateID is: " + ide + "the charges for this vehicle is: 3" + (exitHour*3)+1);
                                    }else {
                                        System.out.println("the plateID is: " + ide + "the charges for this vehicle is: 3" + exitHour*3);
                                    }
                                }
                            }else if ((List.get(k).getEntryDateTime().getDay())>= d){
                                int exitDay = d - (List.get(k).getEntryDateTime().getDay());
                                while (exitDay !=0){
                                    System.out.println("the plateID is: " + ide + "the charges for this vehicle is: £" + exitDay*30);
                                }
                            }
                               
                        }
                    } 
                }
                }
                
    }

    private void printD() {
        
            
               System.out.println("Please enter the day of your date");
                int d = in.nextInt();

                System.out.println("Please enter the month of your date");
                int m = in.nextInt();


                System.out.println("Please enter the year of your date");
                int y = in.nextInt();
        
        
            for (int u =0; u<List.size();u++){
                if ((d==(List.get(u).getEntryDateTime().getDay())) && (m ==(List.get(u).getEntryDateTime().getMonth())) && (y==(List.get(u).getEntryDateTime().getYear()))){
                    if(List.get(u).getV().equals("Car") ){
                System.out.println("Vehicle = Car, IDplate = " + List.get(u).getIDplate() + ", Brand = " + List.get(u).getBrand() + " entryDate = " + List.get(u).getEntryDateTime().toString());
            }
                
            
            if(List.get(u).getV().equals("Motorbike") ){
                System.out.println("Vehicle = Motorbike, IDplate = " + List.get(u).getIDplate() + ", Brand = " + List.get(u).getBrand() + " entryDate = " +List.get(u).getEntryDateTime().toString());
           
            }
            
            if(List.get(u).getV().equals("Van") ){
                System.out.println("Vehicle = Van, IDplate = " + List.get(u).getIDplate() + ", Brand = " + List.get(u).getBrand()+ " entryDate = " +List.get(u).getEntryDateTime().toString());
            }
                }else {
                    System.out.println("no vehicle entered in that day");
            }
            }

        }   

    private void orderedList() {
        
        
            int size = List.size();
            do {

            for (int i = 0; i < size-1; i++) {

                if (List.get(i).getEntryDateTime().getYear() > List.get(i + 1).getEntryDateTime().getYear()) {
                    Collections.swap(List, i, i+1);

                }
                if ((List.get(i).getEntryDateTime().getMonth() > List.get(i+1).getEntryDateTime().getMonth()) && (List.get(i).getEntryDateTime().getYear() <= List.get(i + 1).getEntryDateTime().getYear())){
                    Collections.swap(List, i, i+1);
                }
                if((List.get(i).getEntryDateTime().getDay()> List.get(i+1).getEntryDateTime().getDay()) && ((List.get(i).getEntryDateTime().getMonth() <= List.get(i+1).getEntryDateTime().getMonth()) && (List.get(i).getEntryDateTime().getYear() <= List.get(i + 1).getEntryDateTime().getYear()))){
                    Collections.swap(List, i, i+1);
                }
               if((List.get(i).getEntryDateTime().getHour()>List.get(i+1).getEntryDateTime().getHour()) && ((List.get(i).getEntryDateTime().getDay()<= List.get(i+1).getEntryDateTime().getDay()) && ((List.get(i).getEntryDateTime().getMonth() <= List.get(i+1).getEntryDateTime().getMonth()) && (List.get(i).getEntryDateTime().getYear() <= List.get(i + 1).getEntryDateTime().getYear())))){
                    Collections.swap(List, i, i+1);
                }
                if(((List.get(i).getEntryDateTime().getMinutes() > List.get(i+1).getEntryDateTime().getMinutes())) && ((List.get(i).getEntryDateTime().getHour()<=List.get(i+1).getEntryDateTime().getHour()) && ((List.get(i).getEntryDateTime().getDay()<= List.get(i+1).getEntryDateTime().getDay()) && ((List.get(i).getEntryDateTime().getMonth() <= List.get(i+1).getEntryDateTime().getMonth()) && (List.get(i).getEntryDateTime().getYear() <= List.get(i + 1).getEntryDateTime().getYear()))))){
                    Collections.swap(List, i, i+1);
            }
                
            }
            size = size - 1;
        } while (size != 1);
            for(int i=0; i < List.size(); i++){
            
            if(List.get(i).getV().equals("Car") ){
                System.out.println("Vehicle = Car, IDplate = " + List.get(i).getIDplate() + ", Brand = " + List.get(i).getBrand() + " entryDate = " + List.get(i).getEntryDateTime().toString());
            }
            
            if(List.get(i).getV().equals("Motorbike") ){
                System.out.println("Vehicle = Motorbike, IDplate = " + List.get(i).getIDplate() + ", Brand = " + List.get(i).getBrand() + " entryDate = " +List.get(i).getEntryDateTime().toString());
           
            }
            
            if(List.get(i).getV().equals("Van") ){
                System.out.println("Vehicle = Van, IDplate = " + List.get(i).getIDplate() + ", Brand = " + List.get(i).getBrand()+ " entryDate = " +List.get(i).getEntryDateTime().toString());
            }
        }
    }

    private void LastEntered() {
        int size = List.size();
            

            for (int i = 0; i < size-1; i++) {

                if (List.get(i).getEntryDateTime().getYear() > List.get(i + 1).getEntryDateTime().getYear()) {
                    Collections.swap(List, i, i+1);

                }
                if ((List.get(i).getEntryDateTime().getMonth() > List.get(i+1).getEntryDateTime().getMonth()) && (List.get(i).getEntryDateTime().getYear() <= List.get(i + 1).getEntryDateTime().getYear())){
                    Collections.swap(List, i, i+1);
                }
                if((List.get(i).getEntryDateTime().getDay()> List.get(i+1).getEntryDateTime().getDay()) && ((List.get(i).getEntryDateTime().getMonth() <= List.get(i+1).getEntryDateTime().getMonth()) && (List.get(i).getEntryDateTime().getYear() <= List.get(i + 1).getEntryDateTime().getYear()))){
                    Collections.swap(List, i, i+1);
                }
               if((List.get(i).getEntryDateTime().getHour()>List.get(i+1).getEntryDateTime().getHour()) && ((List.get(i).getEntryDateTime().getDay()<= List.get(i+1).getEntryDateTime().getDay()) && ((List.get(i).getEntryDateTime().getMonth() <= List.get(i+1).getEntryDateTime().getMonth()) && (List.get(i).getEntryDateTime().getYear() <= List.get(i + 1).getEntryDateTime().getYear())))){
                    Collections.swap(List, i, i+1);
                }
                if(((List.get(i).getEntryDateTime().getMinutes() > List.get(i+1).getEntryDateTime().getMinutes())) && ((List.get(i).getEntryDateTime().getHour()<=List.get(i+1).getEntryDateTime().getHour()) && ((List.get(i).getEntryDateTime().getDay()<= List.get(i+1).getEntryDateTime().getDay()) && ((List.get(i).getEntryDateTime().getMonth() <= List.get(i+1).getEntryDateTime().getMonth()) && (List.get(i).getEntryDateTime().getYear() <= List.get(i + 1).getEntryDateTime().getYear()))))){
                    Collections.swap(List, i, i+1);
                }
                
            }
            
            int f = 0;
            
                
                    if(List.get(f).getV().equals("Car") ){
                        System.out.println("Vehicle = Car, IDplate = " + List.get(f).getIDplate() + ", Brand = " + List.get(f).getBrand() + " entryDate = " + List.get(f).getEntryDateTime().toString());
                    }
            
                    if(List.get(f).getV().equals("Motorbike") ){
                        System.out.println("Vehicle = Motorbike, IDplate = " + List.get(f).getIDplate() + ", Brand = " + List.get(f).getBrand() + " entryDate = " +List.get(f).getEntryDateTime().toString());
           
                    }
            
                    if(List.get(f).getV().equals("Van") ){
                            System.out.println("Vehicle = Van, IDplate = " + List.get(f).getIDplate() + ", Brand = " + List.get(f).getBrand()+ " entryDate = " +List.get(f).getEntryDateTime().toString());
                    }
                
            
        
    }

    private void LongestE() {
        int size = List.size();
            

            for (int i = 0; i < size-1; i++) {

                if (List.get(i).getEntryDateTime().getYear() > List.get(i + 1).getEntryDateTime().getYear()) {
                    Collections.swap(List, i, i+1);

                }
                if ((List.get(i).getEntryDateTime().getMonth() > List.get(i+1).getEntryDateTime().getMonth()) && (List.get(i).getEntryDateTime().getYear() <= List.get(i + 1).getEntryDateTime().getYear())){
                    Collections.swap(List, i, i+1);
                }
                if((List.get(i).getEntryDateTime().getDay()> List.get(i+1).getEntryDateTime().getDay()) && ((List.get(i).getEntryDateTime().getMonth() <= List.get(i+1).getEntryDateTime().getMonth()) && (List.get(i).getEntryDateTime().getYear() <= List.get(i + 1).getEntryDateTime().getYear()))){
                    Collections.swap(List, i, i+1);
                }
               if((List.get(i).getEntryDateTime().getHour()>List.get(i+1).getEntryDateTime().getHour()) && ((List.get(i).getEntryDateTime().getDay()<= List.get(i+1).getEntryDateTime().getDay()) && ((List.get(i).getEntryDateTime().getMonth() <= List.get(i+1).getEntryDateTime().getMonth()) && (List.get(i).getEntryDateTime().getYear() <= List.get(i + 1).getEntryDateTime().getYear())))){
                    Collections.swap(List, i, i+1);
                }
                if(((List.get(i).getEntryDateTime().getMinutes() > List.get(i+1).getEntryDateTime().getMinutes())) && ((List.get(i).getEntryDateTime().getHour()<=List.get(i+1).getEntryDateTime().getHour()) && ((List.get(i).getEntryDateTime().getDay()<= List.get(i+1).getEntryDateTime().getDay()) && ((List.get(i).getEntryDateTime().getMonth() <= List.get(i+1).getEntryDateTime().getMonth()) && (List.get(i).getEntryDateTime().getYear() <= List.get(i + 1).getEntryDateTime().getYear()))))){
                    Collections.swap(List, i, i+1);
                }
                
            }
            
            int f = size-1;
            
                
                    if(List.get(f).getV().equals("Car") ){
                        System.out.println("Vehicle = Car, IDplate = " + List.get(f).getIDplate() + ", Brand = " + List.get(f).getBrand() + " entryDate = " + List.get(f).getEntryDateTime().toString());
                    }
            
                    if(List.get(f).getV().equals("Motorbike") ){
                        System.out.println("Vehicle = Motorbike, IDplate = " + List.get(f).getIDplate() + ", Brand = " + List.get(f).getBrand() + " entryDate = " +List.get(f).getEntryDateTime().toString());
           
                    }
            
                    if(List.get(f).getV().equals("Van") ){
                            System.out.println("Vehicle = Van, IDplate = " + List.get(f).getIDplate() + ", Brand = " + List.get(f).getBrand()+ " entryDate = " +List.get(f).getEntryDateTime().toString());
                    }
                
    }
                 
           
    
}

    
