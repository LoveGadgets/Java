import java.util.concurrent.*;
import java.util.*;
public class Threads extends Thread{
	Semaphore sem;
	String threadName;
	public static int count;
	
	public Threads(Semaphore sem, String threadName) {
		super(threadName);
		this.sem = sem;
		this.threadName = threadName;
	}

	public void run() {
		if (threadName.equals("T1")) {
			try {
				sem.acquire(1);
				System.out.println("Thread <" + threadName + "> STARTING");
				Random rndNumber= new Random();
				Thread.sleep(rndNumber.nextInt(100));
			}
			catch (InterruptedException exc) {
				System.out.println(exc);
			}
			System.out.println("Thread <" + threadName + "> ENDED");
			sem.release(2);
		}
		
		else if (threadName.equals("T2")) {
			try {
				sem.acquire(2);
				System.out.println("Thread <" + threadName + "> STARTING");
				Random rndNumber= new Random();
				Thread.sleep(rndNumber.nextInt(100));
			}
			catch (InterruptedException exc) {
			}
			System.out.println("Thread <" + threadName + "> ENDED");
			sem.release(3);
		}
		else  {
				try {
					sem.acquire(2);
				}
				catch (InterruptedException exc) {
				}
				//if receive 3 permit, that means its from T2, continue
				if (sem.availablePermits()==1) {
					//sem.release(2);
					System.out.println("Thread <" + threadName + "> STARTING");
					Random rndNumber= new Random();
					try {
						Thread.sleep(rndNumber.nextInt(100));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Thread <" + threadName + "> ENDED");
					//sem.release(2);
					}
				//if not receive 3 permit then its from T1, get permit to T2, then 
				//wait for T2 to finish and release 3 permit. 
				else {
						sem.release(2);
						try {
							//if (sem.availablePermits()==3) {
							sem.acquire(3);
						}
						catch (InterruptedException exc) {
						}
						System.out.println("Thread <" + threadName + "> STARTING");
						Random rndNumber= new Random();
						try {
							Thread.sleep(rndNumber.nextInt(100));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Thread <" + threadName + "> ENDED");
					}
				}

			}
	
	
	
}
