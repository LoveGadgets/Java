/**
 * general Semaphore class provided by professor
 * @author yihong
 *
 */
public final class Semaphore
{
   public Semaphore() {
      value = 0;
   }

   public Semaphore(int v) {
      value = v;
   }

   public synchronized void acquire() {
      while (value <= 0) {
         try {
            wait();
         }
         catch (InterruptedException e) { }
      }

      value --;
   }

   public synchronized void release() {
      ++value;

      notifyAll();
   }

   public synchronized int getValue() {
		return value;
	   }
   private int value;


public synchronized void signal() {
	notify();
 }
}