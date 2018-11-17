package game;

import player.*;

public class Game {
	Player playerA;
	Player playerB;
	
	int cooperatePoints;
	int temptationPoints;
	int suckerPoints;
	int punishmentPoints;

	public Game(Player a, Player b) {
		playerA = a;
		playerB = b;
		
		// Default scoring system
		cooperatePoints = 5;
		temptationPoints = 10;
		suckerPoints = 1;
		punishmentPoints = 3;
	}
	
	public Game(Player a, Player b, int cp, int tp, int sp, int pp) {
		playerA = a;
		playerB = b;
		
		cooperatePoints = cp;
		temptationPoints = tp;
		suckerPoints = sp;
		punishmentPoints = pp;
	}
	
	public void play() {
		boolean aBetray = playerA.play();
		boolean bBetray = playerB.play();
		String aTactic = playerA.getTacticName();
		String bTactic = playerB.getTacticName();
		
		if (aBetray && bBetray) {
			System.out.println("Player A (" + aTactic + ") has betrayed and gained the punishment score of " + punishmentPoints);
			System.out.println("Player B (" + bTactic + ") has betrayed and gained the punishment score of " + punishmentPoints);
			playerA.lose(punishmentPoints);
			playerB.lose(punishmentPoints);
		}
		else if (aBetray) {
			System.out.println("Player A (" + aTactic + ") has betrayed and gained the temptation score of " + temptationPoints);
			System.out.println("Player B (" + bTactic + ") has cooperated and gained the sucker score of " + suckerPoints);
			playerA.win(temptationPoints);
			playerB.lose(suckerPoints);
		}
		else if (bBetray) {
			System.out.println("Player A (" + aTactic + ") has cooperated and gained the sucker score of " + suckerPoints);
			System.out.println("Player B (" + bTactic + ") has betrayed and gained the temptation score of " + temptationPoints);
			playerA.lose(suckerPoints);
			playerB.win(temptationPoints);
		}
		else {
			System.out.println("Player A (" + aTactic + ") has cooperated and gained the cooperatoion score of " + cooperatePoints);
			System.out.println("Player B (" + bTactic + ") has cooperated and gained the cooperatoion score of " + cooperatePoints);
			playerA.win(cooperatePoints);
			playerB.win(cooperatePoints);
		}
	}

	public int[] scores() {
		return new int[] {playerA.getScore(), playerB.getScore()};
	}
	
	public String scoreString() {
		return "Player A (" + playerA.getTacticName() + ") scored: " + playerA.getScore() +
				"\n"  +
				"Player B (" + playerB.getTacticName() + ") scored: " + playerB.getScore();
	}
	
}
