package net.awewsomegaming.game.render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import net.awewsomegaming.game.main.Main;
import net.awewsomegaming.game.render.entity.Player;
import net.awewsomegaming.game.render.events.KeyEvents;
import net.awewsomegaming.game.render.imageuUtil.LoadSprite;
import net.awewsomegaming.game.render.object.Platform;

public class Renderer extends JPanel{
	private Graphics2D g2 = null;
	private int level = 0;
	private int playerSpeed = 2;
	private int oldPlayerY = 0;
	private int velu = 0;
	private ArrayList<Platform> platforms = new ArrayList<>();
	private Player player;
	private File mapf = null;
	private File playerSpritesf = null;
	private LoadSprite spriteLoader = new LoadSprite();
	private BufferedImage map = null;
	private BufferedImage playerSprites = null;
	private BufferedImage playerCSprite = null;
	private boolean playerJumping = false;
	private boolean getPlayerOldY = false;
	private KeyEvents keyEvent = new KeyEvents();
	public void init(Main m) {
		this.setBackground(Color.BLACK);
		m.addKeyListener(keyEvent);
		try {
			mapf = new File(this.getClass().getResource("res/map0.png").toURI());
			map = ImageIO.read(mapf);
			playerSpritesf = new File(this.getClass().getResource("res/playerSprites.png").toURI());
			playerSprites = ImageIO.read(playerSpritesf);
			playerCSprite = spriteLoader.loadSpriteSheetSquare(1, 1, playerSprites);
		}catch (Exception e) {
			
		}
	}
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		this.g2 = g2;
		
		renderMap();
		renderPlayer();
	}
	private void Physics() {
		// falling
		if (player.getY() < 571 && playerJumping == false) {
			player.setY(player.getY()+8);
		}
		
		// jumping
		if (playerJumping == true) {
			if (getPlayerOldY == false) {
				oldPlayerY = player.getY();
				getPlayerOldY = true;
			}
			Thread jump = new Thread(new Runnable() {
				public void run() {
					player.setY(player.getY()-8);
					velu++;
					if (velu <= oldPlayerY-8) {
						playerJumping = false;
					}
				}
			});
			jump.start();
		}
	}
	public void renderPlayer() {
		if (player == null) {
			player = new Player(g2);
			player.setWidth(100);
			player.setHeight(100);
			this.add(player);
		}else {
			int oldX = player.getX();
			int oldY = player.getY();
			player = null;
			player = new Player(g2);
			player.setX(oldX);
			player.setY(oldY); //572
			player.setWidth(100);
			player.setHeight(100);
			this.add(player);
		}
		Physics();
		if (keyEvent.keyA == true) {
			player.setX(player.getX()-playerSpeed);
		}
		if (keyEvent.keyD == true) {
			player.setX(player.getX()+playerSpeed);		
		}
		if (keyEvent.keySpace == true) {
			playerJumping = true;
			keyEvent.keySpace = false;
		}
		
		player.setSprite(playerCSprite);
		player.draw();
	}
	
	public void renderMap() {
		if (map == null) {
			return;
		}
		int pixel[];
		int spaceMult = 25;
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
					p.setX(x*spaceMult+50);
					p.setY(y*spaceMult);
					p.setWidth(15*spaceMult/10-spaceMult+5);
					p.setHeight(15*spaceMult/10-spaceMult+5);
					platforms.add(p);
					for (Platform cp : platforms) {
						cp.draw();
					}
				}
			}
		}
		platforms.removeAll(platforms);
	}
}
