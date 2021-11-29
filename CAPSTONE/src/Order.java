import javax.swing.JOptionPane;

// Object order extends Restaurant, and also includes the attributes for order number and special instructions (specifications)
class Order extends Restaurant {
	String orderNumber;
	String specifications;
	
	Order() {
		super();
		this.orderNumber = getOrderNumber();
		this.specifications = getSpecifications();				
	}
	
	private String getOrderNumber() {
		String output = JOptionPane.showInputDialog("Please enter order number: ");
		return output;
	}
	private String getSpecifications() {
		String output = JOptionPane.showInputDialog("Please enter order specifications: ");
		return output;
	}
}