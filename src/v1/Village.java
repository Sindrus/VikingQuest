package v1;

public class Village implements grensesnitt.Bosetning{
private int gull, soldater, mat;

	public void Village() {
		soldater = (int) (51*(Math.random()));
		gull = (int) (soldater/4);
		mat = (int) (soldater/2);
	}

	public int getSoldater() {
		return soldater;
	}

	public int getMat() {
		return mat;
	}

	public int getGull() {
		return gull;
	}

}
