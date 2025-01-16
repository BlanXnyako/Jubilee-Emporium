package view;

import javafx.scene.Group;
import javafx.scene.Scene;

public abstract class ViewBase {

	public abstract void initialize();
	public abstract void setComponent();
	public abstract void setStyle();
	public abstract void setAction();
	
	protected Scene scene;
	
	public Scene getScene() {
		return this.scene;
	}
	
	Variables variables = new Variables();
	
	public ViewBase() {
		this.scene = new Scene(new Group(), 1200, 700);
		initialize();
		setComponent();
		setStyle();
		setAction();
	}
	
}
