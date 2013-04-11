package Models;

import java.util.HashMap;

public class Student extends Customer {

	public Student() {

		type = "Student";

		preferences.put("Donuts", 1.0f);
		preferences.put("Coffee Machine", 1.5f);

	}

	
	
}