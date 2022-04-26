package math;

import java.util.Scanner;

public class mathTrigo {

	public static void main(String[] args) {

		System.out.println("Triangulo : introduce la base y el cateto opuesto");
		
		Scanner input = new Scanner(System.in);
		
		float a = input.nextFloat();
		float b = input.nextFloat();
		
		System.out.println("La hipotenusa es : " + Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2)));
		
		double hipo = Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2));
		
		System.out.println("Angulo sin = " + Math.toDegrees(Math.asin(Math.sin(b/hipo))));
		System.out.println("Angulo cos = " + Math.toDegrees(Math.acos(Math.sin(a/hipo))));
		System.out.println("Angulo tan = " + Math.toDegrees(Math.atan(Math.tan(b/a))));
		
		

	}

}
