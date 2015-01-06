package me.subtleoliver.stickmandrawer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouser implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
	System.out.println("X: " + arg0.getLocationOnScreen().x + " Y: " + arg0.getLocationOnScreen().y);
	
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}
