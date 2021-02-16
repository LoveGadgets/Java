//Daniel Yi Hong, lab1
import java.util.Arrays;

public class Main {
	public static int[] evenOdd(int[] nums) {
		  int left = 0;
		  int right = nums.length - 1;
		  while (left < right){
		    if (nums[left] %2 == 0){
		      left ++;
		    } else if (nums[right] % 2 == 1){
		      right --;
		    } else {
		      int temp = nums[left];
		      nums[left] = nums[right];
		      nums[right] = temp;
		    }
		  }
		  return nums;
		}
	
	
	public static int addRag(int[][] nums) {
		int total = 0;
		for (int i = 0; i<nums.length; i++)
			for (int j = 0; j<nums[i].length;j++)
				total+= nums[i][j];
		return total;
	}
	
	public static int Collatz(int nums) {
		while (nums != 1) {
			if (nums % 2 == 0) {
				nums /= 2;
			}
			else if (nums % 2 == 1) {
				nums = (nums * 3) + 1;
			}
		}
		return nums;
	}
	public static boolean mutual(int[][] matrix, int user) {
		boolean mutual = false;
		int follow = 0;
		int followed = 0;
		for (int i=0; i<matrix[user].length; i++)
			if (matrix[user][i]==1) {
				follow +=1;
				if (matrix[i][user]==1) {
					followed +=1;
				}
			}
		if (follow == followed)
			mutual = true;
		return mutual;	
	}
		
	public static int followSame(int[][] matrix, int userA, int userB) {
		int common = 0;
		for (int i=0; i<matrix[userA].length; i++) {
			if (matrix[userA][i]==matrix[userB][i])
				common +=1;
		}
		return common;
	}
	 public static int [][]  randArr(int x) {
		  
		  int[][] A = new int[x][];
		  
		   for (int i = 0; i < x; i++) {
			  //A[i] = new int[(int)(Math.random()*10)];
			   A[i] = new int[0];
		  }
		   
		  return A; 
		  
 
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int[] test1 = {1,1,1,1,0};
		evenOdd(test1);
		System.out.println(Arrays.toString(test1));
		int[][] A = {{1}, {2,3,4},{5,6,7,8},{9,10}};
		System.out.println(addRag (A));
		int N = 55;
		System.out.println (Collatz (N));
		int[][] B = {{0,1,0,0,1},{1,0,1,1,1},{0,0,0,0,0},{0,0,1,0,0},{1,0,0,1,0}};
		if (mutual(B,0))
		System.out.println("true");
		if (!mutual(B,0))
		System.out.println("false");
		int userA = 0;
		int userB = 1;
		System.out.println(followSame(B,userA, userB));
		
		int[][]array = randArr(3);
		System.out.println(Arrays.deepToString(array));

	}

}
