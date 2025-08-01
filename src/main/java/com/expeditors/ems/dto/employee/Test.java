package com.expeditors.ems.dto.employee;

public class Test {
    public static void main(String[] args) {
        Employee employee = new Employee(1,"Bhuvanesh");
        Employee employee1 = new Employee(1,"Bhuvanesh");

        System.out.println(employee.equals(employee1));
        //employee.getName==employee1.getName
    }
}
