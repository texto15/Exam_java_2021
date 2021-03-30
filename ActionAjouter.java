import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionAjouter implements ActionListener {

	private ZoneDessin zoneDessin;
	
	public ActionAjouter(ZoneDessin zd) {
		zoneDessin=zd;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Forme2D c;
		int r=(int)(Math.random()*255),g=(int)(Math.random()*255),b=(int)(Math.random()*255);
		Color col=new Color(r,g,b);
		
		if (zoneDessin.getForme()==false) {//On verifie si on trace un carre ou un cercle
			c=new Carre();
			c.setColor(col);
			try {
				c.redim((int)(50+Math.random()*100));
				c.setX(400-(int)(0.5*c.getSize()));
				c.setY(300-(int)(0.5*c.getSize()));
			}
		
			catch (WrongSizeException e) {
				System.err.println("Wrong Size Exception");
			}
		}
		
		else {
			c=new Cercle();
			c.setColor(col);
			try {
				c.redim((int)(50+Math.random()*100));
				c.setX(400-(int)(0.5*c.getSize()));
				c.setY(300-(int)(0.5*c.getSize()));
			}
		
			catch (WrongSizeException e) {
				System.err.println("Wrong Size Exception");
			}
		}
		
		zoneDessin.add(c);//On ajoute la forme a la liste
		zoneDessin.repaint();//On actualise l'affichage
		
	}

}
//Deschamps Guillaume