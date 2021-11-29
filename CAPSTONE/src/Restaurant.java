import javax.swing.JOptionPane;

// Object Restaurant contains attributes for Restaurant's name, phone number and city
public class Restaurant {
	String name;
	String phoneNumber;
	String city;
	
	public Restaurant () {
		// Constructor calls functions to get all attributes by getting input from user
		this.name = getName();
		this.phoneNumber = getNumber();
		this.city = getCity();
	}
	
	// Functions that get information through input from user
	private String getName() {
		String output = JOptionPane.showInputDialog("Please enter restaurant's name: ");
		return output;
	}
	private String getNumber() {
		String output = JOptionPane.showInputDialog("Please enter restaurant' phone number: ");
		return output;
	}
	private String getCity() {
		String output = JOptionPane.showInputDialog("Please enter restaurant's city: ");
		return output;
	}
}
