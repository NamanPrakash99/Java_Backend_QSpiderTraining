package com.Task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Lead {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lead_id;
	private String source;
	private String status;

	@ManyToOne
	private SalesEmployee employee;

	public SalesEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(SalesEmployee employee) {
		this.employee = employee;
	}

	public int getLead_id() {
		return lead_id;
	}

	public void setLead_id(int lead_id) {
		this.lead_id = lead_id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Lead [lead_id=" + lead_id + ", source=" + source + ", status=" + status + ", employee=" + employee
				+ "]";
	}

	
}
