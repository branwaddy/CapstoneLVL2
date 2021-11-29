import javax.swing.JOptionPane;

// Object Customer contains attributes for Customer name, phone number, address, city and email address
public class Customer {
	String name;
	String phoneNumber;
	String address;
	String city;
	String email;
	
	public Customer () {
		// Constructor calls functions to get all attributes by getting input from user
		this.name = getName();
		this.phoneNumber = getNumber();
		this.address = getAddress();
		this.city = getCity();
		this.email = getEmail();
	}
	
	
	// Functions that get information through input from user
	private String getName() {
		String output = JOptionPane.showInputDialog("Please enter customer's name: ");
		return output;
	}
	private String getNumber() {
		String output = JOptionPane.showInputDialog("Please enter customer's phone number: ");
		return output;
	}
	private String getAddress() {
		String output = JOptionPane.showInputDialog("Please enter customer's address: ");
		return output;
	}
	private String getCity() {
		String output = JOptionPane.showInputDialog("Please enter customer's city: ");
		return output;
	}
	private String getEmail() {
		String output = JOptionPane.showInputDialog("Please enter customer's email address: ");
		return output;
	}
	
	
}
