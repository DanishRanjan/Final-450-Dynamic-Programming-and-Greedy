import java.util.*;

public class unboundedKnapsack {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] vals = new int[n];
		for (int i = 0; i < n; i++) {
			vals[i] = sc.nextInt();
		}
		int weights[] = new int[n];
		for (int i = 0; i < n; i++) {
			weights[i] = sc.nextInt();
		}
		int Capacity = sc.nextInt();

		int[] dp = new int[Capacity + 1];
		dp[0] = 0;
		
		for (int bagCapacity = 1; bagCapacity <= Capacity; bagCapacity++) {
			int max = 0;
			for(int i=0;i<weights.length;i++) {
				if(weights[i]<=bagCapacity) {
					int RemainingBagCapacity = bagCapacity-weights[i];
					int RemainingBagCapacityValue = dp[RemainingBagCapacity];
					int totalBagValue = RemainingBagCapacityValue + vals[i];
					
					if(totalBagValue>max) {
						max = totalBagValue;
					}
				}
				dp[bagCapacity] = max;
			}
		}
		System.out.println(dp[Capacity]);
	}
}
