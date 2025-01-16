package view;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import lib.StageManager;

public class InventoryPage extends ViewBase{
	
	private Label header_lb;
	private BorderPane bp;
	private VBox header_vb;
	private FlowPane fp;
	
	private VBox heart_inv_vb, coffee_inv_vb, whetstone_inv_vb, twinheart_inv_vb, smokebomb_inv_vb;
	private Label heart_inv_lb, coffee_inv_lb, whetstone_inv_lb, twinheart_inv_lb, smokebomb_inv_lb;
	private Image heart_inv_img, coffee_inv_img, whetstone_inv_img, twinheart_inv_img, smokebomb_inv_img;
	private ImageView heart_inv_imgv, coffee_inv_imgv, whetstone_inv_imgv, twinheart_inv_imgv, smokebomb_inv_imgv;
	private Label heart_inv_quant, coffee_inv_quant, whetstone_inv_quant, twinheart_inv_quant, smokebomb_inv_quant;
	private Button heart_use_btn, coffee_use_btn, whetstone_use_btn, twinheart_use_btn, smokebomb_use_btn;
	
	private MenuBar navbar;
	private Menu menu;
	private MenuItem shop_menu, logout_menu;
	
	private Cart cart;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		this.bp = new BorderPane();
		
		this.header_vb = new VBox();
		this.fp = new FlowPane();
		this.header_lb = new Label();
		
		this.cart = Cart.getInstance();
		
		this.heart_inv_vb = new VBox();
		this.coffee_inv_vb = new VBox();
		this.whetstone_inv_vb = new VBox();
		this.twinheart_inv_vb = new VBox();
		this.smokebomb_inv_vb = new VBox();
		
		this.heart_inv_lb = new Label("Heart");
		this.coffee_inv_lb = new Label("Coffee");
		this.whetstone_inv_lb = new Label("Whetstone");
		this.twinheart_inv_lb = new Label("Twin Heart");
		this.smokebomb_inv_lb = new Label("Smoke Bomb");
		
		this.heart_inv_img = new Image(new File("Assets/image/heart.png").toURI().toString());
		this.coffee_inv_img = new Image(new File("Assets/image/coffee.png").toURI().toString());
		this.whetstone_inv_img = new Image(new File("Assets/image/whetstone.png").toURI().toString());
		this.twinheart_inv_img = new Image(new File("Assets/image/twinheart.png").toURI().toString());
		this.smokebomb_inv_img = new Image(new File("Assets/image/smokebomb.png").toURI().toString());
		
		this.heart_inv_imgv = new ImageView();
		this.coffee_inv_imgv = new ImageView();
		this.whetstone_inv_imgv = new ImageView();
		this.twinheart_inv_imgv = new ImageView();
		this.smokebomb_inv_imgv = new ImageView();
		
		this.heart_inv_quant = new Label("Quantity: "+cart.getUsers().get(cart.getUserID()).heart_inv.toString()+"x");
		this.coffee_inv_quant = new Label("Quantity: "+cart.getUsers().get(cart.getUserID()).coffee_inv.toString()+"x");
		this.whetstone_inv_quant = new Label("Quantity: "+cart.getUsers().get(cart.getUserID()).whetstone_inv.toString()+"x");
		this.twinheart_inv_quant = new Label("Quantity: "+cart.getUsers().get(cart.getUserID()).twinheart_inv.toString()+"x");
		this.smokebomb_inv_quant = new Label("Quantity: "+cart.getUsers().get(cart.getUserID()).smokebomb_inv.toString()+"x");
		
		this.heart_use_btn = new Button("Use Charm");
		this.coffee_use_btn = new Button("Use Charm");
		this.whetstone_use_btn = new Button("Use Charm");
		this.twinheart_use_btn = new Button("Use Charm");
		this.smokebomb_use_btn = new Button("Use Charm");
		
		this.navbar = new MenuBar();
		this.menu = new Menu("Menu");
		this.shop_menu = new MenuItem("Shop");
		this.logout_menu = new MenuItem("Logout");
		
	}

	@Override
	public void setComponent() {
		// TODO Auto-generated method stub
		this.bp.setTop(header_vb);
		this.bp.setCenter(fp);
		this.header_vb.getChildren().addAll(navbar, header_lb);
		this.header_lb.setText(cart.getUsers().get(cart.getUserID()).userName + "'s Inventory");
		
		if(cart.getUsers().get(cart.getUserID()).heart_inv > 0) {
			this.fp.getChildren().add(heart_inv_vb);
		}
		if(cart.getUsers().get(cart.getUserID()).coffee_inv > 0) {
			this.fp.getChildren().add(coffee_inv_vb);
		}
		if(cart.getUsers().get(cart.getUserID()).whetstone_inv > 0) {
			this.fp.getChildren().add(whetstone_inv_vb);
		}
		if(cart.getUsers().get(cart.getUserID()).twinheart_inv > 0) {
			this.fp.getChildren().add(twinheart_inv_vb);
		}
		if(cart.getUsers().get(cart.getUserID()).smokebomb_inv > 0) {
			this.fp.getChildren().add(smokebomb_inv_vb);
		}
			
		this.heart_inv_vb.getChildren().addAll(heart_inv_lb, heart_inv_imgv, heart_inv_quant, heart_use_btn);
		this.coffee_inv_vb.getChildren().addAll(coffee_inv_lb, coffee_inv_imgv, coffee_inv_quant, coffee_use_btn);
		this.whetstone_inv_vb.getChildren().addAll(whetstone_inv_lb, whetstone_inv_imgv, whetstone_inv_quant, whetstone_use_btn);
		this.twinheart_inv_vb.getChildren().addAll(twinheart_inv_lb, twinheart_inv_imgv, twinheart_inv_quant, twinheart_use_btn);
		this.smokebomb_inv_vb.getChildren().addAll(smokebomb_inv_lb, smokebomb_inv_imgv, smokebomb_inv_quant, smokebomb_use_btn);
	
		this.heart_inv_imgv.setImage(heart_inv_img);
		this.coffee_inv_imgv.setImage(coffee_inv_img);
		this.whetstone_inv_imgv.setImage(whetstone_inv_img);
		this.twinheart_inv_imgv.setImage(twinheart_inv_img);
		this.smokebomb_inv_imgv.setImage(smokebomb_inv_img);
		
		this.navbar.getMenus().add(menu);
		this.menu.getItems().addAll(shop_menu, logout_menu);
		
		this.scene.setRoot(bp);
	}

	@Override
	public void setStyle() {
		// TODO Auto-generated method stub
		bp.setStyle("-fx-background-color: #613705;");
		header_vb.setAlignment(Pos.CENTER);
		
		header_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 56));
		header_lb.setStyle("-fx-text-fill: white;");
		
		fp.setAlignment(Pos.TOP_CENTER);
		fp.setMaxWidth(800);
		fp.setVgap(20);
		fp.setHgap(20);
		
		heart_inv_vb.setAlignment(Pos.CENTER);
		heart_inv_vb.setStyle("-fx-background-color: #9c4600;"+"-fx-background-radius: 15 15 15 15;");
		heart_inv_vb.setMinWidth(220);
		heart_inv_vb.setMinHeight(280);
		heart_inv_vb.setPadding(new Insets(20,20,20,20));
		heart_inv_vb.setSpacing(10);
		heart_inv_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		heart_inv_lb.setStyle("-fx-text-fill: white;");
		heart_inv_imgv.setPreserveRatio(true);
		heart_inv_imgv.setFitHeight(120);
		heart_inv_quant.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		heart_inv_quant.setStyle("-fx-text-fill: white;");
		heart_use_btn.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		heart_use_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		heart_use_btn.setPrefWidth(100);
		
		coffee_inv_vb.setAlignment(Pos.CENTER);
		coffee_inv_vb.setStyle("-fx-background-color: #9c4600;"+"-fx-background-radius: 15 15 15 15;");
		coffee_inv_vb.setMinWidth(220);
		coffee_inv_vb.setMinHeight(280);
		coffee_inv_vb.setPadding(new Insets(20,20,20,20));
		coffee_inv_vb.setSpacing(10);
		coffee_inv_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		coffee_inv_lb.setStyle("-fx-text-fill: white;");
		coffee_inv_imgv.setPreserveRatio(true);
		coffee_inv_imgv.setFitHeight(120);
		coffee_inv_quant.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		coffee_inv_quant.setStyle("-fx-text-fill: white;");
		coffee_use_btn.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		coffee_use_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		coffee_use_btn.setPrefWidth(100);
		
		whetstone_inv_vb.setAlignment(Pos.CENTER);
		whetstone_inv_vb.setStyle("-fx-background-color: #9c4600;"+"-fx-background-radius: 15 15 15 15;");
		whetstone_inv_vb.setMinWidth(220);
		whetstone_inv_vb.setMinHeight(280);
		whetstone_inv_vb.setPadding(new Insets(20,20,20,20));
		whetstone_inv_vb.setSpacing(10);
		whetstone_inv_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		whetstone_inv_lb.setStyle("-fx-text-fill: white;");
		whetstone_inv_imgv.setPreserveRatio(true);
		whetstone_inv_imgv.setFitHeight(120);
		whetstone_inv_quant.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		whetstone_inv_quant.setStyle("-fx-text-fill: white;");
		whetstone_use_btn.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		whetstone_use_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		whetstone_use_btn.setPrefWidth(100);
		
		twinheart_inv_vb.setAlignment(Pos.CENTER);
		twinheart_inv_vb.setStyle("-fx-background-color: #9c4600;"+"-fx-background-radius: 15 15 15 15;");
		twinheart_inv_vb.setMinWidth(220);
		twinheart_inv_vb.setMinHeight(280);
		twinheart_inv_vb.setPadding(new Insets(20,20,20,20));
		twinheart_inv_vb.setSpacing(10);
		twinheart_inv_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		twinheart_inv_lb.setStyle("-fx-text-fill: white;");
		twinheart_inv_imgv.setPreserveRatio(true);
		twinheart_inv_imgv.setFitHeight(120);
		twinheart_inv_quant.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		twinheart_inv_quant.setStyle("-fx-text-fill: white;");
		twinheart_use_btn.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		twinheart_use_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		twinheart_use_btn.setPrefWidth(100);
		
		smokebomb_inv_vb.setAlignment(Pos.CENTER);
		smokebomb_inv_vb.setStyle("-fx-background-color: #9c4600;"+"-fx-background-radius: 15 15 15 15;");
		smokebomb_inv_vb.setMinWidth(220);
		smokebomb_inv_vb.setMinHeight(280);
		smokebomb_inv_vb.setPadding(new Insets(20,20,20,20));
		smokebomb_inv_vb.setSpacing(10);
		smokebomb_inv_lb.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		smokebomb_inv_lb.setStyle("-fx-text-fill: white;");
		smokebomb_inv_imgv.setPreserveRatio(true);
		smokebomb_inv_imgv.setFitHeight(120);
		smokebomb_inv_quant.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		smokebomb_inv_quant.setStyle("-fx-text-fill: white;");
		smokebomb_use_btn.setFont(Font.loadFont(new File("Assets/font/AlegreyaSansSC-Bold.ttf").toURI().toString(), 16));
		smokebomb_use_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		smokebomb_use_btn.setPrefWidth(100);
		
	}

	@Override
	public void setAction() {
		// TODO Auto-generated method stub
		heart_use_btn.setOnMouseEntered(event -> {
			heart_use_btn.setStyle("-fx-background-color: red;");
		});
		heart_use_btn.setOnMouseExited(event -> {
			heart_use_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		});
		this.heart_use_btn.setOnAction(event -> {
			cart.getUsers().get(cart.getUserID()).heart_inv--;
			this.heart_inv_quant.setText("Quantity: "+cart.getUsers().get(cart.getUserID()).heart_inv.toString()+"x");
			if(cart.getUsers().get(cart.getUserID()).heart_inv == 0) {
				fp.getChildren().remove(heart_inv_vb);
			}
		});
		coffee_use_btn.setOnMouseEntered(event -> {
			coffee_use_btn.setStyle("-fx-background-color: red;");
		});
		coffee_use_btn.setOnMouseExited(event -> {
			coffee_use_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		});
		this.coffee_use_btn.setOnAction(event -> {
			cart.getUsers().get(cart.getUserID()).coffee_inv--;
			this.coffee_inv_quant.setText("Quantity: "+cart.getUsers().get(cart.getUserID()).coffee_inv.toString()+"x");
			if(cart.getUsers().get(cart.getUserID()).coffee_inv == 0) {
				fp.getChildren().remove(coffee_inv_vb);
			}
		});
		whetstone_use_btn.setOnMouseEntered(event -> {
			whetstone_use_btn.setStyle("-fx-background-color: red;");
		});
		whetstone_use_btn.setOnMouseExited(event -> {
			whetstone_use_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		});
		this.whetstone_use_btn.setOnAction(event -> {
			cart.getUsers().get(cart.getUserID()).whetstone_inv--;
			this.whetstone_inv_quant.setText("Quantity: "+cart.getUsers().get(cart.getUserID()).whetstone_inv.toString()+"x");
			if(cart.getUsers().get(cart.getUserID()).whetstone_inv == 0) {
				fp.getChildren().remove(whetstone_inv_vb);
			}
		});
		twinheart_use_btn.setOnMouseEntered(event -> {
			twinheart_use_btn.setStyle("-fx-background-color: red;");
		});
		twinheart_use_btn.setOnMouseExited(event -> {
			twinheart_use_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		});
		this.twinheart_use_btn.setOnAction(event -> {
			cart.getUsers().get(cart.getUserID()).twinheart_inv--;
			this.twinheart_inv_quant.setText("Quantity: "+cart.getUsers().get(cart.getUserID()).twinheart_inv.toString()+"x");
			if(cart.getUsers().get(cart.getUserID()).twinheart_inv == 0) {
				fp.getChildren().remove(twinheart_inv_vb);
			}
		});
		smokebomb_use_btn.setOnMouseEntered(event -> {
			smokebomb_use_btn.setStyle("-fx-background-color: red;");
		});
		smokebomb_use_btn.setOnMouseExited(event -> {
			smokebomb_use_btn.setStyle("-fx-text-fill: white;"+"-fx-background-color: #613705");
		});
		this.smokebomb_use_btn.setOnAction(event -> {
			cart.getUsers().get(cart.getUserID()).smokebomb_inv--;
			this.smokebomb_inv_quant.setText("Quantity: "+cart.getUsers().get(cart.getUserID()).smokebomb_inv.toString()+"x");
			if(cart.getUsers().get(cart.getUserID()).smokebomb_inv == 0) {
				fp.getChildren().remove(smokebomb_inv_vb);
			}
		});
		
		heart_inv_imgv.setOnMouseClicked(event -> {
			cart.setViewCharm(1);
			StageManager.getInstance().changeScene(new ViewCharmPage().getScene());
		});
		coffee_inv_imgv.setOnMouseClicked(event -> {
			cart.setViewCharm(2);
			StageManager.getInstance().changeScene(new ViewCharmPage().getScene());
		});
		whetstone_inv_imgv.setOnMouseClicked(event -> {
			cart.setViewCharm(3);
			StageManager.getInstance().changeScene(new ViewCharmPage().getScene());
		});
		twinheart_inv_imgv.setOnMouseClicked(event -> {
			cart.setViewCharm(4);
			StageManager.getInstance().changeScene(new ViewCharmPage().getScene());
		});
		smokebomb_inv_imgv.setOnMouseClicked(event -> {
			cart.setViewCharm(5);
			StageManager.getInstance().changeScene(new ViewCharmPage().getScene());
		});
		
		shop_menu.setOnAction(event -> {
			StageManager.getInstance().changeScene(new ShopPage().getScene());
		});
		logout_menu.setOnAction(event -> {
			StageManager.getInstance().changeScene(new LoginPage().getScene());
		});
		
	}
	
}
