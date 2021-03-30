import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyListener implements KeyListener {

	ZoneDessin zoneDessin;
	
	public MyListener(ZoneDessin zd) {
		zoneDessin=zd;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {//On appuie sur une touche du clavier
		// TODO Auto-generated method stub
		char key=e.getKeyChar();//On recupere la touche appuyée
		if (key=='r') {//On ajoute un nouveau carre
			Carre c=new Carre();
			int r=(int)(Math.random()*255),g=(int)(Math.random()*255),b=(int)(Math.random()*255);
			Color col=new Color(r,g,b);
			c.setColor(col);
			try {
				c.redim((int)(50+Math.random()*100));
				c.setX(400-(int)(0.5*c.getSize()));
				c.setY(300-(int)(0.5*c.getSize()));
			}
		
			catch (WrongSizeException WSE) {
				System.err.println("Wrong Size Exception");
			}
			
			zoneDessin.add(c);
			zoneDessin.repaint();
		}
		
		if (key=='c') {//On ajoute un cercle
			Cercle c=new Cercle();
			int r=(int)(Math.random()*255),g=(int)(Math.random()*255),b=(int)(Math.random()*255);
			Color col=new Color(r,g,b);
			c.setColor(col);
			try {
				c.redim((int)(50+Math.random()*100));
				c.setX(400-(int)(0.5*c.getSize()));
				c.setY(300-(int)(0.5*c.getSize()));
			}
			
			catch (WrongSizeException WSE) {
				System.err.println("Wrong Size Exception");
			}
			
			zoneDessin.add(c);
			zoneDessin.repaint();
		}
		
		if (key=='d') {//On supprime la derniere forme
			zoneDessin.delete();
			zoneDessin.repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
//Deschamps Guillaume