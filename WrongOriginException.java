
public class WrongOriginException extends Error {
	
	public WrongOriginException () {
		super("Origine n�gative");
	}
	
	public WrongOriginException(String s) {
		super(s);
	}

}
//Deschamps Guillaume