import java.util.*;

public class ComStore {
	private List<Point>points;
	
	public ComStore(LinkedList<Point> linkedPoints) {
		this.points = linkedPoints;
	}
	
	public ComStore(ArrayList<Point> arrayPoints) {
		this.points = arrayPoints;
	}
	
	public void Add(Point obj) {
			points.add(obj);	
		}
		
	public double testAdd0(int index, Point obj) {
		Stopwatch watch = new Stopwatch();
		watch.start();
		for (int i = 0; i< 10000; i++) {
			points.add(0,obj);	
		}
		watch.stop();
		double time = watch.timeLnMilliseconds();
		return time;
	}
	public double testGet() {
		Stopwatch watch = new Stopwatch();
		watch.start();
		for (int i = 0; i< 10000; i++) {
			points.get(i);	
		}
//		Point point = points.get(index);
//		System.out.println(point.sum());
		watch.stop();
		double time = watch.timeLnMilliseconds();
		return time;
		}	
	
	
}
