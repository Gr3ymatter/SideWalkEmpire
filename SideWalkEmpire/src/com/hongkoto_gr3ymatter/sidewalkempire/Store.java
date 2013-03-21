package com.hongkoto_gr3ymatter.sidewalkempire;

import java.util.HashMap;
import java.util.ArrayList;

public class Store {
	
	HashMap stageConstraints, inventory, menuPrices, equipmentPrices, wholesalePrices, menuAdditions;
	int stageNumber;

	
	Store(){
		// Constructor, build following HashMaps: stageConstraints, inventory, menuPrices, equipmentPrices, wholesalePrices, menuAdditions
		stageNumber = 1;
		HashMap<String, ArrayList<String>> stageConstraints = new HashMap<String, ArrayList<String>>();
		stageConstraints.put("Title", new ArrayList<String>() {{add("The Avenues");}});

		stageConstraints.put("Customers", new ArrayList<String>() {{add("Hippie");
																	add("Laborer");
																	add("Student");}});
		
		stageConstraints.put("Equipment Available", new ArrayList<String>(){{add("Espresso Machine");
																			add("Pastry Rack");}});
		
		stageConstraints.put("Equipment Purchased", new ArrayList<String>(){{add("Coffee Machine");}});
		
		stageConstraints.put("Roasts Available", new ArrayList<String>(){{add("French Espresso");}});
		
		stageConstraints.put("Roasts Acquired", new ArrayList<String>(){{add("Italian Espresso");}});
		
		stageConstraints.put("Beans Available", new ArrayList<String>(){{add("Colombian");
																		add("Ethiopian");}});
		
		stageConstraints.put("Beans Acquired",  new ArrayList<String>(){{add("Java");}});
		
		
		HashMap<String,Double> inventory = new HashMap<String,Double>();
		inventory.put("Cash", 1000.00);
		inventory.put("Coffee Beans", 20.0);
		
		HashMap<String,Double> menuPrices = new HashMap<String,Double>();
		menuPrices.put("Donut", 0.5);
		menuPrices.put("Scone", 0.75);
		menuPrices.put("Biscotti", 0.75);
		menuPrices.put("Danish", 0.75);
		menuPrices.put("Mocha", 3.50);
		menuPrices.put("Cappucino", 3.50);
		menuPrices.put("Espress Shot", 2.50);
		menuPrices.put("Latte", 3.50);
		menuPrices.put("Coffee", 2.00);
		
		HashMap<String,Double> equipmentPrices = new HashMap<String,Double>();
		equipmentPrices.put("Espresso Machine", 2000.00);
		equipmentPrices.put("Roaster", 10000.00);
		equipmentPrices.put("Pastry Rack", 750.00);
		equipmentPrices.put("Next Level", 15000.00);
		
		HashMap<String,Double> wholesalePrices = new HashMap<String,Double>();
		wholesalePrices.put("Coffee Beans", 5.00);
		wholesalePrices.put("Donuts", 0.5);
		wholesalePrices.put("Scones", 0.75);
		wholesalePrices.put("Biscotti", 0.75);
		wholesalePrices.put("Danish", 0.75);
		
		HashMap<String, ArrayList<String>> menuAdditions = new HashMap<String, ArrayList<String>>();
		menuAdditions.put("Pastry Rack", new ArrayList<String>() {{add("Donut");
																	add("Scone");
																	add("Danish");}});
		
		menuAdditions.put("Espresso Machine", new ArrayList<String>() {{add("Mocha");
																		add("Latte");
																		add("Cappucino");
																		add("Espresso Shot");}});
		}
		

	
	Store(Store prevStage, int targetStage){
	stageNumber = targetStage;
	switch(targetStage){
	
		case 2: {
			//some factors will be contingent on outputs from prevStage.
			HashMap<String, ArrayList<String>> stageConstraints = new HashMap<String, ArrayList<String>>();
			stageConstraints.put("Title", new ArrayList<String>() {{add("The Streets");}});
			stageConstraints.put("Customers", new ArrayList<String>() {{add("Hippie");
																		add("Laborer");
																		add("Student");
																		add("Businessman");
																		add("Teacher");}});
			
			stageConstraints.put("Equipment Available", (ArrayList<String>) prevStage.stageConstraints.get("Equipment Available"));
			stageConstraints.get("Equipment Available").add("Roaster");
					
			stageConstraints.put("Equipment Purchased", (ArrayList<String>) prevStage.stageConstraints.get("Equipment Purchased"));
						
			stageConstraints.put("Roasts Available", (ArrayList<String>) prevStage.stageConstraints.get("Roasts Available"));
			stageConstraints.get("Roasts Available").add("Spanish Dark");
			stageConstraints.get("Roasts Available").add("Cinnamon");
			
			stageConstraints.put("Roasts Acquired", (ArrayList<String>) prevStage.stageConstraints.get("Roasts Acquired"));
			
			stageConstraints.put("Beans Available", (ArrayList<String>) prevStage.stageConstraints.get("Beans Available"));
			stageConstraints.get("Beans Available").add("Bourbon");
			stageConstraints.get("Beans Available").add("Panama");
			stageConstraints.get("Beans Available").add("Sumatra");
			
			stageConstraints.put("Beans Acquired", (ArrayList<String>) prevStage.stageConstraints.get("Beans Acquired"));
					
		break;
			}
	//cases 3 through 5 reserved for future stages
		}
	
	}		
	

		

		
		
	
	
	
	double determine_preference(Customer cust){
		//Method takes as input customer object, iterates through input Customer preference Hashmap, compares against store inventory, 
		//and stores number greater than 0.0 to Customer.customerPreference field.
		double prefLevel = 0.0;
		for (String item: cust.preferences.keySet() ){
			//START HERE
		}
	}
	
	boolean convert_customer(double customerPreference){
		// Method takes as input result of determine_preference() and sets to true if greater than 1 - customer enters store.
		//call make_purchase in here to use customerPreference.
	}
	
	double make_purchase(double customerPreference){
		// Method iterates 
		
	}
	

}
