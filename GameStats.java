package v6_30Dec22;
import java.util.Random;
public class GameStats {

	
	//initialize variables
	private int rng;
	private int playerPower;
	private int goblinCount;
	private int hordeMultiplier;
	
	
	
	
	
	//Constructor
	public GameStats() {
		this.rng = 0;
		this.playerPower = 0;
		this.goblinCount = 0;
		this.hordeMultiplier = 0;
	}
	
	
	
	
	
	//getter
	public int getRng() {
		return this.rng;
	}
	public int getPlayerPower() {
		return this.playerPower;
	}
	public int getGoblinCount() {
		return this.goblinCount;
	}
	public int getHordeMultiplier() {
		return this.hordeMultiplier;
	}
	
	
	
	
	
	
	public static GameStats calculateGameStats(Stats playerStats , Random scanrng) {
		GameStats gameStats = new GameStats();

		
		int rng = scanrng.nextInt(100) + 1;
		gameStats.rng = rng;
		
	
		gameStats.playerPower = 
				((playerStats.getHealth()) 
				+ (playerStats.getAttack() * 10) 
				+ (playerStats.getLuck() * 10) 
				+ playerStats.getCoin()) 
				/ 4;
		

		gameStats.goblinCount = (rng - 11) / 30;
		gameStats.goblinCount++;
		

		gameStats.hordeMultiplier = 
				((playerStats.getHealth()) 
				+ (playerStats.getAttack() * 10) 
				+ ((100 - playerStats.getLuck() * 10)) 
				+ (gameStats.goblinCount * 100) 
				+ playerStats.getCoin()) 
				/ 5;

		
		return gameStats;
	}
}
