package com.company;

public class Employee {

    private int id;
    private String firstName;
    private String lastname;
    private float salary;

    public Employee(int id, String firstName, String lastname, float salary) {
        setId(id);
        setFirstName(firstName);
        setLastname(lastname);
        setSalary(salary);
    }

    public void setFirstName(String firstName) {
        if (firstName.length() > 25){
            throw new StringIndexOutOfBoundsException();
        }
        this.firstName = firstName;
    }

    public void setId(int id) {
        if (id > 9999){
            throw new IndexOutOfBoundsException();
        }
        this.id = id;
    }

    public void setLastname(String lastname) {
        if (lastname.length() > 25){
            throw new IndexOutOfBoundsException();
        }
        this.lastname = lastname;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public float getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
