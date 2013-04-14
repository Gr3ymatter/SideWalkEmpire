package Models;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.esotericsoftware.spine.Animation;
import com.esotericsoftware.spine.Bone;
import com.esotericsoftware.spine.Skeleton;
import com.esotericsoftware.spine.SkeletonData;

public class Tee extends Actor{

	Bone root;
	SkeletonData skeletonData;
	Skeleton skeleton;
	Animation animation;
	float totalTime;
	

	public Tee (){
		skeletonData = Assets.teeSkeletonData;
		skeleton = new Skeleton(skeletonData);
		animation = Assets.teeWaveAnimation;
		root = skeleton.getRootBone();
		skeleton.setFlipX(true);
		root.setX(250);
		root.setY(380);
		root.setScaleX(.15f);
		root.setScaleY(.15f);
		skeleton.updateWorldTransform();
		
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		
		
		skeleton.draw(batch);
		
	//.draw(Assets.cartRegion, 250, 500, Assets.cartRegion.getRegionWidth()/2, Assets.cartRegion.getRegionHeight()/2);
		
	}

	@Override
	public void act(float delta) {

		totalTime += delta;
		
	//	Gdx.app.log("Message", "Time: " + totalTime);
		
		animation.apply(skeleton, totalTime, true);

		skeleton.updateWorldTransform();
		
		
	}
	
	
	
}
