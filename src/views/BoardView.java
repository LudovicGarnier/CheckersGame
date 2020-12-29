package views;

import java.util.ArrayList;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import managers.BoardManager;
import models.BoardModel;
import models.Pawn;

public class BoardView extends Pane {

	private double currentXCoordinate = 0;
	private double currentYCoordinate = 0;
	private boolean isBlack = true;
	private int column = 0;
	private char row = 'A';
	private BoardModel boardModel;
	BoardManager boardManager;

	public BoardView(BoardModel boardModel) {
		this.boardModel = boardModel;
		this.boardManager = new BoardManager(this.boardModel, this);
		this.initBoardGame();
		this.initPlayersPawns();
	}

	public void refreshTiles() {
		for (Tile tile: this.boardModel.getTiles()) {
			Pawn pawn = tile.getPawn();
			if(pawn != null) {
				pawn.layoutXProperty().bind(tile.widthProperty().divide(2));
				pawn.layoutYProperty().bind(tile.widthProperty().divide(2));
//				tile.getChildren().add(pawn);
			}
		}
	}
	
	public void initPlayersPawns() {
		for (int i = 0; i < this.boardModel.getTiles().size(); i++) {
			Pawn player1Pawn = new Pawn(Pawn.PAWN_RADIUS, Color.RED);
			Tile tile = this.boardModel.getTiles().get(i);
			if (tile.isBlack() && i < 40) {
				//				System.out.println("Player 1 : "+tile.toString());
				player1Pawn.layoutXProperty().bind(tile.widthProperty().divide(2));
				player1Pawn.layoutYProperty().bind(tile.widthProperty().divide(2));
				tile.getChildren().add(player1Pawn);
				tile.setPawn(player1Pawn);
				player1Pawn.setTile(tile);
			}
		}
		for (int j = 60; j < this.boardModel.getTiles().size(); j++) {
			Pawn player2Pawn = new Pawn(Pawn.PAWN_RADIUS, Color.BLUE);
			Tile tile = this.boardModel.getTiles().get(j);
			if (tile.isBlack()) {
				//					System.out.println("Player 2 : "+tile.toString());
				player2Pawn.layoutXProperty().bind(tile.widthProperty().divide(2));
				player2Pawn.layoutYProperty().bind(tile.widthProperty().divide(2));
				tile.getChildren().add(player2Pawn);
				tile.setPawn(player2Pawn);
				player2Pawn.setTile(tile);
			}
		}
	}

	
	public void clearBoard() {
		for(int i = 0; i < this.getChildren().size(); i++) {
			if(this.getChildren().get(i) instanceof Tile) {
				this.getChildren().remove(i);
			}
		}
		
	}

	public void initBoardGame() {
		for (int i = 0; i < 100; i++) {
			Tile tile = new Tile(this.boardManager);
			tile.setPrefSize(Tile.TILE_SIZE, Tile.TILE_SIZE);

			// End of a row
			if (this.currentXCoordinate >= 600) {
				this.currentXCoordinate = 0;
				this.currentYCoordinate += Tile.TILE_SIZE;
				this.isBlack = !isBlack;
			}

			if (column > 9) {
				column = 1;
				row++;
			} else {
				column++;
			}

			// Set tile values into the model
			tile.setRow("" + row);
			tile.setColumn("" + column);

			// Set tile values into the view
			tile.setLayoutX(currentXCoordinate);
			tile.setLayoutY(currentYCoordinate);

			//			Label label = new Label(row+"-"+column);
			//			label.setStyle("-fx-background-color:red;");
			//			tile.getChildren().add(label);

			this.setTileColor(tile);

			this.boardModel.getTiles().add(tile);
			this.getChildren().add(tile);

			this.currentXCoordinate += Tile.TILE_SIZE;
		}
	}

	private void setTileColor(Tile tile) {
		if (this.isBlack == true) {
			tile.setStyle("-fx-background-color:black;");
			this.isBlack = !isBlack;
		} else {
			tile.setStyle("-fx-background-color:beige;");
			isBlack = !isBlack;
		}
		tile.setBlack(!this.isBlack);
	}
}
