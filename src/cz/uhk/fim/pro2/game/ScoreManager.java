package cz.uhk.fim.pro2.game;

import java.util.ArrayList;
import java.util.List;

public class ScoreManager {
	
	private List<Integer> scoreList; 
	
	private static ScoreManager instance;
	
	
	private ScoreManager(){
		this.scoreList = new ArrayList<>();
	}
	
	public void addScore(int score){
		scoreList.add(score);
	}
	
	public List<Integer> getAll(){
		return scoreList;
	}
	
	
	//SINGLETON
	
	public static ScoreManager getInstance(){
		
		if(instance == null){
			instance = new ScoreManager();
		}
		return instance;
	}
	
	public static void putScore(int score){
		getInstance().addScore(score);
	}
	
	public static List<Integer> getList(){
		return getInstance().getAll();

	}
}
