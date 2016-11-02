package cz.uhk.fim.pro2.game.gui;

import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GameScreen extends Screen{

	public GameScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		JButton jButtonBack = new JButton("Back");
		JButton jButtonPause = new JButton("||");
		
		jButtonBack.setBounds(20, 20, 60, 60);
		jButtonPause.setBounds(400, 20, 60, 60);
		
		jButtonBack.setFont(new Font("Arial", Font.PLAIN, 15));
		jButtonPause.setFont(new Font("Arial", Font.PLAIN, 30));
		//jButtonBack.setForeground(background);

		
		add(jButtonBack);
		add(jButtonPause);
		
		jButtonBack.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));
			}
		});
		
	}
	
	

}
