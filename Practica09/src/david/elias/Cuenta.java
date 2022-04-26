package david.elias;

import java.util.Scanner;

public class Cuenta {

	int numeroCuenta;
	float saldo;
	String nombre;

	public Cuenta(String nombre, int numero, float saldo) {

		this.numeroCuenta = numero;
		this.saldo = saldo;
		this.nombre = nombre;

	}
	
	public Cuenta() {
		
		saldo = 10000;
		nombre = "antonio";
		numeroCuenta = 37;
		
	}

	public int getNumeroCuenta() {

		return this.numeroCuenta;

	}

	public float getSaldo() {

		return this.saldo;

	}

	public String getTitular() {

		return this.nombre;

	}

	public void setSaldo(float saldo) {

		this.saldo = saldo;

	}

	public void setTitular(String nombre) {

		this.nombre = nombre;

	}
	
	public void ingresar(float cantidad) {
		
		this.saldo += cantidad;
		
	}
	
	public void retirar (float cantidad) {
		
		this.saldo -= cantidad;
		
	}
	
	public void transferencia (float cantidad, Cuenta enviar) {
		
		this.retirar(cantidad);
		enviar.ingresar(cantidad);
		
	}

	public static void main(String[] args) {

		int id = 0;
		String nombre = "";
		float saldo;
		
		Scanner scan = new Scanner(System.in);
		
		//Guardo las cuentas en una array para poder añadir mas cuentas. Aunque la practica solo pida 2, es para practicar.
		//Esto hace que tenga que recorrer la array para encontrar el nombre de la cuenta.
		
		Cuenta cuentas[] = new Cuenta[2];
		Cuenta cuenta;

		for (int i = 0; i < 2; i++) {
			
			System.out.println("Introduce el nombre del Titular de la cuenta con id: " + (i+1) + "\nIntroduce tambien el salario");

			cuentas[i] = new Cuenta(scan.next(), i + 1, scan.nextFloat());

		}

		while (true) {

			System.out.println(
					"Escoge una opcion: \n 1: Consultar saldo   2: Ingresar dinero \n 3: Sacar dinero      4: Realizar transferencia");

			switch (scan.nextInt()) {

			case 1:

				System.out.println("Que cuenta quieres consultar?");
				nombre = scan.next();
				
				for (int i = 0; i < cuentas.length; i++) {
					
					if (cuentas[i].getTitular().equals(nombre)) {
						
						cuenta = cuentas[i];
						
						System.out.println("La cuenta con el nombre " + nombre + " tiene la id: " + (i+1)  + " y contiene " + cuenta.getSaldo() + "€");
						
						break;
						
					} else if (i == cuentas.length-1) {
						
						System.out.println("Cuenta no encontrada!");
						
					}
					
				}

				break;
				
			case 2:

				System.out.println("A que cuenta quieres ingresarle dinero?");
				
				nombre = scan.next();
				
				for (int i = 0; i < cuentas.length; i++) {
					
					if (cuentas[i].getTitular().equals(nombre)) {
						
						cuenta = cuentas[i];
						
						System.out.println("La cuenta con el nombre " + nombre + " contiene " + cuenta.getSaldo() + "€ \nCuanto dinero quieres ingresar?" );
						
						cuenta.ingresar(scan.nextFloat());
						
						System.out.println("Ingresado con exito. La cuenta con el nombre " + nombre + " contiene " + cuenta.getSaldo() + "€");
						
						break;
						
					} else if ( i == cuentas.length-1) {
						
						System.out.println("Cuenta no encontrada!");
						
					} 
					
				}

				break;
				
			case 3:

				System.out.println("A que cuenta quieres sacarle dinero?");
				
				nombre = scan.next();
				
				for (int i = 0; i < cuentas.length; i++) {
					
					if (cuentas[i].getTitular().equals(nombre)) {
						
						cuenta = cuentas[i];
						
						System.out.println("La cuenta con el nombre " + nombre + " contiene " + cuenta.getSaldo() + "€ \nCuanto dinero quieres sacar?" );
						
						cuenta.retirar(scan.nextFloat());
						
						System.out.println("Retirado con exito. La cuenta con el nombre " + nombre + " contiene " + cuenta.getSaldo() + "€");
						
						break;
						
					} else if ( i == cuentas.length-1) {
						
						System.out.println("Cuenta no encontrada!");
						
					} 
					
				}
				
				break;
				
			case 4:

				System.out.println("Que cuenta inicia la transferencia?");
				
				nombre = scan.next();
				
				for (int i = 0; i < cuentas.length; i++) {
					
					if (cuentas[i].getTitular().equals(nombre)) {
						
						cuenta = cuentas[i];
						
						System.out.println("La cuenta con el nombre " + nombre + " contiene " + cuenta.getSaldo() + "€ \nA que cuenta quieres transferir?" );
						
						nombre = scan.next();
						
						for (int k = 0; k < cuentas.length; k++) {
							
							if (cuentas[k].getTitular().equals(nombre)) {
								
								System.out.println("La cuenta con el nombre " + cuentas[k].getTitular() + " contiene " + cuentas[k].getSaldo() + "€" );
						
								System.out.println("Cuanto quieres transferir?");
								
								cuenta.transferencia(scan.nextFloat(), cuentas[k]);
								
								System.out.println("La cuenta con el nombre " + cuenta.getTitular() + " contiene " + cuenta.getSaldo() + "€" );
								System.out.println("La cuenta con el nombre " + cuentas[k].getTitular() + " contiene " + cuentas[k].getSaldo() + "€" );
								
								break;
								
							} else if ( i == cuentas.length-1) {
								
								System.out.println("Cuenta no encontrada!");
								
							} 
							
						}
						
						break;
						
					} else if ( i == cuentas.length-1) {
						
						System.out.println("Cuenta no encontrada!");
						
					} 
					
				}

			}

		}

	}

}
