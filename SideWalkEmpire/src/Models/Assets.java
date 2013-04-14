package Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.esotericsoftware.spine.Animation;
import com.esotericsoftware.spine.Skeleton;
import com.esotericsoftware.spine.SkeletonBinary;
import com.esotericsoftware.spine.SkeletonData;

public class Assets {

	private static TextureAtlas atlas;
	
	public static TextureRegion menuRegion;
	public static TextureRegion cartRegion;
	public static Animation teeWaveAnimation;
	public static Animation customerWalkingAnimation;
	public static Animation customerIdleAnimation;
	public static SkeletonBinary skelBinary;
	public static SkeletonData skeletonData;
	public static SkeletonData teeSkeletonData;
	public static SkeletonData techieSkeletonData;
	public static SkeletonData laborerSkeletonData;
	public static SkeletonData studentSkeletonData;
	public static Animation techieWalkAnimation;
	public static Animation laborerWalkAnimation;
	public static Animation studentWalkAnimation;
	public static Skin skin;

	
	public  static void load(){
		
		atlas = new TextureAtlas(Gdx.files.internal("data/cust.pack"));
		
		//menuRegion = atlas.findRegion("menu_toolbar");
		cartRegion = atlas.findRegion("shack");
			
		skelBinary = new SkeletonBinary(atlas);
		teeSkeletonData = skelBinary.readSkeletonData(Gdx.files.internal("data/tee.skel"));
		techieSkeletonData = skelBinary.readSkeletonData(Gdx.files.internal("data/techie.skel"));
		laborerSkeletonData = skelBinary.readSkeletonData(Gdx.files.internal("data/laborer.skel"));
		studentSkeletonData = skelBinary.readSkeletonData(Gdx.files.internal("data/student.skel"));
	
		techieWalkAnimation = techieSkeletonData.findAnimation("walk");
		laborerWalkAnimation = laborerSkeletonData.findAnimation("walk");
		studentWalkAnimation = studentSkeletonData.findAnimation("walking");
		
		teeWaveAnimation = teeSkeletonData.findAnimation("wave");
		
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		//skin.addRegions(new TextureAtlas(Gdx.files.internal("data/uiskin.pack")));
	}

}


