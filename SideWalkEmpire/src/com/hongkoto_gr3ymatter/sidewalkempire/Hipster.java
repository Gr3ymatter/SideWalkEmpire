package com.hongkoto_gr3ymatter.sidewalkempire;

import java.util.HashMap;

public class Hipster extends Customer {

	public Hipster() {
			
		name = "Hipster";
		
		HashMap<String, Double> preferences = new HashMap<String,Double>();
		preferences.put("Scones", 0.75);
		preferences.put("Biscotti", 1.5);
		preferences.put("Roaster", 2.5);
		preferences.put("Mundo Novo", 2.0);
		preferences.put("Full City", 1.75);
	}

}
