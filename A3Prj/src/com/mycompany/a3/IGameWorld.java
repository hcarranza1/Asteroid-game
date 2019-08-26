package com.mycompany.a3;

import com.codename1.ui.Graphics;

public interface IGameWorld {

	public int getPlayerScore();

	public boolean getSound();

	public int getLives();

	public int getMissileCount();

	public int getTime();

	public void map();

	public void setWidth(int width);

	public void setHeight(int height);
	
	public void setSound();
	
	public IIterator getGWIterator();
	public boolean getPause();
	
}
