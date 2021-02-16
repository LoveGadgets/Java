//Daniel Yi Hong
//lab 3
abstract public class Manager {
	public int unreadEmail;
	public int age;
	public int quirks;
	Boolean unhappy = false; 

	//constructor
	public Manager(int age, int quirks) {
		unreadEmail = 0;
		this.age = age;
		this.quirks = quirks;	
	}
	
	public Manager() {
		unreadEmail = 0;
		this.age = 0;
		this.quirks = 0;	
	}
	
	
	public void getMail(int newEmail) {
		unreadEmail += newEmail;
		double random = Math.random();
		//System.out.println(random);
		if (random >0.8) {
			if (Math.random()>0.5) {
				quirks +=2;
			}
			else
				quirks -=2;	
		}
	
		if (stress() > respect()) {
			System.out.println("Manager is COPING");
			cope();
		}
	
	}
	public int stress() {
		return (unreadEmail>500)?500:unreadEmail;
	}
	public int respect() {
		int respect = age - quirks;
		if (respect <0)
			respect = 0;
		return respect;
	}
	
	abstract void cope();
	
}
