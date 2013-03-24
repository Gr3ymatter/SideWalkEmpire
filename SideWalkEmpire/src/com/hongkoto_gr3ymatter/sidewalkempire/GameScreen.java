package com.hongkoto_gr3ymatter.sidewalkempire;



import Models.Menu;
import Models.Person;
import Models.Tee;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class GameScreen implements Screen {

	Game game;
	
	Stage stage;
	
	Image image;
	TextureAtlas atlas;
	Menu menu;
	Tee tee;
	Person person;
	Camera camera;
	Array<Person> randomPeople;
	long lastPersonTime;
	
	public GameScreen(Game game){
		this.stage = new Stage();
		this.game = game;
		Gdx.input.setInputProcessor(stage);
		atlas = new TextureAtlas(Gdx.files.internal("data/sidewalkempire_demo.pack"));
		menu = new Menu();
		tee = new Tee();
		
		randomPeople = new Array<Person>();
		spawnRandomPeople();
	}
	
	@Override
	public void render(float delta) {

		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		
		stage.draw();
		
		
		if(TimeUtils.millis() - lastPersonTime > 7000)
				spawnRandomPeople();
		
		
		//Gdx.app.log("People ", "" + randomPeople.size);
		// Debuging Rendering
		//Gdx.app.log("Image", "Stage Width:" + stage.getWidth() + " Stage Height: " + stage.getHeight());
		//Gdx.app.log("Image", "Image Width:" + image.getWidth() + " Image Height: " + image.getHeight());
	}

	@Override
	public void resize(int width, int height) {
		this.camera = new OrthographicCamera(480, 800);
		this.camera.position.set(480/2, 800/2, 0);
		stage.setCamera(camera);
		
		stage.setViewport(480, 800, false);
		
		
		// stage.getCamera().translate(-stage.getGutterWidth(), -stage.getGutterWidth(), 0);
		
	}

	@Override
	public void show() {

		//
		
		image = new Image(new Texture(Gdx.files.internal("data/cartoon_sidewalk2.png")));		
		image.setSize(480, 800);
		image.setPosition(0, 200);
		
		Image cartImage = new Image(new Texture(Gdx.files.internal("data/cart.png")));
		cartImage.setScale(.75f, .75f);
		cartImage.setPosition(175, 450);
		
		
		//Gdx.app.log("Image", "Stage Width:" + stage.getWidth() + " Stage Height: " + stage.getHeight());
		stage.addActor(image);
		stage.addActor(cartImage);

		stage.addActor(menu);
	//	stage.addActor(tee);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {

		stage.dispose();
		
	}


	private void spawnRandomPeople(){
		int x = 0;
		int y = MathUtils.random(250, 500);
		int rand = MathUtils.random(0, 480);

		Person person = new Person(x, y, rand);
		randomPeople.add(person);
		stage.addActor(person);
		lastPersonTime = TimeUtils.millis();
	}
	
	
}
