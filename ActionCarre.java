import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionCarre implements ActionListener {

private ZoneDessin zoneDessin;
	
	public ActionCarre(ZoneDessin zd) {
		zoneDessin=zd;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {//Permet de savoir si le bouton radio carre est actif
		zoneDessin.setForme(false);
	}
}
//Deschamps Guillaume