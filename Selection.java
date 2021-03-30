import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Selection implements MouseListener, MouseMotionListener{

	ZoneDessin zoneDessin;//La zone dans laquelle on travaille
	boolean selection;//sert a savoir si une forme est selectionnée
	boolean pression;//sert a savoir si on "mousepressed" dans la bonne forme
	boolean bord;//sert a savoir si on "mousepressed" au bord de la forme
	Color couleur;//permet de sauvegarder la couleur de la forme selectionner
	int i;//permet de sauvegarder l'indice de la forme selectionner
	int x,y;
	
	public Selection(ZoneDessin zd) {//On initialise 
		zoneDessin=zd;
		i=0;
		couleur=new Color(0,0,0);
		selection=false;
		pression=false;
		bord=false;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getButton()==MouseEvent.BUTTON1) {//Si on clique droit
			i=zoneDessin.taille();
			int dedans=-1;
			while (i>0 && dedans==-1) {//On regarde si on est dans une forme tout en parcourant le tableau
				i--;
				dedans=zoneDessin.get(i).Verif(e.getX(),e.getY());
			}
			
			if (dedans==1) {//Si on est dans la forme
				couleur= zoneDessin.get(i).getColor();//On sauvegarde la couleur
				zoneDessin.get(i).setColor(Color.RED);//On change la couleur de la forme pour du rouge
				selection=true;//On signale qu'une forme est selectionnée
			}
			
		}
		
		if (e.getButton()==MouseEvent.BUTTON3 && selection) {//si on clique gauche
			zoneDessin.get(i).setColor(couleur);//On deselectionne
			selection=false;
		}
		
		zoneDessin.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int dedans=zoneDessin.get(i).Verif(e.getX(),e.getY());
		
		if (selection==true && dedans==1) {//si on presse l'objet selectionnée
			x=e.getX();
			y=e.getY();//on sauvegarde les coordonnees de la souris
			pression=true;//on signale que la forme est "pressée"
			bord=false;//dans ce cas, le bord ne l'est pas 
		}
		
		else if (selection==true && dedans==0) {//si on presse le bord de l'objet 
			x=e.getX();
			y=e.getY();//on sauvegarde les coordonnees de la souris
			bord=true;//on signale que l'on est sur le bord
			pression=false;//dans ce cas, la forme n'est pas pressée 
			System.out.println(bord);
		}
		else {
			pression=false;//Sinon, rien n'est pressé
			bord=false;
		}
		zoneDessin.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if (pression==true) {//Si on a pressé la bonne forme
			try {
				zoneDessin.get(i).trans(e.getX()-x,e.getY()-y);//on translate la position de l'ancienne vers la position actuelle de la souris
			}
			
			catch (WrongOriginException WOE) {
				zoneDessin.get(i).setY(0);
				zoneDessin.get(i).setX(0);
			}
			x=e.getX();//On sauvegarde la position de la souris pour réitérer entre deux appels de mouseDragged
			y=e.getY();
			zoneDessin.repaint();
		}
		
		else if(bord==true) {//Si on presse le bord
			Forme2D F=zoneDessin.get(i);
			try {
				F.redim((int)(F.getSize()+0.5*((e.getX()-x)+(e.getY()-y))));//On redimensionne en fonction du deplacement de la souris
			}
			catch (WrongSizeException WSE) {
				System.err.println("Wrong Size Exception");
			}
			
			x=e.getX();//On sauvegarde la position de la souris pour réitérer entre deux appels de mouseDragged
			y=e.getY();
			zoneDessin.repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
//Deschamps Guillaume