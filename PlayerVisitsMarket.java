package v6_30Dec22;
import java.util.Scanner;
import java.util.Random;
public class PlayerVisitsMarket {
	
	public static void playerVisitsMarket(Items playerBackpack , Items marketItems , Stats playerStats
			, Scanner scanstr , Random scanrng
			, String MARKET , String NEW_PAGE , String playerName) {
		
		//Initializing and assigning variables
		boolean purchasingItems = true;
		int totalOptions;
		int menuChoice = 0;
		int[] purchasableItems;
		
		//Player initially visits the market
		System.out.println(NEW_PAGE);
		System.out.println("\5".repeat(5));
		System.out.println(MARKET);
		
		//Salesperson's greeting
		System.out.println("Welcome adventurer.\n"
				+ "I will help you in whatever way I can to defeat the menaces threatening our city.\n");
		System.out.println(marketItems.getPriceComment());
		
		//Rolling for luck to see if item prices are reduced
		if (marketItems.getItemLuck()) {
			System.out.println();
			System.err.println("You got lucky!");
			System.out.println("All market prices have been reduced by 25%.");
			System.out.println();
		}
		
		
		System.out.println("Press ENTER to continue...");
		scanstr.nextLine();
		System.out.println("\n".repeat(5));
		
		//Player is purchasing items
		while (purchasingItems) {
			
			//print Store menu serves as an additional return method for the number of purchasable items
			totalOptions = printStoreMenu(marketItems , playerStats);
			
			//purchasableItems is a int[] that contains the indexes of marketItems where an item spawned, and marketItems.getItems == true
			purchasableItems = getPurchasableItems(marketItems , totalOptions);
			
			//Checking to make sure that there are items left to purchase
			if (totalOptions != 1) {
				menuChoice = Try.getInt(1, totalOptions, scanstr);
			}
			
			//if the market has no items left for the player to buy
			if  (totalOptions == 1) {
				purchasingItems = false;
				System.out.println("Press ENTER to return to town square...");
				scanstr.nextLine();
			}
			
			//If the player chooses the last option, it will allow them to leave for the town square
			else if (menuChoice == totalOptions) {
				purchasingItems = false;
			
			//Purchasing an item
			} else {
				//Checking to see if the player has enough coins
				if (playerStats.getCoin() < marketItems.getItemPrices()[purchasableItems[menuChoice - 1]]) {
					System.err.printf("You do not have enough coin for %s.\n" , marketItems.getITEM_NAMES()[purchasableItems[menuChoice - 1]]);
					System.out.println("Please choose a different item or return to the town square.\n"
							+ "Press ENTER to continue...");
					scanstr.nextLine();
					
				//The player has enough coins
				} else {
					System.out.printf("You purchased %s\n"
							+ "Press ENTER to continue...\n"
							, marketItems.getITEM_NAMES()[purchasableItems[menuChoice - 1]]);
					marketItems.setItems(purchasableItems[menuChoice - 1] , false);
					playerBackpack.setItems(purchasableItems[menuChoice - 1] , true);
					playerStats.setCoin(playerStats.getCoin() - marketItems.getItemPrices()[purchasableItems[menuChoice - 1]]);
					scanstr.nextLine();
					System.out.println("\n".repeat(5));
				}
			}
		
		
		System.out.println(NEW_PAGE);
		}
	}
	
	
	
	
	
	public static int printStoreMenu(Items marketItems , Stats playerStats) {
		int count = 1;
		
		System.out.println("+==============================================+\n"
				+ "|                    Market                    |\n"
				+ "+=====+========================================+");
		//Iterate through market items and print info if item spawned
		for (int i = 11; i > -1; i--) {
			if (marketItems.getItems()[i] == true) {
				System.out.printf("|  %-3d|%-40s|\n"
						+ "|$%-4d|  %-38s|\n"
						+ "+-----+----------------------------------------+\n"
						, count , marketItems.getITEM_NAMES()[i] , marketItems.getItemPrices()[i] , marketItems.getITEM_DESCRIPTIONS()[i]);
				count++;
		}
	}	
		if (count == 1) {
			System.out.println("There are no more items available for sale.\n");
		} else {
		System.out.printf("%d - Quit Shopping & Return to town square\n"
				+ "Coins: %d\n"
				+ "Choose item to purchase or ENTER %d to leave the store.\n"
				, count , playerStats.getCoin() , count);
		}
		return count;
	}
	
	
	
	
	
	public static int[] getPurchasableItems(Items marketItems , int count) {
		int[] purchasableItems = new int[count - 1];
		//filling out int[] purchasableItems with the correct items
				int purchasableItemsCounter = 0;
				for (int i = 11; i > -1; i--) {
					if (marketItems.getItems()[i] == true) {
						purchasableItems[purchasableItemsCounter] = i;
						purchasableItemsCounter++;
					}
				}
		return purchasableItems;
	}
	
	
	
	
}
