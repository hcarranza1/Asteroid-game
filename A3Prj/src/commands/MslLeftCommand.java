package commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class MslLeftCommand extends Command{
	private GameWorld gw;
	
	public MslLeftCommand(GameWorld gw) {
		super("MSL Left");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
			gw.turnPsLaunchL();
		
	}

}
