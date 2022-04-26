package davidEliasUF2;
import java.util.Scanner;

public class testCaja {

	public static void main(String[] args) {
		
		float a [] = {2.4f,2.2f,3.4f};
		int b [] = {3,4,2};
		
		CajaRegistradora caja = new CajaRegistradora(b,a);
		
		System.out.println(caja.devolverPrecioTotal());

	}

}
