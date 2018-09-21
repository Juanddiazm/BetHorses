
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class cliente {

	public static void main(String[] args) throws IOException {
		// nombre del DNS del servidor
		String serverName = "whois.internic.net";

		InetAddress addressServer = null;
		try {
			//addressServer = InetAddress.getByName(serverName);

			Socket socket = new Socket("localHost", 8000);
			InputStream input = socket.getInputStream();
			InputStreamReader inpReader = new InputStreamReader(input);
			BufferedReader escucha = new BufferedReader(inpReader);

			OutputStream outPut = socket.getOutputStream();
			OutputStreamWriter outWriter = new OutputStreamWriter(outPut);
			BufferedWriter escritor = new BufferedWriter(outWriter);

			escritor.write("Puto el que lo lea");
			escritor.flush();
//			int c;
//			while ((c = escucha.read()) != -1) {
//				System.out.write(c);
//			}

			escritor.close();
			escucha.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
