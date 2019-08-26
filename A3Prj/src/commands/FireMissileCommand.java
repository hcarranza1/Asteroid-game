package commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class FireMissileCommand extends Command{
	private GameWorld gw;

	public FireMissileCommand(GameWorld gw) {
		super("PS Fire");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		if(ev.getKeyEvent() != -1) {
			gw.psFired();
		}
	}

}
