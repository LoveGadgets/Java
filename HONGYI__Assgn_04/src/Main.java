
public class Main {
	static public void main( String[] args ){
		boolean [][] precedences = { { false,   true,  false,  false,  false,  false },
	               { false,  false,   true,  true, false ,  false  },
	               { false,  false,  false,  true,  false,  true   },
	               { false,  false,  false,  false,  false,  false },
	               { false,  false,  false,  true,  false,  true   },
	               { false,  false,  false,  false,  false,  false }
                };
		//other test precedences, worked
//		boolean [][] precedences = { { false,   true,  false,  false,  false,  false },
//        { false,  false,   true,  true, false ,  false  },
//        { false,  false,  false,  true,  false,  true   },
//        { false,  false,  false,  false,  false,  false },
//        { false,  false,  false,  true,  false,  true   },
//        { false,  false,  false,  true,  false,  false }
//     };

		Runnable task0 = ()->{System.out.println("Cutting vegetables");};
		Runnable task1 = ()->{System.out.println("Add oil to a pan");};
		Runnable task3 = ()->{System.out.println("Stir fry vegetable");};
		Runnable task2 = ()->{System.out.println("Prepare chicken");};
		Runnable task4 = ()->{System.out.println("Add flavor");};
		Runnable task5 = ()->{System.out.println("Stir fry chiken");};
		
		Runnable []  tasks = {task0, task1, task2, task3, task4, task5};

     // construct an Executor
		Executor  quicheMaker = new Executor (precedences, tasks);

     // run it
		quicheMaker.run();
	}
}

