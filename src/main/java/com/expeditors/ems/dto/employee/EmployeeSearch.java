package com.expeditors.ems.dto.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class EmployeeSearch {
    public static void main(String[] args) {
        List<EmployeePojo> employee = new ArrayList<>();
        employee.add(new EmployeePojo(1,"Alice","training",80000.0));
        employee.add(new EmployeePojo(2,"david", "developer",49304));
        employee.add(new EmployeePojo(3,"Charlie","local is",21000));

        Collections.sort(employee,new EmployeeSalaryComparator());

        for (EmployeePojo employees : employee) {
            System.out.println(employees.getName());
        }
    }
}

