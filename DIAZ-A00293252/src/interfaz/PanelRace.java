package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modelo.AnimationHorse;

public class PanelRace extends JPanel implements MouseListener {

	static PanelRace panelRace;
	private static boolean firstTime;
	private AnimationHorse animationHorse1;
	private AnimationHorse animationHorse2;
	private AnimationHorse animationHorse3;
	private AnimationHorse animationHorse4;
	private AnimationHorse animationHorse5;
	private AnimationHorse animationHorse6;

	private PanelRace(AnimationHorse animationHorse1, AnimationHorse animationHorse2, AnimationHorse animationHorse3,
			AnimationHorse animationHorse4, AnimationHorse animationHorse5, AnimationHorse animationHorse6) {
		this.animationHorse1 = animationHorse1;
		this.animationHorse2 = animationHorse2;
		this.animationHorse3 = animationHorse3;
		this.animationHorse4 = animationHorse4;
		this.animationHorse5 = animationHorse5;
		this.animationHorse6 = animationHorse6;
		firstTime = true;
		setLayout(new BorderLayout());
		TitledBorder borde = BorderFactory.createTitledBorder("Pelicula");
		setBorder(borde);
		setBackground(new Color(99, 1, 0));
		addMouseListener(this);
	}

	public static PanelRace singlentonPanelRace(AnimationHorse animationHorse1, AnimationHorse animationHorse2,
			AnimationHorse animationHorse3, AnimationHorse animationHorse4, AnimationHorse animationHorse5,
			AnimationHorse animationHorse6) {

		if (panelRace == null) {
			panelRace = new PanelRace(animationHorse1, animationHorse2, animationHorse3, animationHorse4,
					animationHorse5, animationHorse6);
		}

		return panelRace;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		String icon1 = animationHorse1.getRouteImageNow();
		String icon2 = animationHorse2.getRouteImageNow();
		String icon3 = animationHorse3.getRouteImageNow();
		String icon4 = animationHorse4.getRouteImageNow();
		String icon5 = animationHorse5.getRouteImageNow();
		String icon6 = animationHorse6.getRouteImageNow();
		g2.setColor(Color.WHITE);
		g2.drawLine(1208, 30, 1208, 421);
		g2.drawImage(new ImageIcon(icon1).getImage(), animationHorse1.getPositionX(), animationHorse1.getPositionY(),
				this);
		g2.drawImage(new ImageIcon(icon2).getImage(), animationHorse2.getPositionX(), animationHorse2.getPositionY(),
				this);
		g2.drawImage(new ImageIcon(icon3).getImage(), animationHorse3.getPositionX(), animationHorse3.getPositionY(),
				this);
		g2.drawImage(new ImageIcon(icon4).getImage(), animationHorse4.getPositionX(), animationHorse4.getPositionY(),
				this);
		g2.drawImage(new ImageIcon(icon5).getImage(), animationHorse5.getPositionX(), animationHorse5.getPositionY(),
				this);
		g2.drawImage(new ImageIcon(icon6).getImage(), animationHorse6.getPositionX(), animationHorse6.getPositionY(),
				this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.print(e.getX() + " " + e.getY() + " ");

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public static boolean isFirstTime() {
		return firstTime;
	}

	public static void setFirstTime(boolean firstTime) {
		PanelRace.firstTime = firstTime;
	}

}
