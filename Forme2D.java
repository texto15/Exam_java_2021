import java.awt.Color;
import java.awt.Graphics;

public abstract class Forme2D extends Point2D implements Comparable {
	//Forme2D est abstraite car on instancie jamais de Forme2D

	private Color col;
	private static int nb = 0;
	
	public Forme2D() { //constructeur sans arguements
		col=Color.BLUE;
		nb++;//on incr�mente le nombre de forme2D
	}
	
	public Forme2D(int x, int y, Color col) throws WrongOriginException {
		super(x,y);
		if (x>=0 || y>=0) {
			throw new WrongOriginException();
		}
		else {
			setColor(col);
			nb++;//on incr�mente le nombre de forme2D
		}
	}
	
	public abstract int area ();
	
	public void trans(int dx,int dy) throws WrongOriginException {
		if (this.getX()+dx<=0 || this.getY()+dy<=0) { //On v�rifie que la translation ne donne pas de coordonn�es n�gatives
			throw new WrongOriginException();
		}
		else {
			this.setX(this.getX()+dx);
			this.setY(this.getY()+dy);
		}
		
	}
	
	public abstract void redim(int c) throws WrongSizeException;
	
	public Color getColor() {
		return (col);
	}
	
	public void setColor(Color col) {
		this.col=col;
	}
	
	public String toString() {
		return(super.toString()+":"+col.toString());
	}
	
	public abstract void dessin(Graphics g);//Cette fonction est appel� par paint et permet de dessiner la forme2D
	
	public int compareTo (Forme2D F) {//On impl�mente compareTo en fonction de la convention
		if (this.area()<F.area()) { return (-1);} //On retourne -1 si l'objet en argument est plus petit
		if (this.area()>F.area()) { return (1);	}//et 1 s'il est plus grand
		else {return 0;}//Si les deux sont egaux, on retourne 0
	}
	
	public abstract int Verif(int x, int y);
	
	protected void finalize() {//Lorsqu'un objet de la classe est d�truit, finalize est appel�, on d�cr�mente ainsi le nombre d'�l�ments forme2D
		nb--;
	}
	
	public abstract int getSize();
	

}
//Deschamps Guillaume