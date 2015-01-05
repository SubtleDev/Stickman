package me.subtleoliver.stickmandrawer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class SandBoxTest extends JFrame implements ActionListener {

	public final String VERS = "1.0.0";
	public final String TITLE = "Stickman " + VERS;
	private static final long serialVersionUID = -926469678696297356L;

	public static JTextField namefield = new JTextField();
	public static JButton nameupdate = new JButton("Update name");
	public static JButton question = new JButton(new ImageIcon("res/question.png"));
	public static JButton nexthat = new JButton("Next hat"); 
	public static String NAME = System.getProperty("user.name");

	private final Dimension SIZE = new Dimension(1280, 720);

	private Mouser mouser = new Mouser();

	public SandBoxTest() {
		addMouseListener(mouser);
		setLayout(null);
		nameupdate.setSize(new Dimension(120, 40));
		nameupdate.addActionListener(this);
		nameupdate.setLocation(SIZE.width - 150, 10);
		namefield.setLocation(SIZE.width - 252, 10);
		namefield.setSize(new Dimension(100, 40)); namefield.setToolTipText("Leave empty for username");
		namefield.setBorder(new TitledBorder("New Name:"));
		nexthat.setSize(new Dimension(240,60)); nexthat.setToolTipText("Change to the next hat"); nexthat.setBackground(Color.cyan); nexthat.setForeground(Color.black);
		nexthat.setLocation(SIZE.width - 255, 120); nexthat.addActionListener(this);
		setSize(SIZE);
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
		new SandBoxTest();
	}

	public void paint(Graphics g) {
		super.paint(g);

		new Drawer(g);

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
			if(Info.getHat() < Info.getHats()) Info.setHat(Info.getHat() + 1); else Info.setHat(1);
			repaint();
		}
	}
}
