package managers;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import models.BoardModel;
import models.Pawn;
import views.BoardView;
import views.Tile;

/**
 * 
 * @author Ludov
 *
 */
public class BoardManager {

	private Tile currentTile;
	private BoardModel boardModel;
	private BoardView boardView;

	public BoardManager(BoardModel boardModel, BoardView boardView) {
		this.boardModel = boardModel;
		this.boardView = boardView;
	}

	public Tile getCurrentTile() {
		return currentTile;
	}

	public void setCurrentTile(Tile currentTile) {
		this.currentTile = currentTile;
	}

	public BoardModel getBoardModel() {
		return boardModel;
	}

	public void setBoardModel(BoardModel boardModel) {
		this.boardModel = boardModel;
	}

	public void checkMovePostion(Tile tile) {
		System.out.println(tile.toString());
		if (tile.hasPawn()) {
			List<Tile> neighbors = this.getNeighbors(this.getCurrentTile());

			for (Tile t : neighbors) {
				t.setStyle("-fx-background-color:red;");
				t.setOpacity(0.25);
			}
		}
	}

	public void cleanTiles(Tile tile) {
		List<Tile> neighbors = this.getNeighbors(this.getCurrentTile());
		for (Tile t : neighbors) {
			t.setStyle("-fx-background-color:black;");
			t.setOpacity(1);
		}
	}

	public void move(Tile tileStart, Tile tileEnd) {
		Pawn pawn = new Pawn(Pawn.PAWN_RADIUS, tileStart.getPawn().getColor());
		tileEnd.setPawn(pawn);
		tileStart.setPawn(null);
		for (int i = 0; i < tileStart.getChildren().size(); i++) {
			if (tileStart.getChildren().get(i) instanceof Pawn) {
				System.out.println("ok");
				tileStart.getChildren().remove(i);
			}
		}
		tileEnd.getChildren().add(pawn);
		pawn.setTile(tileEnd);
		for (int i = 0; i < tileEnd.getChildren().size(); i++) {
			if (tileEnd.getChildren().get(i) instanceof Pawn) {
				System.out.println("installed");
			}
		}
		this.boardView.refreshTiles();
	}

	public List<Tile> getNeighbors(Tile tile) {
		List<Tile> neighbors = new ArrayList<Tile>();
		if (tile != null) {
			char c = tile.getRow().charAt(0);

			// NorthWest neighbor
			char northWestrow = (char) (c - 1);
			Integer nwCol = Integer.valueOf(tile.getColumn());
			int northWestcol = nwCol - 1;
			Tile northWestTile = checkNeighborExist(northWestrow, northWestcol);

			if (northWestTile != null) {
				neighbors.add(northWestTile);
			}

			// NorthEast neighbor
			char northEastrow = (char) (c - 1);
			Integer neCol = Integer.valueOf(tile.getColumn());
			int northEastcol = neCol + 1;
			Tile northEastTile = checkNeighborExist(northEastrow, northEastcol);

			if (northEastTile != null) {
				neighbors.add(northEastTile);
			}

		}
		return neighbors;
	}

	public void actionOnTileClicked(Tile tile) {
		if (tile.hasPawn()) {
			if (this.getCurrentTile() != null) {
				if (this.getCurrentTile().equals(tile)) {
					this.cleanTiles(this.getCurrentTile());
					this.setCurrentTile(null);
				} else {
					this.cleanTiles(this.getCurrentTile());
					this.setCurrentTile(tile);
					this.checkMovePostion(tile);
				}

			} else {
				this.setCurrentTile(tile);
				this.checkMovePostion(tile);
			}

		} else {
			if (this.getCurrentTile() != null) {
				ArrayList<Tile> neighbors = (ArrayList<Tile>) this.getNeighbors(this.getCurrentTile());
				if(neighbors != null) {
					if(neighbors.contains(tile)) {
						this.move(this.getCurrentTile(), tile);
					}
				}
				this.cleanTiles(this.getCurrentTile());
				this.setCurrentTile(null);
			}
		}
	}

	public Tile checkNeighborExist(char row, int col) {
		Tile tile = null;
		for (int i = 0; i < this.boardModel.getTiles().size(); i++) {
			if (this.boardModel.getTiles().get(i).getRow().equals(row + "")
					&& this.boardModel.getTiles().get(i).getColumn().equals("" + col)) {
				tile = this.boardModel.getTiles().get(i);
			}
		}
		return tile;
	}

}
