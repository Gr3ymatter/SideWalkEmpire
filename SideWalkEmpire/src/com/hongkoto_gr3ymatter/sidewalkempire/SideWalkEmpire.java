package com.hongkoto_gr3ymatter.sidewalkempire;

import Models.Assets;

import com.badlogic.gdx.Game;


public class SideWalkEmpire extends Game {

	public Assets assets;
	
	@Override
	public void create() {
		this.assets = new Assets();
		assets.load();
		setScreen(new GameScreen(assets));
		
	}

	public Assets getAssets() {
		return assets;
	}

	public void setAssets(Assets assets) {
		this.assets = assets;
	}
	
	

	
}
