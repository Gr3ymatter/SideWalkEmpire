package Models;

import com.badlogic.gdx.Gdx;
import com.esotericsoftware.spine.Skeleton;






public class Hippie extends Customer {

	public Hippie() {
		type = "Hippie";
		preferences.put("Donuts", 1.5f);
		preferences.put("Biscotti", 0.5f);
		preferences.put("Espresso Machine", 0.75f);
		preferences.put("Roaster", 2.0f);
		preferences.put("Ethiopian", 1.0f);
		preferences.put("New England", 0.75f);
		
		
		skeleton =new Skeleton(Assets.techieSkeletonData);
		root = skeleton.getRootBone();
		root.setX(positionX);
		root.setY(positionY);
		root.setScaleX(0.32f);
		root.setScaleY(0.32f);
		walkAnimation = Assets.techieWalkAnimation;
		
		Gdx.app.log("Hippie Positon", "" + root.getX() + " ," + root.getY());

	}
	
	
	
	
	

}