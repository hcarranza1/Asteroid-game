package GameObject;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.mycompany.a3.ICollider;

public class PlayerShip extends MoveableGameObject implements Isteerable{
	private MissileLauncher shipLauncher;
	private int PSspeed = 0;
	private int numOfMissiles = 2;
	private Missile missile;
	private int Dir = 0;
	private Point2D initPostion;
	private int size = 9;

	
	public PlayerShip(double width, double height) {
		super(width,height);
		initPostion = new Point2D(width/2 ,height/2);
		super.setLocation(initPostion);
		super.setSpeed(PSspeed);
		super.setDirection(Dir);
		super.setColor(0,0,255);
		shipLauncher = new MissileLauncher( Dir,super.getLocation(), width, height);
	}
	
	public int getNumOfmissiles() {
		return numOfMissiles;
	}
	
	public void relodeMissiles() {
		if( numOfMissiles == 2) {
			System.out.println("Your missile ammo is full.");
		} else {
			numOfMissiles = 2;
			System.out.println("Your missile ammo has been reloaded.");
		}
	}
	
	public void reduceNumOfMissiles() {
		if (numOfMissiles <= 0) {
			System.out.println("Emty! reload missiles.");
		} else {
			--numOfMissiles;
		}
	}
	
	public Missile fireMissile() {
		--numOfMissiles;
		System.out.println("Missile fired");
		return missile = new Missile(this.getLocation(), this.getSpeed(), this.shipLauncher.getDir(),super.getWidth(),super.getHeight());
	}
	
	public void playerShipSpeedIncr() {
	
		if( PSspeed + 5 <= 40) {
		PSspeed += 5;
		shipLauncher.MissileLauncherSpeedIncr();
		super.setSpeed(PSspeed);
		System.out.println("Player ship's speed has increased.");
		} else {
			PSspeed = 40;
			super.setSpeed(PSspeed);
			System.out.println("The player ship has reached the max speed. ");
		}
	}

	public void playerShipSpeeddec() {
		
		if( PSspeed - 5 <= 0 ) {
			PSspeed = 0;
			super.setSpeed(PSspeed);
			System.out.println("The player ship speed is 0. ");
		}else {
			PSspeed -= 5;
			System.out.println("Player ship's speed has decreased.");
			shipLauncher.MissileLauncherSpeeddec();
			super.setSpeed(PSspeed);
		}
	}
	
	public void playerShipHyperSpa() {
		super.setLocation(initPostion);
		
	}
	
	public void turnLauncherLeft() {
		shipLauncher.turnMslLeft();
	}
	
	public void turnLauncherRight() {
		shipLauncher.turnMsright();
	}
	
	public String toString() {
		return ("PlayerShip: loc=" + Math.round(getPointX()) + "," + Math.round(getPointY()) +
				" color: " + "["
				+ ColorUtil.red(this.getColor()) + ","
				+ ColorUtil.green(this.getColor()) + 
				","
				+ ColorUtil.blue(this.getColor()) + "]" + " speed=" + Math.round(getSpeed()) +
				" dir=" + getDirection() + " Missile count=" + numOfMissiles + " Missile launcher dir " +
				this.shipLauncher.getDirection()
				);
	
	}


	@Override
	public void turnLeft() {
		Dir -=5;
		if ( Dir < 0) {
			super.setDirection(360 + Dir);
		}else {	super.setDirection(Dir);
		
		}
		// TODO Auto-generated method stub
		
	}


	@Override
	public void turnRight() {
		Dir += 5;
		if (  Dir > 359) {
			super.setDirection(Dir - 360);
		}else {	super.setDirection(Dir);
	// TODO Auto-generated method stub
		}
	}
	
	@Override
	public void handleCollision(ICollider obj) {
		GameObject otherObj = (GameObject)obj;
		if(obj instanceof Asteroid) {
			this.Crash();
			otherObj.Crash();
		} else if(obj instanceof NPCMissile){
				this.Crash();
				otherObj.Crash();
		} else if(obj instanceof NPCShip){
			this.Crash();
			otherObj.Crash();
		} 
		
}
	
	
	@Override
	public void draw(Graphics g, Point2D pCmpRelPrnt) {
		// TODO Auto-generated method stub
		g.setColor(super.getColor());
		g.drawLine((int)(pCmpRelPrnt.getX() + this.getPointX()), 
				(int)(pCmpRelPrnt.getY()+ this.getPointY() + size),
				(int)(pCmpRelPrnt.getX() - size + this.getPointX()),
				(int)(pCmpRelPrnt.getY() - size + this.getPointY())); 
		
		g.drawLine ((int)(pCmpRelPrnt.getX() - size + this.getPointX()),
				(int)(pCmpRelPrnt.getY() - size + this.getPointY()),
				(int)(pCmpRelPrnt.getX() + size + this.getPointX()),
				(int)(pCmpRelPrnt.getY() - size + this.getPointY()));
		
		g.drawLine ((int)(pCmpRelPrnt.getX() + size + this.getPointX()),
				(int)(pCmpRelPrnt.getY() - size + this.getPointY()),
				(int)(pCmpRelPrnt.getX()  + this.getPointX()),
				(int)(pCmpRelPrnt.getY() + size + this.getPointY()));
		shipLauncher.draw(g, pCmpRelPrnt);
	}

}

