package commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class SoundCommand extends Command{
	private GameWorld gw;
	
	public SoundCommand(GameWorld gw) {
		super("Sound");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		if(gw.getSound() == true) {
			gw.setSound();
			System.out.println(" Sound is toggled off.");
		} else {
			gw.setSound();
			System.out.println(" Sound is toggled on.");
		}
	}
}
