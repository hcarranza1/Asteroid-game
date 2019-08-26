package GameObject;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.mycompany.a3.ICollider;
import com.mycompany.a3.IDrawable;


public abstract class GameObject implements IDrawable,ICollider{
	
	private Point2D location;	
	private int color;
	protected Random rand = new Random();
	private double direction;
	private double width;
	private double height;
	private int size;
	private boolean crash;
	
	public GameObject (double w, double h) {
		this.width = w;
		this.height = h;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getSize() {
		return size;
	}
	public void setLocation(Point2D newLocation) {
		Point2D loc = new Point2D(newLocation.getX(), newLocation.getY());
		this.location = loc;
	}
	
	public void setRandLocation() {
		Point2D point = new Point2D(0,0);
		point.setX((int) (rand.nextFloat()*this.getWidth()-(size/2)));
		point.setY((int) (rand.nextFloat()*this.getHeight()-(size/2)));
		this.location = point;
	}
	public Point2D getLocation() {
		return location;
	}
	public double getPointY(){
		Point2D yVar= getLocation(); 
		return yVar.getY();
	}
	public double getPointX(){
		Point2D xVar= getLocation(); 
		return xVar.getX();
	}
	public int getColor() {
		return color;
	}
	public void setColor(int r, int g, int b) {
		this.color = ColorUtil.rgb(r, g, b);
		
	}
	
	public double getX() {
		return location.getX();
	}

	public double getY() {
		return location.getY();
	}
	
	public double getDirection() {
		return direction;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}
	
	public void setWidth(double width) {
		this.width = width;

	}
	public void setHeight(double height) {
	
		this.height = height;
	}
	public double getWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}

	public double getHeight() {
		// TODO Auto-generated method stub
		return this.height;
	}

	public void setX(double x) {
		if (x >= 0 && x <= this.getWidth()) {
		location.setX( x);
	} else {
		System.out.println("Out of bounds");
}
		
		// TODO Auto-generated method stub
		
	}

	public void setY(double y) {
		if (y >= 0 && y <= this.getHeight()) {
			location.setY( y);
		} else {
			System.out.println("Out of bounds");
	}
	
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public boolean collisionWith(ICollider obj) {
		
		GameObject otherObject = (GameObject)obj;
		
		boolean collide = false;
		int objCenterX = (int)this.getX() + (this.getSize()/ 2); // find centers
		int objCenterY = (int)this.getY() + (this.getSize()/ 2);
		int otherObjCenterX = (int)otherObject.getX() + (this.getSize()/ 2);
		int otherObjCenterY = (int)otherObject.getY() + (this.getSize()/ 2);
		// find the distance between obj centers
		int deltax = objCenterX - otherObjCenterX;
		int deltay = objCenterY - otherObjCenterY;
		int deltaCenter = (deltax * deltax + deltay * deltay);
		// find the square of sum of radii
		int objRadius = this.getSize()/ 2;
		int otherObjRadius = otherObject.getSize()/ 2;
		int radiusSquare = (objRadius * objRadius + 2 * objRadius*otherObjRadius + otherObjRadius * otherObjRadius);
		if (deltaCenter <= radiusSquare) {
			collide = true;
		}
		return collide;
		}
	public boolean getCrash() {
		return this.crash;
	}
	public void Crash() {
		this.crash = true;
	}
	
}
