package main;

public class Testarray {

	public static void main(String[] args) {
		int array[] = new int[5];
		array[1] = 1;
		array[2] = 2;
		String arrayString[]= new String[4];
		
		System.out.println(array[1]);
		System.out.println(array[2]);
		System.out.println(array[2]+array[1]);
		
		arrayString[1] = "Test1";
		arrayString[2] = "Test2";
		System.out.println(arrayString[2] + arrayString[1]);

	}

}
