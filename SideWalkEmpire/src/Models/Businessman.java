package Models;

import java.util.HashMap;

public class Businessman extends Customer {

	public Businessman() {

		type = "Businessman";


		preferences.put("Donuts", 0.5f);
		preferences.put("Biscotti", 1.5f);
		preferences.put("Espresso Machine", 1.0f);
		preferences.put("Pastry Rack", 1.5f);
		preferences.put("Roaster", 1.5f);
		preferences.put("Colombian", 0.75f);
		preferences.put("Spanish Dark", 1.5f);

	}

}