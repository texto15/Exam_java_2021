import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionCercle implements ActionListener{

	private ZoneDessin zoneDessin;
	
	public ActionCercle(ZoneDessin zd) {
		zoneDessin=zd;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {//Permet de savoir si le bouton radio cercle est actif
		zoneDessin.setForme(true);
	}
}
//Deschamps Guillaume