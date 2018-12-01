package modelo;

import java.net.*;

import java.util.Calendar;
import java.io.*;

public class ThreadWelcomeServer extends Thread {
	Socket client;
	BufferedReader readerHS;
	PrintWriter writerHS;
	Calendar calendar;
	String arraySpeeds;

	public ThreadWelcomeServer(Socket request, Calendar calendar, String arraySpeeds2) {
		client = request;
		this.calendar = calendar;
		this.arraySpeeds = arraySpeeds2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run() Pay attention that the next method "run" has
	 * the business logic of the server
	 */
	public void run() {
		try {
			readerHS = new BufferedReader(new InputStreamReader(client.getInputStream()));
			writerHS = new PrintWriter(client.getOutputStream(), true);

			// The next code lines are going to get the name and host from the
			// user
			int numeroCaballo = Integer.parseInt(readerHS.readLine());
			double cantidadApuesta = Double.parseDouble(readerHS.readLine());

			WelcomeServerThread.getDt().addMoneyBet(numeroCaballo, cantidadApuesta);

			String message = (String) calendar.getTime().toString();
			writerHS.println(message+"&&"+arraySpeeds);
			
			 
			
			

			
			// we are going to close the streams and the socket associated to
			// the request
			readerHS.close();
			writerHS.close();
			// client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
