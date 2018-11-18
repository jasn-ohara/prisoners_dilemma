package game;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

import player.*;

public class Game {
	Player playerA;
	Player playerB;
	
	int cooperatePoints;
	int temptationPoints;
	int suckerPoints;
	int punishmentPoints;
	
	File logFile;
	boolean logToStdout;

	public Game(Player a, Player b) { // Just set players
		playerA = a;
		playerB = b;
		
		setScoring(5, 10, 1, 3); // Default scoring system
		
		String logFileName = "PrisonersDilema_" + LocalDateTime.now().toString().replace(":", "").replace(".",  "") + ".txt";
		setLogging(logFileName, true); // Default log settings
	}
	
	public Game(Player a, Player b, int cp, int tp, int sp, int pp) { // Set players and scores
		this(a, b);
		setScoring(cp, tp, sp, pp);
	}
	
	public Game(Player a, Player b, String location, boolean toStdout) { // Set players and log location
		this(a, b);
		setLogging(location, toStdout);
	}
	
	public Game(Player a, Player b, int cp, int tp, int sp, int pp, String location, boolean toStdout) { // Set everything
		this(a, b, cp, tp, sp , pp);
		setLogging(location, toStdout);
	}
	
	public void setScoring(int cp, int tp, int sp, int pp) {
		cooperatePoints = cp;
		temptationPoints = tp;
		suckerPoints = sp;
		punishmentPoints = pp;
	}
	
	public void setLogging(String location, boolean toStdout) {
		logToStdout = toStdout;
		logFile = new File(location);
		try {
			Files.write(logFile.toPath(), "".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void log(String logString){
		try {
			Files.write(logFile.toPath(), logString.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (logToStdout) {
			System.out.println(logString);
		}
	}
	
	public void play() {
		boolean aBetray = playerA.play();
		boolean bBetray = playerB.play();
		
		String aTactic = playerA.getTacticName();
		String bTactic = playerB.getTacticName();
		
		String logString;
		
		if (aBetray && bBetray) {		
			playerA.lose(punishmentPoints);
			playerB.lose(punishmentPoints);
			
			logString = 
			"Player A - " + aTactic + " - Betray - " + punishmentPoints +"\n" +
			"Player B - " + bTactic + " - Betray - " + punishmentPoints + "\n" +
			"Current score: " + scoreString() + "\n\n";
		}
		else if (aBetray) {
			playerA.win(temptationPoints);
			playerB.lose(suckerPoints);
			
			logString = 
			"Player A - " + aTactic + " - Betray - " + temptationPoints + "\n" +
			"Player B - " + bTactic + " - Cooperate - " + suckerPoints + "\n" +
			"Current score: " + scoreString() + "\n\n";
		}
		else if (bBetray) {
			playerA.lose(suckerPoints);
			playerB.win(temptationPoints);
			
			logString = 
			"Player A - " + aTactic + " - Cooperate - " + suckerPoints + "\n" +
			"Player B - " + bTactic + " - Betray - " + temptationPoints + "\n" +
			"Current score: " + scoreString() + "\n\n";

		}
		else {
			playerA.win(cooperatePoints);
			playerB.win(cooperatePoints);
			
			logString = 
			"Player A - " + aTactic + " - Cooperate - " + cooperatePoints + "\n" +
			"Player B - " + bTactic + " - Cooperate - " + cooperatePoints + "\n" +
			"Current score: " + scoreString() + "\n\n";
		}
		log(logString);
	}
	
	public String scoreString() {
		return playerA.getScore() + " : " + playerB.getScore();
	}
	
}
