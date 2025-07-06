package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.OBJ_Key;

public class UI {

	GamePanel gp;
	Font arial_20,arial_40, arial_80B, arial_80;
	BufferedImage keyImg;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
	
	double playTime;
	DecimalFormat dFormat = new DecimalFormat("#0.00");
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
		arial_20 = new Font("Arial", Font.PLAIN, 20);
		arial_40 = new Font("Arial", Font.PLAIN, 40);
		arial_80 = new Font("Arial", Font.PLAIN, 80);
		arial_80B = new Font("Arial", Font.BOLD, 80);
		OBJ_Key key = new OBJ_Key(gp);
		keyImg = key.image;
	}
	
	public void showMessage(String text) {
		
		message = text;
		messageOn = true;
		
	}
	
	public void draw(Graphics2D g2) {
		
		if(gameFinished == false) {
		
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			g2.drawImage(keyImg, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
			g2.drawString(" x " + gp.player.hasKey, 62, 64);
			
			//Time
			playTime += (double)1/225;
			g2.drawString("Time:"+ dFormat.format(playTime), gp.tileSize*16, 64);
			
			//Message
			
			if(messageOn == true) {
				
				g2.setFont(g2.getFont().deriveFont(30F));
				g2.drawString(message, gp.tileSize/2, gp.tileSize*5);
				messageCounter++;
				
				if(messageCounter >120) {
					messageCounter = 0;
					messageOn = false;
				}
			}
		}
		else {
			
			g2.setFont(arial_80B);
			g2.setColor(Color.white);
			
			String text;
			int textLength;
			int x;
			int y;
			
			text = "You Win!!";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2 - (gp.tileSize*3);
			g2.drawString(text, x, y);
			
			g2.setFont(arial_40);
			g2.setColor(Color.yellow);
			
			text = "Your Time:"+ dFormat.format(playTime) + "!!";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2 + (gp.tileSize*4);
			g2.drawString(text, x, y);
			
			g2.setFont(arial_80);
			g2.setColor(Color.cyan);
			
			text = "Congratulations!!";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2 + (gp.tileSize*2);
			g2.drawString(text, x, y);
			
			g2.setFont(arial_20);
			g2.setColor(Color.yellow);
			
			text = "Credit: Md. Ragib Ashhab";
			x = gp.tileSize * 15;
			y = gp.tileSize * 11;
			g2.drawString(text, x, y);
			
			gp.gameThread = null;
			
		}
		
	}
}










