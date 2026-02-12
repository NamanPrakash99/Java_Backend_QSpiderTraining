package com.prac;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

 //   @Test
//    public void testEmptyList() {
//        List<Employee1> list = new ArrayList<>();
//        assertFalse(Employee1.validateEmployees(list));
//    }
    
 //   @Test
//    public void testLessThanFiveEmployees() {
//        List<Employee1> list = new ArrayList<>();
//
//        list.add(new Employee1(1,"A",25,"IT"));
//        list.add(new Employee1(2,"B",26,"IT"));
//
//        assertFalse(Employee1.validateEmployees(list));
//    }
    
    
 //   @Test
    public void testAgeInvalid() {
    	List<Employee1> list = new ArrayList<>();

        list.add(new Employee1(1,"Naman",80000,25,"CSE","02-Jan-1989"));
        list.add(new Employee1(2,"Ravi",40000,16,"IT","04-Apr-1990")); 
        list.add(new Employee1(3,"Divyansh",55000,30,"MEC","05-May-2000"));
        list.add(new Employee1(4,"Utkarsh",65000,28,"ECE","26-Oct-1988"));
        list.add(new Employee1(5,"Harsh",82000,22,"IT","19-Dec-1995"));

        assertTrue(Employee1.validateEmployees(list));
    }
    
    @Test
    public void testAllValid() {
        List<Employee1> list = new ArrayList<>();

        list.add(new Employee1(1,"Naman",80000,25,"CSE","02-Jan-1989"));
        list.add(new Employee1(2,"Ravi",40000,32,"IT","04-Apr-1990")); 
        list.add(new Employee1(3,"Divyansh",55000,30,"MEC","05-May-2000"));
        list.add(new Employee1(4,"Utkarsh",65000,28,"ECE","26-Oct-1988"));
        list.add(new Employee1(5,"Harsh",82000,22,"IT","19-Dec-1995"));

        assertTrue(Employee1.validateEmployees(list));
    }
}
