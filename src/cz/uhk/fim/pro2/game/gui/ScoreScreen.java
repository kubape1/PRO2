package cz.uhk.fim.pro2.game.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import cz.uhk.fim.pro2.game.ScoreManager;

public class ScoreScreen extends Screen {
 

	public ScoreScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		for(int i = 0; i < ScoreManager.getList().size(); i++ ){
			int score = ScoreManager.getList().get(i);
			
			ScoreItem scoreItem = new ScoreItem(i + 1, score);
			scoreItem.setBounds(50,200 + i* 50,300,50);
			add(scoreItem);
		}

		JButton jButtonBack = new JButton("BACK");
		
		jButtonBack.setBounds(100, 400, 280, 50);
		




		add(jButtonBack);
		
		jButtonBack.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));
			}
		});
	}

}
