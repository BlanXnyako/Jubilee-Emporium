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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import lib.StageManager;

public class LoginPage extends ViewBase{

	private StackPane sp;
	private GridPane gp;
	private VBox vb;
	
	private Media media;
	private MediaPlayer mediaPlayer;
	private MediaView mediaView;
	
	private static Media bgm;
	private static MediaPlayer bgm_mp;
	private static MediaView bgm_mv;
	
	private Label header_lb, email_lb, password_lb;
	private TextField email_tf;
	private PasswordField password_pf;
	private Hyperlink register_hl;
	private Button login_btn;
	private ColorAdjust colorAdjust;
	
	private Alert alert;
	
	private Cart cart;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
		this.cart = Cart.getInstance();
		this.cart.addItem(new CartItem(new Heart(), 0));
		this.cart.addItem(new CartItem(new Coffee(), 0));
		this.cart.addItem(new CartItem(new Whetstone(), 0));
		this.cart.addItem(new CartItem(new Twinheart(), 0));
		this.cart.addItem(new CartItem(new Smokebomb(), 0));
		
		this.sp = new StackPane();
		this.gp = new GridPane();
		this.vb = new VBox();
		
		this.colorAdjust = new ColorAdjust();
		
		this.header_lb = new Label("Jubilee Emporium");
		this.email_lb = new Label("Email");
		this.email_tf = new TextField();
		this.password_lb = new Label("Password");
		this.password_pf = new PasswordField();
		this.register_hl = new Hyperlink("Click here to register");
		this.login_btn = new Button("Login");
		
		this.media = new Media(
				new File("Assets/video/video.mp4")
				.toURI()
				.toString()
				);
		this.mediaPlayer = new MediaPlayer(media);
		this.mediaView = new MediaView();
		
		bgm = new Media(new File("Assets/audio/bgm.mp3").toURI().toString());
		bgm_mp = new MediaPlayer(bgm);
		bgm_mv = new MediaView();
		
		this.alert = new Alert(AlertType.ERROR);
		
	}
	
	@Override
	public void setComponent() {
		// TODO Auto-generated method stub
		this.mediaView.setMediaPlayer(mediaPlayer);
		bgm_mv.setMediaPlayer(bgm_mp);
		this.sp.getChildren().add(mediaView);
		this.sp.getChildren().add(vb);
		
		this.vb.getChildren().add(header_lb);
		this.vb.getChildren().add(gp);
		
		this.gp.add(email_lb, 0, 0);
		this.gp.add(email_tf, 0, 1);
		this.gp.add(password_lb, 0, 2);
		this.gp.add(password_pf, 0, 3);
		this.gp.add(register_hl, 0, 4);
		this.gp.add(login_btn, 0, 5);
				
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
		mediaView.setEffect(colorAdjust);
		
		header_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 64));
		header_lb.setStyle("-fx-text-fill: white;");
		email_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		email_lb.setStyle("-fx-text-fill: white;");
		password_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		password_lb.setStyle("-fx-text-fill: white;");
		register_hl.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		register_hl.setStyle("-fx-text-fill: white;");
		login_btn.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		login_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: brown;");
		login_btn.setPrefWidth(400);
	}

	@Override
	public void setAction() {
		// TODO Auto-generated method stub
		this.mediaPlayer.setAutoPlay(true);
		this.mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		
		bgm_mp.setAutoPlay(true);
		bgm_mp.setCycleCount(MediaPlayer.INDEFINITE);
		
		this.register_hl.setOnAction(event -> {
			StageManager.getInstance().changeScene(new RegisterPage().getScene());
		});
		
		login_btn.setOnMouseEntered(event -> {
			login_btn.setStyle("-fx-background-color: red;");
		});
		login_btn.setOnMouseExited(event -> {
			login_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		});
		
		login_btn.setOnAction(event -> {
			if(email_tf.getText().contentEquals("admin@gmail.com") && password_pf.getText().contentEquals("admin")) {
				cart.setIsAdmin(true);
				StageManager.getInstance().changeScene(new AdminPage().getScene());
			}
			else {
				if(validateForm()) {
					cart.setIsAdmin(false);
					StageManager.getInstance().changeScene(new ShopPage().getScene());
				}
			}
		});
		
	}
	
	private boolean validateForm() { 
		if(email_tf.getText().length() == 0) {
			this.alert.setContentText("Email must be filled in!");
			alert.show();
			return false;
		}
		if(cart.getUserAmount() == 0) {
			this.alert.setContentText("Email does not exist in user data!");
			alert.show();
			return false;
		}
		else {
			for(int i=0; i<cart.getUserAmount(); i++) {
				if(email_tf.getText().contentEquals(cart.getUsers().get(i).userEmail)) {
					cart.setUserID(i);
					break;
				}
				if(i == cart.getUserAmount()-1) {
					this.alert.setContentText("Email does not exist in user data!");
					alert.show();
					return false;
				}
			}
			
		}
		if(password_pf.getText().length() == 0) {
			this.alert.setContentText("Password must be filled in!");
			alert.show();
			return false;
		}
		if(!password_pf.getText().contentEquals(cart.getUsers().get(cart.getUserID()).userPassword)) {
			this.alert.setContentText("Invalid Password!");
			alert.show();
			return false;
		}
		
		return true;
	}
	
}
