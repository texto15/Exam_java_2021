import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionRetirer implements ActionListener {
private ZoneDessin zoneDessin;
	
	public ActionRetirer(ZoneDessin zd) {
		zoneDessin=zd;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		zoneDessin.delete();//On retire le dernier element de la liste
		zoneDessin.repaint();
		
	}

}
//Deschamps Guillaume