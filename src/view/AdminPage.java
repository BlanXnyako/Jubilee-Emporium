package view;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import lib.StageManager;

public class AdminPage extends ViewBase{

	private BorderPane bp;
	private VBox base_vb, header_vb;
	private ScrollPane scroll;
	
	private Label header_lb;
	
	private HBox heart_hb, heart_upper_hb;
	private VBox heart_image_vb, heart_text_vb;
	private Label heart_img_lb, heart_price_lb, heart_stock_lb, heart_desc_lb;
	private Image heart_img;
	private ImageView heart_imgv;
	private TextField heart_price_tf;
	private Spinner<Integer> heart_stock_spinner;
	private TextArea heart_desc_ta;
	private Button heart_btn;
	
	private HBox coffee_hb, coffee_upper_hb;
	private VBox coffee_image_vb, coffee_text_vb;
	private Label coffee_img_lb, coffee_price_lb, coffee_stock_lb, coffee_desc_lb;
	private Image coffee_img;
	private ImageView coffee_imgv;
	private TextField coffee_price_tf;
	private Spinner<Integer> coffee_stock_spinner;
	private TextArea coffee_desc_ta;
	private Button coffee_btn;
	
	private HBox whetstone_hb, whetstone_upper_hb;
	private VBox whetstone_image_vb, whetstone_text_vb;
	private Label whetstone_img_lb, whetstone_price_lb, whetstone_stock_lb, whetstone_desc_lb;
	private Image whetstone_img;
	private ImageView whetstone_imgv;
	private TextField whetstone_price_tf;
	private Spinner<Integer> whetstone_stock_spinner;
	private TextArea whetstone_desc_ta;
	private Button whetstone_btn;

	private HBox twinheart_hb, twinheart_upper_hb;
	private VBox twinheart_image_vb, twinheart_text_vb;
	private Label twinheart_img_lb, twinheart_price_lb, twinheart_stock_lb, twinheart_desc_lb;
	private Image twinheart_img;
	private ImageView twinheart_imgv;
	private TextField twinheart_price_tf;
	private Spinner<Integer> twinheart_stock_spinner;
	private TextArea twinheart_desc_ta;
	private Button twinheart_btn;
	
	private HBox smokebomb_hb, smokebomb_upper_hb;
	private VBox smokebomb_image_vb, smokebomb_text_vb;
	private Label smokebomb_img_lb, smokebomb_price_lb, smokebomb_stock_lb, smokebomb_desc_lb;
	private Image smokebomb_img;
	private ImageView smokebomb_imgv;
	private TextField smokebomb_price_tf;
	private Spinner<Integer> smokebomb_stock_spinner;
	private TextArea smokebomb_desc_ta;
	private Button smokebomb_btn;
	
	private MenuBar navbar;
	private Menu menu;
	private MenuItem logout_menu;
	
	private Alert alert;
	
	private Cart cart;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
		this.scroll = new ScrollPane();
		this.bp = new BorderPane();
		this.header_vb = new VBox();
		this.base_vb = new VBox();
		
		this.header_lb = new Label("Admin Page");
		
		this.cart = Cart.getInstance();
		
		this.heart_hb = new HBox();
		this.heart_image_vb = new VBox();
		this.heart_img_lb = new Label("Heart");
		this.heart_imgv = new ImageView();
		this.heart_img = new Image(new File("Assets/image/heart.png").toURI().toString());
		this.heart_text_vb = new VBox();
		this.heart_upper_hb = new HBox();
		this.heart_price_lb = new Label("Price: ");
		this.heart_price_tf = new TextField(cart.getCartItems().get(0).getCart_item().itemPrice.toString());
		this.heart_stock_lb = new Label("Stock: ");
		this.heart_stock_spinner = new Spinner<>(0, 99, cart.getCartItems().get(0).getCart_item().itemStock);
		this.heart_desc_lb = new Label("Description:");
		this.heart_desc_ta = new TextArea(cart.getCartItems().get(0).getCart_item().itemDesc);
		this.heart_btn = new Button("Update");
		
		this.coffee_hb = new HBox();
		this.coffee_image_vb = new VBox();
		this.coffee_img_lb = new Label("Coffee");
		this.coffee_imgv = new ImageView();
		this.coffee_img = new Image(new File("Assets/image/coffee.png").toURI().toString());
		this.coffee_text_vb = new VBox();
		this.coffee_upper_hb = new HBox();
		this.coffee_price_lb = new Label("Price: ");
		this.coffee_price_tf = new TextField(cart.getCartItems().get(1).getCart_item().itemPrice.toString());
		this.coffee_stock_lb = new Label("Stock: ");
		this.coffee_stock_spinner = new Spinner<>(0, 99, cart.getCartItems().get(1).getCart_item().itemStock);
		this.coffee_desc_lb = new Label("Description:");
		this.coffee_desc_ta = new TextArea(cart.getCartItems().get(1).getCart_item().itemDesc);
		this.coffee_btn = new Button("Update");
		
		this.whetstone_hb = new HBox();
		this.whetstone_image_vb = new VBox();
		this.whetstone_img_lb = new Label("Whetstone");
		this.whetstone_imgv = new ImageView();
		this.whetstone_img = new Image(new File("Assets/image/whetstone.png").toURI().toString());
		this.whetstone_text_vb = new VBox();
		this.whetstone_upper_hb = new HBox();
		this.whetstone_price_lb = new Label("Price: ");
		this.whetstone_price_tf = new TextField(cart.getCartItems().get(2).getCart_item().itemPrice.toString());
		this.whetstone_stock_lb = new Label("Stock: ");
		this.whetstone_stock_spinner = new Spinner<>(0, 99, cart.getCartItems().get(2).getCart_item().itemStock);
		this.whetstone_desc_lb = new Label("Description:");
		this.whetstone_desc_ta = new TextArea(cart.getCartItems().get(2).getCart_item().itemDesc);
		this.whetstone_btn = new Button("Update");
		
		this.twinheart_hb = new HBox();
		this.twinheart_image_vb = new VBox();
		this.twinheart_img_lb = new Label("Twin Heart");
		this.twinheart_imgv = new ImageView();
		this.twinheart_img = new Image(new File("Assets/image/twinheart.png").toURI().toString());
		this.twinheart_text_vb = new VBox();
		this.twinheart_upper_hb = new HBox();
		this.twinheart_price_lb = new Label("Price: ");
		this.twinheart_price_tf = new TextField(cart.getCartItems().get(3).getCart_item().itemPrice.toString());
		this.twinheart_stock_lb = new Label("Stock: ");
		this.twinheart_stock_spinner = new Spinner<>(0, 99, cart.getCartItems().get(3).getCart_item().itemStock);
		this.twinheart_desc_lb = new Label("Description:");
		this.twinheart_desc_ta = new TextArea(cart.getCartItems().get(3).getCart_item().itemDesc);
		this.twinheart_btn = new Button("Update");
		
		this.smokebomb_hb = new HBox();
		this.smokebomb_image_vb = new VBox();
		this.smokebomb_img_lb = new Label("Smoke Bomb");
		this.smokebomb_imgv = new ImageView();
		this.smokebomb_img = new Image(new File("Assets/image/smokebomb.png").toURI().toString());
		this.smokebomb_text_vb = new VBox();
		this.smokebomb_upper_hb = new HBox();
		this.smokebomb_price_lb = new Label("Price: ");
		this.smokebomb_price_tf = new TextField(cart.getCartItems().get(4).getCart_item().itemPrice.toString());
		this.smokebomb_stock_lb = new Label("Stock: ");
		this.smokebomb_stock_spinner = new Spinner<>(0, 99, cart.getCartItems().get(4).getCart_item().itemStock);
		this.smokebomb_desc_lb = new Label("Description:");
		this.smokebomb_desc_ta = new TextArea(cart.getCartItems().get(4).getCart_item().itemDesc);
		this.smokebomb_btn = new Button("Update");
		
		this.navbar = new MenuBar();
		this.menu = new Menu("Menu");
		this.logout_menu = new MenuItem("Logout");
		
		this.alert = new Alert(AlertType.ERROR);
	}

	@Override
	public void setComponent() {
		// TODO Auto-generated method stub
		this.scroll.setContent(base_vb);
		this.bp.setTop(header_vb);
		this.bp.setCenter(scroll);
		this.header_vb.getChildren().addAll(navbar, header_lb);
		
		this.heart_imgv.setImage(heart_img);
		this.heart_hb.getChildren().addAll(heart_image_vb, heart_text_vb);
		this.heart_image_vb.getChildren().addAll(heart_img_lb, heart_imgv);
		this.heart_text_vb.getChildren().addAll(heart_upper_hb, heart_desc_lb, heart_desc_ta, heart_btn);
		this.heart_upper_hb.getChildren().addAll(heart_price_lb, heart_price_tf, heart_stock_lb, heart_stock_spinner);
		
		this.coffee_imgv.setImage(coffee_img);
		this.coffee_hb.getChildren().addAll(coffee_image_vb, coffee_text_vb);
		this.coffee_image_vb.getChildren().addAll(coffee_img_lb, coffee_imgv);
		this.coffee_text_vb.getChildren().addAll(coffee_upper_hb, coffee_desc_lb, coffee_desc_ta, coffee_btn);
		this.coffee_upper_hb.getChildren().addAll(coffee_price_lb, coffee_price_tf, coffee_stock_lb, coffee_stock_spinner);
		
		this.whetstone_imgv.setImage(whetstone_img);
		this.whetstone_hb.getChildren().addAll(whetstone_image_vb, whetstone_text_vb);
		this.whetstone_image_vb.getChildren().addAll(whetstone_img_lb, whetstone_imgv);
		this.whetstone_text_vb.getChildren().addAll(whetstone_upper_hb, whetstone_desc_lb, whetstone_desc_ta, whetstone_btn);
		this.whetstone_upper_hb.getChildren().addAll(whetstone_price_lb, whetstone_price_tf, whetstone_stock_lb, whetstone_stock_spinner);
		
		this.twinheart_imgv.setImage(twinheart_img);
		this.twinheart_hb.getChildren().addAll(twinheart_image_vb, twinheart_text_vb);
		this.twinheart_image_vb.getChildren().addAll(twinheart_img_lb, twinheart_imgv);
		this.twinheart_text_vb.getChildren().addAll(twinheart_upper_hb, twinheart_desc_lb, twinheart_desc_ta, twinheart_btn);
		this.twinheart_upper_hb.getChildren().addAll(twinheart_price_lb, twinheart_price_tf, twinheart_stock_lb, twinheart_stock_spinner);
		
		this.smokebomb_imgv.setImage(smokebomb_img);
		this.smokebomb_hb.getChildren().addAll(smokebomb_image_vb, smokebomb_text_vb);
		this.smokebomb_image_vb.getChildren().addAll(smokebomb_img_lb, smokebomb_imgv);
		this.smokebomb_text_vb.getChildren().addAll(smokebomb_upper_hb, smokebomb_desc_lb, smokebomb_desc_ta, smokebomb_btn);
		this.smokebomb_upper_hb.getChildren().addAll(smokebomb_price_lb, smokebomb_price_tf, smokebomb_stock_lb, smokebomb_stock_spinner);
		
		this.base_vb.getChildren().addAll(heart_hb, coffee_hb, whetstone_hb, twinheart_hb, smokebomb_hb);

		this.navbar.getMenus().add(menu);
		this.menu.getItems().add(logout_menu);
		
		this.scene.setRoot(bp);
	}

	@Override
	public void setStyle() {
		// TODO Auto-generated method stub
		bp.setStyle("-fx-background-color: #613705;");
		bp.setAlignment(header_lb, Pos.CENTER);
		base_vb.prefWidthProperty().bind(getScene().widthProperty());
		base_vb.setStyle("-fx-background-color: #613705;");
		base_vb.setPadding(new Insets(15, 0, 15, 0));
		base_vb.setAlignment(Pos.CENTER);
		base_vb.setSpacing(15);
		header_vb.setAlignment(Pos.CENTER);
		scroll.setStyle("-fx-background-color: #613705;");
		
		header_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 56));
		header_lb.setStyle("-fx-text-fill: white;");
		
		heart_hb.setStyle("-fx-background-color: #9c4600;"+"-fx-background-radius: 15 15 15 15;");
		heart_hb.setMaxWidth(900);
		heart_hb.setMaxHeight(300);
		heart_hb.setPadding(new Insets(20,20,20,20));
		heart_img_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		heart_img_lb.setStyle("-fx-text-fill: white;");
		heart_image_vb.setAlignment(Pos.CENTER);
		heart_image_vb.setMinWidth(300);
		heart_image_vb.setMinHeight(200);
		heart_text_vb.setSpacing(10);
		heart_price_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		heart_price_lb.setStyle("-fx-text-fill: white;");
		heart_price_tf.setFont(Font.loadFont(new File("Assets/font/Espera-Regular.ttf").toURI().toString(), 14));
		heart_stock_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		heart_stock_lb.setStyle("-fx-text-fill: white;");
		heart_stock_lb.setPadding(new Insets(0, 0, 0, 10));
		heart_desc_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		heart_desc_lb.setStyle("-fx-text-fill: white;");
		heart_desc_ta.setFont(Font.loadFont(new File("Assets/font/Espera-Regular.ttf").toURI().toString(), 16));
		heart_desc_ta.setMaxHeight(120);
		heart_desc_ta.setMaxWidth(400);
		heart_desc_ta.setWrapText(true);
		heart_btn.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		heart_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		heart_btn.setPrefWidth(250);
		
		coffee_hb.setStyle("-fx-background-color: #9c4600;"+"-fx-background-radius: 15 15 15 15;");
		coffee_hb.setMaxWidth(900);
		coffee_hb.setMaxHeight(300);
		coffee_hb.setPadding(new Insets(20,20,20,20));
		coffee_img_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		coffee_img_lb.setStyle("-fx-text-fill: white;");
		coffee_image_vb.setAlignment(Pos.CENTER);
		coffee_image_vb.setMinWidth(300);
		coffee_image_vb.setMinHeight(200);
		coffee_text_vb.setSpacing(10);
		coffee_price_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		coffee_price_lb.setStyle("-fx-text-fill: white;");
		coffee_price_tf.setFont(Font.loadFont(new File("Assets/font/Espera-Regular.ttf").toURI().toString(), 14));
		coffee_stock_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		coffee_stock_lb.setStyle("-fx-text-fill: white;");
		coffee_stock_lb.setPadding(new Insets(0, 0, 0, 10));
		coffee_desc_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		coffee_desc_lb.setStyle("-fx-text-fill: white;");
		coffee_desc_ta.setFont(Font.loadFont(new File("Assets/font/Espera-Regular.ttf").toURI().toString(), 16));
		coffee_desc_ta.setMaxHeight(120);
		coffee_desc_ta.setMaxWidth(400);
		coffee_desc_ta.setWrapText(true);
		coffee_btn.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		coffee_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		coffee_btn.setPrefWidth(250);
		
		whetstone_hb.setStyle("-fx-background-color: #9c4600;"+"-fx-background-radius: 15 15 15 15;");
		whetstone_hb.setMaxWidth(900);
		whetstone_hb.setMaxHeight(300);
		whetstone_hb.setPadding(new Insets(20,20,20,20));
		whetstone_img_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		whetstone_img_lb.setStyle("-fx-text-fill: white;");
		whetstone_image_vb.setAlignment(Pos.CENTER);
		whetstone_image_vb.setMinWidth(300);
		whetstone_image_vb.setMinHeight(200);
		whetstone_text_vb.setSpacing(10);
		whetstone_price_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		whetstone_price_lb.setStyle("-fx-text-fill: white;");
		whetstone_price_tf.setFont(Font.loadFont(new File("Assets/font/Espera-Regular.ttf").toURI().toString(), 14));
		whetstone_stock_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		whetstone_stock_lb.setStyle("-fx-text-fill: white;");
		whetstone_stock_lb.setPadding(new Insets(0, 0, 0, 10));
		whetstone_desc_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		whetstone_desc_lb.setStyle("-fx-text-fill: white;");
		whetstone_desc_ta.setFont(Font.loadFont(new File("Assets/font/Espera-Regular.ttf").toURI().toString(), 16));
		whetstone_desc_ta.setMaxHeight(120);
		whetstone_desc_ta.setMaxWidth(400);
		whetstone_desc_ta.setWrapText(true);
		whetstone_btn.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		whetstone_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		whetstone_btn.setPrefWidth(250);
		
		twinheart_hb.setStyle("-fx-background-color: #9c4600;"+"-fx-background-radius: 15 15 15 15;");
		twinheart_hb.setMaxWidth(900);
		twinheart_hb.setMaxHeight(300);
		twinheart_hb.setPadding(new Insets(20,20,20,20));
		twinheart_img_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		twinheart_img_lb.setStyle("-fx-text-fill: white;");
		twinheart_image_vb.setAlignment(Pos.CENTER);
		twinheart_image_vb.setMinWidth(300);
		twinheart_image_vb.setMinHeight(200);
		twinheart_text_vb.setSpacing(10);
		twinheart_price_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		twinheart_price_lb.setStyle("-fx-text-fill: white;");
		twinheart_price_tf.setFont(Font.loadFont(new File("Assets/font/Espera-Regular.ttf").toURI().toString(), 14));
		twinheart_stock_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		twinheart_stock_lb.setStyle("-fx-text-fill: white;");
		twinheart_stock_lb.setPadding(new Insets(0, 0, 0, 10));
		twinheart_desc_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		twinheart_desc_lb.setStyle("-fx-text-fill: white;");
		twinheart_desc_ta.setFont(Font.loadFont(new File("Assets/font/Espera-Regular.ttf").toURI().toString(), 16));
		twinheart_desc_ta.setMaxHeight(120);
		twinheart_desc_ta.setMaxWidth(400);
		twinheart_desc_ta.setWrapText(true);
		twinheart_btn.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		twinheart_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		twinheart_btn.setPrefWidth(250);
		
		smokebomb_hb.setStyle("-fx-background-color: #9c4600;"+"-fx-background-radius: 15 15 15 15;");
		smokebomb_hb.setMaxWidth(900);
		smokebomb_hb.setMaxHeight(300);
		smokebomb_hb.setPadding(new Insets(20,20,20,20));
		smokebomb_img_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		smokebomb_img_lb.setStyle("-fx-text-fill: white;");
		smokebomb_image_vb.setAlignment(Pos.CENTER);
		smokebomb_image_vb.setMinWidth(300);
		smokebomb_image_vb.setMinHeight(200);
		smokebomb_text_vb.setSpacing(10);
		smokebomb_price_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		smokebomb_price_lb.setStyle("-fx-text-fill: white;");
		smokebomb_price_tf.setFont(Font.loadFont(new File("Assets/font/Espera-Regular.ttf").toURI().toString(), 14));
		smokebomb_stock_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		smokebomb_stock_lb.setStyle("-fx-text-fill: white;");
		smokebomb_stock_lb.setPadding(new Insets(0, 0, 0, 10));
		smokebomb_desc_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		smokebomb_desc_lb.setStyle("-fx-text-fill: white;");
		smokebomb_desc_ta.setFont(Font.loadFont(new File("Assets/font/Espera-Regular.ttf").toURI().toString(), 16));
		smokebomb_desc_ta.setMaxHeight(120);
		smokebomb_desc_ta.setMaxWidth(400);
		smokebomb_desc_ta.setWrapText(true);
		smokebomb_btn.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		smokebomb_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		smokebomb_btn.setPrefWidth(250);
		
	}

	@Override
	public void setAction() {
		// TODO Auto-generated method stub
		heart_btn.setOnMouseEntered(event -> {
			heart_btn.setStyle("-fx-background-color: red;");
		});
		heart_btn.setOnMouseExited(event -> {
			heart_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		});
		heart_btn.setOnAction(event -> {
			if(validateUpdate(heart_price_tf.getText(), heart_stock_spinner.getValue(), heart_desc_ta.getText())) {
				cart.getCartItems().get(0).getCart_item().itemPrice = Integer.parseInt(heart_price_tf.getText());
				cart.getCartItems().get(0).getCart_item().itemStock = heart_stock_spinner.getValue();
				cart.getCartItems().get(0).getCart_item().itemDesc = heart_desc_ta.getText();
			}
		});
		coffee_btn.setOnMouseEntered(event -> {
			coffee_btn.setStyle("-fx-background-color: red;");
		});
		coffee_btn.setOnMouseExited(event -> {
			coffee_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		});
		coffee_btn.setOnAction(event -> {
			if(validateUpdate(coffee_price_tf.getText(), coffee_stock_spinner.getValue(), coffee_desc_ta.getText())) {
				cart.getCartItems().get(1).getCart_item().itemPrice = Integer.parseInt(coffee_price_tf.getText());
				cart.getCartItems().get(1).getCart_item().itemStock = coffee_stock_spinner.getValue();
				cart.getCartItems().get(1).getCart_item().itemDesc = coffee_desc_ta.getText();
			}
		});
		whetstone_btn.setOnMouseEntered(event -> {
			whetstone_btn.setStyle("-fx-background-color: red;");
		});
		whetstone_btn.setOnMouseExited(event -> {
			whetstone_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		});
		whetstone_btn.setOnAction(event -> {
			if(validateUpdate(whetstone_price_tf.getText(), whetstone_stock_spinner.getValue(), whetstone_desc_ta.getText())) {
				cart.getCartItems().get(2).getCart_item().itemPrice = Integer.parseInt(whetstone_price_tf.getText());
				cart.getCartItems().get(2).getCart_item().itemStock = whetstone_stock_spinner.getValue();
				cart.getCartItems().get(2).getCart_item().itemDesc = whetstone_desc_ta.getText();
			}
		});
		twinheart_btn.setOnMouseEntered(event -> {
			twinheart_btn.setStyle("-fx-background-color: red;");
		});
		twinheart_btn.setOnMouseExited(event -> {
			twinheart_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		});
		twinheart_btn.setOnAction(event -> {
			if(validateUpdate(twinheart_price_tf.getText(), twinheart_stock_spinner.getValue(), twinheart_desc_ta.getText())) {
				cart.getCartItems().get(3).getCart_item().itemPrice = Integer.parseInt(twinheart_price_tf.getText());
				cart.getCartItems().get(3).getCart_item().itemStock = twinheart_stock_spinner.getValue();
				cart.getCartItems().get(3).getCart_item().itemDesc = twinheart_desc_ta.getText();
			}
		});
		smokebomb_btn.setOnMouseEntered(event -> {
			smokebomb_btn.setStyle("-fx-background-color: red;");
		});
		smokebomb_btn.setOnMouseExited(event -> {
			smokebomb_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		});
		smokebomb_btn.setOnAction(event -> {
			if(validateUpdate(smokebomb_price_tf.getText(), smokebomb_stock_spinner.getValue(), smokebomb_desc_ta.getText())) {
				cart.getCartItems().get(4).getCart_item().itemPrice = Integer.parseInt(smokebomb_price_tf.getText());
				cart.getCartItems().get(4).getCart_item().itemStock = smokebomb_stock_spinner.getValue();
				cart.getCartItems().get(4).getCart_item().itemDesc = smokebomb_desc_ta.getText();
			}
		});
		
		heart_imgv.setOnMouseClicked(event -> {
			cart.setViewCharm(1);
			StageManager.getInstance().changeScene(new ViewCharmPage().getScene());
		});
		coffee_imgv.setOnMouseClicked(event -> {
			cart.setViewCharm(2);
			StageManager.getInstance().changeScene(new ViewCharmPage().getScene());
		});
		whetstone_imgv.setOnMouseClicked(event -> {
			cart.setViewCharm(3);
			StageManager.getInstance().changeScene(new ViewCharmPage().getScene());
		});
		twinheart_imgv.setOnMouseClicked(event -> {
			cart.setViewCharm(4);
			StageManager.getInstance().changeScene(new ViewCharmPage().getScene());
		});
		smokebomb_imgv.setOnMouseClicked(event -> {
			cart.setViewCharm(5);
			StageManager.getInstance().changeScene(new ViewCharmPage().getScene());
		});
		
		logout_menu.setOnAction(event -> {
			StageManager.getInstance().changeScene(new LoginPage().getScene());
		});
	}
	
	
	private boolean validateUpdate(String price, Integer stock, String desc) {
		if (price.length() == 0) {
			this.alert.setContentText("Price must be filled in!");
			alert.show();
			return false;
		}
		for(int i = 0; i<price.length(); i++) {
			if (!Character.isDigit(price.charAt(i))) {
				this.alert.setContentText("Price must be numeric!");
				alert.show();
				return false;
			}
		}
		if (Integer.parseInt(price) < 1) {
			this.alert.setContentText("Price must be more than 0!");
			alert.show();
			return false;
		}
		if (stock == null) {
			this.alert.setContentText("Stock must be filled in!");
			alert.show();
			return false;
		}
		if (stock < 1) {
			this.alert.setContentText("Stock must be more than 0!");
			alert.show();
			return false;
		}
		if (desc.length() == 0) {
			this.alert.setContentText("Description must be filled in!");
			alert.show();
			return false;
		}
		return true;
	}
	
}
