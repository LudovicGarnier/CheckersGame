package models;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import views.Tile;

/**
 * 
 * @author Ludov
 *
 */
public class Pawn extends Circle {

	public final static double PAWN_RADIUS = 25.0;
	private Tile tile;
	private Color color;

	public Pawn(double pawnRadius, Color color) {
		this.setRadius(pawnRadius);
		this.setFill(color);
	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.setFill(color);
	}

}
