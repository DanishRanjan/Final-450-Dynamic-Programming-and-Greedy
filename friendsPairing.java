import java.util.*;

public class friendsPairing {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
//------------------ cuz (n-1) give one answer and alse everyone will give same count so we have multiplied with (n-1)-----
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2]*(i-1);
		}
		System.out.println(dp[n]);
		
	}
}
