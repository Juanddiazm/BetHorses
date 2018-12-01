package modelo;

import audioUDP.AudioUDPServer;

public class ThreadAudioServer extends Thread{
	private AudioUDPServer audioUDPServer;

	public ThreadAudioServer(AudioUDPServer audioUDPServer) {
		this.audioUDPServer = audioUDPServer;
	}

	public void run() {
		audioUDPServer.broadcastAudio();
	}
}
