package commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class HyperJumpCommand extends Command{
	private GameWorld gw;

	public HyperJumpCommand(GameWorld gw) {
		super("Jump");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
			gw.jumpHyp();
		
	}

}
