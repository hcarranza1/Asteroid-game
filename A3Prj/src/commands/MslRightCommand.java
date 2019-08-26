package commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class MslRightCommand extends Command{
	private GameWorld gw;
	
	public MslRightCommand(GameWorld gw) {
		super("MSL Right");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
			gw.turnPsLaunchR();
		
	}

}
