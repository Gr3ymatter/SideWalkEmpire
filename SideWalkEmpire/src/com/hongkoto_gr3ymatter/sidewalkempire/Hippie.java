package com.hongkoto_gr3ymatter.sidewalkempire;

import java.util.HashMap;



class Hippie extends Customer {

	public Hippie() {
		name = "Hippie";
		
		HashMap<String, Double> preferences = new HashMap<String,Double>();
		preferences.put("Donuts", 1.5);
		preferences.put("Biscotti", 0.5);
		preferences.put("Espresso Machine", 0.75);
		preferences.put("Roaster", 2.0);
		preferences.put("Ethiopian", 1.0);
		preferences.put("New England", 0.75);
		
	}

}
