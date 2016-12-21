package cz.uhk.fim.pro2.game.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreItem extends JPanel {
	
	JLabel jLabelName = new JLabel();
	JLabel jLabelPosition;
	JLabel jLabelScore;
	
	public ScoreItem(int position, int score){
		
			jLabelPosition = new JLabel(position + ".");
			jLabelPosition.setFont(new Font("Arial", Font.PLAIN, 40));
			jLabelPosition.setBounds(0, 0, 100, 50);
			
			jLabelScore = new JLabel(String.valueOf(score));
			jLabelScore.setFont(new Font("Arial", Font.PLAIN, 40));
			jLabelScore.setBounds(0, 0, 200, 50);
			
		
			add(jLabelPosition);
			add(jLabelScore);

			
			
			
			
			
	}
}
