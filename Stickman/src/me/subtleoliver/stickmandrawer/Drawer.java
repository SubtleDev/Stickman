package me.subtleoliver.stickmandrawer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Drawer {
	
	public static ArrayList<BufferedImage> hats = new ArrayList<BufferedImage>();
	//Icons
	private static BufferedImage WinIcon;
	private static BufferedImage Background;
	//Shirts
	private static BufferedImage tshirt1;
	
	public Drawer(Graphics g) {
		try {
			hats.add(ImageIO.read(getClass().getResourceAsStream(Info.assetspath("textures/hats/TopHat.png")))); //TopHat
			hats.add(ImageIO.read(getClass().getResourceAsStream(Info.assetspath("textures/hats/Cap.png"))));
			hats.add(ImageIO.read(getClass().getResourceAsStream(Info.assetspath("textures/hats/SoldierHat.png"))));
			hats.add(ImageIO.read(getClass().getResourceAsStream(Info.assetspath("textures/hats/StanMarsh.png"))));
			
			Background =(ImageIO.read(getClass().getResourceAsStream(Info.assetspath("textures/Background.png"))));
			WinIcon = (ImageIO.read(getClass().getResourceAsStream(Info.assetspath("textures/extra/WinIcon.png"))));
			
			tshirt1 = ImageIO.read(getClass().getResourceAsStream(Info.assetspath("textures/shirts/tshirt1.png")));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void draw(Graphics g) {
		UIDraw(g);
		headDraw(g);
		faceDraw(g);
		bodyDraw(g);
		nameDraw(g);
		hatDraw(g);
	}

	public void UIDraw(Graphics g) {
		g.drawImage(Background, 2, 2, null);
		g.drawRect(2, 2, Background.getWidth(), Background.getHeight());
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
		g.drawLine(150, 213, 100, 250);
		g.drawLine(150, 213, 200, 250);

		// Draw Legs
		g.drawLine(150, 300, 100, 350);
		g.drawLine(150, 300, 200, 350);

		// Draw Shirt:
		g.drawImage(getCurrentShirt(), 50, 180, null);

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
		g.drawImage(hats.get(Info.getHat()), 85, 18, null);
		g.setColor(Color.cyan);
		g.fillRect(128, Stickman.SIZE.height - 140, 128*(hats.size()), 128);
		g.setColor(Color.black);
		g.draw3DRect(128, Stickman.SIZE.height - 140,
				128 * (hats.size()), 128, true);
		g.draw3DRect(128 * (Info.getHat() + 1), Stickman.SIZE.height - 140, 128, 128,
				true);

		for(int i = 0; i < hats.size(); i++){
			g.drawImage(hats.get(i), 128 * (i+1), Stickman.SIZE.height - 150, null);
		}

	}

	public static Image getCurrentShirt() {
		return tshirt1;
	}
}
