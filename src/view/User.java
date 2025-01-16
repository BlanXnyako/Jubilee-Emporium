package view;

public class User {

	String userName;
	String userEmail;
	String userPassword;
	
	Integer userCoin;
	
	Integer heart_inv;
	Integer coffee_inv;
	Integer whetstone_inv;
	Integer twinheart_inv;
	Integer smokebomb_inv;
	
	public User(String userName, String userEmail, String userPassword, Integer userCoin, Integer heart_inv,
			Integer coffee_inv, Integer whetstone_inv, Integer twinheart_inv, Integer smokebomb_inv) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userCoin = userCoin;
		this.heart_inv = heart_inv;
		this.coffee_inv = coffee_inv;
		this.whetstone_inv = whetstone_inv;
		this.twinheart_inv = twinheart_inv;
		this.smokebomb_inv = smokebomb_inv;
	}
	
	
}
