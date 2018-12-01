package interfaz;

import modelo.AnimationHorse;

public class ThreadMoveAnimationHorse extends Thread {
	AnimationHorse animationHorse;
	InterfazClient interfazClient;
	int positionHorse;

	public ThreadMoveAnimationHorse(AnimationHorse animationHorse, InterfazClient interfazClient) {
		this.animationHorse = animationHorse;
		this.interfazClient = interfazClient;
		positionHorse = 0;
	}

	public void run() {
		while (positionHorse < 1211) {

			try {
				sleep(animationHorse.getSpeed());
				animationHorse.move();
				animationHorse.shift();
				interfazClient.updateAnimationHorses();
				positionHorse = animationHorse.getPositionX();
				if (positionHorse >= 1211) {
					animationHorse.setNumberImageNow(0);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
