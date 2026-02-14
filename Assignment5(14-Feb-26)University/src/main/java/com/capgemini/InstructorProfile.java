package com.capgemini;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InstructorProfile {

    @Id
    private long id;
    private String officeRoom;
    private String phone;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOfficeRoom() {
		return officeRoom;
	}
	public void setOfficeRoom(String officeRoom) {
		this.officeRoom = officeRoom;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "InstructorProfile [id=" + id + ", officeRoom=" + officeRoom + ", phone=" + phone + "]";
	}
    
    
}
