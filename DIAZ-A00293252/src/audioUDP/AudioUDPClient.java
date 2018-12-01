package audioUDP;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class AudioUDPClient {
	AudioInputStream audioInputStream;
	SourceDataLine sourceDataLine;

	public AudioUDPClient() {
		//initiateAudio();
	}

	public void initiateAudio() {
		try {
			MulticastSocket multicastSocket = new MulticastSocket(9794);
			InetAddress inetAddress = InetAddress.getByName("228.5.6.7");
			multicastSocket.joinGroup(inetAddress);
			
			byte[] audioBuffer = new byte[10000];
			while (true) {
				DatagramPacket packet = new DatagramPacket(audioBuffer, audioBuffer.length);
				multicastSocket.receive(packet);
				try {
					byte audioData[] = packet.getData();
					InputStream byteInputStream = new ByteArrayInputStream(audioData);
					AudioFormat audioFormat = getAudioFormat();
					audioInputStream = new AudioInputStream(byteInputStream, audioFormat,
							audioData.length / audioFormat.getFrameSize());
					DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
					sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
					sourceDataLine.open(audioFormat);
					sourceDataLine.start();
					playAudio();
				} catch (Exception e) {
					// Handle exceptions
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private AudioFormat getAudioFormat() {
		float sampleRate = 16000F;
		int sampleSizeInBits = 16;
		int channels = 1;
		boolean signed = true;
		boolean bigEndian = false;
		return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
	}

	public void playAudio() {
		byte[] buffer = new byte[10000];
		try {
			int count;
			while ((count = audioInputStream.read(buffer, 0, buffer.length)) != -1) {
				if (count > 0) {
					sourceDataLine.write(buffer, 0, count);
				}
			}
		} catch (Exception e) {
			// Handle exceptions
		}
	}

//	public static void main(String[] args) {
//		new AudioUDPClient();
//	}
}