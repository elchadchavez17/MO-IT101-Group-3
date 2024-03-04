/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alex.motorph.Deductions;

/**
 *
 * @author Alex Resurreccion
 */
public class PagIbig extends Deduction {
    @Override public double computeDeduction(double basicSalary){
        if(basicSalary > 1500){
            return (basicSalary * 0.02);
        } else if(basicSalary >=1000){
            return (basicSalary * 0.01);
        } else {
            return 0;
        }
         
    }
}

