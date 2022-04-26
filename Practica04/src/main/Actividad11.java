package main;

import mist.P4;

public class Actividad11 {

	public static void main(String[] args) {
		
		String secuencia = "72 111 108 97 33 32 69 115 116 97 105 115 32 97 32 112 117 110 116 111 32 100 101 32 114 101 115 111 108 118 101 114 32 117 110 32 101 110 105 103 109 97 46 32 68 101 98 101 105 115 32 104 97 99 101 114 32 101 115 116 111 32 115 105 110 32 97 121 117 100 97 32 100 101 108 32 114 101 115 116 111 32 100 101 32 99 111 109 112 97 110 121 101 114 111 115 46 32 76 108 97 109 97 100 32 97 32 80 52 46 97 102 80 48 40 41 32 100 101 108 32 106 97 114 32 113 117 101 32 104 97 98 101 1032 99 111 110 102 105 103 117 114 97 100 111 46";
		
		String secuenciaSolucion = traducir(secuencia);
		
		System.out.println(secuenciaSolucion);
		
		System.out.println(P4.afP0());
		
		System.out.println(P4.Fibonacci());
		
		secuenciaSolucion = traducir(P4.Fibonacci());
		
		System.out.println(secuenciaSolucion);
		
		System.out.println(P4.af19());
		
		System.out.println(traducir(P4.af19()));
		
		System.out.println(P4.af11());
		
		System.out.println(traducir(P4.af11()));
		
		System.out.println(P4.af6(8,1,9,1));
		
		System.out.println(traducir(P4.af6(8,1,9,1)));
		
		System.out.println(P4.af15());
		
		System.out.println(traducir(P4.af15()));
		
		// A mano = 74 65 86 65 77 79 76 65
		
		System.out.println(traducir("74 65 86 65 77 79 76 65"));
		
		System.out.println(P4.afSol("JAVAMOLA"));
		
		
				
	} // Lamar al metodo?  1 1 2 3 5 8 13 21 34 55 89 144 // 233 377 610 987 1597 2584	
	
	public static String traducir(String x) {
		String secuenciaDecode = "";
		StringBuilder builder = new StringBuilder();
		String secuenciaSplit[] = x.split(" ");
		int secuenciaSplitInt[] = new int [200];
		
		/*String split separa cada uno de los numeros en una variable array string, esa array paso las strings 
		 *a otra array de ints, al final convierto los ints a char y los guardo en secuenciaDecode */
		
		for (int i = secuenciaSplit.length; i != 0; i--) {
			
			secuenciaSplitInt[secuenciaSplit.length - i] = Integer.parseInt(secuenciaSplit[secuenciaSplit.length - i]);
			secuenciaDecode += String.valueOf((char)secuenciaSplitInt[secuenciaSplit.length - i]);
		} return secuenciaDecode;
	}
} 
