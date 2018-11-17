package player;

// Naive player never betrays
public class NaivePlayer extends Player {
	
	private static final String TACTIC_NAME = "Naive";
	
	public String getTacticName() {
		return TACTIC_NAME;
	}
	
	public boolean play() {
		return false;
	}
}
