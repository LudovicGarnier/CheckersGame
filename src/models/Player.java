package models;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;

/*
 * 
 */
public class Player {

	private List<Pawn> pawns;
	private int id;
	private Color color;
	private boolean isHuman;
	
	
	public Player(int id, Color color, boolean isHuman) {
		this.id = id;
		this.color = color;
		this.isHuman = isHuman;
		this.pawns = new ArrayList<Pawn>();
	}

	public List<Pawn> getPawns() {
		return pawns;
	}

	public void setPawns(List<Pawn> pawns) {
		this.pawns = pawns;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isHuman() {
		return isHuman;
	}

	public void setHuman(boolean isHuman) {
		this.isHuman = isHuman;
	}
	
	@Override
	public String toString() {
		return "Player " + id + " - color:" + color + " - isHuman:" + isHuman;
	}
}
