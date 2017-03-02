package src;
import java.text.DecimalFormat;

public class Time {
	private long startTime; // Stores TimeStarted

	public Time() {
		startTime = System.nanoTime();
	}

	public void ToggleTimer() {
		startTime = System.nanoTime();
	}

	public String parseTime() { // Parse current time
		String result;
		final double seconds = ((double) this.getTime() / 1000000000);
		result = new DecimalFormat("#.###").format(seconds) + " Seconds";
		return result;
	}

	public static String parseTime(long a) { // Parse any integer
		String result;
		final double seconds = ((double) a / 1000000000);
		result = new DecimalFormat("#.###").format(seconds) + " Seconds";
		return result;
	}

	public long getTime() {
		return System.nanoTime() - startTime;
	}
}
