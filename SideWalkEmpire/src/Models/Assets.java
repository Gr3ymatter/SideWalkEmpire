package Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.esotericsoftware.spine.Animation;
import com.esotericsoftware.spine.Skeleton;
import com.esotericsoftware.spine.SkeletonBinary;
import com.esotericsoftware.spine.SkeletonData;

public class Assets {

	private static TextureAtlas atlas;
	
	public static TextureRegion menuRegion;
	public static TextureRegion cartRegion;
	public static Skeleton teeSkeleton;
	public static Animation teeWaveAnimation;
	public static Animation teeSwayAnimation;
	public static Skeleton customerSkeleton;
	public static Animation customerWalkingAnimation;
	public static Animation customerIdleAnimation;
	public static SkeletonBinary skelBinary;
	public static SkeletonData skeletonData;



	public  static void load(){
		
		atlas = new TextureAtlas(Gdx.files.internal("data/sidewalkempire_demo.pack"));

		
		menuRegion = atlas.findRegion("menu_toolbar");
		cartRegion = atlas.findRegion("shack");
				
		skelBinary = new SkeletonBinary(atlas);
		skeletonData = skelBinary.readSkeletonData(Gdx.files.internal("data/tee.skel"));
		teeSkeleton = new Skeleton(skeletonData);
		teeWaveAnimation = skelBinary.readAnimation(Gdx.files.internal("data/tee-Wave.anim"), skeletonData);
		teeSwayAnimation = skelBinary.readAnimation(Gdx.files.internal("data/tee-Sway.anim"), skeletonData);
		
		skeletonData = skelBinary.readSkeletonData(Gdx.files.internal("data/nara.skel"));
		customerWalkingAnimation = skelBinary.readAnimation(Gdx.files.internal("data/nara-Walk.anim"), skeletonData);
		customerIdleAnimation = skelBinary.readAnimation(Gdx.files.internal("data/nara-Idle.anim"), skeletonData);

	}
	
	public static Skeleton getCustomerSkeleton(){
		//skeletonData = skelBinary.readSkeletonData(Gdx.files.internal("data/skeleton.skel"));
		 return new Skeleton(skeletonData);
	}
	
}
