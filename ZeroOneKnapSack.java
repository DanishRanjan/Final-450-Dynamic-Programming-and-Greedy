import java.util.*;

public class ZeroOneKnapSack {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int[] vals = new int[n];
	int[] wts = new int[n];
	for(int i=0;i<n;i++) {
		vals[i] = sc.nextInt();
	}
	for(int j=0;j<n;j++) {
		wts[j] = sc.nextInt();
	}
	int capacity = sc.nextInt();
	int[][] dp = new int[n+1][capacity+1];
	
	for(int i=1;i<dp.length;i++) {
		for(int j=1;j<dp[0].length;j++) {
			if(j>=wts[i-1])    // only applicable if weights are highers
			{
				int remainingCapacity = j-wts[i-1];   // value of vals if i doesnt bat
				
				if(dp[i-1][remainingCapacity]+vals[i-1]>dp[i-1][j])   // if the value of (i bat ,left over ball value ) is greater than    
				{                                                     // when i didn't bat
					dp[i][j] = dp[i-1][remainingCapacity]+vals[i-1];
				}
				
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
			else{
				dp[i][j] = dp[i-1][j]; 	// if weights are  smaller then , values previously waali hi attach ho jaynegi
			}
		}
	}
	System.out.println(dp[vals.length][capacity]);
}
}
