package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lib.StageManager;
import view.AdminPage;
import view.InventoryPage;
import view.LoginPage;
import view.RegisterPage;
import view.ShopPage;
import view.ViewCharmPage;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		//StageManager.getInstance().changeScene(new LoginPage().getScene());
		StageManager.getInstance().changeScene(new LoginPage().getScene());
	
	}
	
}