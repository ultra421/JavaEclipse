package main;

public class Actividad01 {

	public static void main(String[] args) {
		int num = 1;
		System.out.print(num + " ");
		
		while (num != 23) {
			num += 4;
			System.out.print(num + " ");
			
			if (num != 23) {
			num -= 2;
			System.out.print(num + " ");
			}
		}
	}

}
