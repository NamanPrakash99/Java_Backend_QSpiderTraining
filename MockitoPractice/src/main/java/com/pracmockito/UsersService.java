package com.pracmockito;


// Buisness Logic
public class UsersService {
	
	UsersDao dao;     // null Value
	
	public UsersService(UsersDao dao){
		this.dao=dao;
	}
	
	
	public String typeOfUser(int id) {
		Users user=dao.findById(id);
		
		if(user.getBalance()>0 && user.getBalance()<=100) {
			return "new User";
		}else if(user.getBalance()>1001 && user.getBalance()<=2000) {
			return "regular User";
		}else {
			return "premium User";
		}
	}
	
	
}
