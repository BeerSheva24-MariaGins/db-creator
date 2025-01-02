package telran.employees;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "employees-sql-data.csv";
        
        try (FileWriter writer = new FileWriter(filePath)) {
            EmployeeGenerator.generateEmployees(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
