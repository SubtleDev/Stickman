package me.subtleoliver.stickmandrawer;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Stickman extends JFrame implements ActionListener {

	public final String VERS = "1.1.0"; //Version number
	public final String TITLE = "Stickman " + VERS; //Frame Title
	private static final long serialVersionUID = -926469678696297356L; //SerialVersionUID
	//Stuff initialization
	public static JTextField namefield = new JTextField();
	public static JButton nameupdate = new JButton("Update name");
	public static JButton nexthat = new JButton("Next hat"); 
	public static String NAME = System.getProperty("user.name");

	public static final Dimension SIZE = new Dimension(1280, 720);

	private Drawer drawer = new Drawer(getGraphics());
	
	Mouser mouser = new Mouser();

	public Stickman() {
		
		addMouseListener(mouser);
		setLayout(null);
		nameupdate.setSize(new Dimension(120, 40));
		nameupdate.addActionListener(this);
		nameupdate.setLocation(SIZE.width - 150, 10);
		namefield.setLocation(SIZE.width - 252, 10);
		namefield.setSize(new Dimension(100, 40));
		namefield.setBorder(new TitledBorder("New Name:"));
		nexthat.setSize(new Dimension(240,60));
		nexthat.setLocation(SIZE.width - 255, 120); nexthat.addActionListener(this);
		setPreferredSize(SIZE);
		setResizable(false);
		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		add(nameupdate); add(namefield); add(nexthat);
		namefield.addActionListener(this);
		pack();

	}

	public static void main(String[] args) {
		new Stickman();
	}

	public void paint(Graphics g) {
		drawer.draw(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == namefield || e.getSource() == nameupdate) {
			if (!namefield.getText().equalsIgnoreCase("")) {
				NAME = namefield.getText();
			}  else {
				if(new Random().nextInt(100) < 50) NAME = System.getProperty("user.name"); else
					NAME = System.getProperty("os.name");
			}
			repaint();
		}
		if(e.getSource() == nexthat){
			if(Info.getHat() < Info.getHats()) Info.setHat((byte) (Info.getHat() + 1)); else Info.setHat((byte) 1);
			repaint();
		}
	}
}