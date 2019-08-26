package commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class AboutCommand extends Command{
	private GameWorld gw;

	public AboutCommand() {
		super("About");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
			Dialog.show("About","HI!! you are playing a game by Horacio Carranza","Done","Exit");
	}
}
