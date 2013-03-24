package Models;

import java.util.HashMap;

public class Store {

	HashMap stageConstraints, inventory, menuPrices, equipmentPrices, wholesalePrices;

	Store(int stageNumber){
		// Constructor, build following HashMaps: stageConstraints, inventory, menuPrices, equipmentPrices, wholesalePrices
		switch (stageNumber){
		case 1: {
			stageConstraints.put("Title", "The Avenues");
		//	stageConstraints.put("Customers", {"Hippie", "Laborer", "Student"});
			stageConstraints.put("Equipment Available", "The Avenues");
			stageConstraints.put("Title", "The Avenues");
			stageConstraints.put("Title", "The Avenues");
			stageConstraints.put("Title", "The Avenues");
			stageConstraints.put("Title", "The Avenues");

		}


		}			
	}
/*
	double determine_preference(HashMap preference){
		//Method iterates through input Customer preference Hashmap, compares against store inventory, and outputs number greater than 0.0.
		
	}

	boolean convert_customer(double customerPreference){
		// Method takes as input result of determine_preference() and sets to true if greater than 1 - customer enters store.

	}

	double make_purchase(){
		// Method 

	}

	*/
}