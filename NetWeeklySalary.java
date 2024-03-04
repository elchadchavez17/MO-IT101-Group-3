/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alex.motorph;

import java.util.Scanner;
import alex.motorph.Deductions.Sss;
import alex.motorph.Deductions.Philhealth;
import alex.motorph.Deductions.PagIbig;
import alex.motorph.Deductions.Tax;
import java.time.LocalDate;

/**
 *
 * @author Alex Resurreccion
 */
public class NetWeeklySalary extends WeeklyWorkedHours {
    @Override public void main(Employee employeeInformation){
        Sss sssDeduction = new Sss();
        Philhealth philhealthDeduction = new Philhealth();
        PagIbig pagIbigDeduction = new PagIbig();
        Tax taxDeduction = new Tax();
        Double employeeBasicSalary = employeeInformation.getBasicSalary();
        Scanner myScanner = new Scanner(System.in);
        
        char userInput;
        do{
            askAndGetWeekPeriodLocalDate(employeeInformation.getFirstName(), employeeInformation.getLastName());

            // total weekly worked hours, salary rate
            double workedHours = calculateWeeklyHours();
            double grossWeekly = employeeInformation.getHourlyRate() * workedHours;
            double beforeTaxSalary = (
                    grossWeekly 
                    - sssDeduction.computeDeduction(employeeBasicSalary)
                    - philhealthDeduction.computeDeduction(employeeBasicSalary)
                    - pagIbigDeduction.computeDeduction(employeeBasicSalary)
            );
            double withHoldingTax = taxDeduction.computeDeduction(beforeTaxSalary);
            double netWeeklySalary = beforeTaxSalary - withHoldingTax;
            String formattedWeekly = String.format("%,.2f", grossWeekly); 
            System.out.println("Weekly Gross salary: P" + formattedWeekly);
            System.out.println("---------Deductions-----------");
            System.out.println("Sss Deduction: P" + sssDeduction.computeDeduction(employeeBasicSalary));
            System.out.println("Philhealth Deduction: P" + philhealthDeduction.computeDeduction(employeeBasicSalary));
            System.out.println("Pag-ibig Deduction: P" + pagIbigDeduction.computeDeduction(employeeBasicSalary));
            System.out.println("Withholding Tax: P" + taxDeduction.computeDeduction(beforeTaxSalary));
            String total = String.format("%,.2f", netWeeklySalary); 
            System.out.println("Net Weekly salary: P" + total);            
            System.out.println("do you want to see other weekly hours? y/n"); // println for user to see
            userInput = myScanner.next().charAt(0);// get user input char and set the value to userInput
        } while (userInput == 'y');
    }
}
