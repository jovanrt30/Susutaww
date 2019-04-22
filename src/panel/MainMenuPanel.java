package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Main;

public class MainMenuPanel extends JPanel {

	JLabel title;

	ImageIcon bg = new ImageIcon("Resources/Background/MainMenuBg.jpg");
	private String options[] = { "START", "EXIT" };

	private int currChoice = 0;

	KeyListener keyListener = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				currChoice--;
				if(currChoice<0) {
					currChoice=1;
				}
				repaint();
				break;
				
			case KeyEvent.VK_RIGHT:
				currChoice++;
				if(currChoice>1) {
					currChoice=0;
				}
				repaint();
				break;

			case KeyEvent.VK_ENTER:
				if(currChoice == 0) {
					Main.frame.remove(MainMenuPanel.this);
					JPanel panel = new GamePanel();
					Main.frame.add(panel);
					panel.requestFocus();
					Main.frame.validate();
				}
				if(currChoice == 1) {
					System.exit(0);
				}
			default:
				break;
			}
		}
	};

	Thread background = new Thread(new Runnable() {

		@Override
		public void run() {
			
		}
	});

	public MainMenuPanel() {
		setLayout(null);
		setBackground(Color.black);
		setFocusable(true);

		title = new JLabel("SUTING SUTING AWW AWW", JLabel.CENTER);
		title.setBounds(220, 20, 460, 50);
		title.setFont(new Font("Prestige Elite Std", Font.BOLD, 35));
		title.setForeground(Color.WHITE);
		add(title);

		addKeyListener(keyListener);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(bg.getImage(), 0, 0, null);
		
		for (int i = 0; i < 2; i++) {
			if (i == currChoice) {
				g.setColor(Color.RED);
				g.setFont(new Font("Kemasyuran Jawa", Font.BOLD, 70));
				g.drawString(options[i], i*450+50, 190);

			} else {
				g.setColor(Color.WHITE);
				g.setFont(new Font("Kemasyuran Jawa", Font.BOLD, 30));
				g.drawString(options[i], i*450+50, 200);
			}
		}

	}
}
