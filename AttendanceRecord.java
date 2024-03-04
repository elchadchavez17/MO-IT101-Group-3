/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alex.motorph;

import java.time.LocalDate;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Alex Resurreccion
 */
public class AttendanceRecord {
    private CsvReader csvReader = new CsvReader();
    private MonthBasis monthBasis = new MonthBasis();
    private String timeIn[];
    private String timeOut[];
    
    private ArrayList<String> getAll(){
        ArrayList<String> attendance = csvReader.main("resources/Attendance Record.csv");
        return attendance;
    }
    
    private ArrayList<String> getEmployeeWeeklyAttendance(String firstName, String lastName, LocalDate[] weekPeriod){
        ArrayList<String> attendance = getAll();
        int i = 1; 
        int timeIndex = 0;
        ArrayList<String> weeklyAttendance = new ArrayList<>();
        while(i<attendance.size() -1 && weeklyAttendance.size() != 6){
            String[] data = attendance.get(i).split(",");
            LocalDate attendanceDate = monthBasis.convertToLocalDate(data[3]);
            if ((attendanceDate.isEqual(weekPeriod[0]) || attendanceDate.isAfter(weekPeriod[0])) &&
                    (attendanceDate.isEqual(weekPeriod[6]) || attendanceDate.isBefore(weekPeriod[6])) &&
                    data[2].equals(firstName) && data[1].equals(lastName)) {
                weeklyAttendance.add(attendance.get(i));
                timeIndex ++;
            }
            i++;
        }
        return weeklyAttendance;
    }
    
    private String getDateFromRow(String row) {
        // Split the row by comma and return the date at index 3
        String[] parts = row.split(",");
        return parts[3];
    }
    
    public ArrayList<String> getAttendance(String firstName, String lastName, LocalDate[] weekPeriod){
        ArrayList<String> weeklyAttendance = getEmployeeWeeklyAttendance(firstName, lastName, weekPeriod);
        // Sort the rows by the date at index 3
        Collections.sort(weeklyAttendance, Comparator.comparing(row -> getDateFromRow(row)));
        return weeklyAttendance;
    }
}
