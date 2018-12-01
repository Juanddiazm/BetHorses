package modelo;

import audioUDP.AudioUDPClient;

public class ThreadAudioClient extends Thread {

	AudioUDPClient audioUDPClient;

	public ThreadAudioClient(AudioUDPClient audioUDPClient) {
		this.audioUDPClient = audioUDPClient;
	}

	public void run() {
		audioUDPClient.initiateAudio();
	}
}
