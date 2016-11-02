package cz.uhk.fim.pro2.game.gui;

import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

public class HomeScreen extends Screen {

	public HomeScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		JLabel jLabelTitle = new JLabel("FIM BIRD");

		JButton jButtonPlay = new JButton("PLAY");
		JButton jButtonScore = new JButton("SCORE");
		JButton jButtonSound = new JButton("SOUND");

		jButtonPlay.setBounds(100, 400, 280, 50);
		jButtonScore.setBounds(100, 460, 280, 50);
		jButtonSound.setBounds(100, 520, 280, 50);
		
		jLabelTitle.setBounds(100,100,380,100);
		
		jLabelTitle.setFont(new Font("Arial", Font.BOLD,65));
		
		add(jButtonPlay);
		add(jButtonScore);
		add(jButtonSound);
		add(jLabelTitle);
		
		
		
		jButtonPlay.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new GameScreen(mainFrame));
			}
		});
		
		jButtonScore.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new ScoreScreen(mainFrame));
			}
		});
		
		
	}
}
