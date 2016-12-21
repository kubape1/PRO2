package cz.uhk.fim.pro2.game.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import cz.uhk.fim.pro2.game.ScoreManager;

public class ScoreScreen extends Screen {
 

	public ScoreScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		int[] scores = new int[10];
		
		for(int i = 0; i < ScoreManager.getList().size(); i++ ){
			int score = ScoreManager.getList().get(i);
			scores[i] = score;			
		}
		
		bubbleSort(scores);
		
		
		for(int i = 0; i < 10; i++ ){
				
			ScoreItem scoreItem = new ScoreItem(i + 1, scores[i]);
			scoreItem.setBounds(0,50 + i* 50,300,50);
			add(scoreItem);
		}
		JButton jButtonBack = new JButton("BACK");
		
		jButtonBack.setBounds(100, 700, 280, 50);
		




		add(jButtonBack);
		
		jButtonBack.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));
			}
		});
	}
	
	public static void bubbleSort(int[] array){
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if(array[j] < array[j+1]){
				int tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
				}
			}
		}
	} 

}
