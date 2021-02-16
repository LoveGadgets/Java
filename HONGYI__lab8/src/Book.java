
public class Book {
    public String name;
    public double price;
	public Book(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
//	Comparator sortingByName = new Comparator() {
//		   @Override
//		   public int compare(Student s1, Student s2) {
//			return s1.getName().compareTo(s2.getName());
//		   }
		
}
