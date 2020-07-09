package net.awewsomegaming.game.main;

import java.awt.Canvas;

public class Main extends Canvas implements Runnable{
	private boolean running = false;
	private double frame_cap = 1.0/120.0;
	private Thread gameLoop;
	private Window w;
	public void init() {
		w = new Window(this,"Platformer",900,700,false);
		gameLoop = new Thread(this);
		gameLoop.run();
	}
	
	public void run() {
		running = true;
		loop();
	}
	
	public void loop() {
		
	}
	
	public static void main(String args[]) {
		Main m = new Main();
		m.init();
	}
}
