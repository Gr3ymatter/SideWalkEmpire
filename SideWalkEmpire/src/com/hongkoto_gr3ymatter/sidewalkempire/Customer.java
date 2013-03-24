package com.hongkoto_gr3ymatter.sidewalkempire;


import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
// This class will contain common character variables and methods & animation methods for characters 
	
	protected HashMap<String,Double> preferences;
	HashMap<String,ArrayList<String>> comments; //("positive" key with array of possible comments, "negative" as well.  Implemented at individual character level.)
	protected boolean converted; //when store convertCustomer method is run, store value here?
	protected double purchase; // after make purchase is run, store value here?
	protected double customerPreference; // after preference is determined in store method, store value here?
	protected String name;
	
	Customer(){
		// Only consistent aspect is name across customer constructors
		preferences = new HashMap<String,Double>();
		//Placeholder constructor
	}

	public String getName(){
		return name;
		}
	
	public HashMap<String,Double> getPreferences(){
		
		return preferences;
		}
		
	public void setCustomerPreference(double pref){
		customerPreference = pref;
		
		}	
	
	public double getCustomerPreference(){
		return customerPreference;				
		}
		
	public void setConverted(boolean conv){
		converted = conv;
		}
		
	public boolean getConverted(){
		return converted;
		}
		
	public void setPurchase(double purch){
		purchase = purch;
		}
		
	public double getPurchase(){
		return purchase;
		}
	
}
