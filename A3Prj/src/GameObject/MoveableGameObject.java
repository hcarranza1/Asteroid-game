package GameObject;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

public abstract class MoveableGameObject extends GameObject implements IMoveable {

	private int Speed;
	private double Direction;
	
	public MoveableGameObject(double width, double height) {
		// TODO Auto-generated constructor stub
		super(width,height);
	}

	public int getSpeed() {
		return Speed;
	}

	public void setSpeed(int speed) {
		Speed = speed;
	}

	public double getDirection() {
		return Direction;
	}

	public void setDirection(double direction) {
		this.Direction = direction;
	}
	
	public void setRandomDir() {
		this.Direction = rand.nextInt(359)+1;
	}

	public void move() {
		double x,y,newX,newY;
		double deltaX = 0;
		double deltaY = 0;
		Point2D newPoint;
		double thaeta = Math.toRadians(90 - this.getDirection());
		
		if(getSpeed() != 0) {
		 deltaX = Math.cos((thaeta) * getSpeed());
		 deltaY = Math.sin((thaeta) * getSpeed());
		}
		
		newX = super.getPointX() + deltaX;
		newY = super.getPointY() + deltaY;
		
		
		if (newX < 0 ){
			this.setDirection(90-rand.nextInt(180));
			newX = 1;}
		else if(newX > super.getWidth()){
			this.setDirection(90+rand.nextInt(180));
			newX =super.getWidth()-1;}
		else if(newY < 0){
			this.setDirection(180+rand.nextInt(180));
			newY = 1;}
		else if(newY > super.getHeight()){
			this.setDirection(rand.nextInt(180));
			newY =super.getHeight()-1;}
		
		newPoint= new Point2D(newX,newY);
		super.setLocation(newPoint);
		
	}

}
