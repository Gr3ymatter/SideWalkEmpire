package Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.esotericsoftware.spine.Bone;
import com.esotericsoftware.spine.Skeleton;

public class Tee extends Actor{

	Bone root;
	Skeleton skeleton;
	float totalTime;
	

	public Tee (){
		skeleton = Assets.teeSkeleton;
		root = skeleton.getRootBone();
		root.setX(280);
		root.setY(545);
		root.setScaleX(.5f);
		root.setScaleY(.5f);
		skeleton.updateWorldTransform();
		
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		
		
		skeleton.draw(batch);
		
		batch.draw(Assets.cartRegion, 250, 500, Assets.cartRegion.getRegionWidth()/2, Assets.cartRegion.getRegionHeight()/2);
		
	}

	@Override
	public void act(float delta) {

		totalTime += delta;
		
		Gdx.app.log("Message", "Time: " + totalTime);
		
	
		Assets.teeSwayAnimation.apply(skeleton, totalTime, true);
		if (totalTime > 5) {
			float waveTime = totalTime - 5f;
			
			float mixTime = 10f;
			if (waveTime > mixTime)
				Assets.teeWaveAnimation.apply(skeleton, waveTime, true);
			else
				Assets.teeWaveAnimation.mix(skeleton, waveTime, true, waveTime / mixTime);
			if (totalTime > 10.6) totalTime = 0;
		}
	
	//	Assets.teeWaveAnimation.apply(skeleton, totalTime, true);

		skeleton.updateWorldTransform();
		
		
	}
	
	
	
}
