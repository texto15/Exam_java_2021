
public class WrongSizeException extends Exception {
	
	public WrongSizeException () {
		super("coté négatif");
	}
	
	public WrongSizeException(String s) {
		super(s);
	}

}
//Deschamps Guillaume