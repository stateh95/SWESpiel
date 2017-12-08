package SWESpiel.spiel;


	
	


//*import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table; 


//@Entity 
//@Table(name="Result")
public class BattleOutcome {
	
	private Integer row_nr;
	private KI winnName;
	private KI lossName;
	//fk
	private Move winnID;
	private Move lossID;
	private Spiel played_gameID;
	
	BattleOutcome() {}
	
	BattleOutcome(Integer row_nr, Move winnID, KI winnName, Move lossID, KI lossName, Spiel played_gameID) {
		init(row_nr, winnID, winnName, lossID, lossName, played_gameID);
	}
	 
	public void init(Integer row_nr, Move winnID, KI winnName, Move lossID, KI lossName, Spiel played_gameID) {
		this.row_nr = row_nr;
		this.winnID = winnID;
		this.winnName = winnName;
		this.lossID = lossID;
		this.lossName = lossName;
		this.played_gameID = played_gameID;
	}

	//@Id
	//@Column(name="row_nr") //PK
	public Integer getRow_nr(){
		return this.row_nr;
	}
	public void setRow_nr(Integer row_nr) {
		this.row_nr = row_nr;
	}

	//@Column(name = "winnName")
	public String getWinnName(){
		return this.winnName.getLastName();
	}
	public void setWinnName(KI winnName){
		this.winnName= winnName;
	}

	//@Column(name = "lossName")
	public String getLossName(){
		return this.lossName.getLastName();
	}
	public void setLossName(KI lossName){
		this.lossName= lossName;
	}
	
	//@Column(name = "played_gameID")
	public Integer getPlayed_gameID(){
		return this.played_gameID.getGameID();
	}
	
	public void setPlayed_gameID(Spiel played_gameID) {
		this.played_gameID = played_gameID;
	}

	//getting the winnID from Moves table
	//@ManyToOne(fetch = FetchType.LAZY) 
	//@JoinColumn(name = "winnID")
	public KI getWinnID(){
		return this.winnID.getMatrikelNr();
	}
	
	public void setWinnID(Move winnID){
		this.winnID = winnID;
	}
	
	//@ManyToOne(fetch = FetchType.LAZY) 
	//@JoinColumn(name = "lossID")
	public KI getLossID() {
		return this.lossID.getMatrikelNr();
	}
	public void setLossID(Move lossID) {
		this.lossID = lossID;
	}
	


}
