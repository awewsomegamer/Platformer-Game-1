package net.awewsomegaming.game.main;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame{
	public Window(Main m, String title, int width, int height, boolean resizable) {
		Dimension size = new Dimension(width,height);
		this.setSize(size);
		this.setPreferredSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		this.setResizable(resizable);
		this.setLocationRelativeTo(null);
		this.setTitle(title);
		this.add(m);
		this.setVisible(true);
	}
}
