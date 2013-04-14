package Models;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.esotericsoftware.spine.Animation;
import com.esotericsoftware.spine.Bone;
import com.esotericsoftware.spine.Skeleton;

public class Person extends Actor {


	public Bone root;
	public Skeleton skeleton;
	public Animation walkAnimation;
	float totalTime;
	int rand;
	public String state;
	boolean right;
	


	public Person (int width, int height, int rand, int type){	
		float scaleFactor;
		
		switch(type){
		case 0:
			skeleton = new Skeleton(Assets.techieSkeletonData);
			walkAnimation = Assets.techieWalkAnimation;
			scaleFactor = 0.32f;
			break;
		case 1:
			skeleton = new Skeleton(Assets.laborerSkeletonData);
			walkAnimation = Assets.laborerWalkAnimation;
			scaleFactor = 0.08f;
			break;
		default:
			skeleton = new Skeleton(Assets.studentSkeletonData);
			walkAnimation = Assets.studentWalkAnimation;
			scaleFactor = 0.1f;
			break;
		}
		
		this.rand = rand;
		root = skeleton.getRootBone();
		if(rand > 0.5){
			root.setX(width);
			right = false;
		}
		else{ 
			root.setX(480);
			right = true;
		}
		root.setY(height);
		root.setScaleX(scaleFactor);
		root.setScaleY(scaleFactor);
		skeleton.updateWorldTransform();
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		
		
		skeleton.draw(batch);
		
	}

	@Override
	public void act(float delta) {
		totalTime += delta;
		
		randomMovement(delta);
	
		/*
		if(!headScratch){

		if(totalTime > rand){
		float animTime = totalTime - rand;
			 Assets.customerIdleAnimation.apply(skeleton, animTime, false); 
			 headScratch = true;
		}
		 
		}if(totalTime >(rand+3)) totalTime = 0;
		
		skeleton.updateWorldTransform();
		Gdx.app.log("TotalTime: ", "" + totalTime);
			
	 */
	 
	}
	

	public void randomMovement(float delta){
		
		if(right != true){
		
		walkAnimation.apply(skeleton, totalTime, true);
		
		root.setX(root.getX()+1f);
		
		}else{
			
			skeleton.setFlipX(true);
			walkAnimation.apply(skeleton, totalTime, true);
			root.setX(root.getX()-1f);
		}
		
		/*
		
		if(root.getX() == rand){
			
			state = "Idle";
			
			float animTime = totalTime - totalTime;
			
			Assets.customerIdleAnimation.apply(skeleton, totalTime, false);
		
			
			if(totalTime >= 1200){
				state = "moving";
				totalTime = 0;
				Gdx.app.log("TotalTime: ", "" + totalTime);
				
			}
		
		}*/
		
		
		skeleton.updateWorldTransform();	
	}
	
	public float getPositionX(){
		return root.getX();
	}
	
	public boolean isRight(){
		return right;
	}
}
