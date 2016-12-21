package cz.uhk.fim.pro2.game.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;

public class GameCanvas extends Canvas{
	
	
	private World world;
	
	public static int UP_BOUND = 100;
	public static int DOWN_BOUND = 70;
	
	private BufferedImage imageBird,
	imageHeart,
	imageBackground,
	imageTube,
	imageTop,
	imageBottom;
	
	public GameCanvas(World world) {
		this.world = world;
		
		
		try {
			imageBird = ImageIO.read(new File("assets/bird.png"));
			imageHeart = ImageIO.read(new File("assets/heart.png"));
			imageBackground = ImageIO.read(new File("assets/background.png"));
			imageTube = ImageIO.read(new File("assets/tube.png"));
			imageTop = ImageIO.read(new File("assets/top.png"));
			imageBottom = ImageIO.read(new File("assets/bottom.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
	}

	
	@Override
	public void paint(Graphics g) {

		/*g.setColor(Color.GRAY);
		g.fillRect(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);*/
			g.drawImage(imageBackground,
					0,
					0,
					MainFrame.WIDTH,
					MainFrame.HEIGHT,
					null);

		
		Bird bird = world.getBird();
		bird.paint(g, imageBird);
		
		List<Heart> hearts = world.getHearts();
		for(Heart heart : hearts)
			heart.paint(g, imageHeart);
		
		List<Tube> tubes = world.getTubes();
		for(Tube tube : tubes)
			tube.paint(g, imageTube);
		
		/*g.setColor(Color.ORANGE);
		g.fillRect(0, 0, MainFrame.WIDTH, UP_BOUND);*/
		
		
					g.drawImage(imageBottom,
				0,
				MainFrame.HEIGHT - DOWN_BOUND,
				MainFrame.WIDTH,
				DOWN_BOUND,
				null);

					g.drawImage(imageTop,
				0,
				0,
				MainFrame.WIDTH,
				UP_BOUND,
				null);		
					
		/*g.setColor(Color.BLACK);
		g.fillRect(0, MainFrame.HEIGHT - DOWN_BOUND, MainFrame.WIDTH, DOWN_BOUND);*/	
	}
	

	
	public void update(Graphics g){
		paint(g);
	}

}
