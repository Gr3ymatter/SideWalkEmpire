package Models;


import java.util.HashMap;

public class Hipster extends Customer {

	public Hipster() {

		type = "Hipster";


		preferences.put("Scones", 0.75f);
		preferences.put("Biscotti", 1.5f);
		preferences.put("Roaster", 2.5f);
		preferences.put("Mundo Novo", 2.0f);
		preferences.put("Full City", 1.75f);
	}

}

