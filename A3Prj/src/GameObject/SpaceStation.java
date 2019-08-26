package GameObject;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.mycompany.a3.ICollider;

public class SpaceStation extends FixedObjects {

	private int blinkRate;
	private boolean visible;
	private Random rand = new Random();
	private int size = 10;
	
	public SpaceStation(int ID, double width, double height) {
		super(width, height);
		super.setID(ID);
		blinkRate = rand.nextInt(4);
		super.setRandLocation();
		super.setColor(255,0,255);
		visible = false;
		super.setSize(size);
	}
	
	public int getBlinkRate() {
		return blinkRate;
	}
	
	public void reduceBLinkCount() {
		if(blinkRate != 0) {
			--blinkRate;
		} else {
			blinkRate = rand.nextInt(4);
			chgVisible();
		}
	}
	
	public void chgVisible() {
		if(visible == true) {
			visible = false;
		} else {
			visible = true;
		}
	}
	
	public void setVisible(boolean visablity) {
		visible = visablity;
	}
	
	public boolean getVisible() {
		return visible;
	}
	
	public String toString() {
		return ("Space Station: loc=" + Math.round(getPointX()) + "," + Math.round(getPointY()) +
				" color: " + "["
				+ ColorUtil.red(this.getColor()) + ","
				+ ColorUtil.green(this.getColor()) + 
				","
				+ ColorUtil.blue(this.getColor()) + "]" 
				);
	
	}
	
	public void draw(Graphics g, Point2D pCmpRelPrnt) {
		int radius = 10;
		g.setColor(super.getColor()); /* gets the color set in constructor */
		if (visible) 
			g.drawArc((int)(pCmpRelPrnt.getX() + this.getPointX() - (size * radius)), 
					(int)(pCmpRelPrnt.getY()+this.getPointY() - (size * radius)), size * radius, size * radius, 0, 360);
		else 
			g.fillArc((int)(pCmpRelPrnt.getX() + this.getPointX() - (size * radius)), 
					(int)(pCmpRelPrnt.getY()+this.getPointY() - (size * radius)), size * radius, size * radius, 0, 360);
}

	@Override
	public void handleCollision(ICollider obj) {
		// TODO Auto-generated method stub
		
	}
	
}
