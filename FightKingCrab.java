package v6_30Dec22;
import java.util.Scanner;
import java.util.Random;
public class FightKingCrab {
	
	public static void fightKingCrab(Stats playerStats , Items playerBackpack
			, Scanner scanstr , Scanner scanint
			, Random scanrng
			, Boolean viewingStory
			, String NEW_PAGE , String CRAB , String playerName) {
		Stats crabStats = new Stats(20 , 5 , 5 , 10);
		String enemyName = "King Crab";
		String enemyWeakPoint = "Abdomen";
		String enemyMidPoint = "Legs";
		String enemyStrongPoint = "Carapace";
		Stats playerStatsBattle = new Stats(playerStats.getHealth() , playerStats.getAttack() , playerStats.getLuck() , playerStats.getCoin());
		boolean battlingKingCrab = true;
		boolean playerWon = false;
		int menuChoice;
		int playerDamage;
		//int crabDamage;
		
		//Describing the path to Norris's house
		if (viewingStory) {
			pathToNorrisHouse(scanstr , NEW_PAGE , CRAB);
		}
		
		//King Crab Fight
		while (battlingKingCrab) {
			//if the player loses
			if (playerStatsBattle.getHealth() <= 0) {
				battlingKingCrab = false;
			//if the player wins
			} else if (crabStats.getHealth() <= 0) {
				playerWon = true;
				battlingKingCrab = false;
			//during the battle
			} else {
				//Getting player Attack Choice
				Battle.printAttackMenu(playerStatsBattle, crabStats
						, playerBackpack
						, CRAB , enemyName , playerName
						, enemyWeakPoint , enemyMidPoint , enemyStrongPoint);
				menuChoice = Try.getInt(1, 3, scanint);
				
				if (menuChoice > 0 && menuChoice < 4) {
						playerDamage = Battle.getPlayerDamage(playerStatsBattle , crabStats
												, playerBackpack
												, scanrng
												, menuChoice
												, enemyName , playerName
												, enemyWeakPoint , enemyMidPoint , enemyStrongPoint);
						crabStats.setHealth(crabStats.getHealth() - playerDamage);
						
				} else {
						System.out.println("You used an item.");
				}
				
				if (crabStats.getHealth() > 0) {
					System.out.println("\n\n\nIsaac, choose a defense posture...");
					System.out.println("Press ENTER to suimulate defending...");
					scanstr.nextLine();
				}
				
			}
			
			
			System.out.print(NEW_PAGE);
			//SCAFFOLDING
			//Automatic break out for now
			//battlingKingCrab = false;
			//SCAFFOLDING
		}
		
		
		
		
		
		if (playerWon) {
			System.out.println("PlayerWon!");
			//Visit norris. He talks about the symbol you got in your backpack. he asks to see it so he can study it. 
			//He explains when he was a wee lad that the founder of the city had it on his family crest. (later goblins kidnap him and you must rescue him. Goblins steal the crest)
		} else {
			System.out.println("Player Lost");
		}
		
		
		
	}
	
	
	
	
	
	public static void pathToNorrisHouse(Scanner scanstr , String NEW_PAGE , String CRAB) {
		System.out.println("You make your way to Norris's hut.\n"
				+ "On the path there you here a strange banging.\n"
				+ "Press ENTER to continue to the rest of the way...");
		scanstr.nextLine();
		System.out.print(NEW_PAGE);
		System.out.println(CRAB + "\n".repeat(5)
				+ "A gigantic crab is banging on Norris's door, splintering the wood with its sharp claws.\n"
				+ "The crab turns towards you, and you see your reflection in its dark beady eyes.\n"
				+ "Pres ENTER to begin battle with King Crab...");
		scanstr.nextLine();
		System.out.print(NEW_PAGE);
	}
	
}
