package modelo;

public class Data {
	private double[] arrayMoney = new double[6];

	public void addMoneyBet(int numCaballo, double dineroApuesta) {
		arrayMoney[numCaballo - 1] = arrayMoney[numCaballo - 1] + dineroApuesta;
	}

	/**
	 * @return the arrayMoney
	 */
	public double[] getArrayMoney() {
		return arrayMoney;
	}

	/**
	 * @param arrayMoney the arrayMoney to set
	 */
	public void setArrayMoney(double[] arrayMoney) {
		this.arrayMoney = arrayMoney;
	}

	
}
