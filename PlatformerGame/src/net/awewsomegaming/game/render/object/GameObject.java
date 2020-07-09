package net.awewsomegaming.game.render.object;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class GameObject extends JComponent{
	private Graphics2D g2;
	private int x,y,width,height;
	private Color c;
	public GameObject(Graphics2D g2,Color c) {
		this.g2 = g2;
		this.c = c;
	}
	
	public void draw() {
		g2.setColor(c);
		g2.fillRect(x, y, width, height);
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
}
