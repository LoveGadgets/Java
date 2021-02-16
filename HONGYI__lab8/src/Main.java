import java.util.concurrent.*;
import java.util.*;


public class Main {
	public static void main(String args[]) throws InterruptedException{
		
		Semaphore sem = new Semaphore(1);
		Threads T1 = new Threads(sem, "T1");
		Threads T2 = new Threads(sem, "T2");
		Threads T3 = new Threads(sem, "T3");	
		T1.start();
		T2.start();
		T3.start();
		
		T1.join();
		T1.join();
		T3.join();
		
		// part 2
		Book book1 = new Book("a",5);
		Book book2 = new Book("b",4);
		Book book3 = new Book("c",3);
		Book book4 = new Book("d",2);
		Book book5 = new Book("e",1);
		Book[] books = {book2,book3,book1,book4,book5};

		Arrays.sort(books,Comparator.comparing(Book::getName)); 
		//Arrays.sort
	    for (Book p: books)
	        System.out.println(p.getName());
	    Arrays.sort(books,Comparator.comparing(Book::getPrice)); 
	    for (Book p: books)
	        System.out.println(p.getPrice());
	    
	    //part 3
	    Runnable task1 = () -> { for (int i= 0; i<4; i++)
	    	System.out.println("Hello I am JDan "+i); };
	    Runnable task2 = () -> { for (int i= 0; i<4; i++)
	    	System.out.println("Hello I am Joey "+i); };
	    Runnable task3 = () -> { for (int i= 0; i<4; i++)
	    		System.out.println("Hello I am Mike "+i); };
	    Runnable task4 = () -> { for (int i= 0; i<4; i++)
	    			System.out.println("Hello I am Jen "+i); };
	    Runnable task5 = () -> { for (int i= 0; i<4; i++)
	    				System.out.println("Hello I am tony "+i); };
	    Runnable[]run = {task1,task2,task3,task4,task5};
	    
	    executor(run);
	    

	
}		
		public static void executor(Runnable[] run) {
			for (Runnable r: run) {
				Thread thread = new Thread(r);
				thread.start();
				
			}
	
}
	
}
