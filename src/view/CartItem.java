package view;

public class CartItem {

	Item cart_item;
	Integer cart_quantity;
	
	public CartItem(Item cart_item, Integer cart_quantity) {
		super();
		this.cart_item = cart_item;
		this.cart_quantity = cart_quantity;
	}

	public Item getCart_item() {
		return cart_item;
	}

	public void setCart_item(Item cart_item) {
		this.cart_item = cart_item;
	}

	public Integer getCart_quantity() {
		return cart_quantity;
	}

	public void setCart_quantity(Integer cart_quantity) {
		this.cart_quantity = cart_quantity;
	}
	
}
