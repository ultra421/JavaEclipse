package main;

public class Actividad5 {

	public static void main(String[] args) {
		
		int var1 = 3;   // 3 -> 4
		int var2 = 4;   // 4 -> 1
		int var3 = 1;   // 1 -> 3
		int varMemoria; // Memoria
		
		varMemoria = var1;
		var1 = var2;
		var2 = var3;
		var3 = varMemoria;
		
		System.out.print("Var 1 es = " + var1 + " | Var 2 es = " + var2 + " | Var 3 es = " + var3);
		
	}

}
