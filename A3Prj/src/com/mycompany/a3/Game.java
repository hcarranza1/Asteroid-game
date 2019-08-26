package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;

import commands.AboutCommand;
import commands.AddAsteroidCommand;
import commands.AddNpcCommand;
import commands.AddPlayerShipCommand;
import commands.AddSpaceStationCommand;
import commands.AstHitAstCommand;
import commands.AstHitNpcCommand;
import commands.ClockTickCommand;
import commands.DecreaseSpeedCommand;
import commands.DestroyAsteroidCommand;
import commands.DestroyNPSCommand;
import commands.FireMissileCommand;
import commands.HitNPSCommand;
import commands.HyperJumpCommand;
import commands.IncreaseSpeedCommand;
import commands.LaunchNpcMissileCommand;
import commands.LeftTurnCommand;
import commands.LoadMissilesCommand;
import commands.MslLeftCommand;
import commands.MslRightCommand;
import commands.NewGameCommand;
import commands.PSHitAstCommand;
import commands.PauseCommand;
import commands.QuitCommand;
import commands.RefuelCommand;
import commands.RightTurnCommand;
import commands.SaveCommand;
import commands.SoundCommand;
import commands.UndoCommand;
import commands.npcEPSCommand;

import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;
import java.util.Observable;
import java.util.Observer;

public class Game extends Form implements Runnable{
	private GameWorld gw;
	private MapView mv;// new in A2
	private PointView pv;// new in A2
	private UITimer timer;

	private AddPlayerShipCommand addPlayerShipCommand;
	private LeftTurnCommand leftCommand;
	private RightTurnCommand rightCommand;
	private MslLeftCommand mslLeftCommand;
	private MslRightCommand mslRightCommand;
	private FireMissileCommand fCommand;
	private LaunchNpcMissileCommand launchNpcCommand;
	private HyperJumpCommand jCommand;
	private LoadMissilesCommand loadCommand;
	private DestroyAsteroidCommand kCommand;
	private DestroyNPSCommand eCommand;
	private npcEPSCommand ePSCommand;
	private PSHitAstCommand cCommand;
	private HitNPSCommand hitCommand;
	private AstHitAstCommand astHitAstCommand;
	private AstHitNpcCommand astHitNpcCommand;
	private QuitCommand qCommand;
	private PauseCommand pCommand;
	private RefuelCommand refuelCommand;
	
	public Game() {
		setLayout(new BorderLayout());
		gw = new GameWorld(); // create Observable
		mv = new MapView(); // create an Observer for the map
		pv = new PointView(gw);// create an Observer for the points
		// code here to create menus, create Command objects for each command,
		// add commands to Command menu, create a control panel for the buttons,
		// add buttons to the control panel, add commands to the buttons, and
		// add control panel, MapView panel, and PointsView panel to the form
		Toolbar toolbar = new Toolbar();
		this.setToolbar(toolbar);
		toolbar.setTitle("Asteroid Game");

		Container buttonsLoc = new Container();
		buttonsLoc.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		buttonsLoc.add(new Label("Commands"));
		buttonsLoc.getAllStyles().setBgTransparency(200);
		buttonsLoc.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
		buttonsLoc.setScrollableY(true);

		AddAsteroidCommand addAsteroidCommand = new AddAsteroidCommand(gw);
//		Button buttonAddAsteroid = new Button("+ Asteroid");
//		buttonAddAsteroid.getAllStyles().setBgTransparency(200);
//		buttonAddAsteroid.getAllStyles().setBgColor(ColorUtil.BLUE);
//		buttonAddAsteroid.getAllStyles().setFgColor(ColorUtil.BLACK);
//		buttonAddAsteroid.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
//		buttonAddAsteroid.setCommand(addAsteroidCommand);
//		buttonsLoc.add(buttonAddAsteroid);

		AddNpcCommand addNpcCommand = new AddNpcCommand(gw);
//		Button buttonAddNpc = new Button("+ NPS");
//		buttonAddNpc.getAllStyles().setBgTransparency(200);
//		buttonAddNpc.getAllStyles().setBgColor(ColorUtil.BLUE);
//		buttonAddNpc.getAllStyles().setFgColor(ColorUtil.BLACK);
//		buttonAddNpc.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
//		buttonAddNpc.setCommand(addNpcCommand);
//		buttonsLoc.add(buttonAddNpc);

		AddSpaceStationCommand addSpaceStationCommand = new AddSpaceStationCommand(gw);
		Button buttonAddSpaceStation = new Button("+ Space Station");
		buttonAddSpaceStation.getAllStyles().setBgTransparency(200);
		buttonAddSpaceStation.getAllStyles().setBgColor(ColorUtil.BLUE);
		buttonAddSpaceStation.getAllStyles().setFgColor(ColorUtil.BLACK);
		buttonAddSpaceStation.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
		buttonAddSpaceStation.setCommand(addSpaceStationCommand);
		buttonsLoc.add(buttonAddSpaceStation);

		addPlayerShipCommand = new AddPlayerShipCommand(gw);
		Button buttonAddPlayerShip = new Button("+ Player Ship()");
		buttonAddPlayerShip.getAllStyles().setBgTransparency(200);
		buttonAddPlayerShip.getAllStyles().setBgColor(ColorUtil.BLUE);
		buttonAddPlayerShip.getAllStyles().setFgColor(ColorUtil.BLACK);
		buttonAddPlayerShip.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
		buttonAddPlayerShip.setCommand(addPlayerShipCommand);
		buttonsLoc.add(buttonAddPlayerShip);
		// was here

		IncreaseSpeedCommand inceaseSpeedCommand = new IncreaseSpeedCommand(gw);
//		Button buttonIncrease = new Button("PS Speed (+)");
//		buttonIncrease.getAllStyles().setBgTransparency(200);
//		buttonIncrease.getAllStyles().setBgColor(ColorUtil.BLUE);
//		buttonIncrease.getAllStyles().setFgColor(ColorUtil.BLACK);
//		buttonIncrease.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
//		buttonIncrease.setCommand(inceaseSpeedCommand);
//		buttonsLoc.add(buttonIncrease);
		addKeyListener(-91, inceaseSpeedCommand);

		DecreaseSpeedCommand decreaseSpeedCommand = new DecreaseSpeedCommand(gw);
//		Button buttonDecrease = new Button("PS Speed(-)");
//		buttonDecrease.getAllStyles().setBgTransparency(200);
//		buttonDecrease.getAllStyles().setBgColor(ColorUtil.BLUE);
//		buttonDecrease.getAllStyles().setFgColor(ColorUtil.BLACK);
//		buttonDecrease.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
//		buttonDecrease.setCommand(decreaseSpeedCommand);
//		buttonsLoc.add(buttonDecrease);
		addKeyListener(-92, decreaseSpeedCommand);

		leftCommand = new LeftTurnCommand(gw);
//		Button buttonLeft = new Button("PS Left");
//		buttonLeft.getAllStyles().setBgTransparency(200);
//		buttonLeft.getAllStyles().setBgColor(ColorUtil.BLUE);
//		buttonLeft.getAllStyles().setFgColor(ColorUtil.BLACK);
//		buttonLeft.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
//		buttonLeft.setCommand(leftCommand);
//		buttonsLoc.add(buttonLeft);
		addKeyListener(-93, leftCommand);
		// was here
		rightCommand = new RightTurnCommand(gw);
//		Button buttonRight = new Button("PS Right");
//		buttonRight.getAllStyles().setBgTransparency(200);
//		buttonRight.getAllStyles().setBgColor(ColorUtil.BLUE);
//		buttonRight.getAllStyles().setFgColor(ColorUtil.BLACK);
//		buttonRight.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
//		buttonRight.setCommand(rightCommand);
//		buttonsLoc.add(buttonRight);
		addKeyListener(-94, rightCommand);

		mslLeftCommand = new MslLeftCommand(gw);
//		Button buttonMslLeft = new Button("MSL Left");
//		buttonMslLeft.getAllStyles().setBgTransparency(200);
//		buttonMslLeft.getAllStyles().setBgColor(ColorUtil.BLUE);
//		buttonMslLeft.getAllStyles().setFgColor(ColorUtil.BLACK);
//		buttonMslLeft.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
//		buttonMslLeft.setCommand(mslLeftCommand);
//		buttonsLoc.add(buttonMslLeft);
		addKeyListener(44, mslLeftCommand);

		mslRightCommand = new MslRightCommand(gw);
//		Button buttonMslRight = new Button("MSL Right");
//		buttonMslRight.getAllStyles().setBgTransparency(200);
//		buttonMslRight.getAllStyles().setBgColor(ColorUtil.BLUE);
//		buttonMslRight.getAllStyles().setFgColor(ColorUtil.BLACK);
//		buttonMslRight.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
//		buttonMslRight.setCommand(mslRightCommand);
//		buttonsLoc.add(buttonMslRight);
		addKeyListener(46, mslRightCommand);

		fCommand = new FireMissileCommand(gw);
//		Button buttonFireMissile = new Button("PS Fire");
//		buttonFireMissile.getAllStyles().setBgTransparency(200);
//		buttonFireMissile.getAllStyles().setBgColor(ColorUtil.BLUE);
//		buttonFireMissile.getAllStyles().setFgColor(ColorUtil.BLACK);
//		buttonFireMissile.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
//		buttonFireMissile.setCommand(fCommand);
//		buttonsLoc.add(buttonFireMissile);
		addKeyListener(-90, fCommand);

		launchNpcCommand = new LaunchNpcMissileCommand(gw);
//		Button buttonLaunchMissile = new Button("NPC Fire");
//		buttonLaunchMissile.getAllStyles().setBgTransparency(200);
//		buttonLaunchMissile.getAllStyles().setBgColor(ColorUtil.BLUE);
//		buttonLaunchMissile.getAllStyles().setFgColor(ColorUtil.BLACK);
//		buttonLaunchMissile.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
//		buttonLaunchMissile.setCommand(launchNpcCommand);
//		buttonsLoc.add(buttonLaunchMissile);

		jCommand = new HyperJumpCommand(gw);
		Button buttonJump = new Button("Jump");
		buttonJump.getAllStyles().setBgTransparency(200);
		buttonJump.getAllStyles().setBgColor(ColorUtil.BLUE);
		buttonJump.getAllStyles().setFgColor(ColorUtil.BLACK);
		buttonJump.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
		buttonJump.setCommand(jCommand);
		buttonsLoc.add(buttonJump);
		addKeyListener('j', jCommand);

		loadCommand = new LoadMissilesCommand(gw);
		Button buttonloadMissiles = new Button("Load PS");
		buttonloadMissiles.getAllStyles().setBgTransparency(200);
		buttonloadMissiles.getAllStyles().setBgColor(ColorUtil.BLUE);
		buttonloadMissiles.getAllStyles().setFgColor(ColorUtil.BLACK);
		buttonloadMissiles.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
		buttonloadMissiles.setCommand(loadCommand);
		buttonsLoc.add(buttonloadMissiles);

		kCommand = new DestroyAsteroidCommand(gw);
//		Button buttonDestroyAsteroid = new Button("PS Missile (Asteroid)");
//		buttonDestroyAsteroid.getAllStyles().setBgTransparency(200);
//		buttonDestroyAsteroid.getAllStyles().setBgColor(ColorUtil.BLUE);
//		buttonDestroyAsteroid.getAllStyles().setFgColor(ColorUtil.BLACK);
//		buttonDestroyAsteroid.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
//		buttonDestroyAsteroid.setCommand(kCommand);
//		buttonsLoc.add(buttonDestroyAsteroid);
//		addKeyListener('k', kCommand);

		eCommand = new DestroyNPSCommand(gw);
//		Button buttonDNpc = new Button("PS Missile (NPS)");
//		buttonDNpc.getAllStyles().setBgTransparency(200);
//		buttonDNpc.getAllStyles().setBgColor(ColorUtil.BLUE);
//		buttonDNpc.getAllStyles().setFgColor(ColorUtil.BLACK);
//		buttonDNpc.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
//		buttonDNpc.setCommand(eCommand);
//		buttonsLoc.add(buttonDNpc);

		ePSCommand = new npcEPSCommand(gw);
//		Button buttonExplode = new Button("NPS Missile (PS)");
//		buttonExplode.getAllStyles().setBgTransparency(200);
//		buttonExplode.getAllStyles().setBgColor(ColorUtil.BLUE);
//		buttonExplode.getAllStyles().setFgColor(ColorUtil.BLACK);
//		buttonExplode.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
//		buttonExplode.setCommand(ePSCommand);
//		buttonsLoc.add(buttonExplode);

		cCommand = new PSHitAstCommand(gw);
//		Button buttonCrash = new Button("PS (Asteroid)");
//		buttonCrash.getAllStyles().setBgTransparency(200);
//		buttonCrash.getAllStyles().setBgColor(ColorUtil.BLUE);
//		buttonCrash.getAllStyles().setFgColor(ColorUtil.BLACK);
//		buttonCrash.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
//		buttonCrash.setCommand(cCommand);
//		buttonsLoc.add(buttonCrash);

		hitCommand = new HitNPSCommand(gw);
//		Button buttonHit = new Button("PS (NPS)");
//		buttonHit.getAllStyles().setBgTransparency(200);
//		buttonHit.getAllStyles().setBgColor(ColorUtil.BLUE);
//		buttonHit.getAllStyles().setFgColor(ColorUtil.BLACK);
//		buttonHit.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
//		buttonHit.setCommand(hitCommand);
//		buttonsLoc.add(buttonHit);

		astHitAstCommand = new AstHitAstCommand(gw);
//		Button buttonastHitAst = new Button("Asteroid (Asteroid)");
//		buttonastHitAst.getAllStyles().setBgTransparency(200);
//		buttonastHitAst.getAllStyles().setBgColor(ColorUtil.BLUE);
//		buttonastHitAst.getAllStyles().setFgColor(ColorUtil.BLACK);
//		buttonastHitAst.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
//		buttonastHitAst.setCommand(astHitAstCommand);
//		buttonsLoc.add(buttonastHitAst);
//		addKeyListener('x', astHitAstCommand);

		astHitNpcCommand = new AstHitNpcCommand(gw);
//		Button buttonAstHitNpc = new Button("Asteroid (NPS)");
//		buttonAstHitNpc.getAllStyles().setBgTransparency(200);
//		buttonAstHitNpc.getAllStyles().setBgColor(ColorUtil.BLUE);
//		buttonAstHitNpc.getAllStyles().setFgColor(ColorUtil.BLACK);
//		buttonAstHitNpc.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
//		buttonAstHitNpc.setCommand(astHitNpcCommand);
//		buttonsLoc.add(buttonAstHitNpc);
////
//		tickCommand = new ClockTickCommand(gw);
//		Button buttonTick = new Button("Game Clock Tick");
//		buttonTick.getAllStyles().setBgTransparency(200);
//		buttonTick.getAllStyles().setBgColor(ColorUtil.BLUE);
//		buttonTick.getAllStyles().setFgColor(ColorUtil.BLACK);
//		buttonTick.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
//		buttonTick.setCommand(tickCommand);
//		buttonsLoc.add(buttonTick);
		pCommand = new PauseCommand(gw);
		Button buttonpause = new Button("Quit");
		buttonpause.getAllStyles().setBgTransparency(200);
		buttonpause.getAllStyles().setBgColor(ColorUtil.rgb(255,0,0));
		buttonpause.getAllStyles().setFgColor(ColorUtil.BLACK);
		buttonpause.getAllStyles().setBorder(Border.createLineBorder(2,ColorUtil.BLACK));
		buttonpause.setCommand(pCommand);
		buttonsLoc.add(buttonpause);
		addKeyListener('p', pCommand);

		refuelCommand = new RefuelCommand(gw);
		Button buttonrefuel = new Button("Refuel Missiles");
		buttonrefuel.getAllStyles().setBgTransparency(100);
		buttonrefuel.getAllStyles().setBgColor(ColorUtil.GREEN);
		buttonrefuel.getAllStyles().setFgColor(ColorUtil.WHITE);
		buttonrefuel.getAllStyles().setBorder(Border.createLineBorder(2,ColorUtil.WHITE));
		buttonrefuel.setCommand(refuelCommand);
		buttonsLoc.add(buttonrefuel);
		
		qCommand = new QuitCommand(gw);
		Button buttonquit = new Button("Quit");
		buttonquit.getAllStyles().setBgTransparency(200);
		buttonquit.getAllStyles().setBgColor(ColorUtil.rgb(255, 0, 0));
		buttonquit.getAllStyles().setFgColor(ColorUtil.BLACK);
		buttonquit.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
		buttonquit.setCommand(qCommand);
		buttonsLoc.add(buttonquit);
		addKeyListener('q', qCommand);

		CheckBox soundBox = new CheckBox("Sound");
		soundBox.getAllStyles().setBgColor(ColorUtil.WHITE);
		soundBox.getAllStyles().setFgColor(ColorUtil.BLUE);
		soundBox.getAllStyles().setBorder(Border.createLineBorder(1, ColorUtil.WHITE));

		NewGameCommand newGameCommand = new NewGameCommand();
		toolbar.addCommandToSideMenu(newGameCommand);
		SaveCommand saveCommand = new SaveCommand();
		toolbar.addCommandToSideMenu(saveCommand);
		UndoCommand undoCommand = new UndoCommand();
		toolbar.addCommandToSideMenu(undoCommand);
		SoundCommand sound = new SoundCommand(gw);
		soundBox.setCommand(sound);
		toolbar.addComponentToSideMenu(soundBox);
		AboutCommand about = new AboutCommand();
		toolbar.addCommandToSideMenu(about);

		gw.addObserver(mv); // register the map Observer
		gw.addObserver(pv); // register the points observer
		
		add(BorderLayout.WEST, buttonsLoc);
		add(BorderLayout.NORTH, pv);
		add(BorderLayout.CENTER, mv);

		this.show();
		gw.init(getWidth(), getHeight());
	
		timer = new UITimer(this);
		timer.schedule(20, true, this);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		gw.clockTick();
	}
}
