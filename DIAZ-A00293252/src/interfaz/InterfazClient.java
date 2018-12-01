package interfaz;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.WelcomeClient;

public class InterfazClient extends JFrame {

	private WelcomeClient welcomeClient;
	private PanelBet panelBet;
	private PanelRace panelRace;

	private static ThreadMoveAnimationHorse threadMoveAnimationHorse1;
	private static ThreadMoveAnimationHorse threadMoveAnimationHorse2;
	private static ThreadMoveAnimationHorse threadMoveAnimationHorse3;
	private static ThreadMoveAnimationHorse threadMoveAnimationHorse4;
	private static ThreadMoveAnimationHorse threadMoveAnimationHorse5;
	private static ThreadMoveAnimationHorse threadMoveAnimationHorse6;

	/**
	 * @param welcomeClient
	 * @throws HeadlessException
	 */
	public InterfazClient() throws HeadlessException {
		setTitle("Horses races");
		this.welcomeClient = new WelcomeClient(this);
		setLayout(new BorderLayout());
		panelBet = new PanelBet(this);
		add(panelBet, BorderLayout.NORTH);

		panelRace = PanelRace.singlentonPanelRace(welcomeClient.getRace().getAnimationHorse1(),
				welcomeClient.getRace().getAnimationHorse2(), welcomeClient.getRace().getAnimationHorse3(),
				welcomeClient.getRace().getAnimationHorse4(), welcomeClient.getRace().getAnimationHorse5(),
				welcomeClient.getRace().getAnimationHorse6());

		add(panelRace, BorderLayout.CENTER);
		setSize(600, 600);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void writeBDUser(String registration) {
		FileWriter fileBDUsers = null;
		PrintWriter pw = null;
		try {
			fileBDUsers = new FileWriter("BD.txt", true);
			pw = new PrintWriter(fileBDUsers);
			pw.println(registration);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fileBDUsers)
					fileBDUsers.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void findBDUser(String registration) {

		File fileBDUsers = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fileBDUsers = new File("BD.txt");
			fr = new FileReader(fileBDUsers);
			br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null) {
				String[] contLine = new String[2];
				contLine = line.split("|");

				String[] contRegis = new String[2];
				contRegis = registration.split("|");

				if (contLine[0].equals(contRegis[0])) {
					  throw new Exception("The user is already registered");
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void checkBDUser(String registration) {
		File fileBDUsers = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fileBDUsers = new File("BD.txt");
			fr = new FileReader(fileBDUsers);
			br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null) {
				String[] contLine = new String[2];
				contLine = line.split("|");

				String[] contRegis = new String[2];
				contRegis = registration.split("|");

				if (!(contLine[0].equals(contRegis[0]) && contLine[1].equals(contRegis[1] ))) {
					throw new Exception("Username does not exist");
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	public void makeBet(String numHorse, String money) {
		try {
			welcomeClient.makeBet(numHorse, money);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void updateAnimationHorses() {
		repaint();
		
	}

	public void startTheads() {

		if (panelRace.isFirstTime()) {
			if (threadMoveAnimationHorse1 == null) {
				threadMoveAnimationHorse1 = new ThreadMoveAnimationHorse(welcomeClient.getRace().getAnimationHorse1(),
						this);
				threadMoveAnimationHorse2 = new ThreadMoveAnimationHorse(welcomeClient.getRace().getAnimationHorse2(),
						this);
				threadMoveAnimationHorse3 = new ThreadMoveAnimationHorse(welcomeClient.getRace().getAnimationHorse3(),
						this);
				threadMoveAnimationHorse4 = new ThreadMoveAnimationHorse(welcomeClient.getRace().getAnimationHorse4(),
						this);
				threadMoveAnimationHorse5 = new ThreadMoveAnimationHorse(welcomeClient.getRace().getAnimationHorse5(),
						this);
				threadMoveAnimationHorse6 = new ThreadMoveAnimationHorse(welcomeClient.getRace().getAnimationHorse6(),
						this);

				threadMoveAnimationHorse1.start();
				threadMoveAnimationHorse2.start();
				threadMoveAnimationHorse3.start();
				threadMoveAnimationHorse4.start();
				threadMoveAnimationHorse5.start();
				threadMoveAnimationHorse6.start();
			}
			panelRace.setFirstTime(false);
		}
	}

	public void disableButBet() {
		panelBet.disableButBet();
	}

	public static void main(String[] args) {

		InterfazClient window = new InterfazClient();
		window.setVisible(true);
		// window.startTheads();

	}

}
