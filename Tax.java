/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alex.motorph.Deductions;

/**
 *
 * @author Alex Resurreccion
 */
public class Tax extends Deduction {
    @Override public double computeDeduction(double taxableSalary){
        if(taxableSalary >= 666667 ){
            return (taxableSalary * 0.35); 
        }
        else if (taxableSalary >=166667){
            return (taxableSalary * 0.32);          
        }
        else if (taxableSalary >=66667){
            return (taxableSalary * 0.30);
        }
        else if (taxableSalary >= 33333){
            return (taxableSalary * 0.25);
        }
        else if (taxableSalary >= 20833){
            return (taxableSalary * 0.20);
        }
        else{
            return 0;
        }
    }
        
}
