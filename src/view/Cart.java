package view;

import java.util.Vector;

public class Cart {
	private static Cart instance = null;
	private Vector<CartItem> cartItems;
	private Vector<Item> itemToSell;
	private Vector<User> users;

	public Vector<Item> getItemToSell() {
		return itemToSell;
	}

	public void setItemToSell(Vector<Item> itemToSell) {
		this.itemToSell = itemToSell;
	}

	private Cart() {
		cartItems = new Vector<>();
		users = new Vector<>();
	}
	
	public static Cart getInstance() {
		if (instance == null) {
			instance = new Cart();
	    }
	    return instance;
	}
	
	private Integer cartTotal = 0;
	
	private Boolean heart_incart = false;
	private Boolean coffee_incart = false;
	private Boolean whetstone_incart = false;
	private Boolean twinheart_incart = false;
	private Boolean smokebomb_incart = false;
	
	private Integer coin = 100;
	
	private Integer viewCharm = 4;
	
	private Boolean isAdmin = false;
	
	private Integer userAmount = 0;
	
	private Integer userID;

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getUserAmount() {
		return userAmount;
	}

	public void setUserAmount(Integer userAmount) {
		this.userAmount = userAmount;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Integer getViewCharm() {
		return viewCharm;
	}

	public void setViewCharm(Integer viewCharm) {
		this.viewCharm = viewCharm;
	}

	public Integer getCoin() {
		return coin;
	}

	public void setCoin(Integer coin) {
		this.coin = coin;
	}

	public Boolean getHeart_incart() {
		return heart_incart;
	}

	public void setHeart_incart(Boolean heart_incart) {
		this.heart_incart = heart_incart;
	}

	public Boolean getCoffee_incart() {
		return coffee_incart;
	}

	public void setCoffee_incart(Boolean coffee_incart) {
		this.coffee_incart = coffee_incart;
	}

	public Boolean getWhetstone_incart() {
		return whetstone_incart;
	}

	public void setWhetstone_incart(Boolean whetstone_incart) {
		this.whetstone_incart = whetstone_incart;
	}

	public Boolean getTwinheart_incart() {
		return twinheart_incart;
	}

	public void setTwinheart_incart(Boolean twinheart_incart) {
		this.twinheart_incart = twinheart_incart;
	}

	public Boolean getSmokebomb_incart() {
		return smokebomb_incart;
	}

	public void setSmokebomb_incart(Boolean smokebomb_incart) {
		this.smokebomb_incart = smokebomb_incart;
	}

	public Integer getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(Integer cartTotal) {
		this.cartTotal = cartTotal;
	}
	
	public Vector<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Vector<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public Vector<User> getUsers() {
		return users;
	}

	public void setUsers(Vector<User> users) {
		this.users = users;
	}

	public void addUser(User a) {
		users.add(a);
	}
	
	public void addItem(CartItem item) {
        cartItems.add(item);
    }
	
	public void clearCart() {
        cartItems.clear();
    }
	
}
