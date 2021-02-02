import java.util.*;

public class TilingWith2into1Tiles {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] dp = new int[n + 1];

		dp[0] = 0; // 2 cross 0 ko tile up karne k zero tarike h
		dp[1] = 1; // 2 cross 1 ko tile up karne k ek tarike h
		dp[2] = 2; // 2 cross 2 ko tile up karne k two tarike h
		
		
		
//------------------------FIBONACCI-------------------FIBONACCI-----------------------fibonacci--------------------	
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2]; // ek waale tarike + do waale tarike will give teen waale tarike and so on
		} // Recursion

		
		
		
		System.out.println(dp[n]);
	}
}
