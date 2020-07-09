package net.awewsomegaming.game.render;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Renderer extends JPanel{
	private Graphics2D g2 = null;
	private int level = 0;
	
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		this.g2 = g2;
		
		renderMap();
		renderPlayer();
	}
	public void renderMap() {
		try {
			File mapf = new File(this.getClass().getResource("res/maps/map"+level+".png").toURI());
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
					if (red == 0 && green == 0 && blue == 0) {
						
					}
				}
			}
		}catch (Exception e) {
			
		}
	}
	public void renderPlayer() {
		
	}
}
