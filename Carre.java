import java.awt.Color;
import java.awt.Graphics;

public class Carre extends Forme2D {
	//Ici, comme pour la classe Cercle, Eclipse me donne une erreur et m'annonce que je dois impl�menter compareTo car elle est abstraite.
	//Le probl�me est que je ne l'ai pas d�clar�e abstraite, et en ignorant cette erreur, le code n'a jamais plant� a cause de compareTo
	
	private int cote;
	private static int nbcarre;
	
	public Carre(int c) throws WrongSizeException {
		if(c>0) {//On v�rifie que le cote est bien strictement positif
			cote=c;
			nbcarre++;
		}
		
		else {
				throw new WrongSizeException();
			}
	}
	
	public Carre() {//Constructeur sans arguement
		cote=5;
		nbcarre++;
	}
	
	public Carre(int x, int y, int c, Color col) throws WrongSizeException {
		super(x,y,col);
		if(c>0) {//On v�rifie que le cote est bien strictement positif
			cote=c;
			nbcarre++;
		}
		
		else {
				throw new WrongSizeException();
			}
	}

	@Override
	public int area() {
		return (cote*cote);
	}

	@Override
	public void  redim(int c) throws WrongSizeException {
		if(c>0) {//On v�rifie que le cote est bien strictement positif
			cote=c;
		}
		
		else {
				throw new WrongSizeException();
		}
	}

	@Override
	public void dessin(Graphics g) {//Permet de dessiner le carre sur la zonedessin
		g.setColor(this.getColor());
		g.fillRect(this.getX(),this.getY(),this.cote,this.cote);
	}

	@Override
	public int Verif(int x, int y ) {//On v�rifie qu'un point de coordonn�e x et y est bien sur la forme
		int Px=x;
		int Py=y;
		int Cx=this.getX();
		int Cy=this.getY();
		
		if (Px<Cx+cote && Px>Cx && Py<Cy+cote && Py>Cy) {//si le coordonnees du points sont dans la forme strictement
			return(1);
		}
		
		if (Px>Cx+cote || Px<Cx || Py>Cy+cote || Py<Cy) {//si au moins une des coordonnees n'est pas dans la forme strictement
			return(-1);
		}
		
		else {
			return 0;//sinon, c'est-�-dire lorsque l'on est sur le contour strictement.
		}
	}
	
	@Override
	public String toString() {
		return("Carre:"+super.toString()+":"+Integer.toString(cote)+":"+Integer.toString(this.area()));
	}
	
	protected void finalize() {
		nbcarre--;
	}
	
	public int getSize() {
		return cote;
	}

}
//Deschamps Guillaume