package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;


public final class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
    public int hasKey = 0;
    int standCounter = 0;
    boolean moving = false;
    int pixelCounter = 0;
    
    
    
    public Player(GamePanel gp, KeyHandler keyH){
    	
        this.gp = gp;
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2-(gp.tileSize/2);
        screenY = gp.screenHeight/2-(gp.tileSize/2);
        
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 28;
        solidArea.height = 28;
        
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        
        worldX = gp.tileSize * 27;
        worldY = gp.tileSize * 21;
        speed = 1;
        direction = "down";
    }
    public void getPlayerImage(){
    	
        up1 = setup("boy_up_1");
        up2 = setup("boy_up_2");
        down1 = setup("boy_down_1");
        down2 = setup("boy_down_2");
        left1 = setup("boy_left_1");
        left2 = setup("boy_left_2");
        right1 = setup("boy_right_1");
        right2 = setup("boy_right_2");
    }
    
    public BufferedImage setup(String imageName) {
    	
    	UtilityTool uTool = new UtilityTool();
    	BufferedImage image = null;
    	
    	try {
    		
    		image = ImageIO.read(getClass().getResourceAsStream("/Player/" +imageName +".png"));
    		image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
    		
    		
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    	return image;
    }
    public void update(){
    	
    	if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true ||keyH.rightPressed == true) {
      		 
            if(keyH.upPressed == true){
                direction = "up";
            }
            else if(keyH.downPressed == true){
                direction = "down";
            }
            else if (keyH.leftPressed == true){
                direction = "left";
            }
            else if (keyH.rightPressed == true){
                direction = "right";

            }
            
            // Cheeck Tile Collision
            collisionOn = false;
            gp.cChecker.checkTile(this);
            
            //Check Object Collision
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);
            
            //if collision is false, player can move
            if(collisionOn == false) {
            	switch(direction) {
            	case "up" -> worldY -= speed;
            	case "down" -> worldY += speed;
            	case "left" -> worldX -= speed;
            	case "right" -> worldX += speed;
            	}
            	
            }
            
            spriteCounter++;
            if(spriteCounter > 60){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter =0;
            }
    	}
    	else {
    		standCounter++;
    		if(standCounter == 20) {
    			
    			spriteNum = 1;
    			standCounter = 0;
    			
    		}
    	}
    }
    
    public void pickUpObject(int i) {
    	
    	if(i != 999) {
    		
    		String objectName = gp.obj[i].name;
    		
    		switch(objectName) {
	    		case "Key" -> {
	    				gp.playSE(1);
	                    hasKey++;
	                    gp.obj[i] = null;
	                    gp.ui.showMessage("Key+1");
	                    break;
	                    }
	    		case "Door" -> {
	                    if(hasKey > 0) {
	                    	gp.playSE(3);
	                        gp.obj[i] = null;
	                        hasKey--;
	                        gp.ui.showMessage("Door Unlocked!!");
	                        break;
	                    }
	                    else {
	                    	gp.ui.showMessage("Need more Key!!");
	                    }
	                    
	                    }	
	    		case "Boots" -> {
	    			gp.playSE(2);
	    			speed += 1;
	    			gp.obj[i] = null;
	    			gp.ui.showMessage("Speed Increased!!");
	    			break;
	    			}
	    		case "Chest" -> {
	    			gp.ui.gameFinished = true;
	    			gp.stopMusic();
	    			gp.playSE(4);
	    			break;
	    		}
    	
    		}
    		
    	}
    }
    
    public void draw(Graphics2D g2){
        
       BufferedImage image = null;
       switch (direction){
           case "up" -> {
               if(spriteNum ==1){
                   image = up1;
               }
               if(spriteNum ==2){
                   image =up2;
               }
            }
           case "down" -> {
               if(spriteNum ==1){
                   image = down1;
               }
               if(spriteNum ==2){
                   image =down2;
               }
            }
           case "left" -> {
               if(spriteNum == 1){
                   image = left1;
               }
               if(spriteNum == 2){
                   image =left2;
               }
            }
           case "right" -> {
               if(spriteNum ==1){
                   image = right1;
               }
               if(spriteNum ==2){
                   image =right2;
               }
            }
       }
       g2.drawImage(image, screenX, screenY, null);
       
       /*troubleshooting colision
        
       g2.setColor(Color.red);
       g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);*/
    }
}
