package Models;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Customer extends Actor {
// This class will contain common character variables and methods & animation methods for characters 

	protected HashMap<String,Float> preferences;
	HashMap<String,ArrayList<String>> comments; //("positive" key with array of possible comments, "negative" as well.  Implemented at individual character level.)
	protected boolean converted; //when store convertCustomer method is run, store value here?
	protected float purchase; // after make purchase is run, store value here?
	protected float customerPreference; // after preference is determined in store method, store value here?
	protected String type;
	protected ArrayList<String> purchasedItems;

	protected int positionX;
	protected int positionY;
	
	Customer(){
		// Only consistent aspect is name across customer constructors
		preferences = new HashMap<String,Float>();
		purchasedItems = new ArrayList<String>();
		//Placeholder constructor
		positionX = -10;
		positionY = 290;
	}
	
	
	

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
		
	}




	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		
		
	}




	public String getType(){
		return type;
		}

	public HashMap<String,Float> getPreferences(){

		return preferences;
		}

	public void setCustomerPreference(float pref){
		customerPreference = pref;

		}	

	public float getCustomerPreference(){
		return customerPreference;				
		}

	public void setConverted(boolean conv){
		converted = conv;
		}

	public boolean getConverted(){
		return converted;
		}

	public void setPurchase(float purch){
		purchase = purch;
		}

	public float getPurchase(){
		return purchase;
		}

	public ArrayList<String> getPurchasedItems(){

		return purchasedItems;
		}
	public void addPurchasedItem(String item){
		purchasedItems.add(item);
		}

	public int getPositionX(){
		return positionX;
	}
	
	public int getPositionY(){
		return positionY;
	}
	
	public void setPositionX(int x){
		positionX = x;
	}
	
	public void setPositionY(int y){
		positionY = y;
	}
}