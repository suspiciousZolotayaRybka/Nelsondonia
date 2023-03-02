package v6_30Dec22;
import java.util.Random;
import java.util.Scanner;
/* TODO
 * 
 * Create toString method in Stats that is not STATIC
 * 
 * 
 * change bartenderComment to difficulty rating, add difficulty rating to gameStats
 * Add store keeper comment based on difficultyRating, add storeDiscount and shopman advise (return tomorrow, prices are high today)
 * based on difficultyRating
 * 
 * 
 * Make it so PlayerVisitsBar and PlayerVisitsMarket are instance and not static
 * PlayerVisitsMarket(); 
 * not 
 * PlayerVisitsMarket.playerVisitsMarket();
 * 
 * 
 * marketItems will need to be updated whenever player visits Norris's house. Will need to make it so if item in playerBackpack is True
 * it will not spawn in marketItems
 * 
 */
public class TestClient {

	public static void main(String[] args) {
		
		
		
		
		
		
		/*TABLE OF CONTENTS & DECLARING VARIABLES (SKIP TO LINE 86 FOR PROGRAM)
		 *   
		 * 1 Assigning Final Variables
		 *   Line 74
		 */
		//final String HEADER; //the header required in "HowToNameSubmissions.docx"
		final String NEW_PAGE; //used to take the player to a new page
		//Random and Scanner
		Random scanrng = new Random(); //used to determine random events in the game
		Scanner scanstr = new Scanner(System.in); //used for the players name
		Scanner scanint = new Scanner(System.in); //used for menu options
		
		
		 /*  2 Intro
		 *   Line 91
		 */ 
		boolean viewingStory = true; 
		
		
		 /* 3 choosePlayerName and rerollStats
		 *   Line 103
		 */
		String playerName = "PLACEHOLDER"; //the player's name 
		Stats playerStats = new Stats(100 , 5 , 8 , 100); //health, attack, luck, and coin
		GameStats gameStats = new GameStats(); //rng, goblinCount, playerPower, and hordeMultiplier
		
		
		/* 4 Norris
		 * Line 119
		 */
		
		
		/*   5 Visiting Town
		 *   Line 131
		 */
		boolean visitingTown = true; //true for as long as the player decides to visit the town
		int townChoice = 0; //the player option for where to visit in town
		//playerVisitsMarket
		Items playerBackpack = new Items();
		Items marketItems = new Items(scanrng);
		//Uses playerStats.getLuck to determine if the player gets a 25% discount at the market
		marketItems.setItemLuck(playerStats , scanrng);
		
		//playerVisitsNorris
		boolean kingCrabIsDefeated = false;
		
		//playerVisitsBar
		String bartenderComment = ""; //a comment the bartender gives to the player that gives a hint at how difficult the upcoming battle will be

		//Declared variables used throughout the program
		boolean errorCatching = true; //Used to test if the player entered correct info
		

		

		
		
		
		//1 Assigning FINAL Variables
		/*
		HEADER = "Nelsondonia\n"
				+ "A goblin fighting game by Isaac Finehout\n"
				+ "Made in honor of SSgt Brandon Nelson\n";
		*/
		NEW_PAGE = "\n".repeat(35);
		
		final String BOAT = TextArt.boat();
		final String BOAT_2 = TextArt.boat_2();
		final String BEACH = TextArt.beach();
		final String NORRIS = TextArt.norris();
		final String NELSONDONIA = TextArt.nelsondonia();
		final String MARKET = TextArt.market();
		final String BAR = TextArt.bar();
		final String CRAB = TextArt.crab();
		
		
		//SCAFFOLDING
		//TODO
		//Delete this boolean swap after testing. It changes viewing story to yes no matter what
		viewingStory = false;
		//SCAFFOLDING
		if (!kingCrabIsDefeated) {
			FightKingCrab.fightKingCrab(playerStats , playerBackpack 
					, scanstr , scanint
					, scanrng
					, viewingStory 
					, NEW_PAGE , CRAB , playerName);
			kingCrabIsDefeated = true;
		} else {
			System.out.println("You visited Norris for normalsies");
		}
		
		

}
	
	
	
	
	
	
}
//OLD TestClient Code, moved 29 December 2022
		/*
		for (int i = 0; i < 12; i++) {
			marketItems.setItems(i, true);
		}
		PlayerVisitsMarket.playerVisitsMarket(playerBackpack, marketItems, playerStats, 
				scanstr, scanrng, 
				MARKET, NEW_PAGE, playerName);
		*/





//OLD TestClient Code, moved 25 December 2022
/*
Random scanrng = new Random();
		System.out.println();
		int count = 1;
		Items marketItems = new Items(scanrng);
		System.out.println("+==============================================+\n"
				+ "|                    Market                    |\n"
				+ "+=====+========================================+");
		for (int i = 11; i > -1; i--) {
			if (marketItems.getItems()[i] == true) {
				System.out.printf("|  %d  |%-40s|\n"
						+ "|$%-4d|  %-38s|\n"
						+ "+-----+----------------------------------------+\n"
						, count , marketItems.getITEM_NAMES()[i] , marketItems.getItemPrices()[i] , marketItems.getITEM_DESCRIPTIONS()[i]);
				count++;
		}
	}
*/

//OLD SCAFFOLDING
//Items class
/*
//SCAFFOLDING DELETE WHEN GAME IS FINISHED
System.out.println("Item: " + ITEM_NAMES[index] + "\n"
		+ "Item Rarity: " + ITEM_RARITIES[index] + "\n"
		+ "Rng: " + rng + "\n"
		+ "Spawn? (rarity > rng) " + items[index] + "\n");
		*/
/*DELETE ME scaffolding
System.out.println("Item: " + items[index] + "\n"
		+ "Item price: " + itemPrices[index] + "\n"
		+ "Item rarity: " + ITEM_RARITIES[index] + "\n"
		+ "priceCoefficient: " + priceCoefficient + "\n");
System.out.println();
*/
