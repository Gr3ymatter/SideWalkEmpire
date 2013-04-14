package Models;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.esotericsoftware.spine.Skeleton;

public class Student extends Customer {

	public Student() {

		type = "Student";

		preferences.put("Donuts", 1.0f);
		preferences.put("Coffee Machine", 1.5f);

		skeleton =new Skeleton(Assets.studentSkeletonData);
		root = skeleton.getRootBone();
		root.setX(positionX);
		root.setY(positionY);
		root.setScaleX(0.1f);
		root.setScaleY(0.1f);
		Gdx.app.log("Student Positon", "" + root.getX() + " ," + root.getY());
		walkAnimation = Assets.studentWalkAnimation;
		skeleton.updateWorldTransform();
		
	}

	
	
}