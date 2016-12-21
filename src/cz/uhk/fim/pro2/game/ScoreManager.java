package cz.uhk.fim.pro2.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class ScoreManager {
	
	
	private static ScoreManager instance;
	
	
	private ScoreManager(){
		//this.scoreList = new ArrayList<>();
	}
	
	public static void addScore(int score){
		//scoreList.add(score);
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(Game.SCORE_FILE,true);
			
			fileWriter.append(String.valueOf(score));
			fileWriter.append(";");
			fileWriter.append(new Date().toGMTString());
			fileWriter.append("\n");
			
			fileWriter.flush();
			fileWriter.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public List<Integer> getAll(){
		
		

		
		List<Integer> scoreList = new ArrayList<Integer>();
		
		
		try {
			FileReader fileReader = new FileReader(Game.SCORE_FILE);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line;
			while((line = bufferedReader.readLine()) != null){

				String[] values = line.split(";");
				scoreList.add(Integer.valueOf(values[0]));
			}
			bufferedReader.close();
				
			;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
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
