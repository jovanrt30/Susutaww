package main;

import javax.swing.JFrame;

import panel.GamePanel;
import panel.MainMenuPanel;

public class Main {

	public static final int WIDTH = 900;
	public static final int HEIGHT = 600;
	public static JFrame frame;
	
	public Main() {
		frame = new JFrame("susutaww");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		frame.add(new MainMenuPanel());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	
	public static void main(String[] args) {
		new Main();
	}
	
}
