/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alex.motorph;
import java.util.ArrayList;

/**
 *
 * @author Alex Resurreccion
 */
public class FilterEmployee {
    public String[] main(int employeeNumber, ArrayList<String> employees){
        int i=0; 
        String[] data = new String[1];
        while(i<employees.size() -1 && data[0] == null){
            String[] employeeId = employees.get(i).split(",");
            if (employeeId[0].equals(Integer.toString(employeeNumber))){
                data[0] = employees.get(i);
            }
            i++;
        }
        return data[0].split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
    }
    
//    public String[] employee(String[] employees){
//        
//        return {""};
//    }
}
