import java.util.*;
public class coinChangePermutation {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int[] coins = new int[n];
	for(int i=0;i<n;i++) {
		coins[i] = sc.nextInt();
	}
	int target = sc.nextInt();
	int[] dp = new int[target+1];
	dp[0] = 1;
	
	for(int amount=1;amount<=target;amount++) {
		for(int coin:coins) {
			if(coin<=amount) {
				int remainingAmount = amount-coin;
				dp[amount] += dp[remainingAmount];
			}
		}
	}
	System.out.println(dp[target]);
}
}
