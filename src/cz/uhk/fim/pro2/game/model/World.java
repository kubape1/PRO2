package cz.uhk.fim.pro2.game.model;

import java.util.ArrayList;
import java.util.List;

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
	
	private static final int SPEED = 100; 
	
	public void update(float deltaTime) {
		
		
		bird.update(deltaTime);
		
		if(bird.isOutOf())
			worldListener.outOF();

		
		for(Tube tube : tubes){
			tube.update(deltaTime);
			
			if(bird.collideWith(tube))
				worldListener.crashTube(tube);
		
		}
		
		
		for(Heart heart : hearts){
			
			heart.update(deltaTime);
			
			if(bird.collideWith(heart))
				worldListener.crashHeart(heart);
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

}
