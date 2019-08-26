package commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class PauseCommand extends Command{
	private GameWorld gw;
	
	public PauseCommand(GameWorld gw) {
		super("Pause");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if(ev.getKeyEvent() != -1) {
			gw.pause();
		}
	}
}
