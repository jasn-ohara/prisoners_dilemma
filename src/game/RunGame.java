package game;

import java.util.Random;
import player.*;

public class RunGame {	
	public static void main(String[] args) {
		// Run for 100 iterations of the game for two random strategies
		runRandomGame(100);
	}
	
	public static void runGames(int iter, Player pa, Player pb) {
		Game g = new Game(pa, pb);
		for (int i = 0; i < iter; i ++) {
			System.out.println("Round " + (i + 1) + ":");
			g.play();
		}
		String finalScores = "Final Scores:\n" + g.scoreString();
		g.log(finalScores);
	}
	public static void runRandomGame(int iter) {
	
		Player[] allPlayerTypes = new Player[] {
			new NaivePlayer(),
			new DickPlayer(),
			new RandomPlayer(),
			new TftPlayer(),
			new StftPlayer(),
			new GrimPlayer()
			};
		
		Player randomPlayerA = allPlayerTypes[new Random().nextInt(allPlayerTypes.length)];
		Player randomPlayerB = allPlayerTypes[new Random().nextInt(allPlayerTypes.length)];
		
		runGames(iter, randomPlayerA, randomPlayerB);
		;
	}
}
