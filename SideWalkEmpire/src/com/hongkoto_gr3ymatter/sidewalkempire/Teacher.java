package com.hongkoto_gr3ymatter.sidewalkempire;

import java.util.HashMap;

public class Teacher extends Customer {

	public Teacher() {
		
		name = "Teacher";
		HashMap<String, Double> preferences = new HashMap<String,Double>();
		preferences.put("Espresso Machine", 1.5);
		preferences.put("Cinnamon", 0.75);
		preferences.put("Bourbon", 1.5);

	}

}
