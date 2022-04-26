package david.elias.act2;

public class Interruptor { // Cada interruptor estara compuesto por una bombilla
	
	Bombilla bombilla;
	
	Interruptor () {
		bombilla = new Bombilla();
	}

	public Bombilla getBombilla() {
		return bombilla;
	}

	public void setBombilla(Bombilla bombilla) {
		this.bombilla = bombilla;
	}
	
	public void toggleBombilla() { // Metodo que cambia el estado de la bombilla on -> off  / off -> on
		
		if (bombilla.isPower()) {
			bombilla.setPower(false);
		} else {
			bombilla.setPower(true);
		}
	}
	
	public String printBombillaStatus() { // devolver estado de la bombilla en String
		if (bombilla.isPower()) {
			return "La bombilla esta encendida";
		} else {
			return "La bombilla esta apagada";
		}
	}

}
