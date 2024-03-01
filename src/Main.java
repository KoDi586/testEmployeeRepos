import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(List.of(

                new Employee("Ivan", 1, 1234D),
                new Employee("Ivan", 1, 2D),
                new Employee("Ivan", 1, 345D),
                new Employee("Ivan", 2, 2434D),
                new Employee("Ivan", 2, 10000D),
                new Employee("Ivan", 3, 32D)

        ));

        Main main = new Main();

        Map<Integer, Integer> departments = new HashMap<>();
        for (Employee employee : employees) {
            Integer department = employee.getDepartment();
            if (departments.containsKey(department)) {
                departments.put(department, departments.get(department) + 1);
            } else {
                departments.put(department, 1);
            }
        }


        for (Integer department : departments.keySet()) {

            if (departments.get(department) == 1) {
                continue;
            }

            System.out.println("max salary in " + department + " = "
                    + main.getMax(employees, department));

            System.out.println("average salary in " + department + " = "
                    + main.getAverage(employees, department));

            System.out.println("---------------------");
        }


    }

    public Double getAverage(List<Employee> employees, Integer department) {
        Double average = employees.stream()
                .filter(employee -> Objects.equals(employee.getDepartment(), department))
                .map(Employee::getSalary)
                .mapToInt(Double::intValue)
                .average().getAsDouble();

        return average;
    }

    public Double getMax(List<Employee> employees, Integer department) {
        Double maxSalary = employees.stream()
                .filter(employee -> Objects.equals(employee.getDepartment(), department))
                .map(Employee::getSalary)
                .max(Comparator.naturalOrder()).get();

        return maxSalary;
    }
}