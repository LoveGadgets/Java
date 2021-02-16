package rats;
/**
 * This Rat subclass which can be used to move around a Maze faster than random rat
 * @author Daniel Yi Hong
 */
import java.util.Random;
public class SmartRat extends Rat{
	public SmartRat(){
		super();
		/**
		 * constructor that specifies Name and Letter
		 */
		mName="Daniel";
		mLetter='D';
	}
	//public double rate = 0;
	/**
	 * Move Method that determines the next move for the Rat. It will prevent rat go back to the
	 * previous move unless if there is wall present/
	 * move randomly on very first step. start from second step, if the next moves contain a step
	 * that is identical to last step and there is more than 1 possible moves(meaning not in a 
	 * 3-directions wall situation), then delete that step.
	 * @param maz Maze the Rat is currently exploring
	 */
	public void move(Maze maz) {
		/**generate all possible next moves*/
		LookForPossibleMoves(maz);
		/**size of the moves */
		int size =mPossibleMoves.size();
		//System.out.println(size);
		if (mAllMoves.size() == 0) {
			EnactMove(mPossibleMoves.get((int)(Math.random()*mPossibleMoves.size())));
		}
		else {
			for (int i=0; i < size; i++) {
				if (mAllMoves.get(mAllMoves.size()-1).equals(mPossibleMoves.get(i)) &&
						size >1) {
					mPossibleMoves.remove(i);
				    //System.out.println(mPossibleMoves.get(i));
				    size--;
			     }
			}
			/*for (int i=0; i <= mPossibleMoves.size(); i++) {
				System.out.println(mPossibleMoves.get(i).toString());
			}}*/ 		
		//System.out.println(size);
			/**
			 * create random index, so rat can move in any of the remainder direction
			 */
			Random randomNumber = new Random();
			int randomIndex = randomNumber.nextInt(size);
			EnactMove(mPossibleMoves.get(randomIndex));
		//System.out.println(mPossibleMoves.get((int)(Math.random()*mPossibleMoves.size())));
	}
}
}
