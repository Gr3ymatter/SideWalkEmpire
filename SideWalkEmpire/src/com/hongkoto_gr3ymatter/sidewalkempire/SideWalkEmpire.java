package com.hongkoto_gr3ymatter.sidewalkempire;

import Models.Assets;

import com.badlogic.gdx.Game;


public class SideWalkEmpire extends Game {

	
	@Override
	public void create() {
		Assets.load();
		setScreen(new GameScreen(this));
		
	}

	
	

	
}
