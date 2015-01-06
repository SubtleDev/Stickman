package me.subtleoliver.stickmandrawer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Drawer {
private static BufferedImage WinIcon;
private static BufferedImage TopHat;
private static BufferedImage Cap;
private static BufferedImage SoldierHat;
private static BufferedImage Background;
private static BufferedImage Backgrund;
private static BufferedImage StanMarsh;
	public Drawer(Graphics g) {
		UIDraw(g);
		headDraw(g);
		faceDraw(g);
		bodyDraw(g);
		nameDraw(g);
		hatDraw(g);
		
		try {
			TopHat = ImageIO.read(new File("res/TopHat.png"));
			WinIcon = ImageIO.read(new File("res/extrastuff/WinIcon.png"));
			Cap = ImageIO.read(new File("res/Cap.png"));
			SoldierHat = ImageIO.read(new File("res/SoldierHat.png"));
			Background = ImageIO.read(new File("res/Background.png"));
			Backgrund = ImageIO.read(new File("res/extrastuff/124832.png"));
			StanMarsh = ImageIO.read(new File("res/StanMarsh.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

	public void UIDraw(Graphics g) {
		if(System.getProperty("os.name") == Stickman.NAME) g.drawImage(Backgrund, 0, 0, null); else g.drawImage(Background, 0, 0, null);
		g.drawRect(0, 0, 234, 370);
	}

	public static void headDraw(Graphics g) {
		// Draw Head
		g.setColor(new Color(255, 220, 178));
		g.fillOval(100, 100, 100, 100);
		g.setColor(Color.BLACK);
		g.drawOval(100, 100, 100, 100);
	}

	public static void faceDraw(Graphics g) {
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

	public static void bodyDraw(Graphics g) {
		// Draw Body
		g.drawLine(150, 200, 150, 300);
		// Draw Arms
		g.drawLine(150, 250, 100, 250);
		g.drawLine(150, 250, 200, 250);

		// Draw Legs
		g.drawLine(150, 300, 100, 350);
		g.drawLine(150, 300, 200, 350);
	}

	public static void nameDraw(Graphics g) {
		g.setColor(Color.cyan);
		g.fill3DRect(249, 77, 230, 30, true);
		g.setColor(Color.black);
		g.draw3DRect(249, 77, 230, 30, true);
		g.setFont(new Font("Ben", Font.ROMAN_BASELINE, 25));
		g.drawString("Name: " + Stickman.NAME, 250, 100);
	}
	


	private static void hatDraw(Graphics g) {
		g.drawImage(getCurrentHat(), 85, 18, null);
		
		g.setColor(Color.cyan);
		g.fill3DRect(128 * Info.getHat(), 473, 130, 130, true);
		g.setColor(Color.black);
		g.draw3DRect(128 * Info.getHat(), 473, 130, 130, true);
		
		g.drawImage(TopHat, 128, 473, null);
		g.drawImage(Cap, 128 * 2, 473, null);
		g.drawImage(SoldierHat, (128 * 3), 463,null);
		g.drawImage(StanMarsh, 128 * 4, 473, null);

	}


	public static Image getCurrentHat(){
		if(Info.getHat() == 1) return TopHat;
		if(Info.getHat() == 2) return Cap;
		if(Info.getHat() == 3) return SoldierHat;
		if(Info.getHat() == 4) return StanMarsh;
		return null;
	}
}
