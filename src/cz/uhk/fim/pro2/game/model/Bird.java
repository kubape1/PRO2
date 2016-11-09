package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;

public class Bird {

	private String name;
	private float positionX, positionY;
	private float speed;
	private int lives;

	public Bird(String name, float positomX, float positionY) {
		this.name = name;
		this.positionY = positionY;
		this.positionX = positomX;
		speed = 0;
		lives = 3;

	}
	
	public void update(float deltaTime) {
		positionX += World.getSpeed() * deltaTime;
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLUE);

		g.fillRect( (int) getPositionX() - 25,(int) getPositionY() - 2, 50, 50);
	}

	public float getPositionX() {
		return positionX;
	}


	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}


	public float getPositionY() {
		return positionY;
	}


	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}


	public float getSpeed() {
		return speed;
	}


	public void setSpeed(float speed) {
		this.speed = speed;
	}


	public int getLives() {
		return lives;
	}


	public void setLives(int lives) {
		this.lives = lives;
	}


	public String getName() {
		return name;
	}


	public void goUp(){
			
	}
	
	public void catchHeart(){		
		
	}
	
	public void die(){
		
	}
	
	public void addLive(){
		
	}
	
	public void removeLive(){
		
	}
	
	public String toString(){
		return "["  + name + ", " + positionX + "; " + positionY + "]" ;
	}

}
