package models;

import java.util.ArrayList;
import java.util.List;

import views.Tile;

public class BoardModel {

	private List<Tile> tiles = new ArrayList<Tile>();

	public BoardModel() {
	}

	public List<Tile> getTiles() {
		return tiles;
	}

	public void setTiles(List<Tile> tiles) {
		this.tiles = tiles;
	}	

}
