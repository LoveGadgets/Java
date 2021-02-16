
public class Stopwatch {
	private long startTime;
	private long stopTime;
	
	private static final double MILLIS_PER_SEC = 1000;
	
	public void start() {
		System.gc();
		startTime = System.currentTimeMillis();
	}
	
	public void stop() {
		stopTime = System.currentTimeMillis();
	}
	
	public double time() {
		return (stopTime - startTime)/MILLIS_PER_SEC;
	}
	
	public String toString() {
		return "elapsed time: " +time() +"seconds.";
	}
	public long timeLnMilliseconds() {
		return(stopTime - startTime);
	}
}
