package SWESpiel.spiel;

import java.util.ArrayList;
import java.util.List;

public class Move {

	private Integer rowNr;
	private Integer turnKI; 
	private Integer nrOfMoves;
	private String type;
	private String time;
	private String treasurePickUp;
	private String conquerCastle;
	//Fremde Schlussel
	private Spiel gameNumber;
	private KI matrikelNr;
	
private List<BattleOutcome> winn_id = new ArrayList<>();
	
	Move() {}
	
	Move(Integer rowNr,Spiel gameNumber,KI matrikelNr,Integer turnAI, Integer nrOfMoves,
			String type, String time, String treasurePickUp, String conquerCastle) {
		init(rowNr,gameNumber, matrikelNr, turnAI, nrOfMoves, type, time, treasurePickUp, conquerCastle);
	}
	
	public void init(Integer rowNr, Spiel gameNumber,KI matrikelNr,Integer turnKI,Integer nrOfMoves, 
			String type, String time, String treasurePickUp, String conquerCastle ) {
this.rowNr = rowNr;
this.gameNumber = gameNumber;
this.matrikelNr = matrikelNr;
this.turnKI = turnKI;
this.nrOfMoves = nrOfMoves;
this.type = type;
this.time = time;
this.treasurePickUp = treasurePickUp;
this.conquerCastle = conquerCastle;
}
	
	
	//@Id
	//(name = "rowNr") //pk
	public Integer getRowNr(){
		return this.rowNr;
	}
	public void setRowNr(Integer rowNr){
		this.rowNr = rowNr;
	}
	
	//@Column(name = "turnKI") 
	public Integer getTurnKI() {
		return this.turnKI;
	}
	
	public void setTurnKI(Integer turnKI) {
		this.turnKI = turnKI;
	}
	
	//@Column(name= "nrOfMoves")
	public Integer getNrOfMoves(){
		return this.nrOfMoves;
	}
	
	public void setNrOfMoves(Integer nrOfMoves){
		this.nrOfMoves = nrOfMoves;
	}
	
	///@Column(name = "type") 
	public String getType(){
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	//for now i left it String
	///@Column(name= "time")
	public String getTime(){
		return this.time;
	}
	
	public void setTime(String time){
		this.time = time;
	}
	
	///@Column(name= "treasurePickUp")
	public String getTreasurePickUp(){
		return this.treasurePickUp;
	}
	
	public void setTreasurePickUp(String treasurePickUp){
		this.treasurePickUp = treasurePickUp;
	}
	
	///@Column(name= "conquerCastle")
	public String getConquerCastle(){
		return this.conquerCastle;
	}
	
	public void setConquerCastle(String conquerCastle){
		this.conquerCastle = conquerCastle;
	}
	
	//helps get fk gameNumber from Game table
	///@ManyToOne( fetch = FetchType.LAZY)
	///@JoinColumn(name = "gameNumber")
	public Spiel getGameNumber(){
		return this.gameNumber;
	}
	public void setGameNumber(Spiel gameNumber){
		this.gameNumber = gameNumber;
	}
	
	//for fk matrikelNr from table AI
	//@ManyToOne (fetch = FetchType.LAZY)
	//@JoinColumn (name = "matrikelNr")
	public KI getMatrikelNr() {
		return this.matrikelNr;
	}
	
	public void setMatrikelNr(KI matrikelNr) {
		this.matrikelNr = matrikelNr;
	}
	
	//for fk winnID in table OutCome
	//@OneToMany(targetEntity = Move.class, fetch = FetchType.LAZY, 
				///cascade = CascadeType.ALL, mappedBy = "winn_id")
	public List<BattleOutcome> getwinn_id() {
		return this.winn_id;
	}
	public void setwinn_id(List<BattleOutcome> winn_id) {
		this.winn_id = winn_id;
	}
	
}
	

