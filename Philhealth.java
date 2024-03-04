/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alex.motorph.Deductions;

/**
 *
 * @author Alex Resurreccion
 */
public class Philhealth extends Deduction{
    @Override public double computeDeduction(double basicSalary){
       return ((basicSalary * 0.03)/ 2); 
    }
}
