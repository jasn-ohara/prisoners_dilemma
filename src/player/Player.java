package player;

public abstract class Player {
	int score;
	int gameCount;
	boolean[] opponentHistory;
	String tacticName;
	
	public Player() {
		score = 0;
		gameCount = 0;
		opponentHistory = new boolean[1000]; 
		tacticName = "Undefined";
	}
	
	public int getScore() {
		return score;
	}
	
	public int getGameCount() {
		return gameCount;
	}
	
	public boolean[] getOpponentHistory(){
		return opponentHistory;
	}
	
	public boolean opponantJustBetrayed() {
		return getOpponentHistory()[getGameCount() - 1]; 
		
	}
	public void lose(int penalty) {
		opponentHistory[gameCount] = true;
		gameCount ++;
		score += penalty;
	}
	
	public void win(int reward) {
		opponentHistory[gameCount] = false;
		gameCount ++;
		score += reward;
	}
	
	public abstract String getTacticName();
	public abstract boolean play();
}

