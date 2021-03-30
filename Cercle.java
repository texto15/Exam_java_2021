import java.awt.Color;
import java.awt.Graphics;

public class Cercle extends Forme2D {//Cf commentaire de la classe Carre : les fonctions sont identiques.
	
	private int d;
	private static int nbcercle;

	public Cercle () {
		d=5;
		nbcercle++;
	}
	
	public Cercle (int x, int y, int d, Color c) throws WrongSizeException {
		super(x,y,c);
		if(d>0) {
			this.d=d;
			nbcercle++;
		}
		
		else {
				throw new WrongSizeException();
			}
	}

	@Override
	public int area() {
		return ((int)(Math.PI*d/2*d/2));
	}

	@Override
	public void redim(int d) throws WrongSizeException {
		if(d>0) {
			this.d=d;
		}
		
		else {
				throw new WrongSizeException();
		}
		
	}

	@Override
	public void dessin(Graphics g) {
		g.setColor(this.getColor());
		g.fillOval(this.getX(),this.getY(),this.d,this.d);
		
	}

	@Override
	public int Verif(int x, int y) {
		int Px=x;
		int Py=y;
		int Cx=this.getX()+d/2;//On définie la position du centre du cercle, différente de sa postion (x,y);
		int Cy=this.getY()+d/2;
		
		if ((Px-Cx)*(Px-Cx)+(Py-Cy)*(Py-Cy)<(d/2-2)*(d/2-2)) {//On laisse de la marge pour faciliter la pression sur le bord
			return(1);
		}
		
		if ((Px-Cx)*(Px-Cx)+(Py-Cy)*(Py-Cy)>(d/2)*(d/2)) {
			return(-1);
		}
		
		else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return("Cercle:"+super.toString()+":"+Integer.toString(d)+":"+Integer.toString(this.area()));
	}
	
	protected void finalize() {
		nbcercle--;
	}
	
	public int getSize() {
		return d;
	}

}
//Deschamps Guillaume