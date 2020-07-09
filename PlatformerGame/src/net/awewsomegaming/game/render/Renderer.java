package net.awewsomegaming.game.render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import net.awewsomegaming.game.render.object.Platform;

public class Renderer extends JPanel{
	private Graphics2D g2 = null;
	private int level = 0;
	private ArrayList<Platform> platforms = new ArrayList<>();
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		this.g2 = g2;
		
		renderMap();
		renderPlayer();
	}
	public void renderMap() {
		try {
			//File mapf = new File(this.getClass().getResource("res\\map"+level+".png").toURI());
			File mapf = new File("G:\\git\\Platformer-Game-1\\PlatformerGame\\src\\res\\map"+level+".png");
			
			//File mapf = new File("");
			BufferedImage map = ImageIO.read(mapf);
			
			
			
			int pixel[];
			int cModel;
			if (map.getColorModel().hasAlpha()) {
				cModel = 4;
			}else {
				cModel = 3;
			}
			
			for (int y = 0; y < map.getHeight(); y++) {
				for (int x = 0; y < map.getWidth(); x++) {
					pixel = map.getRaster().getPixel(x, y, new int[cModel]);
					int red,green,blue;
					red = pixel[0];
					green = pixel[1];
					blue = pixel[2];
					String rgb = String.valueOf(red+" "+green+" "+blue);
					System.out.println(rgb);
					if (rgb.equals("255 255 255")) {
						Platform p = new Platform(g2,Color.BLUE,x,y,10,10);
						platforms.add(p);
					}
				}
			}
			platforms.removeAll(platforms);
		}catch (Exception e) {
			
		}
	}
	public void renderPlayer() {
		
	}
}
