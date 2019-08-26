package commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class AddNpcCommand extends Command{
	private GameWorld gw;
	
	public AddNpcCommand(GameWorld gw) {
		super("+ NPS");
		this.gw = gw;
	}
	

	@Override
	public void  actionPerformed(ActionEvent ev) {
			gw.addNewNPCShip();
			System.out.println("NPS Command was performed");
		
	}

}
