package com.hongkoto_gr3ymatter.sidewalkempire;


import Models.Assets;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;


public class MenuScreen implements Screen {

	Game game;
	Stage stage;
	TextButton startGameButton;
	TextButton optionsButton;
	TextButton exitButton;
	Image background;
	Camera camera;

	
	public MenuScreen(Game game) {
			this.game = game;
		}

		@Override
		public void render(float delta) {
			// TODO Auto-generated method stub
			Gdx.gl.glClearColor(0f, 1f, 1f, 1);
			Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

			stage.act(delta);
			stage.draw();
//			Table.drawDebug(stage);
		}

		@Override
		public void resize(int width, int height) {
			// TODO Auto-generated method stub
			this.camera = new OrthographicCamera(480, 800);
			this.camera.position.set(480/2, 800/2, 0);
			stage.setCamera(camera);
			
			stage.setViewport(480, 800, false);
		}

		@Override
		public void show() {
			// TODO Auto-generated method stub
			stage = new Stage();
			Gdx.input.setInputProcessor(stage);

			Table table = new Table(Assets.skin);
			table.setRound(true);
			background = new Image(new Texture(Gdx.files.internal("data/background.png")));
			background.setColor(Color.WHITE);
			background.setSize(480, 800);
			startGameButton = new TextButton("New Game", Assets.skin);
			optionsButton = new TextButton("Options", Assets.skin);
			exitButton = new TextButton("Exit", Assets.skin);
			startGameButton.addListener(new InputListener() {

				@Override
				public boolean touchDown(InputEvent event, float x, float y,
						int pointer, int button) {
					// TODO Auto-generated method stub
					game.setScreen(new GameScreen(game));
					
					return true;
				}

			});
			
			exitButton.addListener(new InputListener(){
				@Override
				public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
					Gdx.app.exit();
					return true;
				}
				
			});

			table.setFillParent(true);
//			table.debug(); 
			table.add(startGameButton).width(400).height(50);
			table.row();
			table.add(optionsButton).width(400).height(50).padTop(10);
			table.row();
			table.add(exitButton).width(400).height(50).padTop(10);
			
			stage.addActor(background);
			stage.addActor(table);
			
		}

		@Override
		public void hide() {
			// TODO Auto-generated method stub

		}

		@Override
		public void pause() {
			// TODO Auto-generated method stub
			stage.dispose();
		}

		@Override
		public void resume() {
			// TODO Auto-generated method stub

		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
		
			game.dispose();
			Gdx.app.exit();
		}

	
	
	
}
