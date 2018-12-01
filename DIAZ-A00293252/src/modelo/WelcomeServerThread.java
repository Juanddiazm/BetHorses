package modelo;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Calendar;

import javax.net.ssl.SSLServerSocketFactory;

import audioUDP.AudioUDPServer;

public class WelcomeServerThread {
	private ThreadAudioServer threadAudioServer;
	private AudioUDPServer audioServer;
	private Calendar calendario = Calendar.getInstance();
	private String Speeds;
	private static boolean running = true;
	private static Data dt = new Data();
	private static ThreadGroup threadG = new ThreadGroup("hilos");
	private static ArrayList<Socket> listClients = new ArrayList<Socket>();

	public static final String KEYSTORE_LOCATION = "C:/Program Files/Java/jdk1.8.0_161/bin/keystore.jks";
	public static final String KEYSTORE_PASSWORD = "password";

	public WelcomeServerThread() throws IOException {

		System.setProperty("javax.net.ssl.keyStore", KEYSTORE_LOCATION);
		System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASSWORD);
		SSLServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
		ServerSocket server = ssf.createServerSocket(8070);
		audioServer = new AudioUDPServer();
		threadAudioServer = new ThreadAudioServer(audioServer);
		threadAudioServer.start();
		defineMovementSpeed();
		listenConections(server);

	}

	public void defineMovementSpeed() {
		int numberSpeed = 0;
		int[] arraySpeeds = new int[6];

		for (int i = 0; i < 6; i++) {
			numberSpeed = (int) Math.floor(Math.random() * 90 + 1);
			arraySpeeds[i] = numberSpeed;
		}
		Speeds = "" + arraySpeeds[0] + "," + arraySpeeds[1] + "," + arraySpeeds[2] + "," + arraySpeeds[3] + ","
				+ arraySpeeds[4] + "," + arraySpeeds[5];
	}

	public void listenConections(ServerSocket server) throws IOException {
		while (isRunning()) {
			Socket c = server.accept();
			ThreadWelcomeServer th = new ThreadWelcomeServer(c, calendario, Speeds);
			Thread thread = new Thread(getThreadG(), th);

			listClients.add(c);
			th.start();
		}
	}

	public static Data getDt() {
		return dt;
	}

	public static void setDt(Data dt) {
		WelcomeServerThread.dt = dt;
	}

	public static ThreadGroup getThreadG() {
		return threadG;
	}

	public static void setThreadG(ThreadGroup threadG) {
		WelcomeServerThread.threadG = threadG;
	}

	public static boolean isRunning() {
		return running;
	}

	public static void setRunning(boolean running) {
		WelcomeServerThread.running = running;
	}

	/**
	 * @return the listClients
	 */
	public static ArrayList<Socket> getListClients() {
		return listClients;
	}

	/**
	 * @param listClients
	 *            the listClients to set
	 */
	public static void setListClients(ArrayList<Socket> listClients) {
		WelcomeServerThread.listClients = listClients;
	}

	public Calendar getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendar calendario) {
		this.calendario = calendario;
	}

}
