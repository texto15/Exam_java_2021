import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

public class ZoneDessin extends Component {
	
	private ArrayList<Forme2D> list;//Liste qui contient les Forme2D 
	private JPanel panDessin;//Panel sur lequel on dessine
	private boolean cercle=false;//Permet de savoir si on trace des cercles ou des carre, en lien avec ActionCercle et ActionCarre
	Selection select;//Permet de savoir si un objet est selctionner a l'écran
	
	
	public ZoneDessin() {
		panDessin=new JPanel();
		list=new ArrayList<Forme2D>();
		this.setFocusable(true);
		this.addKeyListener(new MyListener(this));
		select=new Selection(this);
		this.addMouseListener(select);
		this.addMouseMotionListener(select);
	}

	public void add(Forme2D f) {//Permet d'ajouter une forme a la liste
		list.add(f);
	}
	
	public void delete() {//Permet de retirer la dernière forme de la liste
		int size=list.size()-1;
		if (size>=0) {
			list.remove(size);
		}
		
	}
	
	public Forme2D get(int i) {//On accede a l'élément i de la liste
		return (list.get(i));
	}
	
	public void trier() {//On trie la liste par ordre de taille, du plus grand au plus petit, Fonctionne pour les listes contennant des carres et des cercles 
		int i=0;
		Forme2D tmp;
		//Méthode de tri simple, elements comparés deux a deux
		while (i<list.size()-1) {
			int tri=list.get(i).compareTo(list.get(i+1));
			if (tri==-1) {
				tmp=list.get(i);
				list.set(i, list.get(i+1));
				list.set(i+1, tmp);
				i=0;
			}
			else {
				i++;
			}
			repaint();
		}
	}
	
	public boolean getForme() {//On accede au boolean pour savoir si on ajoute des cercle ou des carre a la liste
		return cercle;
	}
	
	public void setForme(boolean b) {//On change 
		cercle=b;
	}
	
	public int taille() {//On accede a la taille de la liste
		return(list.size());
	}
	
	public void paint(Graphics g) {//On trace les forme2D grace à la fonction forme2D.dessin 
		super.paint(g);
		int i=0;
		g.setColor(Color.WHITE);//On met un fond blanc
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for (i=0;i<list.size();i++) {
			list.get(i).dessin(g);//On dessine 1 à 1 les elements de zoneDessin
		}
	}

}
//Deschamps Guillaume