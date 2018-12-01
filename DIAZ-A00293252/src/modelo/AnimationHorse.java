package modelo;

public class AnimationHorse {
	public final static int WAIT_BY_DEFAULT = 150;
	public final static int SPEED_BY_DEFAULT = 100;
	private String ImageFolder;
	private String ImageThisHorse;
	private int numberImages;
	private int positionX;
	private int speed;
	private int positionY;
	private int wait;
	private int numberImageNow;
	private boolean isMoving;

	/**
	 * @param imageFolder
	 * @param numberImages
	 * @param positionX
	 * @param positionY
	 */
	public AnimationHorse(String imageFolder, int numberImages, int positionX, int positionY) {
		ImageFolder = imageFolder;
		this.numberImages = numberImages;
		this.positionX = positionX;
		this.positionY = positionY;
		wait = WAIT_BY_DEFAULT;
		speed = SPEED_BY_DEFAULT;
		numberImageNow = 0;
		isMoving = true;
	}

	

	public void move() {
		numberImageNow++;
		if (numberImageNow >= numberImages) {
			numberImageNow = 1;
		}
	}

	public String getRouteImageNow() {
		String numImageFormat = null;
		if(numberImageNow>9){
			numImageFormat = "_"+numberImageNow;
		}else
			numImageFormat = "_0"+numberImageNow;
		
		return ImageFolder + "/" + numImageFormat + ".png";
	}

	public void shift() {
		positionX++;
		if (positionX > 1211) {
			//positionX = 1210;
		}
	}
	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	/**
	 * @return the imageFolder
	 */
	public String getImageFolder() {
		return ImageFolder;
	}

	/**
	 * @param imageFolder
	 *            the imageFolder to set
	 */
	public void setImageFolder(String imageFolder) {
		ImageFolder = imageFolder;
	}

	/**
	 * @return the numberImages
	 */
	public int getNumberImages() {
		return numberImages;
	}

	/**
	 * @param numberImages
	 *            the numberImages to set
	 */
	public void setNumberImages(int numberImages) {
		this.numberImages = numberImages;
	}

	/**
	 * @return the positionX
	 */
	public int getPositionX() {
		return positionX;
	}

	/**
	 * @param positionX
	 *            the positionX to set
	 */
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	/**
	 * @return the positionY
	 */
	public int getPositionY() {
		return positionY;
	}

	/**
	 * @param positionY
	 *            the positionY to set
	 */
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	/**
	 * @return the wait
	 */
	public int getWait() {
		return wait;
	}

	/**
	 * @param wait
	 *            the wait to set
	 */
	public void setWait(int wait) {
		this.wait = wait;
	}

	/**
	 * @return the numberImageNow
	 */
	public int getNumberImageNow() {
		return numberImageNow;
	}

	/**
	 * @param numberImageNow
	 *            the numberImageNow to set
	 */
	public void setNumberImageNow(int numberImageNow) {
		this.numberImageNow = numberImageNow;
	}

	/**
	 * @return the isMoving
	 */
	public boolean isMoving() {
		return isMoving;
	}

	/**
	 * @param isMoving
	 *            the isMoving to set
	 */
	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

	public String getImageThisHorse() {
		return ImageThisHorse;
	}

	public void setImageThisHorse(String imageThisHorse) {
		ImageThisHorse = imageThisHorse;
	}

}
