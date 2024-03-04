/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alex.motorph;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 *
 * @author Alex Resurreccion
 */
public class MonthBasis {
    public LocalDate convertToLocalDate(String date) {
        // Define the date formatter for the given format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        // Parse the string to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);

        return localDate;
    }
    
    public LocalDate getFirstMonday(LocalDate date){
        // Get the first day of the month
        LocalDate firstDayOfMonth = date.withDayOfMonth(1);

        // Find the first Monday by adding days until we reach a Monday
        while (firstDayOfMonth.getDayOfWeek() != DayOfWeek.MONDAY) {
            firstDayOfMonth = firstDayOfMonth.plusDays(1);
        }

        return firstDayOfMonth;
    }
    
    public static LocalDate getLastSundayOfMonth(LocalDate date) {
        // Get the last day of the month
        LocalDate lastDayOfMonth = date.withDayOfMonth(date.lengthOfMonth());

        // Find the last Friday by subtracting days until we reach a Friday
        while (lastDayOfMonth.getDayOfWeek() != DayOfWeek.SUNDAY) {
            lastDayOfMonth = lastDayOfMonth.minusDays(1);
        }

        return lastDayOfMonth;
    }
    
    public LocalDate[] getWeekPeriod(LocalDate date) {
        // Get the week period (Monday to Friday) for the provided date
        LocalDate[] weekPeriod = new LocalDate[7];
        // Get the monday of the week then just +days to get other days
        LocalDate monday = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        weekPeriod[0] = monday;
        for(int i=1; i<=6; i++){
            weekPeriod[i] = monday.plusDays(i);
        }
        return weekPeriod;
    }
    
    public boolean isLastSunday(LocalDate date){
        LocalDate lastSunday = getLastSundayOfMonth(date);
        return lastSunday == date; 
    }
}
