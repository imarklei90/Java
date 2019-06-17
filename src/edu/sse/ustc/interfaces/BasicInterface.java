package edu.sse.ustc.interfaces;

import java.util.Arrays;
import java.util.Comparator;

public class BasicInterface {

	public static void main(String[] args) {
		Employee[] employees = new Employee[3];
		employees[0] = new Employee("Name1", 12345.1);
		employees[1] = new Employee("Admin1", 12342222.3);
		employees[2] = new Employee("G", 1987.6);
		
		Arrays.sort(employees);
		
		for(Employee employee : employees) {
			System.out.println(employee.getName() + " : " + employee.getSalary());
		}
		
		Arrays.sort(employees, new LengthComparator());
		
		for(Employee employee : employees) {
			System.out.println(employee.getName() + " : " + employee.getSalary());
		}
		
	}

}

// implement Comparable interface
class Employee implements Comparable<Employee>{
	private String name;
	private Double salary;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String name, Double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	
	@Override
	public int compareTo(Employee o) {
		return Double.compare(salary, o.salary);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + ", salary: " + salary; 
	}
}

// implement Comparator Interface
class LengthComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getName().length() - o2.getName().length();
	}
	
}
