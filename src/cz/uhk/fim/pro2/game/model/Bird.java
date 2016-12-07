package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import cz.uhk.fim.pro2.game.gui.GameCanvas;
import cz.uhk.fim.pro2.game.gui.GameScreen;
import cz.uhk.fim.pro2.game.gui.MainFrame;

public class Bird {

	
	public static final int DEFAULT_SCORE = 0;
	public static final int DEFAULT_LIVES = 3;
	public static final int JUMP = 550;
	
	private String name;
	private float positionX, positionY;
	private float speed;
	private int lives;
	private static final int GRAVITY = 300;

	private int score;

	public Bird(String name, float positomX, float positionY) {
		this.name = name;
		this.positionY = positionY;
		this.positionX = positomX;
		speed = JUMP / 2;
		lives = DEFAULT_LIVES;
		score = DEFAULT_SCORE;

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
		int upLimit = GameCanvas.UP_BOUND;
		int downLimit = MainFrame.HEIGHT - GameCanvas.DOWN_BOUND;
		
		return rectangle.getMaxY() > downLimit || rectangle.getMinY() < upLimit;
				}
	
	public void goUp(){
		speed = JUMP;
			
	}
	
	public void addLive(){
		lives++;
	}
	
	public void removeLive(){
		lives--;
	}
	
	public void addPoint(){
		score++;
	}

	public int getScore() {
		return score;
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
	
	public boolean isAlive(){
		if (getLives() <= 0)
			return false;
		return true;
	}
	
	public String toString(){
		return "["  + name + ", " + positionX + "; " + positionY + "]" ;
	}

	public void catchHeart() {
		
		
	}

}
