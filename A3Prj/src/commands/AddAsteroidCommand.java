package commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class AddAsteroidCommand  extends Command{
	private GameWorld gw;
	
	public AddAsteroidCommand(GameWorld gw) {
		super("+ Asteroid");
		this.gw = gw;
	}
	
	@Override
	public void  actionPerformed(ActionEvent ev) {
			gw.addNewAsteroid();
			System.out.println("Asteroid Command was performed");

	}
}
