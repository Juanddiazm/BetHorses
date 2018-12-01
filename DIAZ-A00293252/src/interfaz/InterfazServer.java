package interfaz;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.SequenceInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import modelo.WelcomeServerThread;

public class InterfazServer extends JFrame {

	private WelcomeServerThread welcomeServerThread;

	public InterfazServer() {

		setTitle("Servidor");
		setLayout(new BorderLayout());
		JTextArea textArea = new JTextArea();

		add(textArea, BorderLayout.CENTER);
		setSize(200, 200);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// setVisible(true);
		closeBet();
		try {
			welcomeServerThread = new WelcomeServerThread();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public void closeBet() {
		final Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				for (int i = 0; i < welcomeServerThread.getDt().getArrayMoney().length; i++) {
					System.out.println("Caballo numero " + (i + 1) + " ");
					System.out.println(welcomeServerThread.getDt().getArrayMoney()[i]);
				}
				welcomeServerThread.getThreadG().interrupt();
			}
		};
		timer.schedule(task, 60000, 999999999);
	}

	public static void main(String[] args) {
		InterfazServer server = new InterfazServer();

	}
}
