package Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.esotericsoftware.spine.Bone;
import com.esotericsoftware.spine.Skeleton;

public class Person extends Actor {


	public Bone root;
	public Skeleton skeleton;
	float totalTime;
	Assets assets;
	int rand;
	boolean headScratch;
	public String state;


	public Person (int width, int height, int rand){		
		skeleton =  Assets.getCustomerSkeleton();
		this.rand = rand;
		root = skeleton.getRootBone();
		root.setX(width);
		root.setY(height);
		root.setScaleX(.08f);
		root.setScaleY(.08f);
		skeleton.updateWorldTransform();
		headScratch = false;
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
		
		Assets.customerWalkingAnimation.apply(skeleton, totalTime, true);
		
		skeleton.updateWorldTransform();
		
		if(state != "Idle")
			root.setX(root.getX()+1f);
		
		if(root.getX() == rand){
			
			state = "Idle";
			
			float animTime = totalTime - totalTime;
			
			Assets.customerIdleAnimation.apply(skeleton, totalTime, false);
		
			
			if(totalTime >= 1200){
				state = "moving";
				totalTime = 0;
				Gdx.app.log("TotalTime: ", "" + totalTime);
				
			}
		}
		
		
		
		skeleton.updateWorldTransform();

		
	}
	
}
