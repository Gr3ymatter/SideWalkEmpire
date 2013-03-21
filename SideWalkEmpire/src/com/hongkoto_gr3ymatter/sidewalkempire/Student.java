package com.hongkoto_gr3ymatter.sidewalkempire;

import java.util.HashMap;

public class Student extends Customer {

	public Student() {
		
		name = "Student";
		HashMap<String, Double> preferences = new HashMap<String,Double>();
		preferences.put("Donuts", 1.0);
		preferences.put("Coffee Machine", 1.5);

	}

}
