package cz.uhk.fim.pro2.game.model;

import java.util.ArrayList;
import java.util.List;

public class World {
	
	public World(Bird bird) {
		this.bird = bird;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
	}
	
	private Bird bird;
	private List<Tube> tubes;
	private List<Heart> hearts;
	
	private static final int SPEED = 100; 
	
	public void update(float deltaTime) {
		bird.update(deltaTime);
		
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
