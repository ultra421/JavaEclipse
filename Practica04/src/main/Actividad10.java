package main;

public class Actividad10 {

	public static void main(String[] args) {
		
		int num = 5; int vueltas = 10; 
		
		for (int i = vueltas; i >= 2; i--) {
			
			num = num * 5;
			
		} System.out.println(num);
		
		num = 5;
		int vueltasDo = vueltas;
		
		//////////////////////////////////////
		
		do {
			
			num = num*5;
			vueltasDo--;
		
		} while (vueltasDo != 1);
		System.out.println(num);
		
		
		///////////////////////////////////////
		
		num = 5;
		int vueltasWhile = vueltas;
		
		while (vueltasWhile != 1) {
			
			num = num*5;
			vueltasWhile--;
			
		} System.out.println(num);
	}

}
