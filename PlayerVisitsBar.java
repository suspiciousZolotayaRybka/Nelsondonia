package v6_30Dec22;

import java.util.Scanner;

public class PlayerVisitsBar {
	
	
	
	
	
	public static int playerVisitsBar(Scanner scanstr , Stats playerStats , GameStats gameStats
			, int townChoice
			, boolean kingCrabIsDefeated
			, String bartenderComment , String NEW_PAGE , String BAR , String playerName) {
		boolean leavingForBattle = true;
		
		bartenderComment = generateBartenderComment(gameStats , bartenderComment);
		System.out.print(NEW_PAGE);
		
		//If the player has defeated the king crab, they may leave for battle
		if (kingCrabIsDefeated) {
			System.out.println(BAR);
			System.out.println("\nBartender: " + playerName + bartenderComment);
			System.out.println("Would you like to leave for battle?\n");
			leavingForBattle = Try.getBoolean(scanstr);
		
			if (leavingForBattle) {
				townChoice = 5;
			}
		} else {
			System.out.println("The bar is closed.\n"
					+ "Press ENTER to return to the town square...");
			scanstr.nextLine();
		}
		System.out.println(NEW_PAGE);
		return townChoice;
	}
	
	
	
	
	
	public static String generateBartenderComment (GameStats gameStats, String bartenderComment) {
		

		if (gameStats.getPlayerPower() <= gameStats.getHordeMultiplier()) {
			if (gameStats.getPlayerPower() > (gameStats.getHordeMultiplier() - 10)) {
				bartenderComment = ", I believe you are evenly matched to the beasts in the city...\n"
						+ "Your battle will be slightly difficult.";
			} else if (gameStats.getPlayerPower() > (gameStats.getHordeMultiplier() - 20)) {
				bartenderComment = ", the goblins that have been ransacking the city are no ordinary beasts...\n"
						+ "Tread lightly, your battle will be moderately difficult.";
			} else {
				bartenderComment = ", we face one of the greatest threats of our time...\n"
						+ "For your sake I hope you return, your battle will be extremely difficulty";
			}
		}else if (gameStats.getPlayerPower() > gameStats.getHordeMultiplier()) {
			if ((gameStats.getPlayerPower() - 10) < gameStats.getHordeMultiplier()) {
				bartenderComment = ", I believe you are evenly matched to the beasts in the city...\n"
						+ "You will battle with slight ease.";
			} else if ((gameStats.getPlayerPower() - 20) < gameStats.getHordeMultiplier()) {
				bartenderComment = ", you appear strong...\n"
						+ "You will battle with moderate ease.";
			} else {
				bartenderComment = ", you are a great adventurer...\n"
						+ "You will battle with extreme ease.";
			}
		}
		return bartenderComment;
	}
}
