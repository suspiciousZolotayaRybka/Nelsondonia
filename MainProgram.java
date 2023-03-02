package v6_30Dec22;
/* Name: Finehout, Isaac 
 * CMIS 141/6981 
 * Date: 11/12/2022
 * A text based mini-game where the user fights hordes of goblins
 * @author fineh
 * 
 * v5 Updates for Discussion Post Eight:
 *    1. Added new objects and divided Functions into classes that made sense
 *    		a. Stats
 *    		b. Items
 *    		c. GameStats
 *    		d. PlayerVisitsBar
 *    		e. PlayerVisitsMarket
 *    
 */
import java.util.Scanner;

import java.util.Random;
public class MainProgram {

	public static void main(String[] args) {
		/*TABLE OF CONTENTS & DECLARING VARIABLES (SKIP TO LINE 86 FOR PROGRAM)
		 *   
		 * 1 Assigning Final Variables
		 *   Line 74
		 */
		final String HEADER; //the header required in "HowToNameSubmissions.docx"
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
		Stats playerStats = new Stats(); //health, attack, luck, and coin
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
		
		//playerVisitsNorris
		boolean kingCrabIsDefeated = false;
		
		//playerVisitsBar
		String bartenderComment = ""; //a comment the bartender gives to the player that gives a hint at how difficult the upcoming battle will be

		//Declared variables used throughout the program
		boolean errorCatching = true; //Used to test if the player entered correct info
		

		

		
		
		
		//1 Assigning FINAL Variables
		HEADER = "Nelsondonia\n"
				+ "A goblin fighting game by Isaac Finehout\n"
				+ "Made in honor of SSgt Brandon Nelson\n";
		
		NEW_PAGE = "\n".repeat(35);
		
		final String BOAT = TextArt.boat();
		final String BOAT_2 = TextArt.boat_2();
		final String BEACH = TextArt.beach();
		final String NORRIS = TextArt.norris();
		final String NELSONDONIA = TextArt.nelsondonia();
		final String MARKET = TextArt.market();
		final String BAR = TextArt.bar();
		final String CRAB = TextArt.crab();
		
		
		
		
		
		
		//2 Intro
		System.out.print(HEADER);
		System.out.println("Would you like to view the story?\n"
				+ "=> \n");
		viewingStory = Try.getBoolean(scanstr);
		
		//Intro
		if (viewingStory) {
			Chapter.intro(scanstr , NEW_PAGE , BOAT , BOAT_2 , BEACH);
		}
		
		
		
		
		//3 choosePlayerName and rerollStats
		playerName = Function.choosePlayerName(scanstr , playerName);
		System.out.println("Press ENTER to generate your character stats...");
		scanstr.nextLine();
		
		//Determining playerStats and gameStats
		playerStats = Stats.rerollStats(NEW_PAGE, BEACH, playerName, scanint, scanrng, errorCatching, playerStats);
		
		gameStats = GameStats.calculateGameStats(playerStats , scanrng);
		
		//Setting itemLuck parameters after player luck has been decided. Determines if the player gets a 25% discount at the market based on their luck
		marketItems.setItemLuck(playerStats, scanrng);
		if (marketItems.getItemLuck()) {
			marketItems.reduceItemPrices();
		}
		

		
		

		//4 Norris
		if (viewingStory) {
			Chapter.norris(scanstr , scanrng , playerName , NEW_PAGE , NORRIS);
			
		}
		


		
		
		
		
		//5 Visiting Town
		
		//Entering town for the first time
		System.out.print(NEW_PAGE);
		System.out.println("Brave hero " + playerName + ", you have been tasked with protecting the quaint village of Nelsondonia from a goblin attack.\n "
				+ "Explore the town and prepare for battle.\n");
		
		while (visitingTown) {
			
			if (townChoice != 5) {
				System.out.print(NELSONDONIA);
				townChoice = Try.getInt(1 , 4 , scanint);
			}
			
			switch (townChoice) {
				case 1:
					PlayerVisitsMarket.playerVisitsMarket(playerBackpack, marketItems , playerStats
							, scanint, scanrng 
							, MARKET, NEW_PAGE, playerName);
					break;
				case 2:
					
					//SCAFFOLDING
					//TODO
					//Delete this boolean swap after testing. It changes viewing story to yes no matter what
					viewingStory = true;
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
					
					break;
					
				case 3:
					
					townChoice = PlayerVisitsBar.playerVisitsBar(scanstr , playerStats , gameStats 
							, townChoice
							, kingCrabIsDefeated
							, bartenderComment , NEW_PAGE , BAR , playerName);
					
					break;
					
				case 4:
					
					System.out.println(Stats.toString(playerStats , playerName));
					System.out.println("Player Backpack: \n" + playerBackpack);
					System.out.println("Press ENTER to continue...\n");
					scanstr.nextLine();
					break;
					
				case 5:
					visitingTown = false;
					break;
			}
		}

		
		
		
		
		System.out.print("DELETE THESE (SCAFFOLDING)\n" 
				+ "Goblin Count: " + gameStats.getGoblinCount()
				+ "\nHorde Multiplier: " + gameStats.getHordeMultiplier() 
				+ "\nrng: " + gameStats.getRng()
				+ "\nplayerPower: " + gameStats.getPlayerPower()
				+ "\n".repeat(10));
		//7 Battle
		System.out.println("under construction"
				+ "\n"
				+ "Sources:\n"
				+ "1 - ascii.co.uk\n"
				+ "2 - asciiart.eu\n");
		
		
		
		
		
	scanstr.close();
	scanint.close();
	}
	

}
