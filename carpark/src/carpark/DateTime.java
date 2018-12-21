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
public class DateTime {
     private int year;
    private int month;
    private int day;
    private int hour;
    private int minutes;
    
    
    public DateTime (int day, int month, int year, int hour, int minutes){
        if ((year > 1939) && (year<2099) && (month > 0) && (month<13) && (day > 0) && (day<32) && (hour > 0 ) && (hour<24) && (minutes>0) && (minutes<60)){
            this.day = day;
            this.month = month;
            this.year = year;
            this.hour= hour;
            this.minutes= minutes;
        }  
        else{
            System.out.println("Not correct date");
        }
}
    public DateTime (){
        
    }
    public void setYear(int year){
        if ((year > 1939) && (year<2099)){
        this.year = year;
        }
        else{
            System.out.println("Not correct range");
        }   
    }
    
    public void setMonth(int month){
        if ((month > 0) && (month<13)){
            this.month = month;
        }else{
            System.out.println("Not correct range");
        }
    }
    
    public void setDay(int day){
        if ((day > 0) && (day<32)){
            this.day = day;
        }else{
            System.out.println("Not correct range");
        }
        
    }
    public void setMinutes(int minutes){
        if ((minutes > 0) && (minutes<60)){
            this.minutes = minutes;
        }else{
            System.out.println("Not correct range");
        }
    }
    
    public void setHour(int hour){
        if ((hour > 0) && (hour < 24)){
           this.hour = hour;
        }else{
            System.out.println("Not correct range");
        }
    }
    
    public int getYear(){
        return year;
    }
    
    public int getMonth(){
        return month;
    }
    
    public int getDay(){
        return day;
    }
    
    public int getHour(){
        return hour;
    }
    
    public int getMinutes(){
        return minutes;
    }
    public String getDate(){
        String entryDate= String.format("%02d/%02d/%04d", day, month, year);
        return entryDate;
    }
    
    public String getTime(){
        String entryTime= String.format("%02d/%02d", hour, minutes);
        return entryTime;
    }
      
    public String toString(){
        String entryDate = String.format("%02d/%02d/%04d %02d:%02d", day, month, year, hour, minutes);
        return entryDate;
    }

    

}
