package net.awewsomegaming.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable{
	private boolean running = false;
	private boolean update = false;
	private double frame_cap = 1.0/120.0;
	private Thread gameLoop;
	private Window w;
	public void init() {
		w = new Window(this,"Platformer",900,700,false);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		gameLoop = new Thread(this);
		gameLoop.run();
	}
	
	public void run() {
		running = true;
		loop();
	}
	
	public void loop() {
		double now = 0;
		double past = System.nanoTime() / 1000000000.0;
		double passed = 0;
		double unprocessed = 0;
		while (running) {
			update = false;
			past = now;
			passed += past;
			now = System.nanoTime() / 1000000000.0;
			unprocessed += passed;
			while (unprocessed >= frame_cap) {
				update();
				update = true;
				unprocessed -= frame_cap;
			}
			if (update) {
				update();
			}else {
				try {
					Thread.sleep(1);
				}catch (Exception e) {
					
				}
			}
		}
	}
	public void update() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, 900, 700);
		
		bs.show();
		g.dispose();
	}
	public static void main(String args[]) {
		Main m = new Main();
		m.init();
	}
}
