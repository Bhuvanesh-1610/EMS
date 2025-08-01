package com.expeditors.ems.dto.employee;

import java.util.Comparator;

class EmployeePojo {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor, getters, setters
    public EmployeePojo(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}


    class StudentNameComparator implements Comparator<EmployeePojo> {
        @Override
        public int compare(EmployeePojo s1, EmployeePojo s2) {
            return s1.getName().compareTo(s2.getName());
        }
    }

    class EmployeeSalaryComparator implements Comparator<EmployeePojo> {
        @Override
        public int compare(EmployeePojo s1, EmployeePojo s2) {
            return Double.compare(s1.getSalary(), s2.getSalary());
        }
    }


