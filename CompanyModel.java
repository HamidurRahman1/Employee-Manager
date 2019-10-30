package companyManager;

import java.util.List;
import java.util.TreeMap;
import static java.lang.System.out;

public class CompanyModel
{
    private TreeMap<Integer, Employee> employeeTreeMap = new TreeMap <>();

    public CompanyModel() {}

    public void addEmployee(Employee employee)
    {
        employeeTreeMap.put(employee.getId(),employee);
    }

    public void addEmployee(List<Employee> employeeList)
    {
        for(Employee employee : employeeList)
        {
            employeeTreeMap.put(employee.getId(), employee);
        }
    }

    public void removeEmployee(Employee employee) throws Exception
    {
        removeEmployee(employee.getId());
    }

    public void removeEmployee(int id) throws Exception
    {
        if(employeeTreeMap.containsKey(id))
        {
            employeeTreeMap.remove(id);
        }
        else throw new Exception("Invalid ID");
    }

    public Employee getEmployee(int id) throws Exception
    {
        if(employeeTreeMap.get(id) != null)
        {
            return employeeTreeMap.get(id);
        }
        else throw new Exception("Invalid ID");
    }

    public boolean contains(int id)
    {
        return employeeTreeMap.containsKey(id);
    }

    public void updateEmployee(Employee employee)
    {
        employeeTreeMap.replace(employee.getId(), employee);
    }

    public int size()
    {
        return employeeTreeMap.size();
    }

    public void raiseAll() throws Exception
    {
        if(size() == 0) throw new Exception("No employee yet!");
        else
        {
            HourlyEmployee.RAISE_ALL();
            SalariedEmployee.RAISE_ALL();
            Manager.RAISE_ALL();
        }
    }

    public void raiseThis(int id) throws Exception
    {
        if(size() == 0) throw new Exception("No employee yet!");

        if(id >= 100 && id <= 999)
        {
            Manager.RAISE_THIS(id);
        }
        else if(id >= 1000 && id <= 4999)
        {
            SalariedEmployee.RAISE_THIS(id);
        }
        else if(id >= 5000 && id <= 9999)
        {
            HourlyEmployee.RAISE_THIS(id);
        }
        else throw new Exception("Invalid Employee ID");
    }

    @Override
    public String toString()
    {
        int i = 1;
        int j = 1;
        int k = 1;

        StringBuilder result = new StringBuilder("\n|---------------------------------------\n");

        result.append("|").append("\t").append("Manager(s): ").append("\n");
        result.append("|").append("\t").append("Salaried Employee(s): ").append("\n");
        result.append("|").append("\t").append("Hourly Employee(s): ").append("\n");

        for(Employee employee : employeeTreeMap.values())
        {
            if(employee.getId() <= 999)
            {
                result.append("|").append("\t\t").append(i).append(": ").append(employee).append("\n");
                i++;
            }
            else if(employee.getId() <= 4999)
            {
                result.append("|").append("\t\t").append(j).append(": ").append(employee).append("\n");
                j++;
            }
            else
            {
                result.append("|").append("\t\t").append(k).append(": ").append(employee).append("\n");
                k++;
            }
        }

        result.append(result);
        result.append("|---------------------------------------\n");

        return result + "\n";
    }

}
