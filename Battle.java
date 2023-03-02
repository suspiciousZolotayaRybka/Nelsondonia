package v6_30Dec22;
import java.util.Random;
public class Battle {
	
	
	
	
	
	public static void printAttackMenu(Stats playerStatsBattle , Stats enemyStats
			, Items playerBackpack
			, String ENEMY , String enemyName , String playerName
			, String enemyWeakPoint , String enemyMidPoint , String enemyStrongPoint) {
		//Printing enemy stats 
		System.out.println(ENEMY);
		System.out.println(enemyName);
		System.out.println("Health: " + enemyStats.getHealth() 
		+ " | Attack: " + enemyStats.getAttack());
		
		System.out.print("\n".repeat(3));
		
		//Printing player Stats
		System.out.println(playerName);
		System.out.println("Health: " + playerStatsBattle.getHealth() 
		+ " | Luck: " + playerStatsBattle.getLuck()
		+ " | Attack: " + playerStatsBattle.getAttack());
		
		System.out.println("\n");
		
		//Printing attack menu
		System.out.printf("=======================\n"
				+ "Attack %s\n"
				+ "=======================\n"
				+ "1 - %-10s (Weak)\n"
				+ "2 - %-10s (Mid)\n"
				+ "3 - %-10s (Strong)\n"
				+ "=======================\n"
				+ "Use Item\n"
				+ "=======================\n"
				+ "?\n"
				+ "?\n"
				+ "=>"
				, enemyName
				, enemyWeakPoint , enemyMidPoint , enemyStrongPoint);
	}
	
	
	
	
	
	public static void printDefenseMenu() {
		
	}
	
	
	
	
	
	public static int getPlayerDamage(Stats playerStatsBattle , Stats enemyStats
			, Items playerBackpack
			, Random scanrng
			, int playerAttackPosture
			, String enemyName , String playerName
			, String enemyWeakPoint , String enemyMidPoint , String enemyStrongPoint) {
		
		//Declaring variables
		int enemyDefensePosture;
		int playerDamage;
		boolean playerMisses;
		
		//Get the enemy's defense posture
		enemyDefensePosture = getEnemyDefensePosture(scanrng);
		
		//Using playerLuck to see if the player misses
		playerMisses = getPlayerMisses(playerStatsBattle
				, scanrng);
		if (playerMisses) {
			System.out.print("You got unlucky and ");
			System.err.print("missed");
			System.out.println("!");
			return 0;
		} 
		//If player successfully strikes
		//Check for passive items
		//Calculate damage
		else {
			playerDamage = calculatePlayerDamage(playerStatsBattle
							, scanrng
							, enemyName
							, playerAttackPosture , enemyDefensePosture
							, enemyWeakPoint , enemyMidPoint , enemyStrongPoint);
			if (playerDamage < 1) {
				System.err.println("SCAFFOLDING player damage is less than 1.\n"
						+ "Player damage: " + playerDamage);
				System.out.printf("1 DAMAGE DEALT" , playerDamage);
				return 1;
			} else {
				System.out.printf("%d DAMAGE DEALT\n" , playerDamage);
				return playerDamage;
			}
		}
	}
	
	
	
	
	public static int getEnemyDefensePosture (Random scanrng) {
		
		//Enemies are 50% likely to defend Strong Point
		//40% likely to defend Mid Point
		// and 10% likely to defend Strong Point
		int enemyDefenseCoefficient = scanrng.nextInt(10) + 1;
		
		if (enemyDefenseCoefficient <  6) {
			return 1;
		} else if (enemyDefenseCoefficient < 10) {
			return 2;
		} else {
			return 3;
		}
	}
	
	
	
	
	//SCAFFOLDING
	//Still need to try with low luck
	//SCAFFOLDING
	public static boolean getPlayerMisses(Stats playerStatsBattle
			,Random scanrng) {
		
		//%20 chance to miss if playerLuck is 1-2
		if (playerStatsBattle.getLuck() < 3) {
			if ( (scanrng.nextInt(100) + 1) > 80) {
				return true;
			}
		//%15 chance to miss if playerLuck is 4-5
		} else if (playerStatsBattle.getLuck() < 5) {
			if ( (scanrng.nextInt(100) + 1) > 85) {
				return true;
			}
		//%10 chance to miss if playerLuck is 5-6
		} else if (playerStatsBattle.getLuck() < 7) {
			if ( (scanrng.nextInt(90) + 1) > 90) {
				return true;
			}
		//%5 chance to miss if playerLuck is 7-8
		} else if (playerStatsBattle.getLuck() < 9) {
			if ( (scanrng.nextInt(100) + 1) > 95) {
				return true;
			}
		//%100 percent chance to hit if playerLuck is 9-10
		} else if (playerStatsBattle.getLuck() < 11) {
			return false;
		}
		return false;
	}
	
	
	
	
	
	public static int calculatePlayerDamage(Stats playerStatsBattle
			, Random scanrng
			, String enemyName
			, int playerAttackPosture , int enemyDefensePosture
			, String enemyWeakPoint , String enemyMidPoint , String enemyStrongPoint) {
		int attackModifier;
		String[] enemyPoints = {enemyWeakPoint , enemyMidPoint , enemyStrongPoint};
		
		//Get attackModifier
		attackModifier = getAttackModifier(playerStatsBattle
				, scanrng);
		
		//Player attacks the same body part that the enemy is defending and deals MINIMAL damage
		if (playerAttackPosture == 1 && enemyDefensePosture == 1) {
			System.out.printf("%s was defending its %s and parried you!\n"
					, enemyName , enemyWeakPoint);
			System.err.println("MINIMAL DAMAGE");
			return 1;
		} else if (playerAttackPosture == 2 && enemyDefensePosture == 2) {
			System.out.printf("%s was defending its %s and parried you!\n"
					, enemyName , enemyMidPoint);
			System.err.println("MINIMAL DAMAGE");
			return 1;
		} else if (playerAttackPosture == 3 && enemyDefensePosture == 3) {
			System.out.printf("%s was defending its %s and parried you!\n"
					, enemyName , enemyStrongPoint);
			System.err.println("MINIMAL DAMAGE");
			return 1;
			
		//Player attacks a body part the enemy is not defending and deals increased damage for weaker body parts
		//weakPoint
		} else if (playerAttackPosture == 1) {
			System.out.printf("%s was defending its %s as you attacked!\n"
					, enemyName , enemyPoints[enemyDefensePosture - 1]);
			System.err.println("MASSIVE DAMAGE");
			return (playerStatsBattle.getAttack() + attackModifier) + 2;
		//midPoint
		} else if (playerAttackPosture == 2) {
			System.out.printf("%s was defending its %s as you attacked!\n"
					, enemyName , enemyPoints[enemyDefensePosture - 1]);
			System.err.println("MODERATE DAMAGE");
			return (playerStatsBattle.getAttack() + attackModifier - 3);
		//strongPoint
		} else if (playerAttackPosture == 3) {
			System.out.printf("%s was defending its %s as you attacked!\n"
					, enemyName , enemyPoints[enemyDefensePosture - 1]);
			System.err.println("LIGHT DAMAGE");
			return (playerStatsBattle.getAttack() + attackModifier - 5);
		}
		return 1000;
	}
	
	
	
	
	
	public static int getAttackModifier(Stats playerStatsBattle
			, Random scanrng) {
		
		int attackModifierCoefficient = scanrng.nextInt(100) + 1;
		
		//SCAFFOLDING
		//Good to delete once the main program is in place. Kept here just in case
		/*
		System.err.printf("SCAFFOLDING: \n"
				+ "attackModifierCoefficient: %d \n"
				, attackModifierCoefficient);
				*/
		//SCAFFOLDING
		//if player is UNLUCKY, they are more likely to get a negative attack modifier
		
		if (playerStatsBattle.getLuck() < 6) {
			
			//%8 chance for a -3 attack modifier
			if (attackModifierCoefficient < 9) {
				//SCAFFOLDING
				//Good to delete once the main program is in place. Kept here just in case
				//Real scaffolding has this same print statement under every single else if
				/*
				System.err.printf("SCAFFOLDING: \n"
						+ "UNLUCKY modifierCoefficient\n"
						+ "-3");
				*/
				//SCAFFOLDING
				return -3;
			
			//%14 chance for a -2 attack modifier
			} else if (attackModifierCoefficient < 21) {
				return -2;
			
			//%20 chance for a -1 attack modifier
			} else if (attackModifierCoefficient < 41) {
				return -1;
			
			//%39 chance for a 0 attack modifier
			} else if (attackModifierCoefficient < 80) {
				return 0;
			
			//%10 chance for a +1 attack modifier
			} else if (attackModifierCoefficient < 90) {
				return 1;
			
			//%7 chance for a +2 attack modifier
			} else if (attackModifierCoefficient < 97) {
				return 2;
			
			//%4 chance for a +3 attack modifier
			} else if (attackModifierCoefficient < 101) {
				return 3;
			}
			
			//if a player is LUCKY they are more likely to get a positive attack modifier
		} else {
			
			//%8 chance for a +3 attack modifier
			if (attackModifierCoefficient < 9) {
				return 3;
			
			//%14 chance for a +2 attack modifier
			} else if (attackModifierCoefficient < 21) {
				return 2;
			
			//%20 chance for a +1 attack modifier
			} else if (attackModifierCoefficient < 41) {
				return 1;
			
			//%39 chance for a 0 attack modifier
			} else if (attackModifierCoefficient < 80) {
				return 0;
			
			//%10 chance for a -1 attack modifier
			} else if (attackModifierCoefficient < 90) {
				return -1;
				
			//%7 chance for a -2 attack modifier
			} else if (attackModifierCoefficient < 97) {
				return -2;
				
			//%4 chance for a -3 attack modifier
			} else if (attackModifierCoefficient < 101) {
				return -3;
			}
		}
		return 1000;
	}
}
