package views;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import managers.BoardManager;
import models.Pawn;

/**
 * 
 * @author Ludov
 *
 */
public class Tile extends Pane {

	public static final double TILE_SIZE = 60.0;
	private boolean isBlack;
	private String row = "";
	private String column = "";
	private Pawn pawn;
	private BoardManager boardManager;

	public Tile(BoardManager boardManager) {
		this.boardManager = boardManager;

		this.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				Tile.this.getBoardManager().actionOnTileClicked(Tile.this);
			}
		});
	}

	public BoardManager getBoardManager() {
		return this.boardManager;
	}

	public void setBoardManager(BoardManager boardManager) {
		this.boardManager = boardManager;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public boolean hasPawn() {
		return getPawn() != null;
	}

	public boolean isBlack() {
		return isBlack;
	}

	public void setBlack(boolean isBlack) {
		this.isBlack = isBlack;
	}

	public Pawn getPawn() {
		return pawn;
	}

	public void setPawn(Pawn pawn) {
		this.pawn = pawn;
	}

	@Override
	public String toString() {
		return "row=" + this.row + " - column=" + this.column + " - hasPawn=" + this.hasPawn() + " - isBlack="
				+ this.isBlack;
	}
}
