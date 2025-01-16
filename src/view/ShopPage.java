package view;

import java.io.File;
import java.util.Vector;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import lib.StageManager;
import main.Main;

public class ShopPage extends ViewBase{

	private BorderPane bp;
	private HBox hb;
	private VBox cart_vb, shop_vb;
	private GridPane shop_gp;
	private ScrollPane scroll;
	private FlowPane fp;
	
	private Label cart_header_lb, shop_header_lb;
	
	private VBox heart_shop_vb, coffee_shop_vb, whetstone_shop_vb, twinheart_shop_vb, smokebomb_shop_vb;
	private Label heart_shop_lb, coffee_shop_lb, whetstone_shop_lb, twinheart_shop_lb, smokebomb_shop_lb;
	private Image heart_shop_img, coffee_shop_img, whetstone_shop_img, twinheart_shop_img, smokebomb_shop_img;
	private ImageView heart_shop_imgv, coffee_shop_imgv, whetstone_shop_imgv, twinheart_shop_imgv, smokebomb_shop_imgv;
	private Label heart_shop_price, coffee_shop_price, whetstone_shop_price, twinheart_shop_price, smokebomb_shop_price;
	private Label heart_shop_stock, coffee_shop_stock, whetstone_shop_stock, twinheart_shop_stock, smokebomb_shop_stock;

	private HBox coin_hb;
	private Label coin_lb;
	
	private HBox cart_total_hb, cart_bottom_hb;
	private Label cart_empty_lb, cart_total_lb;
	private Button cart_checkout_btn, cart_clear_btn;
	
	private Integer cart_fill = 0;
	
	private VBox heart_cart_vb, coffee_cart_vb, whetstone_cart_vb, twinheart_cart_vb, smokebomb_cart_vb;
	private Label heart_cart_lb, coffee_cart_lb, whetstone_cart_lb, twinheart_cart_lb, smokebomb_cart_lb;
	private Label heart_cart_quant, coffee_cart_quant, whetstone_cart_quant, twinheart_cart_quant, smokebomb_cart_quant;
	
	private Alert checkout_alert;
	
	private MenuBar navbar;
	private Menu menu;
	private MenuItem inv_menu, logout_menu;
	
	private Vector<Item> itemToSell;
	private Cart cart;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		this.bp = new BorderPane();
		
		this.itemToSell = new Vector<>();
		this.itemToSell.add(new Heart());
		this.itemToSell.add(new Coffee());
		this.itemToSell.add(new Whetstone());
		this.itemToSell.add(new Twinheart());
		this.itemToSell.add(new Smokebomb());
		
		this.cart = Cart.getInstance();
		
		this.hb = new HBox();
		this.cart_vb = new VBox();
		this.shop_vb = new VBox();
		this.shop_gp = new GridPane();
		this.scroll = new ScrollPane();
		this.fp = new FlowPane();
		
		this.cart_empty_lb = new Label("Your cart is currently empty!");
		this.cart_total_hb = new HBox();
		this.cart_total_lb = new Label("Total: "+cart.getCartTotal().toString());
		this.cart_bottom_hb = new HBox();
		this.cart_checkout_btn = new Button("Checkout");
		this.cart_clear_btn = new Button("Clear Cart");
		
		this.heart_shop_vb = new VBox();
		this.heart_shop_lb = new Label("Heart");
		this.heart_shop_img = new Image(new File("Assets/image/heart.png").toURI().toString());
		this.heart_shop_imgv = new ImageView();
		this.heart_shop_price = new Label("Price: "+cart.getCartItems().get(0).getCart_item().itemPrice.toString());
		this.heart_shop_stock = new Label("Stock: "+cart.getCartItems().get(0).getCart_item().itemStock.toString());
		this.heart_shop_vb.setId(""+1);
		
		this.coffee_shop_vb = new VBox();
		this.coffee_shop_lb = new Label("Coffee");
		this.coffee_shop_img = new Image(new File("Assets/image/coffee.png").toURI().toString());
		this.coffee_shop_imgv = new ImageView();
		this.coffee_shop_price = new Label("Price: "+cart.getCartItems().get(1).getCart_item().itemPrice.toString());
		this.coffee_shop_stock = new Label("Stock: "+cart.getCartItems().get(1).getCart_item().itemStock.toString());
		this.coffee_shop_vb.setId(""+2);
		
		this.whetstone_shop_vb = new VBox();
		this.whetstone_shop_lb = new Label("Whetstone");
		this.whetstone_shop_img = new Image(new File("Assets/image/whetstone.png").toURI().toString());
		this.whetstone_shop_imgv = new ImageView();
		this.whetstone_shop_price = new Label("Price: "+cart.getCartItems().get(2).getCart_item().itemPrice.toString());
		this.whetstone_shop_stock = new Label("Stock: "+cart.getCartItems().get(2).getCart_item().itemStock.toString());
		this.whetstone_shop_vb.setId(""+3);
		
		this.twinheart_shop_vb = new VBox();
		this.twinheart_shop_lb = new Label("Twin Heart");
		this.twinheart_shop_img = new Image(new File("Assets/image/twinheart.png").toURI().toString());
		this.twinheart_shop_imgv = new ImageView();
		this.twinheart_shop_price = new Label("Price: "+cart.getCartItems().get(3).getCart_item().itemPrice.toString());
		this.twinheart_shop_stock = new Label("Stock: "+cart.getCartItems().get(3).getCart_item().itemStock.toString());
		this.twinheart_shop_vb.setId(""+4);
		
		this.smokebomb_shop_vb = new VBox();
		this.smokebomb_shop_lb = new Label("Smoke Bomb");
		this.smokebomb_shop_img = new Image(new File("Assets/image/smokebomb.png").toURI().toString());
		this.smokebomb_shop_imgv = new ImageView();
		this.smokebomb_shop_price = new Label("Price: "+cart.getCartItems().get(4).getCart_item().itemPrice.toString());
		this.smokebomb_shop_stock = new Label("Stock: "+cart.getCartItems().get(4).getCart_item().itemStock.toString());
		this.smokebomb_shop_vb.setId(""+5);
		
		this.cart_header_lb = new Label("Your Cart");
		this.shop_header_lb = new Label("Charm Shop");
		
		this.coin_hb = new HBox();
		this.coin_lb = new Label("Coin: "+cart.getUsers().get(cart.getUserID()).userCoin.toString());
		
		this.heart_cart_vb = new VBox();
		this.heart_cart_lb = new Label("Heart");
		this.heart_cart_quant = new Label("Quantity: "+cart.getCartItems().get(0).cart_quantity.toString());
		
		this.coffee_cart_vb = new VBox();
		this.coffee_cart_lb = new Label("Coffee");
		this.coffee_cart_quant = new Label("Quantity: "+cart.getCartItems().get(1).cart_quantity.toString());
		
		this.whetstone_cart_vb = new VBox();
		this.whetstone_cart_lb = new Label("Whetstone");
		this.whetstone_cart_quant = new Label("Quantity: "+cart.getCartItems().get(2).cart_quantity.toString());
		
		this.twinheart_cart_vb = new VBox();
		this.twinheart_cart_lb = new Label("Twin Heart");
		this.twinheart_cart_quant = new Label("Quantity: "+cart.getCartItems().get(3).cart_quantity.toString());
		
		this.smokebomb_cart_vb = new VBox();
		this.smokebomb_cart_lb = new Label("Smoke Bomb");
		this.smokebomb_cart_quant = new Label("Quantity: "+cart.getCartItems().get(4).cart_quantity.toString());
	
		this.checkout_alert = new Alert(AlertType.ERROR);
		
		this.navbar = new MenuBar();
		this.menu = new Menu("Menu");
		this.inv_menu = new MenuItem("Inventory");
		this.logout_menu = new MenuItem("Logout");
	}
	
	@Override
	public void setComponent() {
		// TODO Auto-generated method stub
		
		this.bp.setTop(navbar);
		this.bp.setCenter(hb);
		this.hb.getChildren().addAll(cart_vb, shop_vb);
		this.cart_vb.getChildren().addAll(cart_header_lb, fp, cart_total_hb, cart_bottom_hb);
		this.shop_vb.getChildren().addAll(shop_header_lb, scroll, coin_hb);
		
		this.coin_hb.getChildren().add(coin_lb);
		
		this.scroll.setContent(shop_gp);
		
		this.cart_total_hb.getChildren().add(cart_total_lb);
		if(cart.getCartTotal() == 0) {
			this.fp.getChildren().add(cart_empty_lb);
		}
		if(cart.getCartTotal() > 0 && cart.getHeart_incart() == true) {
			this.fp.getChildren().add(heart_cart_vb);
		}
		if(cart.getCartTotal() > 0 && cart.getCoffee_incart() == true) {
			this.fp.getChildren().add(coffee_cart_vb);
		}
		if(cart.getCartTotal() > 0 && cart.getWhetstone_incart() == true) {
			this.fp.getChildren().add(whetstone_cart_vb);
		}
		if(cart.getCartTotal() > 0 && cart.getTwinheart_incart() == true) {
			this.fp.getChildren().add(twinheart_cart_vb);
		}
		if(cart.getCartTotal() > 0 && cart.getSmokebomb_incart() == true) {
			this.fp.getChildren().add(smokebomb_cart_vb);
		}
		
		this.cart_bottom_hb.getChildren().addAll(cart_checkout_btn, cart_clear_btn);
		
		this.shop_gp.add(heart_shop_vb, 0, 0);
		this.shop_gp.add(coffee_shop_vb, 1, 0);
		this.shop_gp.add(whetstone_shop_vb, 0, 1);
		this.shop_gp.add(twinheart_shop_vb, 1, 1);
		this.shop_gp.add(smokebomb_shop_vb, 0, 2);
		
		this.heart_shop_imgv.setImage(heart_shop_img);
		this.heart_shop_vb.getChildren().addAll(heart_shop_lb, heart_shop_imgv, heart_shop_price, heart_shop_stock);
		
		this.coffee_shop_imgv.setImage(coffee_shop_img);
		this.coffee_shop_vb.getChildren().addAll(coffee_shop_lb, coffee_shop_imgv, coffee_shop_price, coffee_shop_stock);
		
		this.whetstone_shop_imgv.setImage(whetstone_shop_img);
		this.whetstone_shop_vb.getChildren().addAll(whetstone_shop_lb, whetstone_shop_imgv, whetstone_shop_price, whetstone_shop_stock);
		
		this.twinheart_shop_imgv.setImage(twinheart_shop_img);
		this.twinheart_shop_vb.getChildren().addAll(twinheart_shop_lb, twinheart_shop_imgv, twinheart_shop_price, twinheart_shop_stock);
		
		this.smokebomb_shop_imgv.setImage(smokebomb_shop_img);
		this.smokebomb_shop_vb.getChildren().addAll(smokebomb_shop_lb, smokebomb_shop_imgv, smokebomb_shop_price, smokebomb_shop_stock);
		
		this.heart_cart_vb.getChildren().addAll(heart_cart_lb, heart_cart_quant);
		this.coffee_cart_vb.getChildren().addAll(coffee_cart_lb, coffee_cart_quant);
		this.whetstone_cart_vb.getChildren().addAll(whetstone_cart_lb, whetstone_cart_quant);
		this.twinheart_cart_vb.getChildren().addAll(twinheart_cart_lb, twinheart_cart_quant);
		this.smokebomb_cart_vb.getChildren().addAll(smokebomb_cart_lb, smokebomb_cart_quant);
		
		this.checkout_alert.setContentText("Not enough coins!");
		
		this.navbar.getMenus().add(menu);
		this.menu.getItems().addAll(inv_menu, logout_menu);
		
		this.scene.setRoot(bp);
	}

	@Override
	public void setStyle() {
		// TODO Auto-generated method stub
		hb.setStyle("-fx-background-color: #613705;");
		cart_vb.prefWidthProperty().bind(getScene().widthProperty());
		cart_vb.setAlignment(Pos.TOP_CENTER);
		shop_vb.setAlignment(Pos.TOP_CENTER);
		shop_vb.setMinWidth(450);
		shop_vb.setStyle("-fx-background-color: #613705;");
		scroll.setStyle("-fx-background-color: #613705;");
		
		shop_gp.prefWidthProperty().bind(shop_vb.widthProperty());
		shop_gp.setStyle("-fx-background-color: #613705;");
		shop_gp.setAlignment(Pos.CENTER);
		shop_gp.setPadding(new Insets(10, 30, 15, 10));
		shop_gp.setVgap(15);
		shop_gp.setHgap(15);
		
		cart_header_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 56));
		cart_header_lb.setStyle("-fx-text-fill: white;");
		cart_header_lb.setAlignment(Pos.TOP_CENTER);
		shop_header_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 56));
		shop_header_lb.setStyle("-fx-text-fill: white;");
		shop_header_lb.setAlignment(Pos.TOP_CENTER);
		
		fp.prefHeightProperty().bind(cart_vb.heightProperty());
		fp.setPadding(new Insets(10, 10, 15, 15));
		fp.setVgap(15);
		fp.setHgap(15);
		
		cart_empty_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 32));
		cart_empty_lb.setStyle("-fx-text-fill: white;");
		cart_total_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 30));
		cart_total_lb.setStyle("-fx-text-fill: white;");
		cart_total_hb.setAlignment(Pos.CENTER_LEFT);
		cart_total_hb.setPadding(new Insets(15, 0, 0, 15));
		cart_bottom_hb.setAlignment(Pos.CENTER);
		cart_bottom_hb.setPadding(new Insets(15, 0, 15, 0));
		cart_bottom_hb.setSpacing(15);
		
		cart_checkout_btn.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		cart_checkout_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #9c4600");
		cart_checkout_btn.setPrefWidth(100);
		cart_clear_btn.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		cart_clear_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #9c4600");
		cart_clear_btn.setPrefWidth(100);
		
		heart_shop_vb.setAlignment(Pos.CENTER);
		heart_shop_vb.setStyle("-fx-background-color: #9c4600;"+"-fx-background-radius: 15 15 15 15;");
		heart_shop_vb.setMinWidth(200);
		heart_shop_vb.setMinHeight(250);
		heart_shop_vb.setPadding(new Insets(20,20,20,20));
		heart_shop_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		heart_shop_lb.setStyle("-fx-text-fill: white;");
		heart_shop_imgv.setPreserveRatio(true);
		heart_shop_imgv.setFitHeight(120);
		heart_shop_price.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		heart_shop_price.setStyle("-fx-text-fill: white;");
		heart_shop_stock.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		heart_shop_stock.setStyle("-fx-text-fill: white;");
		
		coffee_shop_vb.setAlignment(Pos.CENTER);
		coffee_shop_vb.setStyle("-fx-background-color: #9c4600;"+"-fx-background-radius: 15 15 15 15;");
		coffee_shop_vb.setMinWidth(200);
		coffee_shop_vb.setMinHeight(250);
		coffee_shop_vb.setPadding(new Insets(20,20,20,20));
		coffee_shop_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		coffee_shop_lb.setStyle("-fx-text-fill: white;");
		coffee_shop_imgv.setPreserveRatio(true);
		coffee_shop_imgv.setFitHeight(120);
		coffee_shop_price.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		coffee_shop_price.setStyle("-fx-text-fill: white;");
		coffee_shop_stock.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		coffee_shop_stock.setStyle("-fx-text-fill: white;");
		
		whetstone_shop_vb.setAlignment(Pos.CENTER);
		whetstone_shop_vb.setStyle("-fx-background-color: #9c4600;"+"-fx-background-radius: 15 15 15 15;");
		whetstone_shop_vb.setMinWidth(200);
		whetstone_shop_vb.setMinHeight(250);
		whetstone_shop_vb.setPadding(new Insets(20,20,20,20));
		whetstone_shop_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		whetstone_shop_lb.setStyle("-fx-text-fill: white;");
		whetstone_shop_imgv.setPreserveRatio(true);
		whetstone_shop_imgv.setFitHeight(120);
		whetstone_shop_price.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		whetstone_shop_price.setStyle("-fx-text-fill: white;");
		whetstone_shop_stock.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		whetstone_shop_stock.setStyle("-fx-text-fill: white;");
		
		twinheart_shop_vb.setAlignment(Pos.CENTER);
		twinheart_shop_vb.setStyle("-fx-background-color: #9c4600;"+"-fx-background-radius: 15 15 15 15;");
		twinheart_shop_vb.setMinWidth(200);
		twinheart_shop_vb.setMinHeight(250);
		twinheart_shop_vb.setPadding(new Insets(20,20,20,20));
		twinheart_shop_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		twinheart_shop_lb.setStyle("-fx-text-fill: white;");
		twinheart_shop_imgv.setPreserveRatio(true);
		twinheart_shop_imgv.setFitHeight(120);
		twinheart_shop_price.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		twinheart_shop_price.setStyle("-fx-text-fill: white;");
		twinheart_shop_stock.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		twinheart_shop_stock.setStyle("-fx-text-fill: white;");
		
		smokebomb_shop_vb.setAlignment(Pos.CENTER);
		smokebomb_shop_vb.setStyle("-fx-background-color: #9c4600;"+"-fx-background-radius: 15 15 15 15;");
		smokebomb_shop_vb.setMinWidth(200);
		smokebomb_shop_vb.setMinHeight(250);
		smokebomb_shop_vb.setPadding(new Insets(20,20,20,20));
		smokebomb_shop_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		smokebomb_shop_lb.setStyle("-fx-text-fill: white;");
		smokebomb_shop_imgv.setPreserveRatio(true);
		smokebomb_shop_imgv.setFitHeight(120);
		smokebomb_shop_price.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		smokebomb_shop_price.setStyle("-fx-text-fill: white;");
		smokebomb_shop_stock.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		smokebomb_shop_stock.setStyle("-fx-text-fill: white;");
		
		coin_hb.setAlignment(Pos.CENTER_RIGHT);
		coin_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 30));
		coin_lb.setStyle("-fx-text-fill: white;");
		coin_hb.setPadding(new Insets(5, 15, 5, 0));
		
		heart_cart_vb.setAlignment(Pos.CENTER);
		heart_cart_vb.setStyle("-fx-background-color: #9c4600;"+"-fx-background-radius: 15 15 15 15;");
		heart_cart_vb.setMinWidth(230);
		heart_cart_vb.setMinHeight(90);
		heart_cart_vb.setPadding(new Insets(20,20,20,20));
		heart_cart_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 18));
		heart_cart_lb.setStyle("-fx-text-fill: white;");
		heart_cart_quant.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 18));
		heart_cart_quant.setStyle("-fx-text-fill: white;");
		
		coffee_cart_vb.setAlignment(Pos.CENTER);
		coffee_cart_vb.setStyle("-fx-background-color: #9c4600;"+"-fx-background-radius: 15 15 15 15;");
		coffee_cart_vb.setMinWidth(230);
		coffee_cart_vb.setMinHeight(90);
		coffee_cart_vb.setPadding(new Insets(20,20,20,20));
		coffee_cart_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 18));
		coffee_cart_lb.setStyle("-fx-text-fill: white;");
		coffee_cart_quant.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 18));
		coffee_cart_quant.setStyle("-fx-text-fill: white;");
		
		whetstone_cart_vb.setAlignment(Pos.CENTER);
		whetstone_cart_vb.setStyle("-fx-background-color: #9c4600;"+"-fx-background-radius: 15 15 15 15;");
		whetstone_cart_vb.setMinWidth(230);
		whetstone_cart_vb.setMinHeight(90);
		whetstone_cart_vb.setPadding(new Insets(20,20,20,20));
		whetstone_cart_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 18));
		whetstone_cart_lb.setStyle("-fx-text-fill: white;");
		whetstone_cart_quant.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 18));
		whetstone_cart_quant.setStyle("-fx-text-fill: white;");
		
		twinheart_cart_vb.setAlignment(Pos.CENTER);
		twinheart_cart_vb.setStyle("-fx-background-color: #9c4600;"+"-fx-background-radius: 15 15 15 15;");
		twinheart_cart_vb.setMinWidth(230);
		twinheart_cart_vb.setMinHeight(90);
		twinheart_cart_vb.setPadding(new Insets(20,20,20,20));
		twinheart_cart_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 18));
		twinheart_cart_lb.setStyle("-fx-text-fill: white;");
		twinheart_cart_quant.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 18));
		twinheart_cart_quant.setStyle("-fx-text-fill: white;");
		
		smokebomb_cart_vb.setAlignment(Pos.CENTER);
		smokebomb_cart_vb.setStyle("-fx-background-color: #9c4600;"+"-fx-background-radius: 15 15 15 15;");
		smokebomb_cart_vb.setMinWidth(230);
		smokebomb_cart_vb.setMinHeight(90);
		smokebomb_cart_vb.setPadding(new Insets(20,20,20,20));
		smokebomb_cart_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 18));
		smokebomb_cart_lb.setStyle("-fx-text-fill: white;");
		smokebomb_cart_quant.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 18));
		smokebomb_cart_quant.setStyle("-fx-text-fill: white;");
	}

	@Override
	public void setAction() {
		// TODO Auto-generated method stub
		this.shop_gp.getChildren().forEach(children -> {
			children.setOnDragDetected(event -> {
				Dragboard dragboard = heart_shop_vb.startDragAndDrop(TransferMode.ANY);
				ClipboardContent cc = new ClipboardContent();
				cc.putString(children.getId());
				dragboard.setContent(cc);
				event.consume();
			});
		});
		this.fp.setOnDragOver(event -> {
			event.acceptTransferModes(TransferMode.ANY);
		});
		this.fp.setOnDragDropped(event -> {
			Dragboard dragboard = event.getDragboard();
			if(Integer.valueOf(dragboard.getString()) == 1) {
				if(cart.getCartItems().get(0).getCart_item().itemStock > 0 && cart.getHeart_incart() == false) {
					cart.setHeart_incart(true);
					cart.getCartItems().get(0).getCart_item().itemStock--;
					this.heart_shop_stock.setText("Stock: "+cart.getCartItems().get(0).getCart_item().itemStock.toString());
					cart.getCartItems().get(0).setCart_quantity(cart.getCartItems().get(0).getCart_quantity()+1);
					this.heart_cart_quant.setText("Quantity: "+cart.getCartItems().get(0).getCart_quantity().toString());
					cart_add(heart_cart_vb);
					cart.setCartTotal(cart.getCartTotal()+itemToSell.get(0).itemPrice);
					this.cart_total_lb.setText("Total: "+cart.getCartTotal().toString());
				}
				else if (cart.getCartItems().get(0).getCart_item().itemStock > 0 && cart.getHeart_incart() == true) {
					cart.getCartItems().get(0).getCart_item().itemStock--;
					this.heart_shop_stock.setText("Stock: "+cart.getCartItems().get(0).getCart_item().itemStock.toString());
					cart.getCartItems().get(0).setCart_quantity(cart.getCartItems().get(0).getCart_quantity()+1);
					this.heart_cart_quant.setText("Quantity: "+cart.getCartItems().get(0).getCart_quantity().toString());
					cart.setCartTotal(cart.getCartTotal()+itemToSell.get(0).itemPrice);
					this.cart_total_lb.setText("Total: "+cart.getCartTotal().toString());
				}
			}
			else if(Integer.valueOf(dragboard.getString()) == 2) {
				if(cart.getCartItems().get(1).getCart_item().itemStock > 0 && cart.getCoffee_incart() == false) {
					cart.setCoffee_incart(true);
					cart.getCartItems().get(1).getCart_item().itemStock--;
					this.coffee_shop_stock.setText("Stock: "+cart.getCartItems().get(1).getCart_item().itemStock.toString());
					cart.getCartItems().get(1).setCart_quantity(cart.getCartItems().get(1).getCart_quantity()+1);
					this.coffee_cart_quant.setText("Quantity: "+cart.getCartItems().get(1).getCart_quantity().toString());
					cart_add(coffee_cart_vb);
					cart.setCartTotal(cart.getCartTotal()+itemToSell.get(1).itemPrice);
					this.cart_total_lb.setText("Total: "+cart.getCartTotal().toString());
				}
				else if (cart.getCartItems().get(1).getCart_item().itemStock > 0 && cart.getCoffee_incart() == true) {
					cart.getCartItems().get(1).getCart_item().itemStock--;
					this.coffee_shop_stock.setText("Stock: "+cart.getCartItems().get(1).getCart_item().itemStock.toString());
					cart.getCartItems().get(1).setCart_quantity(cart.getCartItems().get(1).getCart_quantity()+1);
					this.coffee_cart_quant.setText("Quantity: "+cart.getCartItems().get(1).getCart_quantity().toString());
					cart.setCartTotal(cart.getCartTotal()+itemToSell.get(1).itemPrice);
					this.cart_total_lb.setText("Total: "+cart.getCartTotal().toString());
				}
			}
			else if(Integer.valueOf(dragboard.getString()) == 3) {
				if(cart.getCartItems().get(2).getCart_item().itemStock > 0 && cart.getWhetstone_incart() == false) {
					cart.setWhetstone_incart(true);
					cart.getCartItems().get(2).getCart_item().itemStock--;
					this.whetstone_shop_stock.setText("Stock: "+cart.getCartItems().get(2).getCart_item().itemStock.toString());
					cart.getCartItems().get(2).setCart_quantity(cart.getCartItems().get(2).getCart_quantity()+1);
					this.whetstone_cart_quant.setText("Quantity: "+cart.getCartItems().get(2).getCart_quantity().toString());
					cart_add(whetstone_cart_vb);
					cart.setCartTotal(cart.getCartTotal()+itemToSell.get(2).itemPrice);
					this.cart_total_lb.setText("Total: "+cart.getCartTotal().toString());
				}
				else if (cart.getCartItems().get(2).getCart_item().itemStock > 0 && cart.getWhetstone_incart() == true) {
					cart.getCartItems().get(2).getCart_item().itemStock--;
					this.whetstone_shop_stock.setText("Stock: "+cart.getCartItems().get(2).getCart_item().itemStock.toString());
					cart.getCartItems().get(2).setCart_quantity(cart.getCartItems().get(2).getCart_quantity()+1);
					this.whetstone_cart_quant.setText("Quantity: "+cart.getCartItems().get(2).getCart_quantity().toString());
					cart.setCartTotal(cart.getCartTotal()+itemToSell.get(2).itemPrice);
					this.cart_total_lb.setText("Total: "+cart.getCartTotal().toString());
				}
			}
			else if(Integer.valueOf(dragboard.getString()) == 4) {
				if(cart.getCartItems().get(3).getCart_item().itemStock > 0 && cart.getTwinheart_incart() == false) {
					cart.setTwinheart_incart(true);
					cart.getCartItems().get(3).getCart_item().itemStock--;
					this.twinheart_shop_stock.setText("Stock: "+cart.getCartItems().get(3).getCart_item().itemStock.toString());
					cart.getCartItems().get(3).setCart_quantity(cart.getCartItems().get(3).getCart_quantity()+1);
					this.twinheart_cart_quant.setText("Quantity: "+cart.getCartItems().get(3).getCart_quantity().toString());
					cart_add(twinheart_cart_vb);
					cart.setCartTotal(cart.getCartTotal()+itemToSell.get(3).itemPrice);
					this.cart_total_lb.setText("Total: "+cart.getCartTotal().toString());
				}
				else if (cart.getCartItems().get(3).getCart_item().itemStock > 0 && cart.getTwinheart_incart() == true) {
					cart.getCartItems().get(3).getCart_item().itemStock--;
					this.twinheart_shop_stock.setText("Stock: "+cart.getCartItems().get(3).getCart_item().itemStock.toString());
					cart.getCartItems().get(3).setCart_quantity(cart.getCartItems().get(3).getCart_quantity()+1);
					this.twinheart_cart_quant.setText("Quantity: "+cart.getCartItems().get(3).getCart_quantity().toString());
					cart.setCartTotal(cart.getCartTotal()+itemToSell.get(3).itemPrice);
					this.cart_total_lb.setText("Total: "+cart.getCartTotal().toString());
				}
			}
			else if(Integer.valueOf(dragboard.getString()) == 5) {
				if(cart.getCartItems().get(4).getCart_item().itemStock > 0 && cart.getSmokebomb_incart() == false) {
					cart.setSmokebomb_incart(true);
					cart.getCartItems().get(4).getCart_item().itemStock--;
					this.smokebomb_shop_stock.setText("Stock: "+cart.getCartItems().get(4).getCart_item().itemStock.toString());
					cart.getCartItems().get(4).setCart_quantity(cart.getCartItems().get(4).getCart_quantity()+1);
					this.smokebomb_cart_quant.setText("Quantity: "+cart.getCartItems().get(4).getCart_quantity().toString());
					cart_add(smokebomb_cart_vb);
					cart.setCartTotal(cart.getCartTotal()+itemToSell.get(4).itemPrice);
					this.cart_total_lb.setText("Total: "+cart.getCartTotal().toString());
				}
				else if (cart.getCartItems().get(4).getCart_item().itemStock > 0 && cart.getSmokebomb_incart() == true) {
					cart.getCartItems().get(4).getCart_item().itemStock--;
					this.smokebomb_shop_stock.setText("Stock: "+cart.getCartItems().get(4).getCart_item().itemStock.toString());
					cart.getCartItems().get(4).setCart_quantity(cart.getCartItems().get(4).getCart_quantity()+1);
					this.smokebomb_cart_quant.setText("Quantity: "+cart.getCartItems().get(4).getCart_quantity().toString());
					cart.setCartTotal(cart.getCartTotal()+itemToSell.get(4).itemPrice);
					this.cart_total_lb.setText("Total: "+cart.getCartTotal().toString());
				}
			}
		});
		cart_clear_btn.setOnMouseEntered(event -> {
			cart_clear_btn.setStyle("-fx-background-color: red;");
		});
		cart_clear_btn.setOnMouseExited(event -> {
			cart_clear_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #9c4600");
		});
		cart_clear_btn.setOnAction(event -> {
			cart.getCartItems().get(0).getCart_item().itemStock = cart.getCartItems().get(0).getCart_item().itemStock + cart.getCartItems().get(0).getCart_quantity();
			cart.getCartItems().get(0).setCart_quantity(0);
			cart.getCartItems().get(1).getCart_item().itemStock = cart.getCartItems().get(1).getCart_item().itemStock + cart.getCartItems().get(1).getCart_quantity();
			cart.getCartItems().get(1).setCart_quantity(0);
			cart.getCartItems().get(2).getCart_item().itemStock = cart.getCartItems().get(2).getCart_item().itemStock + cart.getCartItems().get(2).getCart_quantity();
			cart.getCartItems().get(2).setCart_quantity(0);
			cart.getCartItems().get(3).getCart_item().itemStock = cart.getCartItems().get(3).getCart_item().itemStock + cart.getCartItems().get(3).getCart_quantity();
			cart.getCartItems().get(3).setCart_quantity(0);
			cart.getCartItems().get(4).getCart_item().itemStock = cart.getCartItems().get(4).getCart_item().itemStock + cart.getCartItems().get(4).getCart_quantity();
			cart.getCartItems().get(4).setCart_quantity(0);
			fp.getChildren().clear();
			fp.getChildren().add(cart_empty_lb);
			cart_fill = 0;
			cart.setCartTotal(0);
			cart.setHeart_incart(false);
			cart.setCoffee_incart(false);
			cart.setWhetstone_incart(false);
			cart.setTwinheart_incart(false);
			cart.setSmokebomb_incart(false);		
			this.heart_shop_stock.setText("Stock: "+cart.getCartItems().get(0).getCart_item().itemStock.toString());
			this.coffee_shop_stock.setText("Stock: "+cart.getCartItems().get(1).getCart_item().itemStock.toString());
			this.whetstone_shop_stock.setText("Stock: "+cart.getCartItems().get(2).getCart_item().itemStock.toString());
			this.twinheart_shop_stock.setText("Stock: "+cart.getCartItems().get(3).getCart_item().itemStock.toString());
			this.smokebomb_shop_stock.setText("Stock: "+cart.getCartItems().get(4).getCart_item().itemStock.toString());
			this.cart_total_lb.setText("Total: "+cart.getCartTotal().toString());
		});
		cart_checkout_btn.setOnMouseEntered(event -> {
			cart_checkout_btn.setStyle("-fx-background-color: red;");
		});
		cart_checkout_btn.setOnMouseExited(event -> {
			cart_checkout_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #9c4600");
		});
		cart_checkout_btn.setOnAction(event -> {
			if(cart.getCoin() >= cart.getCartTotal()) {
				//cart.getUsers().get(cart.getUserID()).heart_inv = cart.getUsers().get(cart.getUserID()).heart_inv + cart.getCartItems().get(0).getCart_quantity();
				cart.getUsers().get(cart.getUserID()).heart_inv = cart.getUsers().get(cart.getUserID()).heart_inv + cart.getCartItems().get(0).getCart_quantity();
				cart.getUsers().get(cart.getUserID()).coffee_inv = cart.getUsers().get(cart.getUserID()).coffee_inv + cart.getCartItems().get(1).getCart_quantity();
				cart.getUsers().get(cart.getUserID()).whetstone_inv = cart.getUsers().get(cart.getUserID()).whetstone_inv + cart.getCartItems().get(2).getCart_quantity();
				cart.getUsers().get(cart.getUserID()).twinheart_inv = cart.getUsers().get(cart.getUserID()).twinheart_inv + cart.getCartItems().get(3).getCart_quantity();
				cart.getUsers().get(cart.getUserID()).smokebomb_inv = cart.getUsers().get(cart.getUserID()).smokebomb_inv + cart.getCartItems().get(4).getCart_quantity();
				cart.getCartItems().get(0).setCart_quantity(0);
				cart.getCartItems().get(1).setCart_quantity(0);
				cart.getCartItems().get(2).setCart_quantity(0);
				cart.getCartItems().get(3).setCart_quantity(0);
				cart.getCartItems().get(4).setCart_quantity(0);
				fp.getChildren().clear();
				fp.getChildren().add(cart_empty_lb);
				//cart.setCoin(cart.getCoin() - cart.getCartTotal());
				cart.getUsers().get(cart.getUserID()).userCoin = cart.getUsers().get(cart.getUserID()).userCoin - cart.getCartTotal();
				this.coin_lb.setText("Coin: "+cart.getUsers().get(cart.getUserID()).userCoin.toString());
				cart.setCartTotal(0);
				this.cart_total_lb.setText("Total: "+cart.getCartTotal().toString());
				cart_fill = 0;
				cart.setHeart_incart(false);
				cart.setCoffee_incart(false);
				cart.setWhetstone_incart(false);
				cart.setTwinheart_incart(false);
				cart.setSmokebomb_incart(false);	
			}
			else {
				checkout_alert.show();
			}
		});
		
		heart_shop_imgv.setOnMouseClicked(event -> {
			cart.setViewCharm(1);
			StageManager.getInstance().changeScene(new ViewCharmPage().getScene());
		});
		coffee_shop_imgv.setOnMouseClicked(event -> {
			cart.setViewCharm(2);
			StageManager.getInstance().changeScene(new ViewCharmPage().getScene());
		});
		whetstone_shop_imgv.setOnMouseClicked(event -> {
			cart.setViewCharm(3);
			StageManager.getInstance().changeScene(new ViewCharmPage().getScene());
		});
		twinheart_shop_imgv.setOnMouseClicked(event -> {
			cart.setViewCharm(4);
			StageManager.getInstance().changeScene(new ViewCharmPage().getScene());
		});
		smokebomb_shop_imgv.setOnMouseClicked(event -> {
			cart.setViewCharm(5);
			StageManager.getInstance().changeScene(new ViewCharmPage().getScene());
		});
		
		
		inv_menu.setOnAction(event -> {
			StageManager.getInstance().changeScene(new InventoryPage().getScene());
		});
		logout_menu.setOnAction(event -> {
			StageManager.getInstance().changeScene(new LoginPage().getScene());
		});
		
	}
	
	private void cart_add(VBox cart_item) {
		if(cart_fill == 0) {
			fp.getChildren().remove(cart_empty_lb);
			fp.getChildren().add(cart_item);
			cart_fill++;
		}
		else{
			fp.getChildren().add(cart_item);
		}
	}
	
}
