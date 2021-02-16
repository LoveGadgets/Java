import java.util.*;

public class Main {
	public static void main(String[] args) {
		ArrayList<Point> array = new ArrayList<>();
		ComStore arrayPoints = new ComStore(array);
		Point apoint = new Point(10.3333,20.99999);
		double time1 = arrayPoints.testAdd0(0, apoint);	
		System.out.println("arraylist add :"+time1+" millisecond");
		double time2 = arrayPoints.testGet();
		System.out.println("arraylist get :"+time2+" millisecond");
		
		LinkedList<Point> linkedlist = new LinkedList<>();
		ComStore linkedPoints = new ComStore(linkedlist);
		double time3 = linkedPoints.testAdd0(0, apoint);	
		System.out.println("linkedlist add :"+time3+" millisecond");
		double time4 = linkedPoints.testGet();
		System.out.println("linkedlist get :"+time4+" millisecond");
	}
	
}
