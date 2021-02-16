//Daniel Yi Hong
//lab 3
class Kacho extends Manager{
	public Kacho(int age, int quirks) {
		super(age, quirks);
		}
	
	public void cope() {
		//System.out.println(unreadEmail);
		String representation = "[Kacho is coping."+ " stress: " 
	              + stress() + ", respect: "+ respect() +"]";
		System.out.println(representation);
		unreadEmail = unreadEmail/2;
		}	
}
