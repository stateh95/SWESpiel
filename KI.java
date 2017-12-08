package SWESpiel.spiel;

import java.util.ArrayList;
import java.util.List;

public class KI {

	private String matrikelnr;
	private String firstName;
	private String lastName;
	private String map;
	private  List<Spiel> playing_game =new ArrayList<>(); 
	private List<Move> matrikelnummer = new ArrayList<>();
	
	KI() {}   
	 
	//constructor with method init
	KI(String matrikelnr, String firstName, String lastName, String map) {
		init(matrikelnr, firstName, lastName, map);
	}
	
	//method for setters
	private void init(String matrikelnr, String firstName, String lastName, String map) {
		this.matrikelnr = matrikelnr;
		this.firstName = firstName;
		this.lastName = lastName;
		this.map = map;
		//this.playing_game= playing_game;
	}
	
	
	public String getMatrikelnr() {
		return this.matrikelnr;
	}
	
	public void setMatrikelnr(String matrikelnr){
		this.matrikelnr = matrikelnr;
	}
	
	//@Column(name = "firstName")
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	///@Column(name = "lastName")
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	///@Column(name = "map")
	public String getMap() {
		return this.map;
	}
	public void setMap(String map) {
		this.map = map;
	}
	
	//gets fk matrikelnr1/2 in Game table
	//@OneToMany (targetEntity = AI.class, fetch = FetchType.LAZY, mappedBy = "playing_game", 
				//cascade = CascadeType.ALL)
	public List<Spiel> getplaying_game(){
		return this.playing_game;
	}
	
	public void setplaying_game(List<Spiel> playing_game) {
		this.playing_game = playing_game;
	}
	
	//for fk matrikelNr in table Moves
	
	///@OneToMany(targetEntity = AI.class, fetch = FetchType.LAZY, mappedBy = "matrikelnummer", 
			//	cascade = CascadeType.ALL)
	public List<Move> getmatrikelnummer() {
		return this.matrikelnummer;
	}
	
	public void setmatrikelnummer(List<Move> matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}
	
	
	
	
}
