package player;

// Dick player always betrays
public class DickPlayer extends Player {

	private static final String TACTIC_NAME = "Dick";
	
	public String getTacticName() {
		return TACTIC_NAME;
	}
	
	public boolean play() {
		return true;
	}
}