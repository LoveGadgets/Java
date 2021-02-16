package rats;
//import java.util.Collections;
/**
 * This Rat subclass which can be used to move around a Maze a bit faster than smart rat
 * @author Daniel Yi Hong
 */
import java.util.Random;
public class GeniusRat extends Rat{
	/**
	 * constructor that specifies Name and Letter
	 */
	public GeniusRat(){
		super();
		mName="Daniel";
		mLetter='D';
	}
	/**
	 * Move Method that determines the next move for the Rat. It will prevent rat go back to the
	 * previous move unless if there is wall present/
	 * move randomly on very first step. start from second step, if the next moves contain a step
	 * that is identical to last step and there is more than 1 possible moves(meaning not in a 
	 * 3-directions wall situation), then delete that step.
	 * on top of smart rat, this rat also search the memory from all previous moves, if one of the 
	 * next moves is contained in the memory and there are more than 3 moves(the more idealized 
	 * solution would be set it to great than 1 moves, but it will prevent rat move out of corners,
	 * this would require higher level of programming skill to solve), then deleted the move.
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
				//int count=Collections.frequency(mAllMoves, mPossibleMoves.get(i));
				if (mAllMoves.get(mAllMoves.size()-1).equals(mPossibleMoves.get(i)) &&
						size > 1 || (mAllMoves.contains(mPossibleMoves.get(i)) &&
						size >3)) {
					mPossibleMoves.remove(i);
				    //System.out.println(mPossibleMoves.get(i));
				    size--;
			     }
			}
		}	
		/**
		 * create random index, so rat can move in any of the remainder direction
		 */
			Random randomNumber = new Random();
			int randomIndex = randomNumber.nextInt(size);
			EnactMove(mPossibleMoves.get(randomIndex));
		//System.out.println(mPossibleMoves.get((int)(Math.random()*mPossibleMoves.size())));
	}

}


