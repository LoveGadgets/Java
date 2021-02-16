import java.util.Random;
//import java.util.concurrent.*;
/**
 * This class will construct a double array that contains objects of semaphore. Those objects were created
 * based on the true conditions from the precedences double array. And the semaphore objects will be pass
 * into Task inner class. 
 * @author yihong
 *
 */
public class Executor{
	/**
	 * doble array that contain Semaphore objects. 
	 */
	public Semaphore [][] semas;
	//public boolean [][] precedences;
	/**
	 * array that holds runnable objects, which represent different tasks
	 */
	public Runnable[] tasks;
	/**
	 * constructor to create semaphore objects based on the double array of precedences, by loop through
	 * double array and find all the true value, and create semaphore objects on the according array
	 * location
	 *  @param tasks array of runnable tasks
	 *  @param precedences double array that represent precedences
	 */
	public Executor(boolean[][] precedences, Runnable[] tasks) {
		this.tasks = tasks;
		/**
		 * the size of double array is depending on how many tasks
		 */
		semas = new Semaphore[tasks.length][tasks.length];
		
		for (int row=0; row < precedences.length; row++) {
			for (int col = 0; col < precedences[row].length; col++) {
				if (precedences[row][col] == true ) {
					semas[row][col] = new Semaphore(0);
				}
				else {
					semas[row][col] = null;
				}
			}
		}
	}
	/**
	 * Runnable objects that created with Task class will be constructed with an integer, which represent 
	 * the number of each specific task. Based on this number, the Task objects will then get the 
     * semaphore objects for wait (from column) and signal (from row)
	 * @author yihong
	 *
	 */
	private class Task implements Runnable{
		/**
		 * represent the task number
		 */
		private int num;
		/**
		 * constructor
		 * @param num represent the task number
		 */
		private Task(int num) {
			this.num=num;
		}
		/**
		 * thread that run this task will wait for all the preceding threads, its done by the 
		 * acquire() methods from semaphore objects. After finish this task, the tasks that are
		 * waiting for this tasks to be done will be notified, and start execution. 
		 */
		public void run() {
			for (int row = 0; row<semas.length; row++) {
				//look at column of this task
					if (semas[row][num] != null) {				
						//System.out.println("acquire"+ row+" "+num);
						semas[row][num].acquire();	
					}
				}		
			System.out.println("TASK:"+num+ " started");
			tasks[num].run();
			
				for (int col=0; col<semas[num].length; col++) {
					if (semas[num][col] != null) {
						//System.out.println("release"+ num+" "+col);
						semas[num][col].release();
					}
				}	
				System.out.println("-->TASK:"+num+ "finished");
		}
}
	/**
	 * create new tasks and assign a thread to it and start, each thread will sleep for a random mili
	 * second. 
	 */
	public void run() {
		for (int i=0; i<tasks.length;i++) {
			/**
			 * create new task
			 */
			Task task = new Task(i);
			/**
			 * create new thread
			 */
			Thread thread = new Thread(task);
			thread.start();
			Random rndNumber= new Random();		
			try {
				Thread.sleep(rndNumber.nextInt(500));
				//Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
	}
}
			
			

