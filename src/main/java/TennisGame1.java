import java.util.HashMap;
import java.util.Map;

public class TennisGame1 implements TennisGame {

	private Player player1;
	private Player player2;

	public TennisGame1(String player1Name, String player2Name) {
		this.player1 = new Player(player1Name);
		this.player2 = new Player(player2Name);
	}

	public void wonPoint(String playerName) {
		Player winner = whoWonThePoint(playerName);
		winner.wonPoint();
	}

	private Player whoWonThePoint(String playerName) {
		return player1.getName().equals(playerName) ? player1 : player2;
	}

	public String getScore() {
		String score = "";
		
		Score scoreBoard = new Score(player1,player2);
		
		if(scoreBoard.isTieScore()) {
			score = scoreBoard.getTieScore();
		} else if(scoreBoard.isAdvantageScore()) {
			score = scoreBoard.getAdvantageScore();
		} else if (scoreBoard.isGameOver()) {
			score = scoreBoard.getWinningScore();
		} else {
			score = scoreBoard.getNormalScore();
		}

//		
//		
//		int tempScore = 0;
//		int player1Score = player1.getScore();
//		int player2Score = player2.getScore();
//		if (scoreBoard.isTieScore()) {
//			score = scoreBoard.getTieScore();
//		} else if (player1Score >= 4 || player2Score >= 4) {
//			int minusResult = player1Score - player2Score;
//			if (minusResult == 1)
//				score = "Advantage player1";
//			else if (minusResult == -1)
//				score = "Advantage player2";
//			else if (minusResult >= 2)
//				score = "Win for player1";
//			else
//				score = "Win for player2";
//		} else {
//			for (int i = 1; i < 3; i++) {
//				if (i == 1)
//					tempScore = player1Score;
//				else {
//					score += "-";
//					tempScore = player2Score;
//				}
//				switch (tempScore) {
//				case 0:
//					score += "Love";
//					break;
//				case 1:
//					score += "Fifteen";
//					break;
//				case 2:
//					score += "Thirty";
//					break;
//				case 3:
//					score += "Forty";
//					break;
//				}
//			}
//		}
		return score;
	}
}
