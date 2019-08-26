package commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class IncreaseSpeedCommand extends Command {
	private GameWorld gw;
	
	public IncreaseSpeedCommand(GameWorld gw) {
		super("PS Speed (+)");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
			gw.increaseSpeed();
			System.out.println("increaseSpeed command");
		
	}

}
