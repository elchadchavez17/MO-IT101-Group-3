/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package alex.motorph;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author Alex Resurreccion
 */
public class MotorPH {

    public static void main(String[] args) {
        System.out.println("Enter employee number:");
        Scanner myScanner = new Scanner(System.in);
        int employeeNumber = myScanner.nextInt();
        CsvReader csvReader = new CsvReader();
        ArrayList<String> employees = csvReader.main("resources/Employee Details.csv");
        
        FilterEmployee getEmployee = new FilterEmployee();
        String[] employeeDetails = getEmployee.main(employeeNumber, employees);
        
        System.out.println("1: Employee Information ");
        System.out.println("2: Weekly Worked Hours");
        System.out.println("3: Gross Weekly Salary");
        System.out.println("4: Net Weekly Salary");
        System.out.println("Type other digits to exit");
        System.out.println("Enter the number of your chosen transaction: ");
        
        int menuTransaction = myScanner.nextInt();
        
        WeeklyWorkedHours workedHours = new WeeklyWorkedHours();
        WeeklyWorkedHours salaryGross = new WeeklySalaryGross();
        WeeklyWorkedHours netSalary = new NetWeeklySalary();
        Employee employeeInformation = new Employee();
        employeeInformation.setAll(employeeDetails);
        
        switch(menuTransaction){
            case 1:
                employeeInformation(employeeInformation);
                break;
                // go to employee information
            case 2:
                workedHours.main(employeeInformation);
                break;
                // go to weekly worked hours
            case 3:
                salaryGross.main(employeeInformation);
                break;
                // gross weekly salary
            case 4:
                netSalary.main(employeeInformation);
                break;
                // net weekly salary
            default:
                System.exit(0);
        }
        
    }
    
    /**
     *
     */
    public static void employeeInformation(Employee employeeInformation) {
        System.out.println("Employee Information");
        System.out.println("----------------------------------");
        System.out.println("Employee #: " + employeeInformation.getEmployeeNumber());
        System.out.println("Full Name: " + employeeInformation.getLastName() +" "+ employeeInformation.getFirstName());
        System.out.println ("Birthday: " + employeeInformation.getBirthday());
        System.out.println ("Address: " + employeeInformation.getAddress());
        System.out.println ("Phone Number: " + employeeInformation.getPhoneNumber());
        System.out.println("----------------------------------");
        System.out.println ("SSS # " + employeeInformation.getSssNumber());
        System.out.println ("Philhealth # " + employeeInformation.getPhilhealthNumber());
        System.out.println ("TIN # " + employeeInformation.getTinNumber());
        System.out.println ("Pag-ibig # " + employeeInformation.getPagIbigNumber());
        System.out.println("----------------------------------");
        System.out.println ("Status: " + employeeInformation.getStatus());
        System.out.println ("Position: " + employeeInformation.getPosition());
        System.out.println ("Immediate Supervisor: " + employeeInformation.getImmediateSupervisor());
        System.out.println ("Rate");
        System.out.println ("     Basic Salary: " + employeeInformation.getBasicSalary());
        System.out.println ("     Gross Semi-monthly Rate: " + employeeInformation.getGrossSemiMonthlyRate());
        System.out.println ("     Hourly Rate: " + employeeInformation.getHourlyRate());
        System.out.println ("Allowance");
        System.out.println ("     Rice Subsidy: " + employeeInformation.getRiceSubsidy());
        System.out.println ("     Phone Allowance: " + employeeInformation.getPhoneAllowance());
        System.out.println ("     Clothing Allowance: " + employeeInformation.getClothingAllowance());
        
        System.out.println("----------------------------------\n\n\n");
//        
    }
}
