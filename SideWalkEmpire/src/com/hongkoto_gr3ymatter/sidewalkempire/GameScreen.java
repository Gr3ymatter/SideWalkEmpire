package com.hongkoto_gr3ymatter.sidewalkempire;



import Models.Assets;
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
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class GameScreen implements Screen {

	Assets assets;
	Stage stage;
	
	Image image;
	TextureAtlas atlas;
	Menu menu;
	Tee tee;
	Person person;
	Person randomPerson;
	Camera camera;
	
	
	public GameScreen(Assets assets){
		this.assets = assets;
		this.stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);
		atlas = new TextureAtlas(Gdx.files.internal("data/sidewalkempire_demo.pack"));
		menu = new Menu();
		tee = new Tee();
		person = new Person(170, 500);
	}
	
	@Override
	public void render(float delta) {

		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		
		
		// Debuging Rendering
		//Gdx.app.log("Image", "Stage Width:" + stage.getWidth() + " Stage Height: " + stage.getHeight());
		//Gdx.app.log("Image", "Image Width:" + image.getWidth() + " Image Height: " + image.getHeight());
	}

	@Override
	public void resize(int width, int height) {
		this.camera = new OrthographicCamera(480, 800);
		this.camera.position.set(480/2, 800/2, 0);
		stage.setCamera(camera);
		
		stage.setViewport(480, 800, true);
		
		
		// stage.getCamera().translate(-stage.getGutterWidth(), -stage.getGutterWidth(), 0);
		
	}

	@Override
	public void show() {

		//
		
		image = new Image(new Texture(Gdx.files.internal("data/cartoon_sidewalk2.png")));		
		image.setSize(480, 800);
		image.setPosition(0, 200);
		
		
		//Gdx.app.log("Image", "Stage Width:" + stage.getWidth() + " Stage Height: " + stage.getHeight());
		stage.addActor(image);
		stage.addActor(menu);
		stage.addActor(tee);
		stage.addActor(person);
	
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


	
	
}
