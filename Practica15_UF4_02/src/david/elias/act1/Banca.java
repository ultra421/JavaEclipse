package david.elias.act1;
import java.util.Scanner;

public class Banca {
	
	// Esta clase Banca estara compuesta por cuenta, ya que una banca no puede existir sin cuentas en ella
	// Aunque se podria decir lo contrario, entonces Banca agregaria a Cuenta
	
	Cuenta cuenta;
	
	Banca (Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
}
