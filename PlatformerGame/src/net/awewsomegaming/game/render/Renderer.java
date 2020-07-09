package net.awewsomegaming.game.render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import net.awewsomegaming.game.render.object.Platform;

public class Renderer extends JPanel{
	private Graphics2D g2 = null;
	private int level = 0;
	private ArrayList<Platform> platforms = new ArrayList<>();
	private File mapf = null;
	private BufferedImage map = null;
	public void init() {
		this.setBackground(Color.BLACK);
		try {
			System.out.println("init");
			//mapf = this.getClass().getResourceAsStream("res/map0.png"); //new File(this.getClass().getResource("res/map"+level+".png").toURI());
			mapf = new File("G:\\git\\Platformer-Game-1\\PlatformerGame\\src\\net\\awewsomegaming\\game\\res\\map0.png");
			map = ImageIO.read(mapf);
		}catch (Exception e) {
			
		}
	}
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		this.g2 = g2;
		
		renderMap();
		renderPlayer();
	}
	public void renderMap() {
		if (map == null) {
			return;
		}
		int pixel[];
		int cModel;
		if (map.getColorModel().hasAlpha()) {
			cModel = 4;
		}else {
			cModel = 3;
		}
		for (int y = 0; y < map.getHeight(); y++) {
			for (int x = 0; x < map.getWidth(); x++) {
				pixel = map.getRaster().getPixel(x, y, new int[cModel]);
				String rgb = String.valueOf(pixel[0]+" "+pixel[1]+" "+pixel[2]);
				if (rgb.equals("0 0 0")) {
					Platform p = new Platform(g2,Color.blue);
					p.setX(x+10);
					p.setY(y+10);
					p.setWidth(10);
					p.setHeight(10);
					platforms.add(p);
					for (Platform cp : platforms) {
						cp.draw();
					}
				}
			}
		}
		platforms.removeAll(platforms);
	}
	public void renderPlayer() {
		
	}
}
