/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alex.motorph.Deductions;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Alex Resurreccion
 */
public class Sss extends Deduction {
    @Override public double computeDeduction(double basicSalary){
        try{
            File myObj = new File("resources/SSS Contribution.csv");
            Scanner myReader = new Scanner(myObj);
            ArrayList<Double> amountDeduction = new ArrayList<>();
            ArrayList<Double> salaryTable = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] separatedValue = data.split(",", 2);
                
                salaryTable.add(Double.parseDouble(separatedValue[0]));
                amountDeduction.add(Double.parseDouble(separatedValue[1]));
            }
            myReader.close();
            if (basicSalary < salaryTable.get(1)){
                return amountDeduction.get(0);
            }
            
            int arrayIndex = amountDeduction.size() - 1;
            while(arrayIndex > 0){
                if (basicSalary > salaryTable.get(arrayIndex)){
                    return amountDeduction.get(arrayIndex);
                }
                arrayIndex--;
            }
//            for(int arrayIndex = amountDeduction.size() - 1; arrayIndex > 0; arrayIndex--){
//               if (basicSalary > salaryTable.get(arrayIndex)){
//                    return amountDeduction.get(arrayIndex);
//                } 
//            }
            
            return 0;
            
        } catch(FileNotFoundException e) {
            System.out.println(e);
            return 0;
        }
    }
}
