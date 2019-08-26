package commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class DecreaseSpeedCommand extends Command{
	private GameWorld gw;

	public DecreaseSpeedCommand(GameWorld gw) {
		super("PS Speed (-)");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
			gw.decreaseSpeed();
			System.out.println("Decreasing Speed");
		
	}

}
