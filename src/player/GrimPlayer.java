package player;

// Grim Trigger Player cooperates, until the opponent defects, and thereafter always defects
public class GrimPlayer extends Player {
	
	private static final String TACTIC_NAME = "Grim Trigger";
	private static boolean beenBetrayed = false;
	
	public String getTacticName() {
		return TACTIC_NAME;
	}
	
	public boolean play() {
		if(beenBetrayed) { 
			return true;
		}
		else if(getGameCount() == 0) { 
			return false;
		}
		if (opponantJustBetrayed()) {
			beenBetrayed = true;
			return true;
		}
		return false;
	}
}
