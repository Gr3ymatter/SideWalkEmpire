package com.hongkoto_gr3ymatter.sidewalkempire;


import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class Store {
	
	private HashMap<String,ArrayList<String>> stageConstraints, menuAdditions;
	private HashMap<String, Float> inventory, menuPrices, equipmentPrices, wholesalePrices;
	private ArrayList<String> menu;

	private int stageNumber;
	private float levelOfDifficulty;

	
	Store(){
		// Constructor, build following HashMaps: stageConstraints, inventory, menuPrices, equipmentPrices, wholesalePrices, menuAdditions
		stageNumber = 1;
		levelOfDifficulty = 1.0f;  // 1.0 easy, 2.0 medium, 3.0 hard
		stageConstraints = new HashMap<String, ArrayList<String>>();
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
		
		
		inventory = new HashMap<String,Float>();
		inventory.put("Cash", 1000.00f);
		inventory.put("Coffee Beans", 20.0f);
		
		menuPrices = new HashMap<String,Float>();
		menuPrices.put("Donut", 0.5f);
		menuPrices.put("Scone", 0.75f);
		menuPrices.put("Biscotti", 0.75f);
		menuPrices.put("Danish", 0.75f);
		menuPrices.put("Mocha", 3.50f);
		menuPrices.put("Cappucino", 3.50f);
		menuPrices.put("Espress Shot", 2.50f);
		menuPrices.put("Latte", 3.50f);
		menuPrices.put("Coffee", 2.00f);
		
		equipmentPrices = new HashMap<String,Float>();
		equipmentPrices.put("Espresso Machine", 2000.00f);
		equipmentPrices.put("Roaster", 10000.00f);
		equipmentPrices.put("Pastry Rack", 750.00f);
		equipmentPrices.put("Next Level", 15000.00f);
		
		wholesalePrices = new HashMap<String,Float>();
		wholesalePrices.put("Coffee Beans", 5.00f);
		wholesalePrices.put("Donuts", 0.5f);
		wholesalePrices.put("Scones", 0.75f);
		wholesalePrices.put("Biscotti", 0.75f);
		wholesalePrices.put("Danish", 0.75f);
		
		menu = new ArrayList<String>();
		
		menu.add("Coffee");
		menu.add("Biscotti");
		
		menuAdditions = new HashMap<String, ArrayList<String>>();
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
	
	public HashMap<String,ArrayList<String>> getStageConstraints(){
		return stageConstraints;
		}
		
	public HashMap<String,Float> getInventory(){
		return inventory;
		}
		
	public void setInventory(String key, Float value){
		inventory.put(key, value);
		}
		
	public void addPurchase(Customer cust){
		// Grabs purchase amount from customer object and adds to total cash.
		inventory.put("Cash", inventory.get("Cash") + cust.getPurchase());
		}
	
	public void addPurchase(float purch){
		// Adds parameter to total cash.
		inventory.put("Cash", inventory.get("Cash") + purch);
		}
		
	public HashMap<String,Float> getMenuPrices(){
		return menuPrices;
		}
		
	public HashMap<String,Float> getEquipmentPrices(){
		return equipmentPrices;
		}
	
	public HashMap<String,Float> getWholeSalePrices(){
		return wholesalePrices;
		}	
		
	public HashMap<String,ArrayList<String>> getMenuAdditions(){
		return menuAdditions;
		}		
		
	public ArrayList<String> getMenu(){
		return menu;
		}
		
	public void addToMenu(String item){
		menu.add(item);
		}
	
	//Need to add public set menus as well.  Probably will have method name for setHashMap, and take "key" and "value" inputs
	// HashMap.put("key", "value") inside method.
	
	void determinePreference(Customer cust){
		//Method takes as input customer object, iterates through input Customer preference Hashmap, compares against store inventory, 
		//and stores number greater than 0.0 to Customer.customerPreference field.
		float prefLevel = 0.0f;
		for (String item: cust.getPreferences().keySet() ){
			if (this.inventory.containsKey(item)) prefLevel += cust.getPreferences().get(item); 
			if (getStageConstraints().get("Equipment Purchased").indexOf(item) != -1) prefLevel += cust.getPreferences().get(item);
			if (getStageConstraints().get("Beans Acquired").indexOf(item) != -1) prefLevel += cust.getPreferences().get(item);
			if (getStageConstraints().get("Roasts Acquired").indexOf(item) != -1) prefLevel += cust.getPreferences().get(item);
			Random randmaker = new Random();
			float randomBoost = (randmaker.nextFloat() * 2);
			
			cust.setCustomerPreference(prefLevel + randomBoost);
		}
		
	}
	
	void convertCustomer(Customer cust){
		// Method takes as input Customer object and uses cust.customerPreference to determine if customer enters store.	
		// Set cust.converted to boolean result;
		if (cust.getCustomerPreference() > this.levelOfDifficulty) {
			cust.setConverted(true);
		}else {cust.setConverted(false);}
		
		
	}
	
	
	
	void makePurchase(Customer cust){
		// Method takes Customer object and uses cust.customerPreference and this.inventory as inputs to calculate amount of purchase.
		float purchaseTotal = 0.0f;
		System.out.println("Purchase!");
		
		int endloop = (int)cust.getCustomerPreference();
		Random randmaker = new Random();
		
		for (int i = 0; i <= endloop; i++){
			
			
			String purchasedItem = getMenu().get((int)((randmaker.nextFloat() * getMenu().size()) ));
			if (randmaker.nextFloat()<= 0.70f){
			// if true, forces customer to buy something within their preferences if in stock.
				for (String item: cust.getPreferences().keySet()) {
					if (menu.contains(item)){
						if (randmaker.nextFloat() >= 0.40){
							purchasedItem = item;
						}
						}
					}
			}
			// ***Find preference items on menu through iteration and increase chance that they will purchase what they want.***
			if (inventory.containsKey(purchasedItem)){
				if (inventory.get(purchasedItem) <= 0){
					// In Inventory, but out of item.
					// Use this to create Customer text output but dont have it spam user.
					}
				else{	
					//add purchase to purchase total and reduce one unit from inventory.
					purchaseTotal += getMenuPrices().get(purchasedItem);
					inventory.put(purchasedItem, inventory.get(purchasedItem) - 1.0f);
						}
				
				// Add higher probability of purchasing from favorite items.  
			}else{
				if (getInventory().get("Coffee Beans") >= 0.1f){
					purchaseTotal += getMenuPrices().get(purchasedItem);
					inventory.put("Coffee Beans", inventory.get("Coffee Beans") - 0.1f);
					}else{
						// Coffee Beans out of stock, can't make drink
						// Use this to create Customer text output of dissatisfaction.
						}
				
				}
		
			
			
			
			} // end for loop

		cust.setPurchase(purchaseTotal);  
		
	}
	
	void processCustomer(Customer cust){
		//method that runs all customer methods to determine if customer makes a purchase and stores customer fields.
		determinePreference(cust);
		convertCustomer(cust);
		if (cust.getConverted()) makePurchase(cust);
				
		}

}
