package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

public class ThreadLisenServer extends Thread {
	WelcomeClient wClient;
	Calendar timeServer;

	public ThreadLisenServer(WelcomeClient client, Calendar cal) {
		this.wClient = client;
		this.timeServer = cal;
	}

	public void run() {
		boolean x = true;
		while (x) {
			if (timeServer.compareTo(Calendar.getInstance()) < 0) {
				wClient.stopBet();
				x = false;
			}
		}

	}
}
