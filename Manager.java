package companyManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.lang.System.out;

public class Manager extends Employee
{
    private double annualSalary;
    private Map<Integer, Employee> employeeList = new HashMap <>();

    private static double raiseAmount = 1.60;
    private static Map<Integer, Manager> managers = new HashMap<>();

    public Manager(int id, String firstName, String lastName, String department, double annualSalary)
    {
        super(id, firstName, lastName, department);
        this.annualSalary = annualSalary;
        managers.put(this.getId(), this);
    }

    public Manager(int id, String firstName, String lastName, String department, double annualSalary, List<Employee> employees)
    {
        this(id, firstName, lastName, department, annualSalary);
        for(Employee employee : employees) employeeList.put(employee.getId(), employee);
    }

    public double getAnnualSalary()
    {
        return annualSalary;
    }

    public void addEmployee(Employee employee)
    {
        employeeList.put(employee.getId(), employee);
    }

    public void removeEmployee(Employee employee)
    {
        removeEmployee(employee.getId());
    }

    public void removeEmployee(int id)
    {
        employeeList.remove(id);
    }

    public int totalSupervisedEmployee()
    {
        return employeeList.size();
    }

    public static void SET_RAISE_AMOUNT(double percentage) throws Exception
    {
        if(percentage > 5 || percentage < 0) throw new Exception("Raise amount CANNOT be more than 5% OR negative.");
        else
        {
            raiseAmount = percentage;
        }
    }

    public static double GET_RAISE_AMOUNT()
    {
        return raiseAmount;
    }

    protected static void RAISE_ALL()
    {
        Manager manager;

        for(Integer key : managers.keySet())
        {
            manager = managers.get(key);
            manager.annualSalary = CALCULATE_NEW_RAISE(manager.getAnnualSalary());
            managers.replace(key, manager);
        }
    }

    protected static void RAISE_THIS(int id)
    {
        Manager manager;

        for(Integer key : managers.keySet())
        {
            if(key == id)
            {
                manager = managers.get(key);
                manager.annualSalary = CALCULATE_NEW_RAISE(manager.getAnnualSalary());
                managers.replace(id, manager);
                out.println("A raise of " + raiseAmount + "% has been applied to this employee #" + id);
                break;
            }
        }
    }

    public static List<Employee> GET_ALL()
    {
        List<Employee> list = new ArrayList<>();
        for(Employee manager : managers.values())
        {
            list.add(manager);
        }

        return list;
    }

    public static int SIZE()
    {
        return managers.size();
    }

    private static double CALCULATE_NEW_RAISE(double amount)
    {
        amount = amount + amount * (raiseAmount /100.0);
        return amount;
    }

    @Override
    public boolean equals(Object o)
    {
        return super.equals(o);
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    @Override
    public int compareTo(Employee employee)
    {
        return super.compareTo(employee);
    }

    @Override
    public String toString()
    {
        StringBuilder stringEmployee = new StringBuilder();
        if(employeeList.size() != 0)
        {
            stringEmployee.append(" -> ");
            for(Employee employee : employeeList.values()) stringEmployee.append("{").append(employee.toString()).append("} ");
        }

        return super.toString().concat(", ").concat(String.valueOf(getAnnualSalary())) + stringEmployee;
    }
}
