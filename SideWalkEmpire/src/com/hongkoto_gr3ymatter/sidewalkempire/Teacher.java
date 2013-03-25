package com.hongkoto_gr3ymatter.sidewalkempire;

import java.util.HashMap;

public class Teacher extends Customer {

	public Teacher() {
		
		type = "Teacher";
		
		preferences.put("Espresso Machine", 1.5f);
		preferences.put("Cinnamon", 0.75f);
		preferences.put("Bourbon", 1.5f);

	}

}
