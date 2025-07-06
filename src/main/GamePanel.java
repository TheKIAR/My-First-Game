package main;

import entity.Player;
import object.SuperObject;
import tile.TileManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
 static final long serialVersionUID = 1L;
	
	//Screen Settings
    final int originalTileSize = 16; //16X16 Tile
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale ; //48X48 Tile
    public final int maxScreenCol = 21;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;//1008 pixels
    public final int screenHeight = tileSize * maxScreenRow;//576 pixels
    
    //World Settings
    public final int maxWorldCol = 60; 
    public final int maxWorldRow = 55;
    
    
    //FPS
    int FPS = 25;
    
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Sound music = new Sound();
    Sound se = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    Thread gameThread;
    
    //Entity and Object
    public Player player = new Player(this,keyH);
    public SuperObject obj[] = new SuperObject[25];

    
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        
    }
    
    public void setupGame() {
    	
    	aSetter.setObject();
    	
    	playMusic(0);
    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
    public void run() {
        
      double drawInterval = 100000000/FPS; //0.01666 sec
      double delta = 0;
      long lastTime = System.nanoTime();
      long currentTime;
      
      while(gameThread != null){
          
          currentTime = System.nanoTime();
          
          delta += (currentTime -lastTime) / drawInterval;
          
          lastTime = currentTime;
          if(delta >= 1){
              update();
              repaint();
              delta--;
          }
      }
      
    }
    public void update(){
        player.update();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
     
        Graphics2D g2 =(Graphics2D)g;
        
        //Debug
        long drawStart = 0;
        if(keyH.checkDrawTime == true) {
        	
        drawStart = System.nanoTime();
        }
        
        //Tile
        tileM.draw(g2);
        
        //Object
        for(int i = 0 ; i < obj.length; i++) {
        	
        	if(obj[i] != null) {
        		obj[i].draw(g2, this);
        	}
        }
        
        //Player
        player.draw(g2);
        
        //UI
        ui.draw(g2);
        
        //Debug
        if(keyH.checkDrawTime == true) {
        	long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            g2.setColor(Color.white);
            g2.drawString("Draw Time: " +passed, 10, 400);
            System.out.println("Draw Time:" + passed);
        }
        
        g2.dispose();
    }
    
    public void playMusic(int i) {
    	
    	music.setFile(i);
    	music.play();
    	music.loop();
    }
    
    public void stopMusic() {
    	
    	music.stop();
    }
    
    public void playSE(int i) {
    	
    	se.setFile(i);
    	se.play();
    }
}














