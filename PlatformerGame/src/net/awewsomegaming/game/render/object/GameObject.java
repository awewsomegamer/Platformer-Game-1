package net.awewsomegaming.game.render.object;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class GameObject extends JComponent{
	private Graphics2D g2;
	private int x,y,width,height;
	private Color c;
	public GameObject(Graphics2D g2,Color c,int width, int height, int x, int y) {
		this.g2 = g2;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.c = c;
	}
	public void draw() {
		g2.setColor(c);
		g2.fillRect(x, y, width, height);
	}
}
