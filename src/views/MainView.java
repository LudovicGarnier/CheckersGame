package views;


import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import models.BoardModel;

/**
 * 
 * @author Ludov
 *
 */
public class MainView extends Parent{

	private SplitPane splitPane;
	private VBox mainBox, infoBox, boardBox;
	private AnchorPane anchorPane;
	private MenuBar menuBar;
	private BoardModel boardModel;
	private BoardView boardView;

	public MainView() {
		this.boardModel = new BoardModel();
		this.boardView = new BoardView(boardModel);

		this.mainBox = new VBox();
		this.splitPane = new SplitPane();
		this.splitPane.setPrefSize(840, 800);
		this.infoBox = new VBox(new Label("infoBox"));
		this.boardBox = new VBox();

		this.boardBox.getChildren().add(boardView);
		this.splitPane.getItems().addAll(this.infoBox, this.boardBox);

		this.getChildren().add(splitPane);

		this.anchorPane = new AnchorPane();

		this.splitPane.setDividerPositions(0.25);
		this.anchorPane.getChildren().add(splitPane);

		this.menuBar = new MenuBar();
		Menu menu1 = new Menu("Menu 1");
		menuBar.getMenus().add(menu1);

		this.mainBox.getChildren().addAll(menuBar, anchorPane);
	}

	public AnchorPane getAnchorPane() {
		return this.anchorPane;
	}

	public VBox getVBox() {
		return this.mainBox;
	}
}
