package v6_30Dec22;

import java.util.Random;
import java.util.Scanner;

public class Chapter {

	public static void main(String[] args) {
		

	}
	//Method for Intro
	public static void intro(Scanner scanstr , String NEW_PAGE , String BOAT , String BOAT_2 , String LAND_AHOY) {
		
		System.out.print(NEW_PAGE);
		System.out.println("Our hero grew up in the middle of the olde world sea. He had a charming uneventful childhood on a small island...\n"
				+ "One day everyone on his beloved island mysteriously disappears...\n"
				+ "After spending his entire life on the small island, the hero seeks an answer in the vast world beyond... \n\n"
				+ BOAT
				+ "\n\n(press ENTER)...");
		scanstr.nextLine();
			
		System.out.print(NEW_PAGE);
		System.out.print("He travels for many days...\n"
				+ "He has nothing to eat and drink except the rations of island fruit he brought with him...\n"
				+ "The hero grows weary. The fruit starts to ripen and rot in the blaring ocean sun...\n"
				+ "He stares into the vast blue horizon and wonders if he will ever make it to land...\n\n"
				+ BOAT_2
				+ "\n\n (press ENTER)...");
		scanstr.nextLine();
			
		System.out.print(NEW_PAGE);
		System.out.print("The sojourner finally spots land, with a a single cottage nested among the palm trees...\n"
				+ "After his long journey, he beaches, climbs onto the shore, and collapses...\n"
				+ LAND_AHOY
				+ "\n\n");
		
	}
	//Method for Chapter 1
	public static void norris(Scanner scanstr , Random scanrng , String playerName , String NEW_PAGE , String TOWNSMAN) {
		
		Function.playerWakesUp(scanrng , playerName);
		System.out.print("\nYou are deep in slumber, but hear someone calling your name.\n");
		System.out.print("(press ENTER to wake up)...");
		scanstr.nextLine();
	
		System.out.print(NEW_PAGE);
		System.out.print("You open your eyes and lean forward.\n"
				+ "A man with tanned olive skin and sunswept hair not unlike your own stands in front of you."
				+ "\n".repeat(5));
		System.out.print(TOWNSMAN);
		System.out.print("\n"
				+ playerName + ", I found your journal in your boat when you washed up on the shore.\n"
						+ "I am Norris, Nelsondonia's seaside watchman.\n\n"
						+ "(press ENTER)...");
		scanstr.nextLine();
						
		
		
		System.out.print(NEW_PAGE);
		System.out.print(TOWNSMAN);
		System.out.print("NORRIS: \n"
						+ "\tYou have been asleep for two days.\n"
						+ "\tIt is miraculous that you survived the month-long journey. I have seen great men perish at sea in a quarter of the time you were lost.\n"
						+ "\tYou are no ordinary adventurer, " + playerName + ".\n\n"
						+ "(press ENTER)...\n");
		scanstr.nextLine();
						
		System.out.print(NEW_PAGE);
		System.out.print(TOWNSMAN);
		System.out.print("NORRIS: \n"
						+ "\t" + playerName + ", you must help my town Nelsondonia.\n\n"
						+ "\tWe are under siege from a group of goblins.\n"
						+ "\tThey are trying to flood the wharf and destroy the city.\n\n"
						+ "\tI would not have interrupted your slumber if this was not such an urgent matter....\n\n"
						+ "(press ENTER)...");
		scanstr.nextLine();
		
		System.out.print(NEW_PAGE);
		
						System.out.print("NORRIS: "
								+ "\tI plead for your help, " + playerName + ".\n"
								+ "\tYou are no ordinary hero.\n"
								+ "\tAnd a hero out of the ordinary is just what Nelsondonia needs right now."
								+ "\n".repeat(10));
	}
}
