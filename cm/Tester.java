
/*
*
*   NOTE: When an user creates Employee objects, they must enter unique ID for each employee.
*         ID range distinguish between different employees.
*
*               ID #: 100 <= Manager <= 999;
*               ID #: 1000 <= Salaried Employee <= 4999;
*               ID #: 5000 <= Hourly Employee <= 9999;
* */

package companyManager;

import java.util.List;
import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

public class Tester
{
    private static StringBuilder menuList;
    private static StringBuilder employeeMenu;
    private static StringBuilder updateOperations;
    private static StringBuilder classOperations;

    private static Scanner scanner;
    private static CompanyModel companyModel;
    private static HourlyEmployee hourlyEmployee;
    private static SalariedEmployee salariedEmployee;
    private static Manager manager;

    public static void main(String[] args)
    {
        init();
    }

    protected static void init()
    {
        menuList = new StringBuilder();
        employeeMenu = new StringBuilder();
        updateOperations = new StringBuilder();
        classOperations = new StringBuilder();

        scanner = new Scanner(in);
        companyModel = new CompanyModel();

        menuList.append("1. Add an employee").append("\n");
        menuList.append("2. Update an employee").append("\n");
        menuList.append("3. Raise an employee").append("\n");
        menuList.append("4. Raise all employees").append("\n");
        menuList.append("5. Remove an employee").append("\n");
        menuList.append("6. Total employees").append("\n");
        menuList.append("7. Go Employee Classes").append("\n");
        menuList.append("8. Display current employee structure").append("\n");
        menuList.append("0. Exit").append("\n");

        employeeMenu.append("1. Hourly Employee").append("\n");
        employeeMenu.append("2. Salaried Employee").append("\n");
        employeeMenu.append("3. Manager").append("\n");
        employeeMenu.append("0. Go Back").append("\n");

        updateOperations.append("1. Change first name").append("\n");
        updateOperations.append("2. Change last name").append("\n");
        updateOperations.append("0. Go Back").append("\n");

        classOperations.append("1. Raise An Employee").append("\n");
        classOperations.append("2. Raise All Employee").append("\n");
        classOperations.append("3. Get Raise Percentage").append("\n");
        classOperations.append("4. Set Raise Percentage").append("\n");
        classOperations.append("5. Total Employee").append("\n");
        classOperations.append("6. List All Employee").append("\n");
        classOperations.append("0. Go Back").append("\n");

        menu();
    }

    protected static void menu()
    {
        final int quit = 0;
        int input = 1;

        do
        {
            out.println(menuList);

            switch (getNavigationInput())
            {
                case 1:
                    addEmployee();
                    break;

                case 2:
                    updateEmployee();
                    break;

                case 3:
                    raiseEmployee();
                    break;

                case 4:
                    raiseAllEmployee();
                    break;

                case 5:
                    removeEmployee();
                    break;

                case 6:
                    displayMessage("Total employees: " + companyModel.size());
                    break;

                case 7:
                    goClasses();
                    break;

                case 8:
                    out.print(companyModel);
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.exit(0);
            }

        } while (input != quit);
    }

    protected static void goClasses()
    {
        out.println(employeeMenu);

        switch (getNavigationInput())
        {
            case 1:
                goHourlyClass();
                break;

            case 2:
                goSalariedClass();
                break;

            case 3:
                goManagerClass();
                break;

            case 0:
                break;

            default:
                displayMessage("Invalid input");
                break;
        }
    }

    protected static void goHourlyClass()
    {
        out.println(classOperations);

        switch (getNavigationInput())
        {
            case 1:
                HourlyEmployee.RAISE_THIS(getId());
                break;

            case 2:
                HourlyEmployee.RAISE_ALL();
                break;

            case 3:
                displayMessage("Hourly Employee: " + HourlyEmployee.GET_RAISE_AMOUNT() +"%");
                break;

            case 4:
                try
                {
                    HourlyEmployee.SET_RAISE_AMOUNT(Double.valueOf(getLongInput("new raise percentage")));
                }
                catch (Exception ex)
                {
                    ex.getMessage();
                }
                break;

            case 5:
                displayMessage("Total Hourly Employee: " + HourlyEmployee.SIZE());
                break;

            case 6:
                List<Employee> list = HourlyEmployee.GET_ALL();
                list.forEach(employee -> out.println(employee));
                break;

            case 0:
                break;

            default:
                displayMessage("Invalid input.");
                break;
        }
    }

    protected static void goSalariedClass()
    {
        out.println(classOperations);

        switch (getNavigationInput())
        {
            case 1:
                SalariedEmployee.RAISE_THIS(getId());
                break;

            case 2:
                SalariedEmployee.RAISE_ALL();
                break;

            case 3:
                displayMessage("Salaried Employee: " + SalariedEmployee.GET_RAISE_AMOUNT() +"%");
                break;

            case 4:
                try
                {
                    SalariedEmployee.SET_RAISE_AMOUNT(Double.valueOf(getLongInput("new raise percentage")));
                }
                catch (Exception ex)
                {
                    ex.getMessage();
                }
                break;

            case 5:
                displayMessage("Total Salaried Employee: " + SalariedEmployee.SIZE());
                break;

            case 6:
                List<Employee> list = SalariedEmployee.GET_ALL();
                list.forEach(employee -> out.println(employee));
                break;

            case 0:
                break;

            default:
                displayMessage("Invalid input.");
                break;
        }
    }

    protected static void goManagerClass()
    {
        out.println(classOperations);

        switch (getNavigationInput())
        {
            case 1:
                Manager.RAISE_THIS(getId());
                break;

            case 2:
                Manager.RAISE_ALL();
                break;

            case 3:
                displayMessage("Manager: " + Manager.GET_RAISE_AMOUNT() +"%");
                break;

            case 4:
                try
                {
                    Manager.SET_RAISE_AMOUNT(Double.valueOf(getLongInput("new raise percentage")));
                }
                catch (Exception ex)
                {
                    ex.getMessage();
                }
                break;

            case 5:
                displayMessage("Total Manager: " + Manager.SIZE());
                break;

            case 6:
                List<Employee> list = Manager.GET_ALL();
                list.forEach(employee -> out.println(employee));
                break;

            case 0:
                break;

            default:
                displayMessage("Invalid input.");
                break;
        }
    }

    protected static void addEmployee()
    {
        out.println(employeeMenu);

        switch (getNavigationInput())
        {
            case 1:
                addHourlyEmployee();
                break;

            case 2:
                addSalariedEmployee();
                break;

            case 3:
                addManager();
                break;

            case 0:
                break;

            default:
                displayMessage("Invalid input");
                addEmployee();
        }
    }

    protected static void updateEmployee()
    {
        try
        {
            int id = getId();
            Employee employee = companyModel.getEmployee(id);
            out.println(employee);
            out.println(updateOperations);
            String input;

            switch (getNavigationInput())
            {
                case 1:
                    input = getLongInput("new first name");
                    employee.setFirstName(input);
                    displayMessage("Change successful for first name");
                    out.println(employee);
                    companyModel.updateEmployee(employee);
                    break;

                case 2:
                    input = getLongInput("new last name");
                    employee.setLastName(input);
                    displayMessage("Change successful for last name");
                    out.println(employee);
                    companyModel.updateEmployee(employee);
                    break;

                case 0:
                    break;

                default:
                    displayMessage("Invalid input");
                    break;
            }
        }
        catch (Exception ex)
        {
            out.println(ex.getMessage());
        }
    }

    protected static void raiseEmployee()
    {
        int id;
        try
        {
            if(companyModel.size() == 0) throw new Exception("No employee yet!");
            id = getId();
            companyModel.raiseThis(id);
        }
        catch (Exception ex)
        {
            out.println(ex.getMessage());
        }
    }

    protected static void raiseAllEmployee()
    {
        try
        {
            companyModel.raiseAll();
        }
        catch (Exception ex)
        {
            out.println(ex.getMessage());
        }
    }

    protected static void removeEmployee()
    {
        try
        {
            int id = getId();
            Employee employee = companyModel.getEmployee(id);
            companyModel.removeEmployee(id);
            out.println(employee + " has successfully been removed.");
        }
        catch (Exception ex)
        {
            out.println(ex.getMessage());
        }
    }

    protected static void addHourlyEmployee()
    {
        out.println("------ Enter Hourly Employee Info -----");
        GeneralInfo gi = new GeneralInfo("hourly wage $");
        out.println("---------------------------------------");

        hourlyEmployee = new HourlyEmployee(gi.id, gi.fname, gi.lname, gi.dept, gi.salary);
        companyModel.addEmployee(hourlyEmployee);
    }

    protected static void addSalariedEmployee()
    {
        out.println("------ Enter Salaried Employee Info -----");
        GeneralInfo gi = new GeneralInfo("annual salary $");
        out.println("-----------------------------------------");

        salariedEmployee = new SalariedEmployee(gi.id, gi.fname, gi.lname, gi.dept, gi.salary);
        companyModel.addEmployee(salariedEmployee);
    }

    protected static void addManager()
    {
        out.println("------ Enter Manager Info -----");
        GeneralInfo gi = new GeneralInfo("annual salary $");
        out.println("--------------------------------");

        manager = new Manager(gi.id, gi.fname, gi.lname, gi.dept, gi.salary);
        companyModel.addEmployee(manager);
    }

    private static int getNavigationInput()
    {
        int input;
        out.print("Enter a number #");
        input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    private static int getId()
    {
        int input = -1;
        try
        {
            out.print("Enter ID #");
            input = scanner.nextInt();
            scanner.nextLine();
        }
        catch (Exception ex)
        {
            out.println(ex.getMessage());
            scanner.nextLine();
            getId();
        }
        return input;
    }

    private static String getLongInput(String str)
    {
        String input;
        out.print("Enter ".concat(str).concat(": "));
        input = scanner.nextLine();
        return input;
    }

    private static void displayMessage(String text)
    {
        out.println(text + "\n");
    }

    private static class GeneralInfo
    {
        int id;
        String fname;
        String lname;
        String dept;
        double salary;

        public GeneralInfo(String salaryOpt)
        {
            this.id = getId();
            this.fname = getLongInput("first name");
            this.lname = getLongInput("last name");
            this.dept = getLongInput("department name");
            this.salary = Double.valueOf(getLongInput(salaryOpt));
        }
    }
}
