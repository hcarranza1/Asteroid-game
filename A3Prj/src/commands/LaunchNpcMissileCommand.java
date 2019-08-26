package commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class LaunchNpcMissileCommand extends Command{
	private GameWorld gw;
	
	public LaunchNpcMissileCommand(GameWorld gw) {
		super("NPS Fire");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
			gw.launchMissNPC();
		
	}

}
