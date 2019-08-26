package commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class AstHitAstCommand extends Command{
	private GameWorld gw;
	
	public AstHitAstCommand(GameWorld gw) {
		super("Asteroid hits Asteroid");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
			gw.AsteroidsHit();
	
	}

}
