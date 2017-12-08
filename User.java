package SWESpiel.spiel;

public class User {
public String getUser1FirstName() {
		
		String firstName = "Horia";
		return firstName; 
	}
	
	public String getUser1LastName() {
		String lastName = "State";
		return lastName;
		
	}
	public String getUser1Matrikelnr() {
		String matrikelnr = "01407549";
		return matrikelnr;
	}
	
	public String getUser2FirstName() {
		
		String firstName = "Sonia";
		return firstName ;
	}
	
	public String getUser2LastName() {
		String lastName = "Suciu";
		return lastName;
	}
	
	public String getUser2Matrikelnr() {
		String matrikelnr = "01503424";
		return matrikelnr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		user.getUser1FirstName();
		user.getUser1LastName();
		user.getUser1Matrikelnr();
		user.getUser2FirstName();
		user.getUser2LastName();
		user.getUser2Matrikelnr();

	}

}
