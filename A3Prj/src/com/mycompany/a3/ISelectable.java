package com.mycompany.a3;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

public interface ISelectable {
	public void setSelected(boolean select);
	
	public boolean isSelected();
	
	public boolean contains(Point pPtrRelPrnt, Point2D pCmpRelPrnt);
	
	public void draw(Graphics g, Point2D pCmpRelPrnt);

}
