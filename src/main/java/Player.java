
public class Player {
	private int score;
	private String name;
	
	Player(String name) {
		this.name = name;
		this.score = 0;
	} 
	
	public int getScore() {
		return score;
	}
	public void wonPoint() {
		this.score++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
