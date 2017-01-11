package com.base.engine;

public class MainComponent {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "NewWindow";
	public static final double FRAME_CAP = 5000.0;
	
	private boolean isRunning;
	private Game game;
	
	public MainComponent(){
		System.out.println(RenderUtil.getOpenGLVersion());
		RenderUtil.initGraphics();
		isRunning = false;
		game = new Game();
	}
	
	public void start(){
		if(isRunning)
			return;
		
		run();
	}
	
	public void stop(){
		if(!isRunning)
			return;
		isRunning = false;
	}
	
	public void run(){
		isRunning = true;
		
		int frames = 0;
		long frameCount = 0;
		
		final double frameTime= 1/FRAME_CAP;
		
		long lastTime = Time.getTime();
		double unprocessedTime = 0;
		
		while(isRunning){
			boolean render = false;

			long startTime = Time.getTime();
			long passedTime = startTime - lastTime;
			lastTime = startTime;
			unprocessedTime += passedTime/(double)Time.SECOND;
			frameCount += passedTime;
			
			while(unprocessedTime > frameTime){
				unprocessedTime -= frameTime;
				render = true;
				
				if(frameCount >= Time.SECOND){
					System.out.println(frames);
					frames = 0;
					frameCount = 0;
				}
				game.input();
				game.update();
				
				Input.update();
				
				Time.setDelta(frameTime);
				
				if(Window.isCloseRequested())
					stop();
				
			}
			
			if(render){
				frames++;
				render();
				
			}
			else{
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		cleanUp();
	}
	
	public void render(){
		RenderUtil.clearScreen();
		game.render();
		Window.render();
	}
	
	public void cleanUp(){
		Window.dispose();
	}
	
	public static void main(String args[]){
		Window.createWindow(WIDTH, HEIGHT, TITLE);
		MainComponent game = new MainComponent();
		game.start();
	}

}
