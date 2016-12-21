package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import cz.uhk.fim.pro2.game.gui.GameScreen;
import cz.uhk.fim.pro2.game.interfaces.WorldListener;

public class World {
	
	public World(Bird bird, WorldListener worldListener) {
		this.bird = bird;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
		this.worldListener = worldListener;
	}
	
	private Bird bird;
	private List<Tube> tubes;
	private List<Heart> hearts;
	private WorldListener worldListener;
	
	private static int SPEED = 150; 
	private static final int SPACE_BETWEEN_TUBES = 300;
	private static final int SPACE_BETWEEN_HEARTS = 450;
	private boolean generated;
	
	public void update(float deltaTime) {
		
		
		/*Timer timer = new Timer(20,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});*/

		
		if(generated)
			regenerate();
		
		bird.update(deltaTime);
		
		if(bird.isOutOf())
			worldListener.outOF();

		for (Tube tube : tubes) {
			tube.update(deltaTime);

			if (bird.collideWith(tube)) {
			tube.setProlet(true);	
			worldListener.crashTube(tube);
				;
			} else {
				if(bird.getPositionX() > tube.getMaxX() &&
				   tube.isProlet() == false){
					bird.addPoint();
					if(bird.getScore() % 10 == 0){
						//addSpeed();
						//timer.start();
						
					}

					tube.setProlet(true);
					System.out.println(bird.getScore()); 
				}
					
			}

		}
		

		for(Heart heart : hearts){
			
			heart.update(deltaTime);
			
			if(bird.collideWith(heart))
				worldListener.catchHeart(heart);
		}
		
		
		
		
	}
	

	public void generateRandom() {
		for (int i = 0; i < 3; i++) {
			addTube(new Tube(500 + i * SPACE_BETWEEN_TUBES,Tube.getRandomHeight(),Color.GREEN));
			
		}
		addHeart(new Heart( 500 + SPACE_BETWEEN_HEARTS,Heart.getRandomY()));
		
		generated = true;

	}
	
	private void regenerate() {
		for (Tube tube : tubes) {
			if (tube.getPositionX() < -100){
				
				tube.setPositionX(tube.getPositionX() + tubes.size()* SPACE_BETWEEN_TUBES);
				tube.setHeight(Tube.getRandomHeight());
				tube.setProlet(false);
				
				
			}
		}
		
		for(Heart heart : hearts) {
			if (heart.getPositionX() < -100){
				heart.setPositionX(heart.getPositionX() + (hearts.size() +  3) * SPACE_BETWEEN_HEARTS);
				heart.setPositionY(Heart.getRandomY());
			}

		}
	}

	public void addTube(Tube tube){
		tubes.add(tube);		
	}
	
	public void addHeart(Heart heart){
		hearts.add(heart);
	}
	
	@Override
	public String toString(){
		
		return "Ptak: " + bird.toString() + "\nPocet trubek: " + tubes.size() + "\nPocet srdíèek: " + hearts.size();
		 
	}

	public Bird getBird() {
		return bird;
	}

	public void setBird(Bird bird) {
		this.bird = bird;
	}

	public List<Tube> getTubes() {
		return tubes;
	}

	public void setTubes(List<Tube> tubes) {
		this.tubes = tubes;
	}

	public List<Heart> getHearts() {
		return hearts;
	}

	public void setHearts(List<Heart> hearts) {
		this.hearts = hearts;
	}

	public static int getSpeed() {
		return SPEED;
	}

	public void addSpeed() {

		SPEED += 125;
	}

}
