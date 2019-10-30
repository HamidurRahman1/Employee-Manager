package companyManager;

public class Employee implements EmployeeInterface, Comparable<Employee>
{
    private int id;
    private String firstName;
    private String lastName;
    private String department;

    public Employee(int id, String firstName, String lastName, String department)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    @Override
    public int getId()
    {
        return this.id;
    }

    @Override
    public String getFirstName()
    {
        return this.firstName;
    }

    @Override
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    @Override
    public String getLastName()
    {
        return this.lastName;
    }

    @Override
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    @Override
    public String getDepartment()
    {
        return this.department;
    }

    @Override
    public String toString()
    {
        return String.valueOf(getId()).concat(", ").concat(getFirstName())
                .concat(" ").concat(getLastName()).concat(", ").concat(getDepartment());
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (! (o instanceof Employee)) return false;
        return (this.getId() == ((Employee) o).getId());
    }

    @Override
    public int hashCode()
    {
        return (Integer.MAX_VALUE)/500 + getId();
    }

    @Override
    public int compareTo(Employee other)
    {
        return (this.getId() - other.getId());
    }
}
