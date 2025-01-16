package view;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import lib.StageManager;

public class ViewCharmPage extends ViewBase{

	private BorderPane bp;
	private VBox vb;
	
	private Label item_lb, item_desc;
	private Image item_img;
	private ImageView item_imgv;
	
	private HBox button_hb;
	private Button zoomin_btn, zoomout_btn, rotateleft_btn, rotateright_btn;
	
	private MenuBar navbar;
	private Menu menu;
	private MenuItem logout_menu, shop_menu, inv_menu, admin_menu;
	
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
		
		
		this.bp = new BorderPane();
		this.vb = new VBox();
		
		if(cart.getViewCharm() == 1) {
			this.item_lb = new Label("Heart");
			this.item_img = new Image(new File("Assets/image/heart.png").toURI().toString());
			this.item_imgv = new ImageView();
			this.item_desc = new Label(cart.getCartItems().get(0).getCart_item().itemDesc);
		}
		else if(cart.getViewCharm() == 2) {
			this.item_lb = new Label("Coffee");
			this.item_img = new Image(new File("Assets/image/coffee.png").toURI().toString());
			this.item_imgv = new ImageView();
			this.item_desc = new Label(cart.getCartItems().get(1).getCart_item().itemDesc);
		}
		else if(cart.getViewCharm() == 3) {
			this.item_lb = new Label("Whetstone");
			this.item_img = new Image(new File("Assets/image/whetstone.png").toURI().toString());
			this.item_imgv = new ImageView();
			this.item_desc = new Label(cart.getCartItems().get(2).getCart_item().itemDesc);
		}
		else if(cart.getViewCharm() == 4) {
			this.item_lb = new Label("Twin Heart");
			this.item_img = new Image(new File("Assets/image/twinheart.png").toURI().toString());
			this.item_imgv = new ImageView();
			this.item_desc = new Label(cart.getCartItems().get(3).getCart_item().itemDesc);
		}
		else if(cart.getViewCharm() == 5) {
			this.item_lb = new Label("Smoke Bomb");
			this.item_img = new Image(new File("Assets/image/smokebomb.png").toURI().toString());
			this.item_imgv = new ImageView();
			this.item_desc = new Label(cart.getCartItems().get(4).getCart_item().itemDesc);
		}
		
		this.button_hb = new HBox();
		
		this.zoomin_btn = new Button("+");
		this.zoomout_btn = new Button("-");
		this.rotateleft_btn = new Button("<-");
		this.rotateright_btn = new Button("->");
		
		this.navbar = new MenuBar();
		this.menu = new Menu("Menu");
		this.logout_menu = new MenuItem("Logout");
		this.shop_menu = new MenuItem("Shop");
		this.inv_menu = new MenuItem("Inventory");
		this.admin_menu = new MenuItem("Admin Page");
		
	}

	@Override
	public void setComponent() {
		// TODO Auto-generated method stub
		this.bp.setTop(navbar);
		this.bp.setCenter(vb);
		
		this.item_imgv.setImage(item_img);
		
		this.vb.getChildren().addAll(item_lb, item_imgv, item_desc, button_hb);
		
		this.button_hb.getChildren().addAll(zoomin_btn, zoomout_btn, rotateleft_btn, rotateright_btn);
		
		this.navbar.getMenus().add(menu);
		
		if(cart.getIsAdmin() == true) {
			this.menu.getItems().addAll(admin_menu, logout_menu);
		}
		else {
			this.menu.getItems().addAll(shop_menu, inv_menu, logout_menu);
		}
		
		this.scene.setRoot(bp);
	}

	@Override
	public void setStyle() {
		// TODO Auto-generated method stub
		bp.setStyle("-fx-background-color: #9c4600;");
		
		vb.setAlignment(Pos.CENTER);
		vb.setSpacing(20);
		
		item_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 64));
		item_lb.setStyle("-fx-text-fill: white;");
		item_imgv.setPreserveRatio(true);
		item_imgv.setFitHeight(300);
		item_desc.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 35));
		item_desc.setStyle("-fx-text-fill: white;");
		item_desc.setWrapText(true);
		item_desc.setMaxWidth(700);
		item_desc.setTextAlignment(TextAlignment.CENTER);
		
		button_hb.setAlignment(Pos.CENTER);
		button_hb.setSpacing(30);
		button_hb.getChildren().forEach(child -> {
			child.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		});
		zoomin_btn.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 20));
		zoomin_btn.setPrefWidth(45);
		zoomin_btn.setPrefHeight(45);
		zoomout_btn.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 20));
		zoomout_btn.setPrefWidth(45);
		zoomout_btn.setPrefHeight(45);
		rotateleft_btn.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 20));
		rotateleft_btn.setPrefWidth(45);
		rotateleft_btn.setPrefHeight(45);
		rotateright_btn.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 20));
		rotateright_btn.setPrefWidth(45);
		rotateright_btn.setPrefHeight(45);
		
	}

	@Override
	public void setAction() {
		// TODO Auto-generated method stub
		zoomin_btn.setOnAction(event -> {
			if(this.item_imgv.getScaleX() < 1.5 && this.item_imgv.getScaleY() < 1.5) {
				this.item_imgv.setScaleX(this.item_imgv.getScaleX() * 1.1);
				this.item_imgv.setScaleY(this.item_imgv.getScaleY() * 1.1);
				if(this.item_imgv.getScaleX() > 1.5 || this.item_imgv.getScaleY() > 1.5) {
					this.item_imgv.setScaleX(1.5);
					this.item_imgv.setScaleY(1.5);
				}
			}
		});
		zoomout_btn.setOnAction(event -> {
			if(this.item_imgv.getScaleX() > 0.75 && this.item_imgv.getScaleY() > 0.75) {
				this.item_imgv.setScaleX(this.item_imgv.getScaleX() * 0.9);
				this.item_imgv.setScaleY(this.item_imgv.getScaleY() * 0.9);
				if(this.item_imgv.getScaleX() < 0.75 || this.item_imgv.getScaleY() < 0.75) {
					this.item_imgv.setScaleX(0.75);
					this.item_imgv.setScaleY(0.75);
				}
			}
		});
		rotateleft_btn.setOnAction(event -> {
			this.item_imgv.setRotate(this.item_imgv.getRotate()-15);
		});
		rotateright_btn.setOnAction(event -> {
			this.item_imgv.setRotate(this.item_imgv.getRotate()+15);
		});
		
		admin_menu.setOnAction(event -> {
			StageManager.getInstance().changeScene(new AdminPage().getScene());
		});
		shop_menu.setOnAction(event -> {
			StageManager.getInstance().changeScene(new ShopPage().getScene());
		});
		inv_menu.setOnAction(event -> {
			StageManager.getInstance().changeScene(new InventoryPage().getScene());
		});
		logout_menu.setOnAction(event -> {
			StageManager.getInstance().changeScene(new LoginPage().getScene());
		});
	}

}
