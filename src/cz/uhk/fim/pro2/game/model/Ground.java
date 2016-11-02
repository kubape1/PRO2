package cz.uhk.fim.pro2.game.model;

import java.awt.Color;

public class Ground {

	public Ground(Color color, float height) {
		super();
		this.color = color;
		this.height = height;
	}

	private Color color;
	private float height;

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

}
