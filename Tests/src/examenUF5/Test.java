package examenUF5;

public class Test {

	public static void main(String[] args) {
		
		int array [] = new int[2];
		
		try {
			System.out.println(array[3]);
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}

	}

}
