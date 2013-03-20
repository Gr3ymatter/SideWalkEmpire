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

	public Person (int width, int height){		
		skeleton =  assets.customerSkeleton;
		
		root = skeleton.getRootBone();
		root.setX(width);
		root.setY(height);
		root.setScaleX(.25f);
		root.setScaleY(.25f);
		skeleton.updateWorldTransform();
		
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		
		skeleton.draw(batch);
		
	}

	@Override
	public void act(float delta) {
		
		totalTime += delta;
						
		if(totalTime > 3){
		float animTime = totalTime - 3;
			
		Assets.customerIdleAnimation.apply(skeleton, animTime, false); 			
		
		}if(totalTime >10) totalTime = 0;
		
		skeleton.updateWorldTransform();
	}
	

	
}
