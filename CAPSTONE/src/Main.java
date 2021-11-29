import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// Initialise order details (see Restaurant.java for details)
		Order Order1 = new Order();
		// Initialise customer details (see Customer.java for details)
		Customer Customer1 = new Customer();

		/* Requests user to enter amount of different orders received and then build an ArrayList of Items (see Restaurant.java).
		 * itemsAmount is requested so program knows how many different item objects to create.*/
		int itemsAmount = Integer.parseInt(JOptionPane.showInputDialog("Please enter the amount of DIFFERENT items ordered:"));
		List<Item> itemObjects = new ArrayList<Item>();
		for (int i = 0; i < itemsAmount; i++)
		{
			itemObjects.add(new Item());
		}
		
		// Initialise driver using getDriver function and pass Order1 as parameter
		Driver allocatedDriver = getDriver(Order1);
		
		/* If city of order(restaurant) isn't equal to city of customer, call printErrorReceipt function, 
		 * else call printReceipt function, and call Order1, Customer1, itemObjects and driver as parameters.*/
		if (Order1.city.equalsIgnoreCase(Customer1.city) == false) {
			printErrorReceipt();
		}
		else {
			printReceipt(Order1, Customer1, itemObjects, allocatedDriver);
		}
	}

	public static Driver getDriver(Order order) {
		// Create empty Driver object
		Driver returnDriver = new Driver("", "", 0);
		// Try and catch blocks in case driver-info.txt is not found
		try {
			// New scanner on file drivers.txt
			File input = new File("driver-info.txt");
			Scanner sc = new Scanner(input);
			
			/* Initialise firstDriver boolean. Will store the first driver found in the file as the main Driver, which then allows 
			 * program to compare the next drivers.*/
			boolean firstDriver = true;

			// Iterate through drivers.txt while there is still a next line
			while (sc.hasNextLine()) 
			{
				// Current line in iteration = String currentDriver
				String currentDriver = sc.nextLine();
				// Split String by a comma and space and create String list
				String[] driverList = currentDriver.split(", ");
				
				/* If Driver's city is equal to the order's city AND (current Driver's load is smaller than the stored driver OR
				 * boolean firstDriver is true)*/
				if (driverList[1].equalsIgnoreCase(order.city) && 
					(Integer.parseInt(driverList[2]) < returnDriver.load || firstDriver == true)) {
					
					// Add current driver, make 'firstDriver' false
					returnDriver.name = driverList[0];
					returnDriver.city = driverList[1];
					returnDriver.load = Integer.parseInt(driverList[2]);
					firstDriver = false;
				}
			}
			sc.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Error");
		}
		return returnDriver;
	}
	
	public static void printReceipt(Order order, Customer customer, List<Item> itemList, Driver driver) {
		try {
			// Use fileWriter to print text to new file invoice.txt
			FileWriter fileWriter = new FileWriter("invoice.txt");
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			printWriter.printf("Order number: %s%n", order.orderNumber);
			printWriter.printf("Customer: %s%n", customer.name);
			printWriter.printf("Email: %s%n", customer.email);
			printWriter.printf("Phone number: %s%n", customer.phoneNumber);
			printWriter.printf("Location: %s%n", customer.city);
			printWriter.printf("You have ordered the following from %s in %s:%n", order.name, order.city);
			// Use for loop to iterate through list of order Items and print each
			for (int i = 0; i < itemList.size(); i++)
			{
				Item currentItem = itemList.get(i);
				printWriter.printf("%s x %s (R%s)%n", currentItem.itemAmount, currentItem.itemName, currentItem.itemPrice);
			}
			printWriter.printf("Special instructions: %s%n", order.specifications);
			printWriter.printf("%s is nearest to the restaurant and so he will be delivering your order"
					+ " to you at:%n", driver.name);
			printWriter.printf("%s%n", customer.address);
			printWriter.printf("If you need to contact the restaurant, their number is %s", order.phoneNumber);
			printWriter.close();
		}
		// Catch IOException
		catch (IOException e) {
			System.out.println("Error");
		}
	}
	
	// Print error on to receipt if customer does not stay in city that the restaurant is in
	public static void printErrorReceipt() {
		try {
			FileWriter fileWriter = new FileWriter("invoice.txt");
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.print("Sorry! Our drivers are too far away from you to be able to deliver to your location.");
			printWriter.close();
		}
		catch (IOException e) {
			System.out.println("Error");
		}
	}
}