package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.MainView;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			MainView mainView = new MainView();
			Scene scene = new Scene(mainView.getVBox(), 840, 640);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
