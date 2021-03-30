
public abstract class Point2D {
	
	private int x,y; //Attributs de la classe
	
	public Point2D (){ //Construceurs sans arguemnts
		x=0;
		y=0;
	}
	
	public Point2D (int x, int y) {
		setX(x);
		setY(y);
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String toString() {
		return ("(x,y)=("+Integer.toString(x)+","+Integer.toString(y)+")");
	}
	
}
//Deschamps Guillaume