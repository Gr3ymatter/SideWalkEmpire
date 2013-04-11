package Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Menu extends Actor {

	//TextureRegion region;
	Store store;
	float cash;
	float coffeeBeans; 
	BitmapFont font;
	TextButton menuButton;
	TextButton exitButton;
	Table table;
	Rectangle menuBounds = new Rectangle(0,0,480,200);
	public Menu(Store store){		
		this.store = store;
		font = new BitmapFont();	
		cash = store.getInventory().get("Cash");
		coffeeBeans = store.getInventory().get("Coffee Beans");
		initializeMenuButtons();
		
	}
	
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		batch.draw(Assets.menuRegion, 0, 0, Gdx.graphics.getWidth(), menuBounds.getHeight());
		menuButton.draw(batch, parentAlpha);
		exitButton.draw(batch, parentAlpha);
	}
	
	
	public void initializeMenuButtons(){
		menuButton = new TextButton("Menu", Assets.skin);
		exitButton = new TextButton("Exit", Assets.skin);
		//menuButton.setPosition(getOriginX(), this.getHeight()-menuButton.getHeight());
		menuButton.setSize(150f, 100f);
		menuButton.setPosition(0, menuBounds.getHeight()-menuButton.getHeight());
		
		exitButton.setSize(150f, 100f);
		exitButton.setPosition(0, 0);
		
	}
	
	
	

	
}
