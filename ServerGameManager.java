package SWESpiel.spiel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

import javax.jws.soap.SOAPBinding.Use;

public class ServerGameManager implements Runnable {
	
	private static Logger logg = Logger.getLogger(ServerGameManager.class.getName());
	protected Socket playerOne= null;
	protected Socket playerTwo = null;
	Gson gson = new Gson();

	public ServerGameManager(Socket playerOne, Socket playerTwo, int i) {
		// TODO Auto-generated constructor stub
		this.playerOne= playerOne;
		this.playerTwo=playerTwo;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		try {
			//opens printwriter and bufferedreader on socket
			// we use the socket connection to the client to make a PrintWriter
			//wir ver
			PrintWriter out = new PrintWriter(playerOne.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(playerOne.getInputStream()));
			
			//get user message
			String user = in.readLine();
			User connectedUser = gson.fromJson(user, User.class);
			logg.info("Connected user1: " + connectedUser.getUser1FirstName()+ " " +connectedUser.getUser1LastName()+ " "+ connectedUser.getUser1Matrikelnr());
			logg.info("Connected user2: " + connectedUser.getUser2FirstName() + " " + connectedUser.getUser2LastName()+ " "+ connectedUser.getUser2Matrikelnr());
			 
			//send map message
			String map = in.readLine();
			Map clientMap = gson.fromJson(map, Map.class);
			logg.info("Client1 map: " + clientMap.getMap1());
			logg.info("Client2 map: " + clientMap.getMap2());
			
			//disconnect players message
			String disconnect = in.readLine();
			DisconnectKI playersDisconnected = gson.fromJson(disconnect, DisconnectKI.class);
			logg.info( playersDisconnected.disconnect());

			
			out.close();
			in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
