package com.jhdit.java.learning.streams;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeSalarySumExamples {
    public class Employee  {
        private String salary;

        public Employee(String salary) {
            this.salary = salary;
        }

        public String getSalary() {
            return salary;
        }
    }

    @Test
    void sumSalaries()  {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("50000"));
        list.add(new Employee("100000"));

        int sum = list.stream()
                .map(e -> e.salary)
                .map(Integer::parseInt)
                .reduce(0, (subTotal, value) -> subTotal + value);

        assertEquals(150000, sum);
    }

    @Test
    void sumSalariesAlt()  {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("50000"));
        list.add(new Employee("100000"));

        int sum = list.stream() // Stream<EmployeeSalarySumExamples.Employee>
                .map(Employee::getSalary) // Steam<String>
                .map(Integer::parseInt) // Stream<Integer>
                .reduce(0, (subTotal, value) -> subTotal + value);

        assertEquals(150000, sum);
    }

}
