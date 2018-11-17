package player;

// Tit-for-tat player cooperates on the first move, then copies the opponent’s last move.
public class TftPlayer extends Player {

	private static final String TACTIC_NAME = "Tit-for-tat";
	
	public String getTacticName() {
		return TACTIC_NAME;
	}
	
	public boolean play() {
		if(getGameCount() == 0) { 
			return false;
		}
		else if(opponantJustBetrayed()) {
			return true;
		}
		return false;
	}
}
