package rocket;

public class MRUA_Accel {

	public static void main(String[] args) {
		
		double accel = 9.81;
		double tick = 0;
		
		while (true) {
			
			try {
			    Thread.sleep(200);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
			tick++;
			
			double time = (tick/5);
			
			//System.out.println("tick=" + tick + " time="+ time + " timeSquare=" + (time*time));
			
			double x = accel/2*(time*time);
			
			//System.out.println((x) + " currentVel ="+ (x/time));
			
			for (int i = 0; i < (int)x; i++) {
				
				if (i < (int)x-1) {
				
					System.out.print("|");
				
				} else {
					
					System.out.println("XX>");
					
				}
				
			}
			
		}

	}

}
