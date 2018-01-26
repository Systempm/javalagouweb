package com.attempt.select.vo;

import java.util.HashSet;
import java.util.Set;

public class SelectVo {

	
	private String city;
	private String position;
	Set<Integer> salary = new HashSet<Integer>();
	public Set<Integer> getSalary() {
		return salary;
	}
	public void setSalary(Set<Integer> salary) {
		this.salary = salary;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}


	
}
