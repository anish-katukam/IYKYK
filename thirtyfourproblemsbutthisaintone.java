import java.util.Random;
import java.util.Arrays;
import java.lang.Math;
import java.time.Clock;
import java.text.NumberFormat;
import java.util.Locale;

public class thirtyfourproblemsbutthisaintone{
	public static void main(String[] args) {
		Random rand = new Random();
		int[] values = new int[20];
		
		float totalRuns = 0;
		float successes = 0;
		float successRate = 0;
		boolean successfulRun = false;
		
		Clock clock = Clock.systemDefaultZone();
		long startTime = clock.millis();
		
		int runCap = 0;
		
		System.out.print("[");
		
		runCap = (int) Math.pow(10, Integer.parseInt(args[0]));

			
			while (totalRuns < runCap){
				totalRuns++;
				
				if (totalRuns % (runCap/100) == 0){
					System.out.print("-");
				}
				
				for (int i = 0; i < values.length; i++){
					values[i] = rand.nextInt(6)+1;
				}
			
				for (int i = 0; i < values.length - 1; i++) {
					if (values[i] == 3 && values[i+1] == 4 && !successfulRun){
						successes++;
						successfulRun = true;
					}
				}
				successfulRun = false;
			}
		
		successRate = successes/totalRuns;
		System.out.print("]");
		System.out.println();
		System.out.println("The probability is now " + successRate + " for " + (NumberFormat.getNumberInstance(Locale.US).format(runCap) + " tests"));
		long endTime = clock.millis();
		double runTime = endTime-startTime;
		System.out.println("Runtime: " + runTime/1000 + " seconds");
	}
	
}