/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alex.motorph;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Alex Resurreccion
 */

public class CsvReader {

    public ArrayList main(String filePath) {
        String csvFile = filePath; // Replace with your CSV file path
        ArrayList<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line by comma (assuming the CSV file is comma-separated)
                data.add(line);
            }
            
        } catch (IOException e) {
            System.out.println("error: " + e);
        }
        return data;
    }
    
    public String[] splitStringByComma(String data){
        return data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
    }
}

