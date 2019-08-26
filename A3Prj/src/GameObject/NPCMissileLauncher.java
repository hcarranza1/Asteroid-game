package GameObject;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.mycompany.a3.ICollider;
public class NPCMissileLauncher extends MoveableGameObject {
	private int NpcSpeed = 1;
	private Point pCmpRelPrnt;
	
	public NPCMissileLauncher ( double dir, Point2D loc, double w, double h) {
		super(w,h);
		super.setDirection(dir);
		super.setLocation(loc);
		super.setColor(128,128,128);
		super.setSpeed(NpcSpeed);

	}
	
	
	public Point2D missileLancherLocation () {
		return getLocation();
	}


	@Override
	public void draw(Graphics g, Point2D pCmpRelPrnt) {
		// TODO Auto-generated method stub
		g.setColor(super.getColor());
		g.drawLine((int)(pCmpRelPrnt.getX() + this.getPointX()),
				(int)(pCmpRelPrnt.getY()+this.getPointY()),
				(int)((pCmpRelPrnt.getX() + this.getPointX())+super.getSpeed()*(Math.cos(Math.toRadians(90-this.getDirection())))),
				(int)((pCmpRelPrnt.getY() + this.getPointY())+super.getSpeed()*(Math.sin(Math.toRadians(90-this.getDirection())))));
		
	}


	@Override
	public void handleCollision(ICollider obj) {
		// TODO Auto-generated method stub
		
	}
	
	
}
