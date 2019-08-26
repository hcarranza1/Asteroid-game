/**
 * 
 */
package GameObject;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

/**
 * @author Horacio
 *
 */
public abstract class FixedObjects extends GameObject{

	private int ID;
	
	
	public FixedObjects(double w, double h) {
		super(w, h);
		// TODO Auto-generated constructor stub
	}

	
	
	public int getID() {
		return ID;
	}



	public void setID(int iD) {
		ID = iD;
	}



	public String toString() {
		return ("ID= " + ID
				);
	
	}

	@Override
	public void draw(Graphics g, Point2D pCmpRelPrnt) {
		// TODO Auto-generated method stub
		
	}
	
	
}
