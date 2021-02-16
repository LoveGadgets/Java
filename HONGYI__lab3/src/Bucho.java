//Daniel Yi Hong
//lab 3
class Bucho extends Manager{
	public Bucho(int age, int quirks) {
		super(age, quirks);
	}
	public int stress() {
		return (unreadEmail>800)?800:(unreadEmail+unreadEmail/2);
		}
	
	public void cope() {
		if (Math.random()>0.5) {
			quirks +=3;
		}
		else
			quirks -=3;	
		//
		String representation = "[Bucho is coping."+ " stress: " 
	              + stress() + ", respect: "+ respect() +"]";
		System.out.println(representation);
		unreadEmail = 0;
	}
		
		

	
}


