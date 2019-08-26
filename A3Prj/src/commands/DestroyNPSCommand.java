package commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class DestroyNPSCommand extends Command{
	private GameWorld gw;

	public DestroyNPSCommand(GameWorld gw) {
		super("PS Missile (NPS)");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
			gw.MissileHitNPC();
		
	}

}
