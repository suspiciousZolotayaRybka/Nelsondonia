package v6_30Dec22;
import java.util.Scanner;
import java.util.Random;
public class Stats {
	
	
	
	/* TODO
	 * 
	 * Create toString method that is NOT STATIC
	 * 
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static final String[] PLAYER_STATS = {"Health" , "Attack" , "Luck" , "Coin"};
	Random scanrng = new Random();
	
	//Initialize class
	private int health;
	private int attack;
	private int luck;
	private int coin;

	
	
	
	
	//Constructor randomized
	public Stats() {
		this.health = scanrng.nextInt(100) + 1;
		this.attack = scanrng.nextInt(10) + 1;
		this.luck = scanrng.nextInt(10) + 1;
		this.coin = scanrng.nextInt(100) + 1;
	}


	
	
	
	//Constructor used for monster stats
	public Stats(int h , int a , int l , int c) {
		this.health = h;
		this.attack = a;
		this.luck = l;
		this.coin = c;
	}

	
	
	
	
	
	//getter
	public int getHealth() {
		return this.health;
	}
	public int getAttack() {
		return this.attack;
	}
	public int getLuck() {
		return this.luck;
	}
	public int getCoin() {
		return this.coin;
	}
	
	
	
	
	
	//setter
	public void setHealth(int health) {
		this.health = health;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public void setCoin(int coin) {
		this.coin = coin;
	}
	
	
	//printStats method
	public static String toString(Stats characterStats , String characterName) {
		return String.format("=================\n"
				+ "%-16s|\n"
				+ "+===+=========== ====\n"
				+ "| 1 | %-11s%d\n"
				+ "+===+=========== ====\n"
				+ "| 2 | %-11s%d\n"
				+ "+===+=========== ====\n"
				+ "| 3 | %-11s%d\n"
				+ "+===+=========== ====\n"
				+ "| 4 | %-11s%d\n"
				+ "+===+=========== ===="
				, characterName
				
				, PLAYER_STATS[0] , characterStats.health
				
				, PLAYER_STATS[1] , characterStats.attack
				
				, PLAYER_STATS[2] , characterStats.luck
				
				, PLAYER_STATS[3] , characterStats.coin);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//All methods below this line are for playerStats ONLY
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//rerollStats method
	public static Stats processRerollChoice(Stats characterStats , int rerollChoice , Random scanrng) {
		
		
		switch (rerollChoice) {
		case 1:
			characterStats.health = scanrng.nextInt(100) + 1;
			break;
		case 2:
			characterStats.attack = scanrng.nextInt(10) + 1;
			break;
		case 3:
			characterStats.luck = scanrng.nextInt(10) + 1;
			break;
		case 4:
			characterStats.coin = scanrng.nextInt(100) + 1;
			break;
		}
		return characterStats;
	}
	
	
	
	
	
	public static Stats rerollStats(String NEW_PAGE , String BEACH , String playerName 
			, Scanner scanint , Random scanrng 
			, boolean errorCatching
			, Stats playerStats) {
		
		//allowing player to reroll their stats, allowing two attempts for any stat
		int rerollChoice = 0; //used to access the menu to reroll a player's stat
		for (int rerollCounter = 1; rerollCounter <= 2; rerollCounter++) {
			System.out.print(NEW_PAGE);
			System.out.print(BEACH);

			System.out.println(Stats.toString(playerStats , playerName));
			
			System.out.println("| 5 | Continue   ...\n"
					+ "================ ===="
					+ "\n\nChoose a stat to reroll or choose 5 to continue with these stats.");
			
			System.out.printf("On reroll %d of 2\n"
					+ "=> \n" , rerollCounter);

			rerollChoice = Try.getInt(1 , 5 , scanint);
			
			//The code menu for deciding which stat to reroll.
			
			
			if (rerollChoice == 5) {
				//Player chooses 5 to Continue
				rerollCounter = 2;
			} else {
				//Player chooses 1-4 to reroll a stat
				playerStats = Stats.processRerollChoice(playerStats, rerollChoice, scanrng);
			}
			
		}
		return playerStats;
	}
	
	
	
	
	





	
	
	//getStatLengths method NOTE: not currently in use /excess code
	public static int[] getStatLengths (Stats characterStats) {
		int[] statLengths = new int[4];
		statLengths[0] = (String.valueOf(characterStats.health).length());
		statLengths[1] = (String.valueOf(characterStats.attack).length());
		statLengths[2] = (String.valueOf(characterStats.luck).length());
		statLengths[3] = (String.valueOf(characterStats.coin).length());
		return statLengths;
	}
	
	
	
	
	















}
