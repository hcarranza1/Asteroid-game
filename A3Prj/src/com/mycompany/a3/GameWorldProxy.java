package com.mycompany.a3;

import java.util.Observable;

import com.codename1.ui.Graphics;

public class GameWorldProxy extends Observable implements IGameWorld {

	private GameWorld realgw;

	public GameWorldProxy(GameWorld gw) {
		this.realgw = gw;
	}

	@Override
	public int getPlayerScore() {
		// TODO Auto-generated method stub
		return realgw.getPlayerScore();
	}

	@Override
	public boolean getSound() {
		// TODO Auto-generated method stub
		return realgw.getSound();
	}

	@Override
	public int getLives() {
		// TODO Auto-generated method stub
		return realgw.getLives();
	}

	@Override
	public int getMissileCount() {
		// TODO Auto-generated method stub
		return realgw.playerMissileCount();
	}

	@Override
	public int getTime() {
		// TODO Auto-generated method stub
		return realgw.getGameTime();
	}

	@Override
	public void setWidth(int width) {
		realgw.setWidth(width);
		// TODO Auto-generated method stub

	}

	@Override
	public void setHeight(int height) {
		realgw.setHeight(height);
		// TODO Auto-generated method stub

	}

	@Override
	public void map() {
		realgw.map();
		// TODO Auto-generated method stub

	}

	@Override
	public void setSound() {
		realgw.setSound();
		// TODO Auto-generated method stub
		
	}
	@Override
	public IIterator getGWIterator() 
	{
		return realgw.getGWIterator();	
	}

	@Override
	public boolean getPause() {
		// TODO Auto-generated method stub
		return realgw.getPause();
	}



}
