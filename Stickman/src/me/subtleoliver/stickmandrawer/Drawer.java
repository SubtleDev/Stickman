package me.subtleoliver.stickmandrawer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Drawer {
private static BufferedImage WinIcon;
private static BufferedImage TopHat;
private static BufferedImage Cap;
private static BufferedImage SoldierHat;
private static BufferedImage Background;
private static BufferedImage BackgroundHat;
private static BufferedImage Stan;
	public Drawer(Graphics g) {
		try {
			
			TopHat = ImageIO.read(getClass().getResourceAsStream(Info.assetspath + "textures/TopHat.png"));
			WinIcon = ImageIO.read(getClass().getResourceAsStream(Info.assetspath + "textures/extra/WinIcon.png"));
			Cap = ImageIO.read(getClass().getResourceAsStream(Info.assetspath + "textures/Cap.png"));
			SoldierHat = ImageIO.read(getClass().getResourceAsStream(Info.assetspath + "textures/SoldierHat.png"));
			Background = ImageIO.read(getClass().getResourceAsStream(Info.assetspath + "textures/Background.png"));
			BackgroundHat = ImageIO.read(getClass().getResourceAsStream(Info.assetspath + "textures/HatBackground.png"));
			Stan = ImageIO.read(getClass().getResourceAsStream(Info.assetspath + "textures/StanMarsh.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void draw(Graphics g){
		UIDraw(g);
		headDraw(g);
		faceDraw(g);
		bodyDraw(g);
		nameDraw(g);
		hatDraw(g);
	}

	public void UIDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null);
		g.drawRect(0, 0, 234, 370);
	}

	public void headDraw(Graphics g) {
		// Draw Head
		g.setColor(new Color(255, 220, 178));
		g.fillOval(100, 100, 100, 100);
		g.setColor(Color.BLACK);
		g.drawOval(100, 100, 100, 100);
	}

	public void faceDraw(Graphics g) {
		if (Stickman.NAME.equals(System.getProperty("os.name"))) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillOval(102, 102, 95, 95);
			g.drawImage(WinIcon, 110, 113, 73, 73, null);
			g.setColor(Color.BLACK);
		} else {
			// Draw Face
			g.drawLine(120, 180, 180, 180);
			g.drawLine(120, 180, 120, 170);
			g.drawLine(180, 180, 180, 170);
			// Draw Eyes
			g.setColor(Color.white);
			g.fillOval(110, 140, 20, 20);
			g.fillOval(160, 140, 20, 20);
			g.setColor(Color.black);
			g.drawOval(110, 140, 20, 20);
			g.drawOval(160, 140, 20, 20);

			g.setColor(Color.blue);
			g.fillOval(115, 145, 10, 10);
			g.fillOval(165, 145, 10, 10);
			g.setColor(Color.black);
			g.fillOval(117, 147, 5, 5);
			g.fillOval(167, 147, 5, 5);
		}
	}

	public void bodyDraw(Graphics g) {
		// Draw Body
		g.drawLine(150, 200, 150, 300);
		// Draw Arms
		g.drawLine(150, 250, 100, 250);
		g.drawLine(150, 250, 200, 250);

		// Draw Legs
		g.drawLine(150, 300, 100, 350);
		g.drawLine(150, 300, 200, 350);
	}

	public void nameDraw(Graphics g) {
		g.setColor(Color.cyan);
		g.fill3DRect(248, 77, 230, 30, true);
		g.setColor(Color.black);
		g.draw3DRect(248, 77, 230, 30, true);
		g.setFont(new Font("Ben", Font.ROMAN_BASELINE, 25));
		g.drawString("Name: " + Stickman.NAME, 250, 100);
		
	}
	


	public void hatDraw(Graphics g) {
		g.drawImage(getCurrentHat(), 85, 18, null);
		g.drawImage(BackgroundHat, 128, Stickman.SIZE.height-140,null);
		g.draw3DRect(128, Stickman.SIZE.height -140, 128 * (Info.getHats() + 1),128, true);
		g.setColor(Color.black);
		g.draw3DRect(128 * Info.getHat(), Stickman.SIZE.height - 140, 130, 128, true);
		
		g.drawImage(TopHat, 128, Stickman.SIZE.height - 140, null);
		g.drawImage(Cap, 128 * 2, Stickman.SIZE.height - 140, null);
		g.drawImage(SoldierHat, (128 * 3), Stickman.SIZE.height - 150,null);
		g.drawImage(Stan, 128 * 4, Stickman.SIZE.height - 140, null);

	}


	public static Image getCurrentHat(){
		if(Info.getHat() == 1) return TopHat;
		if(Info.getHat() == 2) return Cap;
		if(Info.getHat() == 3) return SoldierHat;
		if(Info.getHat() == 4) return Stan;
		return null;
	}
}
