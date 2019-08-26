package GameObject;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.mycompany.a3.ICollider;
public class MissileLauncher extends MoveableGameObject implements Isteerable{
	private int missSpeed =0;
	private double Dir;

	public MissileLauncher ( double dir, Point2D loc, double w, double h) {
		super(w,h);
		super.setDirection(dir);
		super.setLocation(loc);
		super.setSpeed(missSpeed);
		super.setColor(128,128,128);

	}
	
	public void MissileLauncherSpeedIncr() {
		missSpeed += 5;
		super.setSpeed(missSpeed);
	}
	
	public void MissileLauncherSpeeddec() {
		missSpeed -= 5;
		super.setSpeed(missSpeed);
	
	}
	public Point2D missileLancherLocation () {
		return getLocation();
	}
	
	public void changeDirection(int change) {
		setDirection((getDirection() + change));
		
	}
	
	public void turnMslLeft() {
		Dir = Dir - 5.0;
		if ( Dir < 0) {
			super.setDirection(360 + Dir);
		}else {	super.setDirection(Dir);
		
		}
	}


	public void turnMsright() {;
		Dir = Dir + 5.0;
		if (  Dir > 359) {
			super.setDirection(Dir - 360);
		}else {	super.setDirection(Dir);
	// TODO Auto-generated method stub
		}
	}

	@Override
	public void turnLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnRight() {
		// TODO Auto-generated method stub
		
	}

	public double getDir() {
		// TODO Auto-generated method stub
		return getDirection();

	}
	
	public void draw(Graphics g, Point2D pCmpRelPrnt) {
		g.setColor(super.getColor());
		g.drawLine((int)(pCmpRelPrnt.getX() + this.getX()),
				(int)(pCmpRelPrnt.getY() + this.getY()),
				(int)((pCmpRelPrnt.getX() + this.getX() + 4)+missSpeed*(Math.cos(Math.toRadians(90-getDir())))),
				(int)((pCmpRelPrnt.getY() + this.getY() + 4)+missSpeed*(Math.sin(Math.toRadians(90-getDir())))));
		
}

	@Override
	public void handleCollision(ICollider obj) {
		// TODO Auto-generated method stub
		
	}


}
