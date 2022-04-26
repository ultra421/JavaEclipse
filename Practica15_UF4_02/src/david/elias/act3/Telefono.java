package david.elias.act3;
import java.util.Random;

public class Telefono {

	int numero;
	int caracteres;
	int saldo;
	
	Telefono () { // Si telefono no recibe nada se genera un numero aleatorio de 8 digitos
		saldo = 20;
		caracteres = 10;
		numero = numberGenerator(8);
	}
	
	Telefono (int numero) {
		this.numero = numero;
		caracteres = 10;
		saldo = 20;
	}
	
	int numberGenerator(int cantidad) {
		
		Random rng = new Random();
		
		String totalNum = "";
		
		for (int i = 0; i < cantidad; i++) {
			
			totalNum += rng.nextInt(10);
			
		}
		
		return Integer.parseInt(totalNum);
		
	}
	
	boolean checkLongitudMsg (String mensaje) { // compruba la  longitud
		if (mensaje.length() <= 10) {
		 	return true;
		} else {
			return false;
		}
	}
	
	boolean sendMensaje(String mensaje) { // envia true si se cumplen condiciones, TODO: imprimir mensaje fuera del metodo
		
		if (checkLongitudMsg(mensaje) && saldo > 5) {
			return true;
		} else if (saldo < 5) {
			System.out.println("No tienes suficiente saldo, saldo actual:" + saldo);
			return false;
		} else {
			System.out.println("No tienes sufcientes caracteres, caracteres actuales: " + caracteres + "\n El mensaje tenia " + mensaje.length() + " caracteres");
			return false;
		}
	}
	
	public int getCaracteres() {
		return caracteres;
	}

	public void setCaracteres(int caracteres) {
		this.caracteres = caracteres;
	}
	
	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String toString () { // deuvelve el numero con los caracteres y el saldo
		return "Numero: " + numero + " Caracteres: " + caracteres + " saldo: " + saldo;
	}
	
}
