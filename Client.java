package SWESpiel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import SWESpiel.spiel.DisconnectKI;
import SWESpiel.spiel.Gson;
import SWESpiel.spiel.Map;
import SWESpiel.spiel.User;

public class Client {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Gson gson = new Gson();
		
		Socket clientSocket = new Socket("127.0.0.1", 4567);
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		//client sends message to server: connect
		User user = new User();
		user.getUser1FirstName();
		user.getUser1LastName();
		user.getUser1Matrikelnr();
		
		user.getUser2FirstName();
		user.getUser2LastName();
		user.getUser2Matrikelnr();
		out.println(((Gson) gson).toJson(user));
		
		//client sends message to server: get my map
		Map map = new Map();
		map.getMap1(); 
		map.getMap2();
		out.println(gson.toJson(map));
		
		//disconnect message
		DisconnectKI disconnect = new DisconnectKI();
		disconnect.disconnect();
		out.println(gson.toJson1(disconnect));
		
		in.close();
		out.close();
		clientSocket.close();
	}

}


