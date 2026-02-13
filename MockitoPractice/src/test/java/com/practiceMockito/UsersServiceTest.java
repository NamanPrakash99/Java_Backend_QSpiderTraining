package com.practiceMockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.pracmockito.Calculator;
import com.pracmockito.MathService;
import com.pracmockito.UsersDao;
import com.pracmockito.UsersService;

public class UsersServiceTest {
	
	@Test
	public void testGetTypeOfCustomer() {
		UsersDao userdao=new UsersDao();
		UsersService userService=new UsersService(userdao);
		String actualRes=userService.typeOfUser(1);
		assertEquals("regular User",actualRes);
		
	}
	
	@Test
	public void testDoubeAddition() {
		
		// Step1:  CreateFakeObject
		Calculator calmock=mock(Calculator.class);
		
		// Step2:  what mock object should return 
		when(calmock.add(5, 5)).thenReturn(10);
		
		// Step3:  inject the mock reference
		MathService service=new MathService(calmock);
		
		int res=service.doubleAddition(5, 5);
		
		assertEquals(20,res);
		
	}
}
