package v6_30Dec22;
import java.util.Random;
public class Items {

	public static final String[] ITEM_NAMES = 
		{"Vial of Phoenix Tears" 
		, "Defense Amulet" 
		, "Boots of Speed" 
		, "Hardened Leather Gloves" 
		, "Poison for Kuzco" 
		, "Leather Chestplate" 
		, "Large Potion" 
		, "Dojo Training" 
		, "Medium Potion" 
		, "Medium Helmet" 
		, "Antidote" 
		, "Small Potion"};
	//Higher int means a more common item
	public static final int[] ITEM_RARITIES = 
			{5
			,10
			,15
			,25
			,35
			,60
			,70
			,75
			,80
			,85
			,90
			,95};
	public static final String[] ITEM_DESCRIPTIONS = 
		   {"Immunity to poison",
		    "75% accurate hint when blocking",
		    "50% chance to attack twice",
		    "+20 max health",
		    "10% chance to poison enemy",
		    "+10 max health",
		    "+40 health when used",
		    "+3 attack",
		    "+25 health when used",
		    "+5 max health",
		    "Cures poison once",
		    "+10 health when used"};

	
	
	
	
	//initialize variables
	private boolean[] items = new boolean[12];
	private int[] itemPrices = new int[12];
	private double averagePrice;
	private String priceComment;
	private boolean itemLuck = false;
	
	
	
	
	
	
	//Constructor for playerBackpack
	public Items() {
		priceComment = "null";
		itemPrices = null;
		averagePrice = 69;
	}
	
	
	
	
	
	
	//Constructor to randomize marketItems
	public Items(Random scanrng) {
		int rng;
		for (int index = 0; index < 12; index++) {
			rng = scanrng.nextInt(100) +1;
			//If the rarity of the item is less then a randomly generated number, the item will spawn
			if (ITEM_RARITIES[index] > rng ) {
				this.items[index] = true;
			}
			
			
		}
		//Prices are determined by multiplying a random coefficient to 100 - ITEM_RARITIES[index]
		this.averagePrice = scanrng.nextDouble(25) + 25;
		for (int index = 0; index < 12; index++) {
			double priceCoefficient = (scanrng.nextDouble(25) + 25 + this.averagePrice) / 100;
			//Showing the type cast to int for the itemPrices array so the equation does not get too long
			double price = ((double) (100 - ITEM_RARITIES[index])) * priceCoefficient;
			this.itemPrices[index] = (int) price;
			
			
			
			if (averagePrice > 45) {
				priceComment = "Prices are extremely high today.\n"
						+ "I recommend coming back and shopping another day.";
			} else if (averagePrice > 40) {
				priceComment = "Prices are high today.\n"
						+ "You may want to try again tomorrow.";
			} else if (averagePrice > 35) {
				priceComment = "Prices are moderately priced today.\n"
						+ "Feel feel to browse our stock.";
			} else if (averagePrice > 30) {
				priceComment = "Prices are low today.\n"
						+ "You may want to consider purchasing more.";
			} else if (averagePrice > 25) {
				priceComment = "Prices are very low today.\n"
						+ "I highly recommend purchasing items.";
			}
		}
	}
	
	
	
	
	
	//Getters
	public String[] getITEM_NAMES() {
		return ITEM_NAMES;
	}
	public int[] getetITEM_RARITIES() {
		return ITEM_RARITIES;
	}
	public String[] getITEM_DESCRIPTIONS() {
		return ITEM_DESCRIPTIONS;
	}
	public boolean[] getItems() {
		return this.items;
	}
	public int[] getItemPrices() {
		return this.itemPrices;
	}
	public double getAveragePrice() {
		return this.averagePrice;
	}
	public String getPriceComment() {
		return this.priceComment;
	}
	public boolean getItemLuck() {
		return this.itemLuck;
	}
	
	
	
	
	
	//Setters
	public void setItems(int index , boolean spawn) {
		this.items[index] = spawn;
	}
	public void setPrice(int index , int price) {
		this.itemPrices[index] = price;
	}
	public void setItemLuck(Stats playerStats , Random scanrng) {
		if (playerStats.getLuck() > scanrng.nextInt(5) + 6) {
			this.itemLuck = true;
		} else {
			this.itemLuck = false;
		}
	}
	
	
	
	
	
	public String toString() {
		//if no items have spawned the string will return "EMPTY"
		boolean backpackIsEmpty = true;
		for (int i = 0; i < 12; i++) {
			if (this.items[i] == true) {
				backpackIsEmpty = false;
			} 
		}
		if (backpackIsEmpty) {
			return "EMPTY";
		}
		
		//If items spawn, print out the items
		String itemsStr;
		itemsStr = "=======================\n";
		int index = 0;
		for (boolean item : this.items) {
			if (item) {
				itemsStr += 
			  ITEM_NAMES[index]        + ":\n" 
			+ ITEM_DESCRIPTIONS[index] + "\n"
			+ "=======================\n";
			}
			index++;
		}
		return itemsStr;
	}
	
	
	
	
	
	public void reduceItemPrices() {
		for (int index = 0; index < 12; index++) {
			this.itemPrices[index] = (int) (itemPrices[index] * .75);
		}
	}
	
	
	
	
	
	
	
}
