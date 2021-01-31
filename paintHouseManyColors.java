import java.util.*;
public class paintHouseManyColors {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	int building = sc.nextInt();
	int color = sc.nextInt();
	int[][] arr = new int[building][color];
	for(int i=0;i<building;i++) {
		for(int j=0;j<color;j++) {
			arr[i][j] = sc.nextInt();
		}
	}
	
	int[][] dp = new int[arr.length][arr[0].length];
	
	for(int j=0;j<arr[0].length;j++) {
		dp[0][j] = arr[0][j]; 
	}
	
	for(int i=1;i<dp.length;i++) {
		for(int j=0;j<dp[0].length;j++) {
			int min = Integer.MAX_VALUE;
			
			for(int k=0;k<dp[0].length;k++) {
				if(k!=j) {
					if(dp[i-1][k]<min) {
						min = dp[i-1][k];
					}
				}
			}
			dp[i][j] = arr[i][j]+min;
		}
	}
	int min = Integer.MAX_VALUE;
	for(int k=0;k<dp[0].length;k++) {
		if(dp[building-1][k]<min) {
			min = dp[building-1][k];
		}
	}
	System.out.println(min);
}
}