package SWESpiel.spiel;

import java.util.List;

public class Spiel {

	
	private Integer game_id;
	private String mergedMap;
	
	private KI matrikelnr_1;
	private KI matrikelnr_2;
	private List<Move> game_number;
	
	
	
	
	public Integer getGameID() {
		return this.game_id;
	}
	
	public void setGameID(Integer game_id) {
		this.game_id = game_id;
	} 
	
	
	public String getMergedMap(){
		return this.mergedMap;
	}
	public void setMergedMap(String mergedMap) {
		this.mergedMap = mergedMap;
	}
	
	public KI getMatrikelnr_1(){
		return this.matrikelnr_1; 
	}
	
	public void setmatrikelnr_1(KI matrikelnr_1) {
		this.matrikelnr_1 = matrikelnr_1;
	} 
	
	
	public KI getMatrikelnr_2(){
		return this.matrikelnr_2; 
	}
	
	public void setmatrikelnr_2(KI matrikelnr_2) {
		this.matrikelnr_2 = matrikelnr_2;
	}
	
	public List<Move> getgame_number() {
		return this.game_number;
	}
	
	public void setgame_number(List<Move> game_number){
		this.game_number = game_number;
	}
	
	
}
