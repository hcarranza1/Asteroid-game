package com.mycompany.a3;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;
import java.util.Vector;

import com.codename1.ui.Command;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

import GameObject.Asteroid;
import GameObject.GameObject;
import GameObject.IMoveable;
import GameObject.Missile;
import GameObject.NPCMissile;
import GameObject.NPCShip;
import GameObject.PlayerShip;
import GameObject.SpaceStation;

public class GameWorld extends Observable implements IGameWorld {
	Random random = new Random();
	private Vector gameObjects = new Vector();
	private Collection go;
	private int lives;
	private int score;
	private int gameTime;
	private int ID = random.nextInt();
	private boolean soundOn;
	private boolean pause = false;
	private int height;
	private int width;
	private Sound fireSound;
	private Sound mLaunchSound;
	private Sound missHitAstSound;
	private Sound gameOver;
	private static final BGSound bgSound = new BGSound("Woodwork.mp3");

	public void init(int h, int w) {
		this.score = 0;
		this.lives = 3;
		this.height = h;
		this.width = w;
		setGameTime(0);
		this.soundOn = false;
		this.go = new Collection();
		this.addNewAsteroid();
		fireSound = new Sound("missile.wav");
		mLaunchSound = new Sound("Metal Slide 02.wav");
		missHitAstSound = new Sound("exp12.wav");
		gameOver = new Sound("smw_gameover.wav");
		bgSound.play();
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public boolean getPause() {
		return this.pause;
	}
	public void addNewAsteroid() {
		Asteroid asteroid = new Asteroid(width, height);

		go.add(asteroid);

		System.out.println("A new ASTEROID has been created.");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public void addNewNPCShip() {
		NPCShip npcShip = new NPCShip(width, height);

		go.add(npcShip);

		System.out.println("A new NPCShip has been created.");

		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public void addNewPlayerShip() {
		if (!playerInStore()) {
			PlayerShip playerShip = new PlayerShip(width, height);

			go.add(playerShip);

			System.out.println("A new PlayerShip has been created.");
		} else {
			System.out.println("A there is already a PlayerShip in game.");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public void addNewSpaceStation() {
		SpaceStation spaceStation = new SpaceStation(ID, width, height);

		go.add(spaceStation);

		System.out.println("A new space Station has been created.");

		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public void increaseSpeed() {
		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof PlayerShip) {
				((PlayerShip) GameObject).playerShipSpeedIncr();
			}
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public void decreaseSpeed() {
		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof PlayerShip) {
				((PlayerShip) GameObject).playerShipSpeeddec();
				;
			}
		}
	
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public void psTurnLeft() {
		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof PlayerShip) {
				((PlayerShip) GameObject).turnLeft();
				System.out.println("Player ship's has slightly left.");

			}
		}
		
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public void psTurnRight() {
		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof PlayerShip) {
				((PlayerShip) GameObject).turnRight();
				System.out.println("Player ship's has slightly left.");

			}
		}
		
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public void psFired() {
		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof PlayerShip) {
				if (((PlayerShip) GameObject).getNumOfmissiles() <= 0) {
					System.out.println("Emty! reload missiles.");
				} else {
					go.add(((PlayerShip) GameObject).fireMissile());
					fireSound.play();
				}
			}
		}
		
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public void turnPsLaunchL() {
		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof PlayerShip) {
				((PlayerShip) GameObject).turnLauncherLeft();
				System.out.println("Player ship's Missile launcher has slightly turned left.");
				mLaunchSound.play();
			}
		}
		
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public void turnPsLaunchR() {
		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof PlayerShip) {
				((PlayerShip) GameObject).turnLauncherRight();
				System.out.println("Player ship's Missile launcher has slightly turned right.");
				mLaunchSound.play();
			}
		}
		
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public void jumpHyp() {
		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof PlayerShip) {
				((PlayerShip) GameObject).playerShipHyperSpa();
				System.out.println("Player ship's has jumped into hyperSpeed!");

			}
		}
		
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public void launchMissNPC() {
		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof NPCShip) {
				if (((NPCShip) GameObject).getMissile() <= 0) {
					System.out.println("Emty! reload missiles.");
				} else {
					go.add(((NPCShip) GameObject).fireMissile());

				}
			}
		}
		
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));

	}

	public void shipDocked() {
		if (spaceStationInStore() && playerInStore()) {
			IIterator worldObjects = go.getIterator();

			while (worldObjects.hasNext()) {
				GameObject GameObject = (GameObject) worldObjects.getNext();
				if (GameObject instanceof PlayerShip) {
					((PlayerShip) GameObject).relodeMissiles();

				}
			}
		
		} else {
			System.out.println("There needs to be a player and a space station in order to reload ammo.");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		// TODO Auto-generated method stub

	}

	public void MissileHitAsteroid() {
		ArrayList<Missile> allMiss = this.removePsMiss();
		ArrayList<Asteroid> allAst = this.removeAsteroid();
		if (missileInStore() && asteroidInStore(1)) {
			go.remove(allAst.get(0));
			go.remove(allMiss.get(0));
			missHitAstSound.play();
			score += 1;
			System.out.println("Your missile hit a asteroid!");
		} else {
			System.out.println("There is either no missiles or no asteroids in play to land a hit.");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public void MissileHitNPC() {
		ArrayList<Missile> allMiss = this.removePsMiss();
		ArrayList<NPCShip> allNPS = this.removeNPC();

		if (missileInStore() && NPCInStore()) {
			go.remove(allNPS.get(0));
			go.remove(allMiss.get(0));
			
			score += 1;
			System.out.println("Your missile hit a NPCShip!");
		} else {
			System.out.println("There is either no missiles or no NPCShip in play to land a hit.");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		// TODO Auto-generated method stub

	}

	public void NPCmissHitPS() {
		ArrayList<NPCMissile> allNpcMiss = this.removeNpcMiss();
		ArrayList<PlayerShip> allPS = this.removePS();

		if (NPCMissInStore() && playerInStore()) {
			go.remove(allPS.get(0));
			go.remove(allNpcMiss.get(0));
			
			playerLosesLife();
			System.out.println("NPC missile hit a Playership!");
		} else {
			System.out.println("There is either no NPC missiles or no Player in play to land a hit.");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public void ShipHitAsteroid() {
		ArrayList<Asteroid> allAst = this.removeAsteroid();
		ArrayList<PlayerShip> allPS = this.removePS();

		if (asteroidInStore(1) && playerInStore()) {
			go.remove(allPS.get(0));
			go.remove(allAst.get(0));
			
			playerLosesLife();
			System.out.println("Asteroid hit a Playership!");

			// TODO Auto-generated method stub
		} else {
			System.out.println("There is either no Asteroid or no Player in play to land a hit.");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		// TODO Auto-generated method stub

	}

	public void ShipHitNPC() {
		ArrayList<NPCShip> allNPS = this.removeNPC();
		ArrayList<PlayerShip> allPS = this.removePS();

		if (NPCInStore() && playerInStore()) {
			go.remove(allPS.get(0));
			go.remove(allNPS.get(0));
			playerLosesLife();
			
			System.out.println("NPC and Playership have collided!");

			// TODO Auto-generated method stub
		} else {
			System.out.println("There is either no NPC or no Player that can collided.");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public void AsteroidsHit() {
		ArrayList<Asteroid> allAst = this.removeAsteroid();

		if (asteroidInStore(2)) {
			go.remove(allAst.get(0));
			go.remove(allAst.get(1));
			
			System.out.println("Asteroid hit another Asteroid!");
			// TODO Auto-generated method stub
		} else {
			System.out.println("There is not enough Asteroid in order for there to be a collision.");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public void AsteroidHitNPC() {
		ArrayList<NPCShip> allNPS = this.removeNPC();
		ArrayList<Asteroid> allAst = this.removeAsteroid();
		if (asteroidInStore(1) && NPCInStore()) {
			go.remove(allAst.get(0));
			go.remove(allNPS.get(0));
			
			System.out.println("Asteroid hit a NPCship!");
			// TODO Auto-generated method stub
		} else {
			System.out.println("There is either no Asteroid or no NPC Ship in play to land a hit.");
		}
		// TODO Auto-generated method stub
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public void clockTick() {
		
		if(!pause) {
			
		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof IMoveable) {
				((IMoveable) GameObject).move();
			}
		}
	
		/* Handle Collision of Objects */
		IIterator elements1;
		IIterator elements2;

		elements1 = go.getIterator();
		while(elements1.hasNext()) {
			ICollider currentObject = (ICollider)elements1.getNext();
			elements2 = go.getIterator();
			while(elements2.hasNext()) {
				ICollider otherObject = (ICollider)elements2.getNext(); 
				if(otherObject!=currentObject) {
					if(currentObject.collisionWith(otherObject)) {
						currentObject.handleCollision(otherObject);
						
					}//end collision handle
				}//end if same object check
			}//end parse through ele2
		}//end parse through ele1
		
		clearCrash();
		UpdateMissilefuel();
		UpdateNPCMissilefuel();
		updateStation();
		setGameTime(getGameTime() + 1);
		spawnObj(); 
		System.out.println("Time has passed.");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		}
		
	}
	


	public void clearCrash() {
        for (int i = 0; i < go.iteratorSize(); i++) {
    		GameObject gameObj = (GameObject)go.elementAt(i);
    		if(gameObj.getCrash()) {
    			if(gameObj instanceof Asteroid) {
    				go.remove(i);
    			}
    			if(gameObj instanceof NPCShip){
    				go.remove(i);
    			}
    			if(gameObj instanceof Missile){
    				go.remove(i);
    			}
    			if (gameObj instanceof PlayerShip) {
    				lives -= 1;
    				go.remove(i);
    			}
    		}
    	}//end for
	}//end clear poofs

	public void showState() {
		System.out.println("Players Score " + score);
		playerMissileCount();
		System.out.println("Time player: " + getGameTime());
		// TODO Auto-generated method stub
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));

	}

	public void map() {
		// TODO Auto-generated method stub
		IIterator worldObjects = go.getIterator();
		if (worldObjects.hasNext()) {
			while (worldObjects.hasNext()) {
				GameObject GameObject = (GameObject) worldObjects.getNext();
				System.out.println(GameObject);
			}
		} else {
			System.out.println("No GameObjects exist currently.");
		}
		
	}

	public Command quitGame() {
		quitiGame();
		return null;
		
	}
	public void quitiGame() {
		System.out.println("Thanks for playing.");
		System.exit(0);
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public boolean missileInStore() {
		boolean missInStore = false;
		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof Missile) {
				missInStore = true;
			}
		}

		return missInStore;
	}

	public boolean asteroidInStore(int numOfAst) {
		int nOfast = 0;
		boolean astInStore = false;
		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof Asteroid) {
				nOfast += 1;
			}
		}
		
		if (nOfast >= numOfAst) {
			astInStore = true;
		}
		return astInStore;
	}

	public boolean playerInStore() {
		boolean PsInStore = false;
		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof PlayerShip) {
				PsInStore = true;
			}
		}
		
		return PsInStore;
	}

	public boolean NPCInStore() {
		boolean NPCInStore = false;
		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof NPCShip) {
				NPCInStore = true;
			}
		}
		
		return NPCInStore;
	}

	public boolean NPCMissInStore() {
		boolean NPCMissInStore = false;
		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof NPCMissile) {
				NPCMissInStore = true;
			}
		}
		
		return NPCMissInStore;
	}

	public boolean spaceStationInStore() {
		IIterator worldObjects = go.getIterator();
		boolean spaceStationInStore = false;

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof SpaceStation) {
				spaceStationInStore = true;
			}
		}
	
		return spaceStationInStore;
	}

	public void playerLosesLife() {
		lives -= 1;
		if (lives <= 0) {
			gameOver.play();
			System.out.println("GAMEOVER");
			System.out.println("No more lives");
			quitGame();
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public void UpdateMissilefuel() {
		
		ArrayList<Missile> allMiss = this.removePsMiss();
		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof Missile) {
					((Missile) GameObject).decrFuel();

				}
			}
		for (int i = 0; i < allMiss.size(); i++) {
			
			if (allMiss.get(i).getFuelLevel() == 0) {
					go.remove(allMiss.get(i));
					System.out.println("Player missile ran out of fuel and was removed from game.");
			}
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	public void refuelMissiles() {
		IIterator theElements = go.getIterator();
		if(pause) {
			if(missileInStore()) {
				while(theElements.hasNext()) {
					GameObject gameObj = (GameObject) theElements.getNext();
					if (gameObj instanceof Missile) {
						if(((Missile) gameObj).isSelected()) {
							((Missile) gameObj).setFuelLevel(60); /* resets fuel level to 30 */
							((Missile) gameObj).setSelected(false);
						}
					} 
				}
			} else {/* nothing */}
				
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		}
} //end refuel
	public void spawnObj(){
		Random r = new Random();
		int rInt = r.nextInt(100);
        
		if(rInt == 23) {
			addNewAsteroid();
		}
		
        if(rInt == 5){
            addNewNPCShip();
        }
        if(rInt == 15 || rInt == 35){
            IIterator theElements = go.getIterator();
            while(theElements.hasNext()){
                GameObject gameobject = (GameObject) theElements.getNext();
                if(gameobject instanceof NPCShip) {
                    ((NPCShip) gameobject).fireMissile();
                    break;
                }
            }
        }
	}//end randomNPS
	public void UpdateNPCMissilefuel() {
		ArrayList<NPCMissile> allNPSMiss = this.removeNpcMiss();
		
		IIterator worldObjects = go.getIterator();
		
		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof NPCMissile) {
				((NPCMissile) GameObject).decrFuel();
				}
					
			}
		for (int i = 0; i < allNPSMiss.size(); i++) {
			if (allNPSMiss.get(i).getFuelLevel() == 0) {
					go.remove(allNPSMiss.get(i));
					System.out.println("Player missile ran out of fuel and was removed from game.");
			}
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
			


	public int playerMissileCount() {
		int numOfMiss = 0;
		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof PlayerShip) {
				numOfMiss = ((PlayerShip) GameObject).getNumOfmissiles();
			}
		}
		
		return numOfMiss;
	}

	public void updateStation() {
		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof SpaceStation) {
				((SpaceStation) GameObject).reduceBLinkCount();
			}
		}
		
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public ArrayList<Asteroid> removeAsteroid() {
		ArrayList<Asteroid> NPCShips = new ArrayList<>();

		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof Asteroid) {
				
				NPCShips.add((Asteroid) GameObject);
			}
			
		}
		return NPCShips;
	}

	public ArrayList<NPCMissile> removeNpcMiss() {
		ArrayList<NPCMissile> allObj = new ArrayList<>();
		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof NPCMissile) {
			
				allObj.add((NPCMissile) GameObject);
			}
		}
		
		return allObj;
	}

	public ArrayList<PlayerShip> removePS() {
		ArrayList<PlayerShip> allObj = new ArrayList<>();
		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof PlayerShip) {
				
				allObj.add((PlayerShip) GameObject);
			}
			
		}
		return allObj;
		
	}

	public ArrayList<Missile> removePsMiss() {
		ArrayList<Missile> allObj = new ArrayList<>();
		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof Missile) {
				
				allObj.add((Missile) GameObject);
			}
			
		}
		return allObj;
	}

	private ArrayList<NPCShip> removeNPC() {
		ArrayList<NPCShip> allObj = new ArrayList<>();
		IIterator worldObjects = go.getIterator();

		while (worldObjects.hasNext()) {
			GameObject GameObject = (GameObject) worldObjects.getNext();
			if (GameObject instanceof NPCShip) {
				
				allObj.add((NPCShip) GameObject);
			}
			
		}
		return allObj;
		// TODO Auto-generated method stub

	}

	@Override
	public int getPlayerScore() {
		// TODO Auto-generated method stub
		return score;
	}

	@Override
	public boolean getSound() {
		// TODO Auto-generated method stub
		return soundOn;
	}

	@Override
	public int getLives() {
		// TODO Auto-generated method stub
		return lives;
	}

	@Override
	public int getTime() {
		// TODO Auto-generated method stub
		return getGameTime();
	}

	@Override
	public int getMissileCount() {
		// TODO Auto-generated method stub
		return playerMissileCount();
	}

	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub
		this.width = width;

	}

	@Override
	public void setHeight(int height) {
		// TODO Auto-generated method stub
		this.height = height;
	}

	public int getGameTime() {
		return gameTime;
	}

	public void setGameTime(int gameTime) {
		this.gameTime = gameTime;
	}

	public Vector getGameObjects() {
		return gameObjects;
	}

	public void setGameObjects(Vector gameObjects) {
		this.gameObjects = gameObjects;
	}

	@Override
	public void setSound() {
		if (this.soundOn == false) {
			this.soundOn = true;
			bgSound.play();
			} else {
			this.soundOn = false;
			bgSound.pause();
		// TODO Auto-generated method stub
			}
	}
	

	@Override
	public IIterator getGWIterator() {
		// TODO Auto-generated method stub
		return go.getIterator();
	}

	public void pause() {
	
			pause = !pause;		
	}	
}
