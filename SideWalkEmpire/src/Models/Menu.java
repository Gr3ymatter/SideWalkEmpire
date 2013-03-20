package Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Menu extends Actor {

	//TextureRegion region;
	
	public Menu(){
		//region = new TextureRegion(atlas.findRegion("menu_toolbar"));
	}
	
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		batch.draw(Assets.menuRegion, 0, 0, Gdx.graphics.getWidth(), Assets.menuRegion.getRegionHeight());
	
		
	
	}
	

	
}
