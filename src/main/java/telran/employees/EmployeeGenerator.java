package telran.employees;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.Random;

public class EmployeeGenerator {
    private static final Random RANDOM = new Random();
    
    public static void generateEmployees(PrintWriter writer) throws IOException {        
        int id = Config.MIN_ID;         
        id = generateDepartmentEmployees(writer, id, "QA", 1, 2, 10, 0);             
        id = generateDepartmentEmployees(writer, id, "Development", 1, 0, 30, 0);          
        id = generateDepartmentEmployees(writer, id, "Devops", 1, 5, 0, 0);           
        id = generateDepartmentEmployees(writer, id, "Sales", 1, 0, 0, 3);
    }
    
    private static int generateDepartmentEmployees(PrintWriter writer, int startingId, String department, 
                                                    int numManagers, int numEmployees, 
                                                    int numWageEmployees, int numSalesPersons) throws IOException {
        int id = startingId;        
        
        for (int i = 0; i < numManagers; i++) {
            writer.println(generateEmployeeRow(id++, "Manager", department, true));
        }        
        
        for (int i = 0; i < numEmployees; i++) {
            writer.println(generateEmployeeRow(id++, "Employee", department, false));
        }        
        
        for (int i = 0; i < numWageEmployees; i++) {
            writer.println(generateWageEmployeeRow(id++, department));
        }        
        
        for (int i = 0; i < numSalesPersons; i++) {
            writer.println(generateSalesPersonRow(id++));
        }
        
        return id;
    }
    
    private static String generateEmployeeRow(int id, String role, String department, boolean withFactor) {
        int basicSalary = getRandomSalary(Config.MIN_BASIC_SALARY, Config.MAX_BASIC_SALARY);
        String factor = withFactor ? String.format("%.1f", getRandomFactor(Config.MIN_FACTOR, Config.MAX_FACTOR)) : "";
        return String.format("%d,%s,%d,%s,%s,,,,", id, role, basicSalary, department, factor);
    }
    
    private static String generateWageEmployeeRow(int id, String department) {
        int basicSalary = getRandomSalary(Config.MIN_BASIC_SALARY, Config.MAX_BASIC_SALARY);
        int wage = getRandomNumber(Config.MIN_WAGE, Config.MAX_WAGE); 
        int hours = getRandomNumber(Config.MIN_HOURS, Config.MAX_HOURS);
        return String.format("%d,WageEmployee,%d,%s,,%d,%d,,", id, basicSalary, department, wage, hours);
    }
    
    private static String generateSalesPersonRow(int id) {
        int basicSalary = getRandomSalary(Config.MIN_BASIC_SALARY, Config.MAX_BASIC_SALARY);
        int wage = getRandomNumber(Config.MIN_WAGE, Config.MAX_WAGE); 
        int hours = getRandomNumber(Config.MIN_HOURS, Config.MAX_HOURS);
        double percent = getRandomFactor(Config.MIN_PERCENT, Config.MAX_PERCENT);
        int sales = getRandomNumber(1, 500);  
        return String.format("%d,SalesPerson,%d,Sales,,%d,%d,%.1f,%d", id, basicSalary, wage, hours, percent, sales);
    }
    
    private static int getRandomNumber(int min, int max) {
        return RANDOM.nextInt((max - min) + 1) + min;
    }
    
    private static int getRandomSalary(int min, int max) {
        int randomSalary = getRandomNumber(min, max);
        return (randomSalary / 500) * 500; 
    }
    
    private static double getRandomFactor(double min, double max) {
        return Math.round((min + (max - min) * RANDOM.nextDouble()) * 10.0) / 10.0;
    }
}
