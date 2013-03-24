package com.hongkoto_gr3ymatter.sidewalkempire;


import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class Store {
	
	private HashMap<String,ArrayList<String>> stageConstraints, menuAdditions;
	private HashMap<String, Double> inventory, menuPrices, equipmentPrices, wholesalePrices;
	private ArrayList<String> menu;
	int stageNumber;
	double levelOfDifficulty;

	
	Store(){
		// Constructor, build following HashMaps: stageConstraints, inventory, menuPrices, equipmentPrices, wholesalePrices, menuAdditions
		stageNumber = 1;
		levelOfDifficulty = 1.0;  // 1.0 easy, 2.0 medium, 3.0 hard
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
		
		
		inventory = new HashMap<String,Double>();
		inventory.put("Cash", 1000.00);
		inventory.put("Coffee Beans", 20.0);
		
		menuPrices = new HashMap<String,Double>();
		menuPrices.put("Donut", 0.5);
		menuPrices.put("Scone", 0.75);
		menuPrices.put("Biscotti", 0.75);
		menuPrices.put("Danish", 0.75);
		menuPrices.put("Mocha", 3.50);
		menuPrices.put("Cappucino", 3.50);
		menuPrices.put("Espress Shot", 2.50);
		menuPrices.put("Latte", 3.50);
		menuPrices.put("Coffee", 2.00);
		
		equipmentPrices = new HashMap<String,Double>();
		equipmentPrices.put("Espresso Machine", 2000.00);
		equipmentPrices.put("Roaster", 10000.00);
		equipmentPrices.put("Pastry Rack", 750.00);
		equipmentPrices.put("Next Level", 15000.00);
		
		wholesalePrices = new HashMap<String,Double>();
		wholesalePrices.put("Coffee Beans", 5.00);
		wholesalePrices.put("Donuts", 0.5);
		wholesalePrices.put("Scones", 0.75);
		wholesalePrices.put("Biscotti", 0.75);
		wholesalePrices.put("Danish", 0.75);
		
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
		
	public HashMap<String,Double> getInventory(){
		return inventory;
		}
		
	public HashMap<String,Double> getMenuPrices(){
		return menuPrices;
		}
		
	public HashMap<String,Double> getEquipmentPrices(){
		return equipmentPrices;
		}
	
	public HashMap<String,Double> getWholeSalePrices(){
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
		double prefLevel = 0.0;
		for (String item: cust.getPreferences().keySet() ){
			if (this.inventory.containsKey(item)) prefLevel += cust.getPreferences().get(item); 
			if (getStageConstraints().get("Equipment Purchased").indexOf(item) != -1) prefLevel += cust.getPreferences().get(item);
			if (getStageConstraints().get("Beans Acquired").indexOf(item) != -1) prefLevel += cust.getPreferences().get(item);
			if (getStageConstraints().get("Roasts Acquired").indexOf(item) != -1) prefLevel += cust.getPreferences().get(item);
			Random randmaker = new Random();
			double randomBoost = (randmaker.nextDouble() * 2);
			
			cust.setCustomerPreference(prefLevel + randomBoost);
		}
		
	}
	
	void convert_customer(Customer cust){
		// Method takes as input Customer object and uses cust.customerPreference to determine if customer enters store.	
		// Set cust.converted to boolean result;
		if (cust.getCustomerPreference() > this.levelOfDifficulty) {
			cust.setConverted(true);
		}else {cust.setConverted(false);}
		
		
	}
	
	void make_purchase(Customer cust){
		// Method takes Customer object and uses cust.customerPreference and this.inventory as inputs to calculate amount of purchase.
		double thispurchase = 0.0;
		System.out.println("Purchase!");
		/*
		double inter = cust.getCustomerPreference();
		int endloop = int(inter);
		for (int i = 0; i <= endloop; i++){
			
			}
		*/
		/*
		 		for i in range(int(self.preference)):  #purchases one item for each point of preference
			purchasedItem = game.menu[random.randint(0, len(game.menu) - 1)]
			if purchasedItem in game.inventory:
				if game.inventory[purchasedItem] <= 0:
					print "Out of %s inventory." % (purchasedItem)
				else:
					print str(self) + " purchased " + purchasedItem
					purchaseTotal += game.menuPrices[purchasedItem]
					game.inventory[purchasedItem] -= 1
			else:
				if game.inventory['Coffee Beans'] <= 0.00:
					print "Not enough coffee beans."
				else:
					print str(self) + " purchased " + purchasedItem
					purchaseTotal += game.menuPrices[purchasedItem]
					game.inventory['Coffee Beans'] -= 0.10* 
		*/
		cust.setPurchase(thispurchase);  
		
	}
	
	void process_customer(Customer cust){
		//method that runs all customer methods to determine if customer makes a purchase and stores customer fields.
		determinePreference(cust);
		convert_customer(cust);
		if (cust.getConverted()) make_purchase(cust);
				
		}

}
