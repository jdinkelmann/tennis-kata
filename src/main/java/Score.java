import java.util.HashMap;
import java.util.Map;

public class Score {
	private Player player1;
	private Player player2;
	
	Score(Player playerOne, Player playerTwo) {
		this.player1 = playerOne;
		this.player2 = playerTwo;
	}
	
	public boolean isNormalScore() {
		return player1.getScore() <= 3 && player2.getScore() <= 3;
	}
	
	public boolean isTieScore() {
		return player1.getScore() == player2.getScore();
	}
	
	public boolean isAdvantageScore() {
		return player1.hasAdvantage(player2) || player2.hasAdvantage(player1);
	}
	
	public boolean isGameOver() {
		return player1.hasWon(player2) || player2.hasWon(player1);
	}
	
	public String getNormalScore() {
		return scoreName(player1.getScore()) + "-" + scoreName(player2.getScore());
	}
	
	public String getTieScore() {
		String scoreDescription = scoreName(player1.getScore());
		return player1.getScore() < 3 ? scoreDescription + "-All" : "Deuce";
	}
	
	public String getAdvantageScore() {
		Player playerWithAdvantage = player1.hasAdvantage(player2)? player1:player2;
		return "Advantage " + playerWithAdvantage.getName();
	}
	
	public String getWinningScore() {
		Player playerThatWon = player1.hasWon(player2)? player1:player2;
		return "Win for " + playerThatWon.getName();
	}
	
	private String scoreName(int score) {
		return scoreNames().get(score);
	}
	
	private static final Map<Integer, String> scoreNames() {
        return new HashMap<Integer, String>() {
            private static final long serialVersionUID = 1L;
            {
                put(0, "Love");
                put(1, "Fifteen");
                put(2, "Thirty");
                put(3, "Forty");
            }
        };
    }
	
}
