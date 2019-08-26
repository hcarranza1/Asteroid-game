package GameObject;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.mycompany.a3.ICollider;
import com.mycompany.a3.ISelectable;

public class Asteroid extends MoveableGameObject implements ISelectable{
	private boolean selected;
	
	public Asteroid(double width, double height) {
		super(width,height);
		super.setColor(0,0,0);
		super.setSpeed(1);
		super.setRandomDir();
		super.setRandLocation();
		super.setSize(this.size());
		selected = false;
	}
	
	public int size() {
		final int MIN_SIZE = 6;
		final int MAX_SIZE = 30;
		return rand.nextInt(MAX_SIZE - MIN_SIZE + 1) + MIN_SIZE; 
	}
	
	public String toString() {
		return ("Asteroid: loc=" + Math.round(getPointX()) + "," + Math.round(getPointY()) +
				" color: " + "["
				+ ColorUtil.red(this.getColor()) + ","
				+ ColorUtil.green(this.getColor()) + 
				","
				+ ColorUtil.blue(this.getColor()) + "]"  + " speed=" + Math.round(getSpeed()) +
				" dir=" + getDirection() + " size=" + getSize()
				);
	}
	

	@Override
	public void handleCollision(ICollider obj) {
		GameObject otherObj = (GameObject)obj;
		if(obj instanceof Asteroid) {
			this.Crash();
			otherObj.Crash();
		} else if(obj instanceof Missile){
			this.Crash();
			otherObj.Crash();		
		} else if(obj instanceof NPCShip) {
			this.Crash();
			otherObj.Crash();
		} else if(obj instanceof PlayerShip){
			this.Crash();
			otherObj.Crash();
		} else {/* do nothing */}
	}
	
	@Override
	public void draw(Graphics g, Point2D pCmpRelPrnt) {
		
		
		if(isSelected()) { //selected
			g.setColor(ColorUtil.rgb(100, 100, 0));
			g.fillArc((int)(pCmpRelPrnt.getX() + this.getX() - (2 * getSize())), 
					(int)(pCmpRelPrnt.getY()+this.getY() - (2 * getSize())), 2 * getSize(), 2 * getSize(), 0, 360);
        } else {
        	g.setColor(ColorUtil.rgb(0, 0, 0));
        	g.fillArc((int)(pCmpRelPrnt.getX() + this.getX() - (2 * getSize())), 
    				(int)(pCmpRelPrnt.getY()+this.getY() - (2 * getSize())), 2 * getSize(), 2 * getSize(), 0, 360);
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

        int iShapeX=(int)this.getPointX(); 
    	int iShapeY=(int)this.getPointY(); 
		int px = pPtrRelPrnt.getX(); // pointer location relative to
		int py = pPtrRelPrnt.getY(); // parents origin
		double xLoc = (pCmpRelPrnt.getX());// shape location relative
		double yLoc = (pCmpRelPrnt.getY());// to parents origin

		if ( (px >= xLoc) && (px <= xLoc+getWidth()) && (py >= yLoc) && (py <= yLoc+getHeight()) ) {
				return true; 
		}else return false;
		
		
	
		}


}
