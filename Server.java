package SWESpiel;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import SWESpiel.spiel.ServerGameManager;

/**
 * 
 * Das Server erstellt ein socket und hoert zu auf Verbindungen von den 2 Spieler in einen Spiel session.
 * Jede Sessioin ist von eine Thread behandelt, AICI CEVA, das die Kommuinkation zwischen den zwei Spieler erstellet und 
 * stellt der Status Fest
 * DEUTSCHHHH
 */

public class Server implements Runnable {
	

public static void main(String[] args) throws IOException {
	
	private static Logger logg = Logger.getLogger(Server.class.getName());
	
	protected int serverPort = 4567; // default port number 
	protected ServerSocket serverSocket = null;
	protected boolean isStopped = false;
	protected Thread runningThread = null;
	protected ExecutorService threadPool = Executors.newFixedThreadPool(2); //each request gives thread from pool
	
	public Server (int port) {
		this.serverPort = port;
	}
	
	public void run() { // ein thread nach  einandere (anfrage von client sich zu verbinden)
		synchronized (this) {
			this.runningThread = Thread.currentThread(); // Threads from pool
		} 
		openServerSocket();
        
        String hostAddress    = InetAddress.getLocalHost().getHostAddress();
        ServerSocket listener = null;
        int sessionNumber     = 1;
        
        try {
            listener = new ServerSocket(4567);
            System.out.println("Server start @ " + hostAddress);
            System.out.println("Warten auf Verbindung...\n");
            
            while (true) {
                Socket playerOne = listener.accept();
                System.out.println("Session " + sessionNumber + 
                                   ": Spieler  1 has joined the session");
                
                Socket playerTwo = listener.accept();
                System.out.println("Session " + sessionNumber + 
                                   ": Spieler 2 has joined the session");
                
                Thread session = new Thread(new ServerGameManager(
                        playerOne, playerTwo, sessionNumber++));
                session.setDaemon(true);
                session.start();
            }
        }
        
        finally { listener.close(); }
    }


	private void openServerSocket() {
		try {
			this.serverSocket = new ServerSocket(this.serverPort);
		}catch (IOException e) {
			throw new RuntimeException("Server cannot be opened on port: "+ this.serverPort,e);
			}
		
		private synchronized boolean isStopped() {
			// TODO Auto-generated method stub
			return this.isStopped;
		}

		private void stopServer() {
			this.isStopped = true;
			try {
				this.serverSocket.close();
			} catch(IOException e) {
				throw new RuntimeException("Error while closing server",e);
			}
		}

	}
	


