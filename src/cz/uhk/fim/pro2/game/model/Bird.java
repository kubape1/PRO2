package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import cz.uhk.fim.pro2.game.gui.MainFrame;

public class Bird {

	private String name;
	private float positionX, positionY;
	private float speed;
	private int lives;
	private static final int GRAVITY = 300;
	private static final int JUMP = 650;

	public Bird(String name, float positomX, float positionY) {
		this.name = name;
		this.positionY = positionY;
		this.positionX = positomX;
		speed = 0;
		lives = 3;

	}
	
	public void update(float deltaTime) {
		positionY -= speed * deltaTime;
		positionY += GRAVITY * deltaTime;
		
		speed -= speed * deltaTime;
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLUE);

		Rectangle rectangle = getRectangle();
		
		g.fillRect( (int) rectangle.getX(),
					(int) rectangle.getY()	,
					(int)rectangle.getWidth(),
					(int)rectangle.getHeight());
	}
	
	public Rectangle getRectangle(){
		return  new Rectangle( (int) getPositionX() - 25,(int) getPositionY() - 2, 50, 50);
	}
	
	public boolean collideWith(Tube tube){
		Rectangle rectangle = getRectangle();
		
		return rectangle.intersects(tube.getTop()) || rectangle.intersects(tube.getBottom());
		
	}
	
	public boolean collideWith(Heart heart){
		return getRectangle().intersects(heart.getRectangle());
	}
	
	public boolean isOutOf(){
		Rectangle rectangle = getRectangle();
		return rectangle.getMaxY() > MainFrame.HEIGHT || rectangle.getMinY() < 0;
				}
	
	public void goUp(){
		speed = JUMP;
			
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
