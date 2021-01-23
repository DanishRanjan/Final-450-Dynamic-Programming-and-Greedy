import java.util.*;

public class minCostMazeTraversal {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int[][] originalArray = new int[row][col];
		for (int i = 0; i < originalArray.length; i++) {
			for (int j = 0; j < originalArray[0].length; j++) {
				originalArray[i][j] = sc.nextInt();
			}
		}

		int[][] dp = new int[row][col];

		for (int i = dp.length - 1; i >= 0; i--) {
			for (int j = dp[0].length - 1; j >= 0; j--) {
				if (i == dp.length - 1 && j == dp[0].length - 1) {
					dp[i][j] = originalArray[i][j];
				} 
				else if (i == dp.length - 1)    //Row is at it extreme, means column changes
				{
					dp[i][j] = dp[i][j + 1] + originalArray[i][j];
				}
				else if (j == dp[0].length - 1)   //Column is at it extreme, means row changes
				{
					dp[i][j] = dp[i + 1][j] + originalArray[i][j];
				}
				else
				{
					dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + originalArray[i][j];
				}
			}
		}
		System.out.println(dp[0][0]);
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