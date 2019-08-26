package GameObject;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.mycompany.a3.ICollider;

public class NPCMissile extends MoveableGameObject {
	private int fuelLevel = 60;
	private int missSpeed;
	private int size = 1;
	
	public NPCMissile(Point2D loc, int speed, double direction, double w, double h) {
		super(w, h);
		super.setLocation(loc);
		super.setSize(size);
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
		return ("NPCMissile: loc=" + Math.round(getPointX()) + "," + Math.round(getPointY()) +
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
		if(obj instanceof PlayerShip) {
			PlayerShip pship = (PlayerShip)obj;
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

	}


}
