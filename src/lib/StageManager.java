package lib;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageManager {
	
	public static StageManager instance;

	public static StageManager getInstance() {
		if (instance == null)
			instance = new StageManager();
		return instance;
	}
	
	private StageManager() {
		this.stage = new Stage();
	}
	
	private Stage stage;
	
	public void changeScene(Scene scene) {
		this.stage.setScene(scene);
		if(!this.stage.isShowing())
			this.stage.show();
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
