package companyManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.lang.System.out;

public class SalariedEmployee extends Employee
{
    private double annualSalary;

    public static double raiseAmount = 1.55;
    private static Map<Integer, SalariedEmployee> salariedEmployees = new HashMap <>();

    public SalariedEmployee(int id, String firstName, String lastName, String department, double annualSalary)
    {
        super(id, firstName, lastName, department);
        this.annualSalary = annualSalary;
        salariedEmployees.put(this.getId(), this);
    }

    public double getAnnualSalary()
    {
        return annualSalary;
    }

    public double weeklyPay()
    {
        return getAnnualSalary()/52;
    }

    protected static void SET_RAISE_AMOUNT(double percentage) throws Exception
    {
        if(percentage > 5 || percentage < 0) throw new Exception("Raise amount CANNOT be more than 5% OR negative.");
        else
        {
            raiseAmount = percentage;
        }
    }

    protected static double GET_RAISE_AMOUNT()
    {
        return raiseAmount;
    }

    protected static void RAISE_ALL()
    {
        SalariedEmployee salariedEmployee;

        for(Integer key : salariedEmployees.keySet())
        {
            salariedEmployee = salariedEmployees.get(key);
            salariedEmployee.annualSalary = CALCULATE_NEW_RAISE(salariedEmployee.getAnnualSalary());
            salariedEmployees.replace(key, salariedEmployee);
        }
    }

    protected static void RAISE_THIS(int id)
    {
        SalariedEmployee salariedEmployee;

        for(Integer key : salariedEmployees.keySet())
        {
            if(key == id)
            {
                salariedEmployee = salariedEmployees.get(key);
                salariedEmployee.annualSalary = CALCULATE_NEW_RAISE(salariedEmployee.getAnnualSalary());
                salariedEmployees.replace(id, salariedEmployee);
                out.println("A raise of " + raiseAmount + "% has been applied to this employee #" + id);
                break;
            }
        }
    }

    public static List<Employee> GET_ALL()
    {
        List<Employee> list = new ArrayList<>();
        for(Employee salaried : salariedEmployees.values())
        {
            list.add(salaried);
        }

        return list;
    }

    public static int SIZE()
    {
        return salariedEmployees.size();
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
        return super.toString().concat(", ").concat(String.valueOf(getAnnualSalary()));
    }
}
