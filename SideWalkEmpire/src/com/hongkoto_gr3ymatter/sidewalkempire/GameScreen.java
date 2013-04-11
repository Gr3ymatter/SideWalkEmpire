package com.hongkoto_gr3ymatter.sidewalkempire;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import Models.Businessman;
import Models.Customer;
import Models.Hippie;
import Models.Hipster;
import Models.Laborer;
import Models.Menu;
import Models.Person;
import Models.Store;
import Models.Student;
import Models.Teacher;
import Models.Tee;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
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
	static ArrayList<Customer> custList;
	long beginTime;
	
	Store store;
	
	public GameScreen(Game game){
		this.stage = new Stage();
		this.game = game;		
		store = new Store();
		Gdx.input.setInputProcessor(stage);
		atlas = new TextureAtlas(Gdx.files.internal("data/sidewalkempire_demo.pack"));
		menu = new Menu(store);
		tee = new Tee();
		custList = new ArrayList<Customer>();
		randomPeople = new Array<Person>();
		beginTime = TimeUtils.millis();
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);

		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		
		stage.draw();
		
		if(TimeUtils.millis() - lastPersonTime > 5000)
				spawnRandomPeople();

		for(int i = 0; i< randomPeople.size; i++){
			if(randomPeople.get(i).getPositionX() >= 480 && !randomPeople.get(i).isRight()){
				randomPeople.get(i).remove();
				randomPeople.removeIndex(i);
		}else if(randomPeople.get(i).getPositionX()<= 0 && randomPeople.get(i).isRight()){
			randomPeople.get(i).remove();
			randomPeople.removeIndex(i);
			}
		}
		if(TimeUtils.millis() - beginTime > 3000){
			Gdx.app.log("DEBUG", " BING! ");
			makeCustomer(store);
			beginTime = TimeUtils.millis();
		}
		
		//Gdx.app.log("Debug", "" + randomPeople.size);	
		
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

		image = new Image(new Texture(Gdx.files.internal("data/background.png")));
		image.setColor(Color.WHITE);
		image.setSize(480, 600);
		image.setPosition(0, 170);
		
		Image cartImage = new Image(new Texture(Gdx.files.internal("data/cart.png")));
		cartImage.setScale(.65f, .65f);
		cartImage.setPosition(175, 300);
		
		//Gdx.app.log("Image", "Stage Width:" + stage.getWidth() + " Stage Height: " + stage.getHeight());
		stage.addActor(image);
		stage.addActor(cartImage);

		stage.addActor(menu);
	//	stage.addActor(tee);
	//	spawnRandomPeople();

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
	
		int x = -10;
		int y = MathUtils.random(200, 299);
		int z = 1;
		int rand = MathUtils.random(0,1);
		
		for(int i = 0; i<randomPeople.size; i++)
		{
			if(randomPeople.get(i).getY() > y)
				randomPeople.get(i).toBack();
		}
		Person person = new Person(x, y, rand);
		
		randomPeople.add(person);
		
		stage.addActor(person);
		lastPersonTime = TimeUtils.millis();
	}
	
	
	
	public void makeCustomer(Store store){
		Random randmaker = new Random();
		String custType = store.getStageConstraints().get("Customers").get(randmaker.nextInt(store.getStageConstraints().get("Customers").size()));
		
		
		if(custType.equals("Hippie")){
			Hippie hippie = new Hippie();
			custList.add(hippie);
			stage.addActor(hippie);
			
		}else if(custType.equals("Laborer")){
			Laborer laborer = new Laborer();
			custList.add(laborer);
			stage.addActor(laborer);
		}else if(custType.equals("Student")){
			Student student = new Student();
			custList.add(student);
			stage.addActor(student);
		}else if(custType.equals("Businessman")){
			Businessman businessman = new Businessman(); 
			custList.add(businessman);
			stage.addActor(businessman);
		}else if(custType.equals("Teacher")){
			Teacher teacher = new Teacher();
			custList.add(teacher);
			stage.addActor(teacher);
		}else if(custType.equals("Hipster")){
			Hipster hipster = new Hipster();
			custList.add(hipster);
			stage.addActor(hipster);
		}
		
		
		
		
		
		/*switch(custType){
			case "Hippie": {
				custList.add(new Hippie());
				break;
				}
			case "Laborer": {
				custList.add(new Laborer());
				break;
				}
			case "Student": {
				custList.add(new Student());
				break;
				}
			case "Businessman": {
				custList.add(new Businessman());
				break;
				}
			case "Teacher": {
				custList.add(new Teacher());
				break;
				}
			case "Hipster": {
				custList.add(new Hipster());
				break;
				}
			*/
			
		}

	
}
