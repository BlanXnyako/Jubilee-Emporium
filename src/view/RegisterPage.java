package view;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import lib.StageManager;

public class RegisterPage extends ViewBase{

	private StackPane sp;
	private GridPane gp;
	private VBox vb;
	
	private Image image;
	private ImageView imageView;
	
	private Label header_lb, name_lb, email_lb, password_lb, confirm_lb;
	private TextField name_tf, email_tf;
	private PasswordField password_pf, confirm_pf;
	private Hyperlink login_hl;
	private Button register_btn;
	private ColorAdjust colorAdjust;
	
	private Alert alert;
	
	private Cart cart;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		this.cart = Cart.getInstance();
		
		this.sp = new StackPane();
		this.gp = new GridPane();
		this.vb = new VBox();
		
		this.colorAdjust = new ColorAdjust();
		
		this.header_lb = new Label("Jubilee Emporium");
		this.name_lb = new Label("Name");
		this.name_tf = new TextField();
		this.email_lb = new Label("Email");
		this.email_tf = new TextField();
		this.password_lb = new Label("Password");
		this.password_pf = new PasswordField();
		this.confirm_lb = new Label("Confirm Password");
		this.confirm_pf = new PasswordField();
		this.login_hl = new Hyperlink("Login here");
		this.register_btn = new Button("Register Account");
		
		this.imageView = new ImageView();
		this.image = new Image(
				new File("Assets/image/register bg.jpg")
				.toURI()
				.toString()
				);
		
		this.alert = new Alert(AlertType.ERROR);
	}

	@Override
	public void setComponent() {
		// TODO Auto-generated method stub
		this.imageView.setImage(image);
		this.sp.getChildren().add(imageView);
		this.sp.getChildren().add(vb);
		
		this.vb.getChildren().add(header_lb);
		this.vb.getChildren().add(gp);
		
		this.gp.add(name_lb, 0, 0);
		this.gp.add(name_tf, 0, 1);
		this.gp.add(email_lb, 0, 2);
		this.gp.add(email_tf, 0, 3);
		this.gp.add(password_lb, 0, 4);
		this.gp.add(password_pf, 0, 5);
		this.gp.add(confirm_lb, 0, 6);
		this.gp.add(confirm_pf, 0, 7);
		this.gp.add(login_hl, 0, 8);
		this.gp.add(register_btn, 0, 9);
				
		colorAdjust.setBrightness(-0.3);
		
		this.scene.setRoot(sp);
		
	}

	@Override
	public void setStyle() {
		// TODO Auto-generated method stub
		vb.setSpacing(15);
		gp.setVgap(10);
		sp.setAlignment(Pos.CENTER);
		vb.setAlignment(Pos.CENTER);
		gp.setAlignment(Pos.CENTER);
		imageView.setEffect(colorAdjust);
		
		header_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 64));
		header_lb.setStyle("-fx-text-fill: white;");
		name_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		name_lb.setStyle("-fx-text-fill: white;");
		email_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		email_lb.setStyle("-fx-text-fill: white;");
		password_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		password_lb.setStyle("-fx-text-fill: white;");
		confirm_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		confirm_lb.setStyle("-fx-text-fill: white;");
		login_hl.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		login_hl.setStyle("-fx-text-fill: white;");
		register_btn.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		register_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705;");
		register_btn.setPrefWidth(400);
	}

	@Override
	public void setAction() {
		// TODO Auto-generated method stub
		register_btn.setOnMouseEntered(event -> {
			register_btn.setStyle("-fx-background-color: red;");
		});
		register_btn.setOnMouseExited(event -> {
			register_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		});
		
		this.register_btn.setOnAction(event -> {
			if(validateForm()) {
				cart.addUser(new User(name_tf.getText(), email_tf.getText(), password_pf.getText(), 100, 0, 0, 0, 0, 0));
				cart.setUserAmount(cart.getUserAmount()+1);
				StageManager.getInstance().changeScene(new LoginPage().getScene());
			}
		});
		
		this.login_hl.setOnAction(event -> {
			StageManager.getInstance().changeScene(new LoginPage().getScene());
		});
	}
	
	
	private boolean validateForm() {
		if(name_tf.getText().length() == 0) {
			this.alert.setContentText("Name must be filled in!");
			alert.show();
			return false;
		}
		if(name_tf.getText().length() < 3 || name_tf.getText().length() > 12) {
			this.alert.setContentText("Name must 3 – 12 characters long (inclusive)!");
			alert.show();
			return false;
		}
		if(email_tf.getText().length() == 0) {
			this.alert.setContentText("Email must be filled in!");
			alert.show();
			return false;
		}
		if(cart.getUserAmount() > 0) {
			for(int i = 0; i<cart.getUserAmount(); i++) {
				if(email_tf.getText().contentEquals(cart.getUsers().get(i).userEmail)) {
					this.alert.setContentText("Email must be unique!");
					alert.show();
					return false;
				}
			}
		}
		if(!email_tf.getText().endsWith("@gmail.com")) {
			this.alert.setContentText("Email must end with '@gmail.com'!");
			alert.show();
			return false;
		}
		if(email_tf.getText().contains(" ")) {
			this.alert.setContentText("Email must not contain space!");
			alert.show();
			return false;
		}
		if(password_pf.getText().length() == 0) {
			this.alert.setContentText("Password must be filled in!");
			alert.show();
			return false;
		}
		if(password_pf.getText().length() < 8) {
			this.alert.setContentText("Password must be at least 8 characters long (inclusive)!");
			alert.show();
			return false;
		}
		if(!checkAlphaNumeric(password_pf.getText())) {
			this.alert.setContentText("Password must be alphanumeric!");
			alert.show();
			return false;
		}
		if(confirm_pf.getText().length() == 0) {
			this.alert.setContentText("Confirm Password must be filled in!");
			alert.show();
			return false;
		}
		if(!password_pf.getText().contentEquals(confirm_pf.getText())) {
			this.alert.setContentText("Password and Confirm Password must be the same!");
			alert.show();
			return false;
		}

		return true;
	}
	
	private boolean checkAlphaNumeric(String text) {
		int alpha = 0;
		int num = 0;
		for(int i = 0; i<text.length(); i++) {
			if (Character.isAlphabetic(text.charAt(i))) {
				alpha++;
			}
			if (Character.isDigit(text.charAt(i))) {
				num++;
			}
			if (alpha != 0 && num != 0) {
				return true;
			}
		}
		return false;
	}
	
}
