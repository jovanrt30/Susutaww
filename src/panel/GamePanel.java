package panel;

import object.*;
import main.*;
import main.Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class GamePanel extends JPanel {
	ImageIcon background = new ImageIcon("Resources/background_medieval.JPG");
	ImageIcon playerA = new ImageIcon("Resources/player_mage_idle.PNG");
	ImageIcon playerB = new ImageIcon("Resources/player_archer_idle.PNG");
	ImageIcon lifeBarMage = new ImageIcon("Resources/lifebarMage.PNG");
	ImageIcon lifeBarArcher = new ImageIcon("Resources/lifebarArcher.PNG");
	
	//Mage colorful
	ImageIcon one = new ImageIcon("Resources/mage1.PNG");
	ImageIcon two = new ImageIcon("Resources/health2.PNG");
	ImageIcon three = new ImageIcon("Resources/def3.PNG");
	ImageIcon four = new ImageIcon("Resources/x2_4.PNG");
		
	//Mage Greyscale
	ImageIcon satu = new ImageIcon("Resources/mage1_dark.PNG");
	ImageIcon dua = new ImageIcon("Resources/health2_dark.PNG");
	ImageIcon tiga = new ImageIcon("Resources/defense3_dark.PNG");
	ImageIcon empat = new ImageIcon("Resources/x2_4_dark.PNG");
		
	//Archer colorful
	ImageIcon oneArcher = new ImageIcon("Resources/archer7.PNG");
	ImageIcon twoArcher = new ImageIcon("Resources/health8.PNG");
	ImageIcon threeArcher = new ImageIcon("Resources/defense9.PNG");
	ImageIcon fourArcher = new ImageIcon("Resources/x2_0.PNG");
		
	//Archer greyscale
	ImageIcon satuArcher = new ImageIcon("Resources/archer7_dark.PNG");
	ImageIcon duaArcher = new ImageIcon("Resources/health8_dark.PNG");
	ImageIcon tigaArcher = new ImageIcon("Resources/defense9_dark.PNG");
	ImageIcon empatArcher = new ImageIcon("Resources/x2_0_dark.PNG");
	
	// for player Mage & archer
	private Player p1 = new Player1();
	Rectangle playerAr = new Rectangle();
	int xA = 0;
	int playerA_Width;
	int playerA_Height;
		
	private Player p2 = new Player2();
	Rectangle playerBr = new Rectangle();
	int xB = 0;
	int playerB_Width;
	int playerB_Height;
	
	//counter turn
	int turnA = 0;
	int turnB = 0;
		
	// for lifeBar Mage & Archer
	Rectangle lifeBarMages = new Rectangle();
	Rectangle lives_a = new Rectangle(58, 60, p1.getHp()*3, 30);
	Rectangle lives_a_avalaible = new Rectangle(58, 60, 300, 30);
	int mageWidth;
	int mageHeight;
	int lifesA = p1.getHp() * 3;// progress HP mage

	Rectangle lifeBarArchers = new Rectangle();
	Rectangle lives_b = new Rectangle(548, 60, p2.getHp()*3, 30);
	Rectangle lives_b_avalaible = new Rectangle(548, 60, 300, 30);
	int archerWidth;
	int archerHeight;
	int lifesB = p2.getHp() * 3; // progress HP archer
	
	// player
	Rectangle PlayerA = new Rectangle(170, 350, 50, 100);
	Rectangle PlayerB = new Rectangle(700, 350, 50, 100);

	// Power Bar
	Rectangle pwrBarA = new Rectangle(100, 300, 0, 20);
	Rectangle pwrBarB = new Rectangle(700, 300, 0, 20);

	// CurveA
	final int sizeCurve = 20;
	Point coorCurveA = new Point(170, 350);
	int axA = 0;
	int ayA = 2;
	int vxA = pwrBarA.width; // setelah dapat power kita ubah si power jadi vx kurva
	int vyA = -30;

	// curveB
	Point coorCurveB = new Point(700, 350);
	int axB = 0;
	int ayB = 2;
	int vxB = pwrBarB.width; // setelah dapat power kita ubah si power jadi vx kurva
	int vyB = -30;
	
	//bola
	Rectangle bola1 = new Rectangle(coorCurveA.x, coorCurveA.y, sizeCurve, sizeCurve);
	Rectangle bola2 = new Rectangle(coorCurveB.x, coorCurveB.y, sizeCurve, sizeCurve);
	
	// boolean start n pause thread pwr
	boolean isPausePA = true;
	boolean isPausePB = true;
	
	//boolean start n pause thread crv
	boolean isPauseCA = true;
	boolean isPauseCB = true;

	// counter ganji genap di keylistener untuk start n pause power bar
	int countPBA = 0;
	int countPBB = 0;
	
	//wind
	int randWind = 0;
	
	private boolean isRunning = true;
	
	public GamePanel() {
//		p1.setHp(hp);
		// player A(kiri)
		playerA_Width = playerA.getIconWidth() / 5;
		playerA_Height = playerA.getIconHeight();

		playerAr.x = 160;
		playerAr.y = 340;
		playerAr.width = playerA_Width;
		playerAr.height = playerA_Height;

		// player B(kanan)
		playerB_Width = playerB.getIconWidth() / 4;
		playerB_Height = playerB.getIconHeight();

		playerBr.x = 670;
		playerBr.y = 370;
		playerBr.width = playerB_Width;
		playerBr.height = playerB_Height;
		
		// life bar Mage(kiri)
		mageWidth = lifeBarMage.getIconWidth();
		mageHeight = lifeBarMage.getIconHeight();
		lifeBarMages.x = 0;
		lifeBarMages.y = -36;
		lifeBarMages.width = mageWidth;
		lifeBarMages.height = mageHeight;

		// life bar archer(kanan)
		archerWidth = lifeBarArcher.getIconWidth();
		archerHeight = lifeBarArcher.getIconHeight();
		lifeBarArchers.x = 510;
		lifeBarArchers.y = -33;
		lifeBarArchers.width = archerWidth;
		lifeBarArchers.height = archerHeight;
		
		setFocusable(true);
		player.start();
		crvA.start();
		crvB.start();
		pwrA.start();
		pwrB.start();
		addKeyListener(keyListener);
	}
	
	int randomWind() {
		randWind = new Random().nextInt(15) - 7;
		return randWind;
	}
	
	void kena() {
		if (coorCurveA.x <= 745 && coorCurveA.y <= 470) {
			if (coorCurveA.x >= 674 && coorCurveA.y >= 370) {
				System.out.println("A kenain B");
				p2.getAttack(p1.getCurrWeapon());
				System.out.println(p1.getCurrWeapon().getName());
				System.out.println(p1.getCurrWeapon().getDamage());
			}
		}
		
		if (coorCurveB.x <= 180 && coorCurveB.y <= 470) {
			if (coorCurveB.x >= 140 && coorCurveB.y >= 350 ) {
				System.out.println("B kenain A");
				p1.getAttack(p2.getCurrWeapon());
				System.out.println(p2.getCurrWeapon().getName());
				System.out.println(p2.getCurrWeapon().getDamage());
			}
		}
	}

	KeyListener keyListener = new KeyListener() {
		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			switch (e.getKeyCode()) {
			case KeyEvent.VK_A:
				if (turnB %2 == 0) {
					turnA++;
					countPBA++;
					if (countPBA > 1) {
						isPausePA = true;
						isPauseCA = false;
						p2.setCurrWeapon(p2.getBasic());
						vxA = pwrBarA.width / 3 + randWind;// custom sendiri untuk vx dari pwr bar (+ 7) si tambah 7 ini sama aja
						// kaya wind yang natinya bisa negatuf atau positif
						pwrBarA.width = 0;
						countPBA = 0;
						System.out.println("Power :" + vxA);
					} else {
						randWind = randomWind();
						isPausePA = false;
						isPauseCA = true;
					}	
				}
				break;
			case KeyEvent.VK_L:
				if (turnA %2 == 0) {
					turnB++;
					countPBB++;
					if (countPBB > 1) {
						isPausePB = true;
						isPauseCB = false;
						countPBB = 0;
						p1.setCurrWeapon(p1.getBasic());
						vxB = pwrBarB.width / 3 + randWind;// custom sendiri untuk vx dari pwr bar (+ 7) si tambah 7 ini sama aja
						// kaya wind yang natinya bisa negatuf atau positif
						pwrBarB.width = 0;
						countPBB = 0;
						System.out.println("Power :" + vxB);
					} else {
						randWind = randomWind();
						isPausePB = false;
						isPauseCB = true;
					}
				}
				break;
			case KeyEvent.VK_1:
				//special weapon1 punya p1
				if(p1.getBomb().isValid()) {
					p1.setCurrWeapon(p1.getBomb());
					System.out.println(p1.getCurrWeapon().getName());
					p1.getBomb().setValid(false);
				}else {
					System.out.println("udah abis goblok");
				}
				break;
			case KeyEvent.VK_2:
				//special weapon2 punya p1
				if(p1.getDoubleAttack().isValid()) {
					p1.setCurrWeapon(p1.getDoubleAttack());
					System.out.println(p1.getCurrWeapon().getName());
					p1.getDoubleAttack().setValid(false);
				}else {
					System.out.println("udah abis goblok");
				}
				break;
			case KeyEvent.VK_3:
				//special item1 punya p1
				if (p1.getBigHealing().isValid()) {
					p1.setHp(p1.getHp() + p1.getBigHealing().getEffect());
					if (p1.getHp() > 100) p1.setHp(100);
					p1.getBigHealing().setValid(false);
				} else {
					System.out.println("udah abis goblok");
				}
				break;
			case KeyEvent.VK_4:
				//special item1 punya p1
				if (p1.getHeal().isValid()) {
					p1.setHp(p1.getHp() + p1.getHeal().getEffect());
					if (p1.getHp() > 100) p1.setHp(100);
					p1.getHeal().setValid(false);
				} else {
					System.out.println("udah abis goblok");
				}
				break;
			case KeyEvent.VK_7:
				//special weapon1 punya p2
				if(p2.getBomb().isValid()) {
					p2.setCurrWeapon(p2.getBomb());
					System.out.println(p2.getCurrWeapon().getName());
					p2.getBomb().setValid(false);
				}else {
					System.out.println("udah abis goblok");
				}
				break;
			case KeyEvent.VK_8:
				//special weapon2 punya p2
				if(p2.getDoubleAttack().isValid()) {
					p2.setCurrWeapon(p2.getDoubleAttack());
					System.out.println(p2.getCurrWeapon().getName());
					p2.getDoubleAttack().setValid(false);
				}else {
					System.out.println("udah abis goblok");
				}
				break;
			case KeyEvent.VK_9:
				//special item1 punya p2
				if (p2.getBigHealing().isValid()) {
					p2.setHp(p2.getHp() + p2.getBigHealing().getEffect());
					if (p2.getHp() > 100) p2.setHp(100);
					p2.getBigHealing().setValid(false);
				} else {
					System.out.println("udah abis goblok");
				}
				break;
			case KeyEvent.VK_0:
				//special item2 punya p2
				if (p2.getHeal().isValid()) {
					p2.setHp(p2.getHp() + p2.getHeal().getEffect());
					if (p2.getHp() > 100) p2.setHp(100);
					p2.getHeal().setValid(false);
				} else {
					System.out.println("udah abis goblok");
				}
				break;
			default:
				break;
			}
			repaint();
		}
	};
	
	Thread player = new Thread(() -> {
		while (isRunning) {
			xA++;
			xA %= 2;

			xB++;
			xB %= 2;
			repaint();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//validasi menang
			if(p1.getHp() <= 0) {
				System.out.println("Archer win");
				Main.frame.remove(GamePanel.this);
				Main.frame.add(new MainMenuPanel());
				Main.frame.validate();
				isRunning=false;
			}else if(p2.getHp() <= 0) {
				System.out.println("Mage win");
				Main.frame.remove(GamePanel.this);
				Main.frame.add(new MainMenuPanel());
				Main.frame.validate();
				isRunning=false;
				
			}
		}
	});

	Thread crvA = new Thread(() -> {// thread untuk si kurva
		while (isRunning) {
			if (isPauseCA != true) {
				coorCurveA.x += vxA;
				coorCurveA.y += vyA;
				vxA += axA;
				vyA += ayA;
				kena();
			} else {
				coorCurveA.x = 170;
				coorCurveA.y = 350;
				axA = 0;
				ayA = 2;
				vxA = 0;
				vyA = -30;
			}

			repaint();

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});

	Thread crvB = new Thread(() -> {// thread untuk si kurva
		while (isRunning) {
			if (isPauseCB != true) {
				coorCurveB.x -= vxB;
				coorCurveB.y += vyB;
				vxB -= axB;
				vyB += ayB;
				kena();
			} else {
				coorCurveB.x = 700;
				coorCurveB.y = 350;
				axB = 0;
				ayB = 2;
				vxB = 0;
				vyB = -30;
			}

			repaint();

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});

	Thread pwrA = new Thread(() -> {// thread untuk si power bar
		while (isRunning) {
			if (!isPausePA) {
				pwrBarA.width += 5;
				pwrBarA.width %= 100;
			}

			repaint();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});

	Thread pwrB = new Thread(() -> {// thread untuk si power bar
		while (isRunning) {
			if (!isPausePB) {
				pwrBarB.width += 5;
				pwrBarB.width %= 100;
			}

			repaint();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, 900, 600);
		
		//background
		g.drawImage(background.getImage(), 0, 0, 900, 600, null);

		// CurveBall
		g.setColor(Color.GREEN);
		g.fillOval(coorCurveA.x, coorCurveA.y, sizeCurve, sizeCurve);
		g.fillOval(coorCurveB.x, coorCurveB.y, sizeCurve, sizeCurve);

		// Power Bar
		g.setColor(Color.BLACK);
		g.fillRect(pwrBarA.x, pwrBarA.y, pwrBarA.width, pwrBarA.height);
		g.fillRect(pwrBarB.x, pwrBarB.y, pwrBarB.width, pwrBarB.height);
		
		// lives
		g.setColor(Color.white);
		g.fillRect(lives_a_avalaible.x, lives_a_avalaible.y, lives_a_avalaible.width, lives_a_avalaible.height);
		g.fillRect(lives_b_avalaible.x, lives_b_avalaible.y, lives_b_avalaible.width, lives_b_avalaible.height);
		g.setColor(Color.red);
		g.fillRect(lives_a.x, lives_a.y, p1.getHp()*3, lives_a.height);
		g.fillRect(lives_b.x, lives_b.y, p2.getHp()*3, lives_b.height);
		g.drawImage(lifeBarMage.getImage(), lifeBarMages.x, lifeBarMages.y, lifeBarMages.x + mageWidth - 500,
				lifeBarMages.y + mageHeight - 350, 0, 0, mageWidth, mageHeight, null);
		g.drawImage(lifeBarArcher.getImage(), lifeBarArchers.x, lifeBarArchers.y, lifeBarArchers.x + archerWidth - 500,
				lifeBarArchers.y + archerHeight - 350, 0, 0, archerWidth, archerHeight, null);
		
		//player
		g.drawImage(playerA.getImage(), playerAr.x, playerAr.y, playerAr.x + playerA_Width, playerAr.y + playerA_Height,
				xA * playerA_Width, 0, (xA * playerA_Width) + playerA_Width, playerA_Height, null);
		g.drawImage(playerB.getImage(), playerBr.x, playerBr.y, playerBr.x + playerB_Width, playerBr.y + playerB_Height, 
				xB * playerB_Width, 0, (xB * playerB_Width) + playerB_Width, playerB_Height, null);
		
		//Mage
		if(p1.getBomb().isValid()==true) {
			g.drawImage(one.getImage(), lives_a.x-10, lives_a.y+20, 100, 100,null);
		} else {
			g.drawImage(satu.getImage(), lives_a.x-10, lives_a.y+20, 100, 100,null);
		}
		
		if (p1.getDoubleAttack().isValid()==true) {
			g.drawImage(four.getImage(), lives_a.x+50, lives_a.y+19, 100, 100,null);			
		} else {
			g.drawImage(empat.getImage(), lives_a.x+50, lives_a.y+19, 100, 100,null);			
		}
		
		if (p1.getHeal().isValid()==true) {			
			g.drawImage(three.getImage(), lives_a.x+175, lives_a.y+21, 100, 100,null);
		} else {
			g.drawImage(tiga.getImage(), lives_a.x+175, lives_a.y+21, 100, 100,null);
		}
		
		if (p1.getBigHealing().isValid()==true) {
			g.drawImage(two.getImage(), lives_a.x+110, lives_a.y+21, 100, 100,null);			
		} else {
			g.drawImage(dua.getImage(), lives_a.x+110, lives_a.y+21, 100, 100,null);			
		}
		
		//Archer
		if (p2.getBomb().isValid()==true) {
			g.drawImage(oneArcher.getImage(), lives_b.x+lifesB-295, lives_b.y+21, 100, 100,null);
		} else {
			g.drawImage(satuArcher.getImage(), lives_b.x+lifesB-295, lives_b.y+21, 100, 100,null);
		}
		
		if (p2.getHeal().isValid()==true) {	//paling ujung kanan
			g.drawImage(threeArcher.getImage(), lives_b.x+lifesB-110, lives_b.y+21, 100, 100,null);
		} else {
			g.drawImage(tigaArcher.getImage(), lives_b.x+lifesB-110, lives_b.y+21, 100, 100,null);
		}
		
		if (p2.getBigHealing().isValid()==true) {//no 2 dari kanan
			g.drawImage(twoArcher.getImage(), lives_b.x+lifesB-173, lives_b.y+21, 100, 100,null);
		} else {
			g.drawImage(duaArcher.getImage(), lives_b.x+lifesB-173, lives_b.y+21, 100, 100,null);
		}
		
		if(p2.getDoubleAttack().isValid()==true) {
			g.drawImage(fourArcher.getImage(), lives_b.x+lifesB-230, lives_b.y+20, 100, 100,null);
		} else {
			g.drawImage(empatArcher.getImage(), lives_b.x+lifesB-230, lives_b.y+20, 100, 100,null);
		}
		
		//random wind
		g.drawString("WIND : " + randWind, 440, 90);
	}

	

}
