package commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class QuitCommand extends Command{
	private GameWorld gw;
	
	public QuitCommand(GameWorld gw) {
		super("Quit");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		Boolean anwser = false;
		anwser = Dialog.show("Exit Game", "Do you wish to quit?", "Yes", "No");
			if(anwser) {gw.quitGame();}

	}
}
