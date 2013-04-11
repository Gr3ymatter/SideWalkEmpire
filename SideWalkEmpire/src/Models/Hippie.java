package Models;

import java.util.HashMap;



public class Hippie extends Customer {

	public Hippie() {
		type = "Hippie";
		preferences.put("Donuts", 1.5f);
		preferences.put("Biscotti", 0.5f);
		preferences.put("Espresso Machine", 0.75f);
		preferences.put("Roaster", 2.0f);
		preferences.put("Ethiopian", 1.0f);
		preferences.put("New England", 0.75f);

	}

}