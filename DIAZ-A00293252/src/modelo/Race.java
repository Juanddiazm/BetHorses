package modelo;

public class Race {
	static Race race;
	private final static int CHANGE_VELOCITY = 2;
	private static AnimationHorse animationHorse1;
	private static AnimationHorse animationHorse2;
	private static AnimationHorse animationHorse3;
	private static AnimationHorse animationHorse4;
	private static AnimationHorse animationHorse5;
	private static AnimationHorse animationHorse6;

	private Race() {
		animationHorse1 = new AnimationHorse("Animation/Horse1", 13, 20, 20);
		animationHorse2 = new AnimationHorse("Animation/Horse2", 13, 20, 80);
		animationHorse3 = new AnimationHorse("Animation/Horse3", 13, 20, 140);
		animationHorse4 = new AnimationHorse("Animation/Horse4", 13, 20, 200);
		animationHorse5 = new AnimationHorse("Animation/Horse5", 13, 20, 260);
		animationHorse6 = new AnimationHorse("Animation/Horse6", 13, 20, 320);
	}

	public static Race getSingletonInstance() {
		if (race == null) {
			race = new Race();

		}
		return race;
	}

	public static void defineMovementSpeed(int[] arraySpeeds) {
		int speedNow1 = animationHorse1.getSpeed();
		speedNow1 -= arraySpeeds[0];
		animationHorse1.setSpeed(speedNow1);

		int speedNow2 = animationHorse2.getSpeed();
		speedNow2 -= arraySpeeds[1];
		animationHorse2.setSpeed(speedNow2);

		int speedNow3 = animationHorse3.getSpeed();
		speedNow3 -= arraySpeeds[2];
		animationHorse3.setSpeed(speedNow3);

		int speedNow4 = animationHorse4.getSpeed();
		speedNow4 -= arraySpeeds[3];
		animationHorse4.setSpeed(speedNow4);

		int speedNow5 = animationHorse5.getSpeed();
		speedNow5 -= arraySpeeds[4];
		animationHorse5.setSpeed(speedNow5);

		int speedNow6 = animationHorse6.getSpeed();
		speedNow6 -= arraySpeeds[5];
		animationHorse6.setSpeed(speedNow6);

	}

	/**
	 * @return the animationHorse1
	 */
	public AnimationHorse getAnimationHorse1() {
		return animationHorse1;
	}

	/**
	 * @param animationHorse1
	 *            the animationHorse1 to set
	 */
	public void setAnimationHorse1(AnimationHorse animationHorse1) {
		this.animationHorse1 = animationHorse1;
	}

	/**
	 * @return the animationHorse2
	 */
	public AnimationHorse getAnimationHorse2() {
		return animationHorse2;
	}

	/**
	 * @param animationHorse2
	 *            the animationHorse2 to set
	 */
	public void setAnimationHorse2(AnimationHorse animationHorse2) {
		this.animationHorse2 = animationHorse2;
	}

	/**
	 * @return the animationHorse3
	 */
	public AnimationHorse getAnimationHorse3() {
		return animationHorse3;
	}

	/**
	 * @param animationHorse3
	 *            the animationHorse3 to set
	 */
	public void setAnimationHorse3(AnimationHorse animationHorse3) {
		this.animationHorse3 = animationHorse3;
	}

	/**
	 * @return the animationHorse4
	 */
	public AnimationHorse getAnimationHorse4() {
		return animationHorse4;
	}

	/**
	 * @param animationHorse4
	 *            the animationHorse4 to set
	 */
	public void setAnimationHorse4(AnimationHorse animationHorse4) {
		this.animationHorse4 = animationHorse4;
	}

	/**
	 * @return the animationHorse5
	 */
	public AnimationHorse getAnimationHorse5() {
		return animationHorse5;
	}

	/**
	 * @param animationHorse5
	 *            the animationHorse5 to set
	 */
	public void setAnimationHorse5(AnimationHorse animationHorse5) {
		this.animationHorse5 = animationHorse5;
	}

	/**
	 * @return the animationHorse6
	 */
	public AnimationHorse getAnimationHorse6() {
		return animationHorse6;
	}

	/**
	 * @param animationHorse6
	 *            the animationHorse6 to set
	 */
	public void setAnimationHorse6(AnimationHorse animationHorse6) {
		this.animationHorse6 = animationHorse6;
	}
}
