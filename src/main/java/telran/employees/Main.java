package telran.employees;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream("employees-sql-data.csv"))) {
            EmployeeGenerator.generateEmployees(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
