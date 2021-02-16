//Daniel Yi Hong
//lab 3
public class Main {
		public static void main (String[] args){

			Bucho yuko = new Bucho(56, 2);
			Kacho mrHiro = new Kacho (62, 4);
			Shunin toshiro = new Shunin (34, 10);
				   	
			Manager [ ] JAPCo = {yuko, mrHiro, toshiro};
					
			for (int k = 0; k<10;k++){
				System.out.println(  "\n===========  Day " + k );
				
		            int mail = k*2 + 6;
						
				for ( Manager m  : JAPCo){
				      	m.getMail( mail);
					}
				}
		}

		
		
	}


