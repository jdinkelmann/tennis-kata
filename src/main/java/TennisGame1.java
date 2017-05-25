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
		Score scoreBoard = new Score(player1, player2);

		if (scoreBoard.isTieScore()) {
			score = scoreBoard.getTieScore();
		} else if (scoreBoard.isAdvantageScore()) {
			score = scoreBoard.getAdvantageScore();
		} else if (scoreBoard.isGameOver()) {
			score = scoreBoard.getWinningScore();
		} else {
			score = scoreBoard.getNormalScore();
		}

		return score;
	}
}
