package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

public class PointView extends Container implements Observer {
	private GameWorld gw;

	private Label points;
	private Label missileCount;
	private Label elapsedTime;
	private Label sound;
	private Label lives;

	public PointView(GameWorld gw) {
		this.gw = gw;

		Container pvContainer = new Container();
		pvContainer.setLayout(new BoxLayout(BoxLayout.X_AXIS));
		pvContainer.getAllStyles().setBgTransparency(100);
		pvContainer.getAllStyles().setBgColor(ColorUtil.BLUE);

		Label lpoints = new Label("Points: ");
		lpoints.getAllStyles().setBgTransparency(100);
		lpoints.getAllStyles().setBgColor(ColorUtil.BLUE);
		lpoints.getAllStyles().setFgColor(ColorUtil.WHITE);
		lpoints.getAllStyles().setPadding(LEFT, 1);
		lpoints.getAllStyles().setPadding(RIGHT, 1);

		points = new Label("___");
		points.getAllStyles().setBgTransparency(100);
		points.getAllStyles().setBgColor(ColorUtil.BLUE);
		points.getAllStyles().setFgColor(ColorUtil.WHITE);
		points.getAllStyles().setPadding(LEFT, 1);
		points.getAllStyles().setPadding(RIGHT, 1);

		Label lmissileCount = new Label("Missile Count: ");
		lmissileCount.getAllStyles().setBgTransparency(100);
		lmissileCount.getAllStyles().setBgColor(ColorUtil.BLUE);
		lmissileCount.getAllStyles().setFgColor(ColorUtil.WHITE);
		lmissileCount.getAllStyles().setPadding(LEFT, 1);
		lmissileCount.getAllStyles().setPadding(RIGHT, 1);

		missileCount = new Label("___");
		missileCount.getAllStyles().setBgTransparency(100);
		missileCount.getAllStyles().setBgColor(ColorUtil.BLUE);
		missileCount.getAllStyles().setFgColor(ColorUtil.WHITE);
		missileCount.getAllStyles().setPadding(LEFT, 1);
		missileCount.getAllStyles().setPadding(RIGHT, 1);

		Label lelapsedTime = new Label("Elapsed Time: ");
		lelapsedTime.getAllStyles().setBgTransparency(100);
		lelapsedTime.getAllStyles().setBgColor(ColorUtil.BLUE);
		lelapsedTime.getAllStyles().setFgColor(ColorUtil.WHITE);
		lelapsedTime.getAllStyles().setPadding(LEFT, 1);
		lelapsedTime.getAllStyles().setPadding(RIGHT, 1);

		elapsedTime = new Label("___");
		elapsedTime.getAllStyles().setBgTransparency(100);
		elapsedTime.getAllStyles().setBgColor(ColorUtil.BLUE);
		elapsedTime.getAllStyles().setFgColor(ColorUtil.WHITE);
		elapsedTime.getAllStyles().setPadding(LEFT, 1);
		elapsedTime.getAllStyles().setPadding(RIGHT, 1);

		Label lsound = new Label("Sound: ");
		lsound.getAllStyles().setBgTransparency(100);
		lsound.getAllStyles().setBgColor(ColorUtil.BLUE);
		lsound.getAllStyles().setFgColor(ColorUtil.WHITE);
		lsound.getAllStyles().setPadding(LEFT, 1);
		lsound.getAllStyles().setPadding(RIGHT, 1);

		sound = new Label("____");
		sound.getAllStyles().setBgTransparency(100);
		sound.getAllStyles().setBgColor(ColorUtil.BLUE);
		sound.getAllStyles().setFgColor(ColorUtil.WHITE);
		sound.getAllStyles().setPadding(LEFT, 1);
		sound.getAllStyles().setPadding(RIGHT, 1);

		Label llives = new Label("Lives: ");
		llives.getAllStyles().setBgTransparency(100);
		llives.getAllStyles().setBgColor(ColorUtil.BLUE);
		llives.getAllStyles().setFgColor(ColorUtil.WHITE);
		llives.getAllStyles().setPadding(LEFT, 1);
		llives.getAllStyles().setPadding(RIGHT, 1);

		lives = new Label("___");
		lives.getAllStyles().setBgTransparency(100);
		lives.getAllStyles().setBgColor(ColorUtil.BLUE);
		lives.getAllStyles().setFgColor(ColorUtil.WHITE);
		lives.getAllStyles().setPadding(LEFT, 1);
		lives.getAllStyles().setPadding(RIGHT, 1);

		pvContainer.add(lpoints);
		pvContainer.add(points);
		pvContainer.add(lmissileCount);
		pvContainer.add(missileCount);
		pvContainer.add(lelapsedTime);
		pvContainer.add(elapsedTime);
		pvContainer.add(lsound);
		pvContainer.add(sound);
		pvContainer.add(llives);
		pvContainer.add(lives);
		this.add(pvContainer);
		// TODO Auto-generated constructor stub
	}

	public void update(Observable o, Object arg) {
		// code here to update labels from data in the Observable (a GameWorldPROXY)
		// casting arg as a GameWorld (proxy = arg)
		IGameWorld gw = (IGameWorld) o;

		/* Getting Player Score */
		int score = gw.getPlayerScore();
		points.setText("" + score+ "");

		/* Getting and displaying missile count */
		int mCount = gw.getMissileCount();
		missileCount.setText("" + mCount + "");

		/* Getting and displaying elapsed time/clock ticks */
		int ticks = gw.getTime();
		elapsedTime.setText("" + ticks + "");

		/* Getting and Displaying sound */
		boolean sound = gw.getSound();

		if (sound = true) {
			this.sound.setText("ON");
		} else
			this.sound.setText("OFF");

		/* Getting and Displaying lives */
		int lives = gw.getLives();
		this.lives.setText("" + lives + "");
		this.getParent().revalidate();

		/* update */
		this.repaint();
	}
}
