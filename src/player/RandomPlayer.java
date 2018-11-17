package player;

// Random player betrays and cooperates at random
public class RandomPlayer extends Player {

	private static final String TACTIC_NAME = "Random";
	
	public String getTacticName() {
		return TACTIC_NAME;
	}
	
	public boolean play() {
		return Math.random() < 0.5;
	}
}
