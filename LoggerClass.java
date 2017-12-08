package SWESpiel.spiel;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerClass {

	private static final Logger logg = Logger.getLogger(LoggerClass.class.getName()); // gets full name of class if its in package
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileHandler fh;
		ConsoleHandler ch;
		try {
			fh = new FileHandler("myLogger.log");
			ch = new ConsoleHandler();
			logg.addHandler(fh);
			logg.addHandler(ch); // outputs as xml
			
			//level helps organize things
			
			fh.setLevel(Level.ALL);
			ch.setLevel(Level.ALL); 
			logg.setLevel(Level.ALL); // stellt das level meiner log: alles wird durch gehen
			logg.config("Configuration done");
			
			logg.removeHandler(ch);
			logg.log(Level.FINE, "fine log"); // Kompletes Loggen: sever, warnung, info
			
		}catch (IOException e) {
			logg.log(Level.SEVERE, "Error in fileHandler", e); // outputs to the console also the exception
		}
		logg.finer("Finest e.g on logger handler"); // level associated with level
	}

}
