package view;

public class Variables {
	
	private Integer heart_price = 5;
	private Integer heart_stock = 10;
	private String heart_desc = "Adds an additional hit point but lightly weakens your attack power.";
	
	private Integer coffee_price = 8;
	private Integer coffee_stock = 7;
	private String coffee_desc = "Super meter continuously fills in addition to what you earn.";
	
	private Integer whetstone_price = 6;
	private Integer whetstone_stock = 6;
	private String whetstone_desc = "Your first parry move doubles as a damaging axe attack.";
	
	private Integer twinheart_price = 5;
	private Integer twinheart_stock = 3;
	private String twinheart_desc = "Adds two additional hit points but weakens your attack power.";
	
	private Integer smokebomb_price = 6;
	private Integer smokebomb_stock = 12;
	private String smokebomb_desc = "You will not take damage during a dash. A great defense maneuver.";
	
	private Integer coin = 100;
	private Integer cart_total = 0;
	
	private Integer heart_cartquantity = 0;
	private Integer coffee_cartquantity = 0;
	private Integer whetstone_cartquantity = 0;
	private Integer twinheart_cartquantity = 0;
	private Integer smokebomb_cartquantity = 0;
	
	private Integer heart_inv = 5;
	private Integer coffee_inv = 3;
	private Integer whetstone_inv = 4;
	private Integer twinheart_inv = 2;
	private Integer smokebomb_inv = 7;
	
	private Boolean isAdmin;

	/*
	public Integer heart_price = 5;
	public Integer heart_stock = 10;
	public String heart_desc = "Adds an additional hit point but lightly weakens your attack power.";
	
	public Integer coffee_price = 8;
	public Integer coffee_stock = 7;
	public String coffee_desc = "Super meter continuously fills in addition to what you earn.";
	
	public Integer whetstone_price = 6;
	public Integer whetstone_stock = 6;
	public String whetstone_desc = "Your first parry move doubles as a damaging axe attack.";
	
	public Integer twinheart_price = 5;
	public Integer twinheart_stock = 3;
	public String twinheart_desc = "Adds two additional hit points but weakens your attack power.";
	
	public Integer smokebomb_price = 6;
	public Integer smokebomb_stock = 12;
	public String smokebomb_desc = "You will not take damage during a dash. A great defense maneuver.";
	
	public Integer coin = 100;
	public Integer cart_total = 0;
	
	public Integer heart_cartquantity = 0;
	public Integer coffee_cartquantity = 0;
	public Integer whetstone_cartquantity = 0;
	public Integer twinheart_cartquantity = 0;
	public Integer smokebomb_cartquantity = 0;
	
	public Integer heart_inv = 5;
	public Integer coffee_inv = 3;
	public Integer whetstone_inv = 4;
	public Integer twinheart_inv = 2;
	public Integer smokebomb_inv = 7;
	*/
	
	public Integer getCoin() {
		return coin;
	}

	public void setCoin(Integer coin) {
		this.coin = coin;
	}
	
	public Integer getCart_total() {
		return cart_total;
	}
	public void setCart_total(Integer cart_total) {
		this.cart_total = cart_total;
	}
	
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public Integer getHeart_inv() {
		return heart_inv;
	}
	public void setHeart_inv(Integer heart_inv) {
		this.heart_inv = heart_inv;
	}
	public Integer getCoffee_inv() {
		return coffee_inv;
	}
	public void setCoffee_inv(Integer coffee_inv) {
		this.coffee_inv = coffee_inv;
	}
	public Integer getWhetstone_inv() {
		return whetstone_inv;
	}
	public void setWhetstone_inv(Integer whetstone_inv) {
		this.whetstone_inv = whetstone_inv;
	}
	public Integer getTwinheart_inv() {
		return twinheart_inv;
	}
	public void setTwinheart_inv(Integer twinheart_inv) {
		this.twinheart_inv = twinheart_inv;
	}
	public Integer getSmokebomb_inv() {
		return smokebomb_inv;
	}
	public void setSmokebomb_inv(Integer smokebomb_inv) {
		this.smokebomb_inv = smokebomb_inv;
	}
	public Integer getHeart_cartquantity() {
		return heart_cartquantity;
	}
	public void setHeart_cartquantity(Integer heart_cartquantity) {
		this.heart_cartquantity = heart_cartquantity;
	}
	public Integer getCoffee_cartquantity() {
		return coffee_cartquantity;
	}
	public void setCoffee_cartquantity(Integer coffee_cartquantity) {
		this.coffee_cartquantity = coffee_cartquantity;
	}
	public Integer getWhetstone_cartquantity() {
		return whetstone_cartquantity;
	}
	public void setWhetstone_cartquantity(Integer whetstone_cartquantity) {
		this.whetstone_cartquantity = whetstone_cartquantity;
	}
	public Integer getTwinheart_cartquantity() {
		return twinheart_cartquantity;
	}
	public void setTwinheart_cartquantity(Integer twinheart_cartquantity) {
		this.twinheart_cartquantity = twinheart_cartquantity;
	}
	public Integer getSmokebomb_cartquantity() {
		return smokebomb_cartquantity;
	}
	public void setSmokebomb_cartquantity(Integer smokebomb_cartquantity) {
		this.smokebomb_cartquantity = smokebomb_cartquantity;
	}
	
	public Integer getHeart_price() {
		return heart_price;
	}
	public void setHeart_price(Integer heart_price) {
		this.heart_price = heart_price;
	}
	public Integer getHeart_stock() {
		return heart_stock;
	}
	public void setHeart_stock(Integer heart_stock) {
		this.heart_stock = heart_stock;
	}
	public String getHeart_desc() {
		return heart_desc;
	}
	public void setHeart_desc(String heart_desc) {
		this.heart_desc = heart_desc;
	}
	public Integer getCoffee_price() {
		return coffee_price;
	}
	public void setCoffee_price(Integer coffee_price) {
		this.coffee_price = coffee_price;
	}
	public Integer getCoffee_stock() {
		return coffee_stock;
	}
	public void setCoffee_stock(Integer coffee_stock) {
		this.coffee_stock = coffee_stock;
	}
	public String getCoffee_desc() {
		return coffee_desc;
	}
	public void setCoffee_desc(String coffee_desc) {
		this.coffee_desc = coffee_desc;
	}
	public Integer getWhetstone_price() {
		return whetstone_price;
	}
	public void setWhetstone_price(Integer whetstone_price) {
		this.whetstone_price = whetstone_price;
	}
	public Integer getWhetstone_stock() {
		return whetstone_stock;
	}
	public void setWhetstone_stock(Integer whetstone_stock) {
		this.whetstone_stock = whetstone_stock;
	}
	public String getWhetstone_desc() {
		return whetstone_desc;
	}
	public void setWhetstone_desc(String whetstone_desc) {
		this.whetstone_desc = whetstone_desc;
	}
	public Integer getTwinheart_price() {
		return twinheart_price;
	}
	public void setTwinheart_price(Integer twinheart_price) {
		this.twinheart_price = twinheart_price;
	}
	public Integer getTwinheart_stock() {
		return twinheart_stock;
	}
	public void setTwinheart_stock(Integer twinheart_stock) {
		this.twinheart_stock = twinheart_stock;
	}
	public String getTwinheart_desc() {
		return twinheart_desc;
	}
	public void setTwinheart_desc(String twinheart_desc) {
		this.twinheart_desc = twinheart_desc;
	}
	public Integer getSmokebomb_price() {
		return smokebomb_price;
	}
	public void setSmokebomb_price(Integer smokebomb_price) {
		this.smokebomb_price = smokebomb_price;
	}
	public Integer getSmokebomb_stock() {
		return smokebomb_stock;
	}
	public void setSmokebomb_stock(Integer smokebomb_stock) {
		this.smokebomb_stock = smokebomb_stock;
	}
	public String getSmokebomb_desc() {
		return smokebomb_desc;
	}
	public void setSmokebomb_desc(String smokebomb_desc) {
		this.smokebomb_desc = smokebomb_desc;
	}
	
}
