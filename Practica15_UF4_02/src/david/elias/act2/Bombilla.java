package david.elias.act2;

public class Bombilla { // La bombilla tendra variable boolean para si encendida o no
	
	boolean power;
	
	Bombilla () {
		this.power = false;
	}
	
	Bombilla (boolean power) {
		this.power = power;
	}

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

}
