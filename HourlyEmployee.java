package companyManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.lang.System.out;

public class HourlyEmployee extends Employee
{
    private double hourlyWage;

    private static double raiseAmount = 1.50;
    private static final double MAX_HOURS = 40.00;
    private static Map<Integer, HourlyEmployee> hourlyEmployees = new HashMap<>();

    public HourlyEmployee(int id, String firstName, String lastName, String department, double hourlyWage)
    {
        super(id, firstName, lastName, department);
        this.hourlyWage = hourlyWage;
        hourlyEmployees.put(this.getId(), this);
    }

    public double getHourlyWage()
    {
        return hourlyWage;
    }

    public double getTotalPay(double hoursWorked) throws Exception
    {
        double totalPay;

        if((hoursWorked <= 0)) throw new Exception("Invalid input for worked hours.");
        else if(hoursWorked <= MAX_HOURS)
        {
            totalPay = hoursWorked * hourlyWage;
        }
        else totalPay = hourlyWage * MAX_HOURS;
        return totalPay;
    }

    protected static void SET_RAISE_AMOUNT(double percentage) throws Exception
    {
        if(percentage > 5 || percentage < 0) throw new Exception("Raise amount CANNOT be more than 5% OR negative.");
        else raiseAmount = percentage;
    }

    protected static double GET_RAISE_AMOUNT()
    {
        return raiseAmount;
    }

    protected static void RAISE_ALL()
    {
        HourlyEmployee hourlyEmployee;

        for(Integer key : hourlyEmployees.keySet())
        {
            hourlyEmployee = hourlyEmployees.get(key);
            hourlyEmployee.hourlyWage = CALCULATE_NEW_RAISE(hourlyEmployee.getHourlyWage());
            hourlyEmployees.replace(key, hourlyEmployee);
        }
    }

    protected static void RAISE_THIS(int id)
    {
        HourlyEmployee hourlyEmployee;

        for(Integer key : hourlyEmployees.keySet())
        {
            if(key == id)
            {
                hourlyEmployee = hourlyEmployees.get(key);
                hourlyEmployee.hourlyWage = CALCULATE_NEW_RAISE(hourlyEmployee.getHourlyWage());
                hourlyEmployees.replace(id, hourlyEmployee);
                out.println("A raise of " + raiseAmount + "% has been applied to this employee #" + id);
                break;
            }
        }
    }

    public static int SIZE()
    {
        return hourlyEmployees.size();
    }

    public static List<Employee> GET_ALL()
    {
        List<Employee> list = new ArrayList<>();
        for(Employee hourly : hourlyEmployees.values())
        {
            list.add(hourly);
        }

        return list;
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
        return super.toString().concat(", ").concat(String.valueOf(getHourlyWage()));
    }
}
