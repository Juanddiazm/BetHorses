package modelo;

import java.io.*;
import java.net.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.net.ssl.SSLSocketFactory;

import audioUDP.AudioUDPClient;
import interfaz.InterfazClient;

public class WelcomeClient {
	public static final String TRUSTTORE_LOCATION = "C:/Program Files/Java/jdk1.8.0_161/bin/keystore.jks";
	// private static final String SONG = ""
	// Socket del cliente
	private Music music;
	private Socket client;
	private ThreadAudioClient threadAudioClient;
	private ThreadMusic threadMusic;
	private Calendar timeServer;
	private Race raceW;
	InterfazClient interfazClient;
	private AudioUDPClient audioClient;
	// Lector
	BufferedReader readerC;

	// Escritor
	PrintWriter writerC;
	String answer, host;
	int port;
	Scanner scanner = new Scanner(System.in);
	ThreadLisenServer lisenServer;

	public WelcomeClient(InterfazClient interfazClient) {
		this.interfazClient = interfazClient;
		audioClient = new AudioUDPClient();
		threadAudioClient = new ThreadAudioClient(audioClient);
		music = new Music();
		threadMusic = new ThreadMusic(music);
		raceW = Race.getSingletonInstance();

	}

	public void establishConnection() throws UnknownHostException, IOException {
		System.setProperty("javax.net.ssl.trustStore", TRUSTTORE_LOCATION);
		SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();

		setClient(sf.createSocket("localhost", 8070));
		readerC = new BufferedReader(new InputStreamReader(getClient().getInputStream()));

		writerC = new PrintWriter(getClient().getOutputStream(), true);

		// we are going to get the user name and his host
		host = getClient().getLocalAddress().getHostName();
		port = getClient().getLocalPort();

	}

	public void makeBet(String numHorse, String money) throws InterruptedException {

		try {
			establishConnection();

			writerC.println(numHorse);
			writerC.println(money);

			answer = readerC.readLine();
			System.out.println(answer);
			String[] data = answer.split("&&");
			String[] timeAux = data[0].split(" ");
			String[] date = timeAux[3].split(":");
			int month = 0;

			switch (timeAux[1]) {
			case "Jan":
				month = 0;
				break;
			case "Feb":
				month = 1;
				break;
			case "Mar":
				month = 2;
				break;
			case "Apr":
				month = 3;
				break;
			case "May":
				month = 4;
				break;
			case "Jun":
				month = 5;
				break;
			case "Jul":
				month = 6;
				break;
			case "Aug":
				month = 7;
				break;
			case "Sep":
				month = 8;
				break;
			case "Oct":
				month = 9;
				break;
			case "Nov":
				month = 10;
				break;
			case "Dec":
				month = 11;
				break;
			default:
				break;
			}
			Calendar timeServer = Calendar.getInstance();
			timeServer.set(Integer.parseInt(timeAux[5]), month, Integer.parseInt(timeAux[2]), Integer.parseInt(date[0]),
					Integer.parseInt(date[1]), Integer.parseInt(date[2]));

			System.out.println((String) timeServer.getTime().toString());

			Calendar forThread = timeServer;
			forThread.add(Calendar.MINUTE, 1);
			String minusSpeeds = data[1];
			int[] arraySpeeds = new int[6];
			String[] arratSpeedStr = minusSpeeds.split(",");
			for (int i = 0; i < 6; i++) {
				arraySpeeds[i] = Integer.parseInt(arratSpeedStr[i]);
			}
			raceW.defineMovementSpeed(arraySpeeds);
			lisenServer = new ThreadLisenServer(this, forThread);
			lisenServer.start();
			// readerC.close();
			writerC.close();
			client.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void stopBet() {
		threadAudioClient.start();
		threadMusic.start();
		// audioClient.playAudio();
		interfazClient.disableButBet();
		interfazClient.startTheads();

	}

	/**
	 * @return the race
	 */
	public Race getRace() {
		return raceW;
	}

	/**
	 * @param race
	 *            the race to set
	 */
	public void setRace(Race race) {
		this.raceW = race;
	}

	public Socket getClient() {
		return client;
	}

	public void setClient(Socket client) {
		this.client = client;
	}
}