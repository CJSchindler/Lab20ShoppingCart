// Lauren Shindo

/**
 * * A shopping list application that uses collections to store items.
*/

package pkgLabBonus20;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class LabBonus20ShoppingList {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		// create a hashtable to hold the list of candy items
		HashMap <String, Double> inventory = new HashMap<String, Double>();
		//create an array list to hold items ordered
		ArrayList<String> shoppingCart = new ArrayList<>();
		String goAgain; //variable to keep track of whether the user wants to continue

		// fill the hashtable with items using a method
		inventory = fillInventory(inventory);
		
		System.out.println("Welcome to the Candy Emporium!\n");
		
		// display all items in the store inventory using a method
		displayInventory(inventory);
		
	do {
		// using the following prompt, have user enter an item to order using validateOrder method
		String prompt = ("\nWhat would you like to order? ");
		String orderedItem = validateOrder(scnr, prompt, inventory);
		
		//add item from the previous step to the shopping cart
		shoppingCart.add(orderedItem);
		
		//ask if user would like to order more items and keep track of answer
		System.out.println("Would you like to order another item? (y/n) ");
		goAgain = scnr.nextLine();
		goAgain = goAgain.toLowerCase();
		
	} while (goAgain.startsWith("y"));
		
		// When user is finished shopping, display the cart
		System.out.println("Thank you for shopping with us. Here is your cart: ");
		System.out.println();
		
		// display all items in the shopping cart using a method
		displayShoppingCart(shoppingCart, inventory);
		System.out.println();
		
		//display the average price of items in the shopping cart
		System.out.println();
		average(shoppingCart, inventory);		
		
		//display the highest price of items in the shopping cart
		System.out.println();
		System.out.println("The highest priced item was " + Collections.max(shoppingCart) + " at $" + inventory.get(Collections.max(shoppingCart)));	
		
		//display the lowest price of items in the shopping cart
		System.out.println();
		System.out.println("The lowest priced item was " + Collections.min(shoppingCart) + " at $" + inventory.get(Collections.min(shoppingCart)));	
				
	System.out.println("Press any key to continue...");
	
	}




	private static void displayShoppingCart(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
			System.out.println("Item");
			System.out.println("===========");
			
			double sum = 0;//the total price, added together
			double price = 0.0;
			int count = 0; //the number of individual items
			
			for (String orderedItem : shoppingCart) {
				sum += inventory.get(orderedItem);
				price = inventory.get(orderedItem);
				count++;
				System.out.println(orderedItem + "\t\t$" + price);
			}
		}

	private static void average(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
		double sum = 0;//the total price of all items
		int count = 0; //the number of individual items
		for ( String orderedItem : shoppingCart ) {
			
			//sum get from the inventory,
			sum += inventory.get(orderedItem);
			count++;
		}
		System.out.println("Your total is $" + sum);
		System.out.println();
		System.out.println("The average price of items in your cart is: $" + sum/count);
		
	}


	private static String validateOrder(Scanner scnr, String prompt, HashMap<String, Double> inventory) {
		String userInput; //user's input
		System.out.println(prompt); // asks user to put in item to order
		userInput = scnr.nextLine(); // scans user's input
		
		if (inventory.containsKey(userInput)) { //if input is in the hashtable, print message
			System.out.println("Excellent choice. Adding " + userInput + " to your cart at $" + inventory.get(userInput) + ".\n");
		}
		else { //if input is not in hashtable, prompt user to try again
			System.out.println("I'm sorry, that item is not in stock. Please try an item from the list. ");
			validateOrder(scnr, prompt, inventory); //calls on method again to get valid input
		}
		return userInput; //once valid input is received, method returns that input
	}

	// method to fill the inventory of the hashtable created in the main method
	private static HashMap<String, Double> fillInventory(HashMap<String, Double> inventory) {
		// key is item as a string
		// value is price as a double
				
		inventory.put("Jujubees", 1.25);
		inventory.put("Nerds", 1.15);
		inventory.put("Mike & Ike", 2.25);
		inventory.put("Sour Patch Kids", 2.45);
		inventory.put("Junior Mints", 2.25);
		inventory.put("Twizzlers", 2.35);
		inventory.put("Swedish Fish", 2.75);
		inventory.put("Goobers", 2.25);
		
		return inventory;
	}
	
	
	// method to display the inventory and prices of the store
	private static void displayInventory(HashMap<String, Double> inventory) {
		String format = "%-10s\t\t$%s";
		System.out.println("Item\t\t\tPrice");
		System.out.println("=============================");
		
		for (String item : inventory.keySet()) {
			System.out.printf(format, item, inventory.get(item));
			System.out.println();
		}
	}

}
	
