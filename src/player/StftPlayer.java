package player;

// Suspicious Tit-for-tat player betrays on the first move, then copies the opponent’s last move.
public class StftPlayer extends Player {
	
	private static final String TACTIC_NAME = "Suspicious Tit-for-tat";
	
	public String getTacticName() {
		return TACTIC_NAME;
	}
	
	public boolean play() {
		if(getGameCount() == 0) { 
			return true;
		}
		else if(opponantJustBetrayed()) {
			return true;
		}
		return false;
	}
}
