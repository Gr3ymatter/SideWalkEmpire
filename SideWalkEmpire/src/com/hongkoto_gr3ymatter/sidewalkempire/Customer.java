package com.hongkoto_gr3ymatter.sidewalkempire;

import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
// This class will contain common character variables and methods & animation methods for characters 
	HashMap<String,Double> preferences;
	HashMap<String,ArrayList<String>> comments; //("positive" key with array of possible comments, "negative" as well.  Implemented at individual character level.)
	boolean converted; //when store convertCustomer method is run, store value here?
	double purchase; // after make purchase is run, store value here?
	double customerPreference; // after preference is determined in store method, store value here?
	String name;
	
	Customer(){
		// Only consistent aspect is name across customer constructors
		preferences.put("name", null);
		
	}
	

}
