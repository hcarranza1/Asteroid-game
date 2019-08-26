package GameObject;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.mycompany.a3.ICollider;
import com.mycompany.a3.ISelectable;

public class Missile extends MoveableGameObject implements ISelectable{
	
	private int fuelLevel = 60;
	private int missSpeed;
	private int size = 3;
	private boolean selected;
	
	public Missile(Point2D loc, int speed, double direction, double w, double h) {
		super(w,h);
		super.setLocation(loc);
		missSpeed = speed + 4;
		super.setSpeed(missSpeed);
		super.setDirection(direction);
		super.setColor(0,128,0);
	}
	
	public int getFuelLevel() {
		return fuelLevel;
	}
	
	public void decrFuel() {
		if(fuelLevel <= 0) {
			System.out.println("Fuel has run out!!");
		}else {
				fuelLevel -= 1;
		}
	}
	
	public String toString() {
		return ("Missile: loc=" + Math.round(getPointX()) + "," + Math.round(getPointY()) +
				" color: " + "["
				+ ColorUtil.red(this.getColor()) + ","
				+ ColorUtil.green(this.getColor()) + 
				","
				+ ColorUtil.blue(this.getColor()) + "]"  + " speed=" + missSpeed +
				" dir=" + getDirection() +" fuel level="+ getFuelLevel()
				);
	
	}
	

	@Override
	public void handleCollision(ICollider obj) {
		GameObject otherObj = (GameObject)obj;
		if(obj instanceof NPCMissile) {
			NPCMissile pship = (NPCMissile)obj;
				this.Crash();
				pship.Crash();
		} else if(obj instanceof NPCShip) {
			NPCShip nonPS = (NPCShip)obj;
				this.Crash();
				nonPS.Crash();
		} else if (obj instanceof Missile){
			Missile m = (Missile)obj;
			this.Crash();
			m.Crash();
		} else if(obj instanceof Asteroid){
			this.Crash();
			otherObj.Crash();
		}
	}
	
	@Override
	public void draw(Graphics g, Point2D pCmpRelPrnt) {
		g.setColor(super.getColor());
		g.fillRect((int)(pCmpRelPrnt.getX()+this.getPointX()), (int)(pCmpRelPrnt.getY()+this.getPointY()), size, 2*size);
		if(isSelected()) { //selected
			g.setColor(ColorUtil.rgb(0, 0, 0));
            g.fillRect((int) (pCmpRelPrnt.getX()+this.getPointX()), (int) (pCmpRelPrnt.getY()+this.getPointY()), size, size);
        } else {
        	g.setColor(ColorUtil.rgb(0, 0, 0));
            g.drawRect((int) (pCmpRelPrnt.getX()+this.getPointX()), (int)  (pCmpRelPrnt.getY()+this.getPointY()), size, 2*size);
        }
	}
	@Override
	public void setSelected(boolean select) {
		this.selected = select;
	}
	
	@Override
	public boolean isSelected() {
		return selected;
}

	@Override
	public boolean contains(Point pPtrRelPrnt, Point2D pCmpRelPrnt) {
		boolean contains = false;
		int pointx = pPtrRelPrnt.getX();
		int pointy = pPtrRelPrnt.getY();
		double locationx = this.getLocation().getX() + pCmpRelPrnt.getX();
		double locationy = this.getLocation().getY() + pCmpRelPrnt.getY();
		
		if(pointx >= locationx && pointx <= locationx+7 && pointy >= locationy && pointy <= locationy+14) {
			contains = true;
		}
		
		return contains;
	}

	public void setFuelLevel(int i) {
		// TODO Auto-generated method stub
		this.fuelLevel = i;
	}


}
