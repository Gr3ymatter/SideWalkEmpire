package Models;


import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.esotericsoftware.spine.Skeleton;

public class Laborer extends Customer {

	public Laborer() {
		type = "Laborer";

		preferences.put("Donuts", 1.5f);
		preferences.put("Coffee Machine", 1.25f);
		preferences.put("French Espresso", 1.0f);

		
		skeleton =new Skeleton(Assets.laborerSkeletonData);
		root = skeleton.getRootBone();
		root.setX(positionX);
		root.setY(positionY);
		root.setScaleX(0.08f);
		root.setScaleY(0.08f);
		walkAnimation = Assets.laborerWalkAnimation;
		Gdx.app.log("Laborer Positon", "" + root.getX() + " ," + root.getY());
		skeleton.updateWorldTransform();
	}

}