package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

import GameObject.Asteroid;
import GameObject.GameObject;
import GameObject.Missile;

import com.mycompany.a3.IGameWorld;
import com.mycompany.a3.IIterator;

public class MapView extends Container implements Observer {
	private IGameWorld igw;
	
	public MapView() {
	}


	@Override
	public void paint(Graphics g) {
		super.paint(g);
		IIterator theElements = igw.getGWIterator();
		while(theElements.hasNext()) {
			GameObject gameObj = (GameObject) theElements.getNext();
			if(gameObj instanceof IDrawable) {
				gameObj.draw(g, new Point2D(this.getX(), this.getY()));
			}
		}
	}
	public void pointerPressed(int x, int y) {
			x = x - getParent().getAbsoluteX();
			y = y - getParent().getAbsoluteY();
			Point pPtrRelPrnt = new Point(x, y);
			Point2D pCmpRelPrnt = new Point2D(getX(), getY());
		
			 if(igw.getPause()==true){
				 System.out.println("we are in pause mode and pointerPressed works.");
				 IIterator itr =  igw.getGWIterator();
				 while(itr.hasNext()) {
					 
					 GameObject obj = (GameObject) itr.getNext();
					 			    
					 if (obj instanceof Asteroid){
						 	if (((Asteroid) obj).contains(pPtrRelPrnt, pCmpRelPrnt)){
						 		    ((Asteroid) obj).setSelected(true);
						 		 
						 		  
						 	}else{
						 			((Asteroid) obj).setSelected(false);
						 			
						 	}
					 }	 	
					 if (obj instanceof Missile){ 	
					        if (((Missile) obj).contains(pPtrRelPrnt, pCmpRelPrnt)){
					 				((Missile) obj).setSelected(true);
					 	    }else{
					 				((Missile) obj).setSelected(false);
					        }
					 }      
					 repaint(); 
			    }//end while 
			  }else{System.out.println("pointerPressed but does not have any action. Actions are in pause mode.");}
				 
	
}
	
	public void update(Observable o, Object arg) {
		igw = (IGameWorld) arg;
		igw.setWidth(this.getWidth());
		igw.setHeight(this.getHeight());
		igw.map();
		this.repaint();

	
	}
	
}
