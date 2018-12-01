package modelo;

public class ThreadMusic extends Thread {

	private Music music;

	public ThreadMusic(Music music) {
		this.music = music;
	}
	
	public void run() {
		music.startMusic();
	}
}
