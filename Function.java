package v6_30Dec22;

import java.util.Random;
import java.util.Scanner;

public class Function {

	public static void main(String[] args) {
		

	}
	
	
	
	
	
	public static String choosePlayerName(Scanner scanstr , String playerName) {
		int lenPlayerName = 11;
		while (lenPlayerName > 10 || lenPlayerName == 0) {
			System.out.println("\n\n\nPlease enter a hero name less than ten characters long: ");
			playerName = scanstr.nextLine();
			lenPlayerName = playerName.length();
			if (lenPlayerName > 10) {
				System.err.println("That name is greater than ten characters long.");
			} else if (lenPlayerName == 0) {
				System.err.println("You did not enter anything.");
			}
		} 
		return (playerName);
	}
	
	
	
	
	
	public static void playerWakesUp(Random scanrng , String playerName) {
		
		//for loop spits out 1-3 random letters of playerName on each line to simulate waking up.
		for (int letterInName = 0; letterInName <= playerName.length() - 1;) {
			int randomLetters = scanrng.nextInt(3) + 1;
			//makes sure that the code doesn't try to pull a sub string out of range of playerName.length()
			if ( letterInName + 1 > (playerName.length() - 1) ) {
				randomLetters = 1;
			} else if (letterInName + 2 > (playerName.length() - 1) ) {
				randomLetters = scanrng.nextInt(2) + 1;
			} 
		
			if (randomLetters == 1) {
				System.out.print(playerName.charAt(letterInName) + "...\n");
				letterInName++;
			} else if (randomLetters == 2) {
				System.out.print(playerName.substring(letterInName , letterInName + 2) + "...\n");
				letterInName+=2;
			} else if (randomLetters == 3) {
				System.out.print(playerName.substring(letterInName , letterInName + 3) + "...\n");
				letterInName+=3;
			}
		}

	}
	
	
}