/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alex.motorph;

import java.util.Scanner;

/**
 *
 * @author Alex Resurreccion
 */
public class WeeklySalaryGross extends WeeklyWorkedHours{
    @Override public void main(Employee employeeInformation){
        char userInput;
        Scanner myScanner = new Scanner (System.in);
        do{
            askAndGetWeekPeriodLocalDate(employeeInformation.getFirstName(), employeeInformation.getLastName());
            // total weekly worked hours, salary rate
            double workedHours = calculateWeeklyHours();
            double grossWeekly = employeeInformation.getHourlyRate() * workedHours;
            String total = String.format("%,.2f", grossWeekly); 
            System.out.println("Weekly Gross salary: P" + total);
            System.out.println("do you want to see other weekly hours? y/n"); // println for user to see
            userInput = myScanner.next().charAt(0);// get user input char and set the value to userInput
        } while (userInput == 'y');
    }
}
