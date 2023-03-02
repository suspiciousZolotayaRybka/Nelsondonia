package v6_30Dec22;

import java.util.Random;
import java.util.Scanner;

public class SCAFFOLDING_RockPaperScissors {

	static String userChoice;
	static String computerChoice;
	static int[] health = {3 , 3};
	static int damage;
	static boolean playerForfeits;
	static boolean computerForfeits;
	static boolean playerWon;
	static boolean computerWon;
	static boolean battling = true;	
	
	
	static Random scanrng = new Random();
	static Scanner scanint = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		
		while (battling) {
			//player loses
		if (health[0] == 0) {
				battling = false;
				computerWon = true;
		//computer loses
		} else if (health[1] == 0) {
				battling =  false;
				playerWon = true;
		} else {
			userChoice = getUserChoice();
			computerChoice = getComputerChoice();
			//player forfeits
			if (userChoice.equals("forfeit") ) {
				battling = false;
				playerForfeits = true;
			//computer forfeits
			} else if (computerChoice.equals("forfeit")) {
				battling = false;
				computerForfeits = true;
			//Still in the game!
			} else {
				damage = compareChoices(computerChoice , userChoice);
				System.out.println("Computer chooses " + computerChoice + "!");
				if (damage == 0) {
					System.out.printf("Draw!\n"
							+ "Player health   -> %d\n"
							+ "Computer health -> %d\n"
							, health[0] , health[1]);
				} else if (damage == 1) {
					health[1] -= 1;
					System.out.printf("Computer takes damage!\n"
							+ "Player health   -> %d\n"
							+ "Computer health -> %d\n"
							, health[0] , health[1]);
				} else {
					health[0] -= 1;
					System.out.printf("Player takes damage!\n"
							+ "Player health   -> %d\n"
							+ "Computer health -> %d\n"
							, health[0] , health[1]);
				}
			}
		 }
	   }
		
		
		
		
		if (playerForfeits) {
			System.out.println("You forfeitted the match!");
		} else if (computerForfeits) {
			System.out.println("The computer forfeitted the match!");
		} else if (playerWon) {
			System.out.println("You won!");
		} else {
			System.out.println("The computer won!");
		}

	}
	
	
	
	
	public static int compareChoices(String computerChoice , String userChoice) {
		if (computerChoice.equals(userChoice) ) {
			return 0;
		} else if ( (userChoice.equals("rock") && computerChoice.equals("scissors") )
				  ||(userChoice.equals("paper")&& computerChoice.equals("rock") )
				  ||(userChoice.equals("scissors")&& computerChoice.equals("paper") ) ){
			return 1;
		} else {
			return -1;
		}
		
		
	}
	
	
	
	
	
	public static String getComputerChoice() {
		//Seeing if the computer wants to forefeit
		int computerChoice = scanrng.nextInt(100);
		if (computerChoice == 69) {
			return "forfeit";
		}
		//scanning for computer's choice
		computerChoice = scanrng.nextInt(3) + 1;
		//Returning string for computer
		switch (computerChoice) {
		case 1:
			return "rock";
		case 2:
			return "paper";
		case 3:
			return "scissors";
		}
		return null;
	}
	
	
	
	
	//Used to get and return the string for userChoice
	public static String getUserChoice() {
		int userChoice = 1;
		boolean errorCatching = true;
		System.out.println("Shoot! \n"
				+ "1 - Rock\n"
				+ "2 - Paper\n"
				+ "3 - Scissors\n"
				+ "4 - Forfeit\n"
				+ "=>");
		
		//Checks user input for errors
		while (errorCatching) {
			while(!scanint.hasNextInt()) {
				String error = scanint.nextLine();
				System.err.printf("%s is not an int.\n"
						, error);
				System.out.println("Please enter an int and try again.\n"
						+ "=>");
			} userChoice = scanint.nextInt();
			//Checks range.
			if ( (userChoice < 1) || (userChoice > 4) ) {
				System.err.printf("%d is not an int between 1-4." , userChoice);
				System.out.println("Please enter an int between 1-4 and try again.\n"
						+ "=>");
			//If range is correct, makes errorCatching false
			} else {
				errorCatching = false;
			}
		}
		
		//Returns the string for userChoice
		switch (userChoice) {
		case 1:
			return "rock";
		case 2:
			return "paper";
		case 3:
			return "scissors";
		case 4:
			return "forfeit";
		}
		return null;
	}

}
