/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alex.motorph;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Alex Resurreccion
 */
public class WeeklyWorkedHours {
    private MonthBasis monthBasis = new MonthBasis();
    private AttendanceRecord attendanceRecord = new AttendanceRecord();
    private LocalDate[] weekPeriod;
    private String[] timeIn = new String[7];
    private String[] timeOut = new String[7];
    
    private LocalDate askAndGetWeekPeriod(){
        // add do while to catch exception
        System.out.println("Enter valid week period");
        System.out.println("Use this format (MM/DD/YYYY) ex. 01/01/2001");
        Scanner myScanner = new Scanner(System.in);
        String inputDate = myScanner.nextLine();
        return monthBasis.convertToLocalDate(inputDate);
    }
    
    private LocalDate[] getWeekPeriodLocalDate(LocalDate date){
       return monthBasis.getWeekPeriod(date); 
    }
    
    public void askAndGetWeekPeriodLocalDate(String firstName,String lastName){
        LocalDate date = askAndGetWeekPeriod();
        this.weekPeriod = getWeekPeriodLocalDate(date);
        setWeeklyAttendance(firstName, lastName, weekPeriod);
    }
    
    public boolean isLastSunday(LocalDate date){
        return monthBasis.isLastSunday(date);
    }
    
    public void setWeeklyAttendance(String firstName,String lastName, LocalDate[] weekPeriod){
        ArrayList<String> record = attendanceRecord.getAttendance(firstName, lastName, weekPeriod);
        int recordIndex = 0;
        for(int i=0; i<7; i++){
            String[] dataRecord = record.get(recordIndex).split(",");
            LocalDate rowDate = monthBasis.convertToLocalDate(dataRecord[3]);
            if(rowDate.equals(weekPeriod[i])){
                timeIn[i] = dataRecord[4];
                timeOut[i] = dataRecord[5];
                if(recordIndex < record.size()-1){
                    recordIndex++;
                }
            } else {
                timeIn[i] = "0:00";
                timeOut[i] = "0:00";
            }
        }
    }
    //insert main method here
    public void main(Employee employeeInformation){
        char userInput;
        Scanner myScanner = new Scanner(System.in);
        do{
            askAndGetWeekPeriodLocalDate(employeeInformation.getFirstName(), employeeInformation.getLastName());
            double totalHours = calculateWeeklyHours();
            // format totalWeeklyHours to 2 decimal value to roundoff
            String result = String.format("%.2f", totalHours);
            System.out.println("Week period: " + this.weekPeriod[0] + " - " + this.weekPeriod[6]);
            System.out.println("Total Weekly Hours: "+ result);
            
            System.out.println("do you want to see other weekly hours? y/n"); // println for user to see
            userInput = myScanner.next().charAt(0);// get user input char and set the value to userInput
        } while (userInput == 'y');
    }
    
    public double calculateWeeklyHours(){
        double totalHours = 0;

        // loop timeIn and timeOut to call computeDailyHours 7 times
        for (int i = 0; i < 7; i++) {
            totalHours += computeDailyHours(timeIn[i], timeOut[i]);
        }
        
        return totalHours;
    }
    
    public double computeDailyHours(String timeIn, String timeOut){
        double breakTime = 1.00;
        // split string value between : to get hours and minutes
        String[] timeInArr = timeIn.split(":", 2); // after split ["8", "27"]
        String[] timeOutArr = timeOut.split(":", 2);
        // get hour and minutes but convert to double first for computation
        double timeInHours = Double.parseDouble(timeInArr[0]);
        double timeInMinutes = Double.parseDouble(timeInArr[1]);
        double timeOutHours = Double.parseDouble(timeOutArr[0]);
        double timeOutMinutes = Double.parseDouble(timeOutArr[1]);
        
        // return 0 immediately if no in/out for that day
        if(timeInHours == 0 && timeOutHours == 0){
            return 0;
        }
        
        // within grace period
        if(timeInHours < 8 || (timeInHours == 8 && timeInMinutes <= 10)){
            timeInHours = 8;
            timeInMinutes = 0;
        // for lates
        } else {
            timeInMinutes -= 10; // minutes = minutes - 10
        }

       
        double timeInDouble = timeInHours + (timeInMinutes/60); // # ex. "8:55" -> 8 + (55/60)
        double timeOutDouble = timeOutHours + (timeOutMinutes/60);
        
        // compute for daily hours
        double dailyHours = timeOutDouble - timeInDouble - breakTime;
        return dailyHours;
    }
}
