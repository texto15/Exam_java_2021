import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionTrier implements ActionListener {
	private ZoneDessin zoneDessin;
	
	public ActionTrier(ZoneDessin zd) {
		zoneDessin=zd;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {//On lance le tri 
		zoneDessin.trier();
		zoneDessin.repaint();
	}

}
//Deschamps Guillaume