package GameObject;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

public interface IMoveable {
	public void move();

	void draw(Graphics g, Point2D pCmpRelPrnt);
	
}
