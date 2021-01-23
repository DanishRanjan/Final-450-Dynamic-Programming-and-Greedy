import java.util.*;

public class goldMine {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int[][] arr = new int[row][col];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int[][] dp = new int[row][col];
		for(int j=arr[0].length-1;j>=0;j--) {
			for(int i=0;i<arr.length;i++) {
				if(j==arr[0].length-1)      //print as it is in last column
				{
					dp[i][j] = arr[i][j];
				}
				else if(i==0)       //two check point in top row, right and downward diagonally right
				{
					dp[i][j] = arr[i][j]+ Math.max(dp[i][j+1], dp[i+1][j+1]);
				}
				else if(i==arr.length-1)       //two check point in bottom row, right and upward diagonally right
				{
					dp[i][j] = arr[i][j]+ Math.max(dp[i][j+1], dp[i-1][j+1]);
				}
				else {             //three check, right , diagonally up, diagonally down
					dp[i][j] = arr[i][j]+ Math.max(dp[i][j+1], Math.max(dp[i-1][j+1], dp[i+1][j+1]) );
				}
			}
		}
		
		int max = dp[0][0];                            //now we are finding the maximum number in dp array in first column,
		for(int i=0;i<dp.length;i++) {                 // so that we can find , which path gives us more gold
			if(dp[i][0]>max) {
				max = dp[i][0];
			}
		}

		System.out.println(max);
}
}


//6
//6
//0 1 4 2 8 2
//4 3 6 5 0 4
//1 2 4 1 4 6
//2 0 7 3 2 2
//3 1 5 9 2 4
//2 7 0 8 5 1
