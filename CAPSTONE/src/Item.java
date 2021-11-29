import javax.swing.JOptionPane;

/* Object item describes one item on menu (eg. chicken burger), and has attributes for item name,
 * amount being ordered, and price for single item.*/
class Item {
	String itemName;
	String itemAmount;
	String itemPrice;
	public Item() {
		this.itemName = getItemName();
		this.itemAmount = getAmount();
		this.itemPrice = getPrice();
	}

	private String getItemName() {
		String output = JOptionPane.showInputDialog("Please enter Item name: ");
		return output;
	}
	private String getAmount() {
		String output = JOptionPane.showInputDialog("Please enter amount of item ordered: ");
		return output;
	}
	private String getPrice() {
		String output = JOptionPane.showInputDialog("Please enter price of item ordered: ");
		return output;
	}
}