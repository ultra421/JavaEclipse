package rocket;
import java.util.Scanner;
import java.util.Arrays;

public class Rocket {

	public static void main(String[] args) {
		
		int tick = 0;
		String [] field = new String [200];
		double oVel = 0;
		double x = 0;
		
		while (true) {
			
			tick++;
			//double deltaTime = (double)tick / 10;
			double accel = 2.3;
			
			try {
			    Thread.sleep(1000);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
			double pos =  ((accel*0.5)*(tick*tick));
			
			/*System.out.println("Testtickrate = " + tick + " deltaTime= " + deltaTime + " deltatimeSquare =" + (deltaTime*deltaTime) + " accel1/2 = " + (accel*0.5));
			
			System.out.println("Position=" + pos);
			
			for (int i = 0; i < (int)pos; i++ ) {
				
				System.out.print("#");
				
			}*/
			
			System.out.println();
			
			System.out.println("DeltaX = " + (pos-x));
			System.out.println("DeltaV = " + ((pos-x)/tick));
			
			x = pos;

		}

	}

}
