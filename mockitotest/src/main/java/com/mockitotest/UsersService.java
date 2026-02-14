package com.mockitotest;

public class UsersService {

	
	private UsersDao dao;
	
	public UsersService(UsersDao dao) {
		this.dao=dao;
	}
	
	public String typeOfUser(int id) {
		
		Users user=dao.findById(id);
		
		if(user.getBalance()>0&& user.getBalance()<=1000) {
			 return "new user";
		}else if(user.getBalance()>1001 && user.getBalance()<=2000) {
			return "regular user";
		}else {
			return "premium user";
		}
	}
}
