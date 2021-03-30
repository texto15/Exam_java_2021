
public class WrongOriginException extends Error {
	
	public WrongOriginException () {
		super("Origine négative");
	}
	
	public WrongOriginException(String s) {
		super(s);
	}

}
//Deschamps Guillaume