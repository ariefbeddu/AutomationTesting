package qaautomation.saucedemo;

public class Utility {
	public static void hardWait(int seconds) {
		try {
			Thread.sleep(1000 * seconds);	
		}catch (InterruptedException e) {
		e.printStackTrace();
		}
	} 
}
