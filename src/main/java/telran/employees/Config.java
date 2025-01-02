package telran.employees;

public class Config {
    public static final String[] DEPARTMENTS = {"QA", "Development", "Devops", "Sales"};
    public static final int[][] DEPARTMENT_COUNTS = {
        {1, 2, 10},   // QA
        {1, 0, 30},   // Development
        {1, 5, 0},    // Devops
        {1, 0, 3}     // Sales
    };
    
    public static final int MIN_ID = 1000;
    public static final int MAX_ID = 9999;
    public static final int MIN_BASIC_SALARY = 5000;
    public static final int MAX_BASIC_SALARY = 50000;
    public static final double MIN_FACTOR = 1.5;
    public static final double MAX_FACTOR = 4.0;
    public static final int MIN_WAGE = 30;
    public static final int MAX_WAGE = 300;
    public static final int MIN_HOURS = 1;
    public static final int MAX_HOURS = 200;
    public static final double MIN_PERCENT = 0.1;
    public static final double MAX_PERCENT = 1.5;
}
