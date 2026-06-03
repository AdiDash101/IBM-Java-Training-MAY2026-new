package day4;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "IT", 55000));
        employees.add(new Employee("Bob", "Finance", 60000));
        employees.add(new Employee("Alice", "HR", 52000)); // duplicate name
        employees.add(new Employee("Ken", "IT", 60000));
        employees.add(new Employee("Maria", "HR", 50000));
        employees.add(new Employee("John", "Finance", 70000));
        employees.add(new Employee("Ken", "Finance", 65000)); // duplicate name
        employees.add(new Employee("Lara", "IT", 62000));
        employees.add(new Employee("Sam", "HR", 48000));
        employees.add(new Employee("Bob", "IT", 59000)); // duplicate name
        
        // === Unique Employees ===
        System.out.println("=== Unique Employees ===");
        List<Employee> cleanedList = new ArrayList<>();
        Set<String> seenNames = new HashSet<>();
        for (Employee emp : employees) {
            if (seenNames.add(emp.getName())) {
                cleanedList.add(emp);
            }
        }
        for (Employee emp : cleanedList) {
            System.out.println(emp.getName() + " | " + emp.getDepartment() + " | $" + emp.getSalary());
        }
        System.out.println();
        
        // === Employees by Department ===
        System.out.println("=== Employees by Department ===");
        Map<String, List<Employee>> departmentMap = new LinkedHashMap<>(); 
      
        
        for (Employee emp : employees) {
            String dept = emp.getDepartment();
            if (!departmentMap.containsKey(dept)) {
                departmentMap.put(dept, new ArrayList<>());
            }
            departmentMap.get(dept).add(emp);
        }
        
        for (Map.Entry<String, List<Employee>> entry : departmentMap.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Employee emp : entry.getValue()) {
                System.out.println("  " + emp); 
            }
        }
        System.out.println();
        
        // === Highest Paid per Department ===
        System.out.println("=== Highest Paid per Department ===");
        for (Map.Entry<String, List<Employee>> entry : departmentMap.entrySet()) {
            String dept = entry.getKey();
            List<Employee> deptEmployees = entry.getValue();
            Employee highestPaid = null;
            
            for (Employee emp : deptEmployees) {
                if (highestPaid == null || emp.getSalary() > highestPaid.getSalary()) {
                    highestPaid = emp;
                }
            }
            
            if (highestPaid != null) {
                System.out.println(dept + ": " + highestPaid.getName() + " | " + highestPaid.getDepartment() + " | $" + highestPaid.getSalary());
            }
        }
        System.out.println();
        
        // === Employees Sorted by Salary (Desc) ===
        System.out.println("=== Employees Sorted by Salary (Desc) ===");
        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        
        for (Employee emp : employees) {
            System.out.println(emp.getName() + " | " + emp.getDepartment() + " | $" + emp.getSalary());
        }
        System.out.println();
        
        // === Unique Salaries (Sorted) ===
        System.out.println("=== Unique Salaries (Sorted) ===");
        Set<Double> uniqueSalaries = new TreeSet<>();
        for (Employee emp : employees) {
            uniqueSalaries.add(emp.getSalary());
        }
        for (Double salary : uniqueSalaries) {
            System.out.println(salary);
        }
    }
}