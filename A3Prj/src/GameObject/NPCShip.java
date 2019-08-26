package GameObject;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.mycompany.a3.ICollider;
import com.mycompany.a3.ISelectable;



public class NPCShip extends MoveableGameObject implements ISelectable{
	private int speed = 1;
	private NPCMissile NPCmissileObj;
	private int size;
	private int NPCmissile = 2;
	private  NPCMissileLauncher NPCmissileLaun; 
	private Random rand = new Random();
	private boolean selected;
	
	public NPCShip(double width, double height) {
		super(width,height);
		int randomSize = rand.nextInt(1);
		selected = false;
		super.setSpeed(speed);
		super.setRandLocation();
		super.setColor(255,255,255);
		super.setRandomDir();
		super.setWidth(width);
		super.setHeight(height);
		if (randomSize == 0) {
			size = 10;
		} else {
			size = 20;
		}
		 NPCmissileLaun = new NPCMissileLauncher( this.getDirection(), super.getLocation(), width, height);
		
	}
	
	public NPCMissile fireMissile() {
		--NPCmissile;
		System.out.println("NPCMissile fired");
		return NPCmissileObj = new NPCMissile(this.getLocation(), this.getSpeed(), NPCmissileLaun.getDirection(),super.getWidth(),super.getHeight());
		
	}
	
	public int getMissile() {
		return NPCmissile;
	}
	public String toString() {
		return ("NPCShip: loc=" + Math.round(getPointX()) + "," + Math.round(getPointY()) +
				" color: " + "["
				+ ColorUtil.red(this.getColor()) + ","
				+ ColorUtil.green(this.getColor()) + 
				","
				+ ColorUtil.blue(this.getColor()) + "]" + " speed=" + speed +
				" dir=" + this.getDirection()  + " size=" + size +" Missile count="+ this.getMissile()
				);
	
	}
	@Override
	public void handleCollision(ICollider obj) {
		GameObject otherObj = (GameObject)obj;
		if(obj instanceof Asteroid) {
			this.Crash();
			otherObj.Crash();
		} else if(obj instanceof PlayerShip) {
			this.Crash();
			otherObj.Crash();
		}else if(obj instanceof Missile){
			Missile tempM = (Missile)obj;
				this.Crash();
				tempM.Crash();

		} else if(obj instanceof NPCShip){
			this.Crash();
			otherObj.Crash();
			
		} 
		
}
	
	@Override
	public void draw(Graphics g, Point2D pCmpRelPrnt) {
		// TODO Auto-generated method stub
		g.setColor(super.getColor());
		g.fillTriangle((int)(pCmpRelPrnt.getX()+this.getPointX()+0), (int)(pCmpRelPrnt.getY()+this.getPointY()+size),
				(int)(pCmpRelPrnt.getX()+this.getPointX()-size), (int)(pCmpRelPrnt.getY()+this.getPointY()-size),
				(int)(pCmpRelPrnt.getX()+this.getPointX()+size), (int)(pCmpRelPrnt.getY()+this.getPointY()-size));
		NPCmissileLaun.draw(g, pCmpRelPrnt);
		if(isSelected()) { //selected
			g.setColor(ColorUtil.rgb(0, 0, 0));
			g.fillTriangle((int)(pCmpRelPrnt.getX()+this.getPointX()+0), (int)(pCmpRelPrnt.getY()+this.getPointY()+size),
					(int)(pCmpRelPrnt.getX()+this.getPointX()-size), (int)(pCmpRelPrnt.getY()+this.getPointY()-size),
					(int)(pCmpRelPrnt.getX()+this.getPointX()+size), (int)(pCmpRelPrnt.getY()+this.getPointY()-size));
			NPCmissileLaun.draw(g, pCmpRelPrnt);
		}
		
	}

	@Override
	public void setSelected(boolean select) {
		// TODO Auto-generated method stub
		this.selected = select;
		
	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return selected;
	}

	@Override
	public boolean contains(Point pPtrRelPrnt, Point2D pCmpRelPrnt) {
		// TODO Auto-generated method stub
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
	
}
