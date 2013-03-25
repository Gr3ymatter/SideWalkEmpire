package com.hongkoto_gr3ymatter.sidewalkempire;

import java.util.HashMap;

public class Laborer extends Customer {

	public Laborer() {
		type = "Laborer";
		
		preferences.put("Donuts", 1.5f);
		preferences.put("Coffee Machine", 1.25f);
		preferences.put("French Espresso", 1.0f);

	}

}
