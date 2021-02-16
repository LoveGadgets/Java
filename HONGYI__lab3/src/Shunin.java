//Daniel Yi Hong
//lab 3
class Shunin extends Manager{
	public Shunin(int age, int quirks) {
		super(age, quirks);
		}
	public int respect() {
		int respect = age + quirks;
		if (respect <0)
			respect = 0;
		return respect;
	}
	public void cope() {
		//System.out.println(unreadEmail);
		String representation = "[Shunin is coping."+ " stress: " 
	              + stress() + ", respect: "+ respect() +"]";
		System.out.println(representation);
		quirks += 10;
		}	
}
