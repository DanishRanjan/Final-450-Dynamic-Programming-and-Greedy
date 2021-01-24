import java.util.*;
public class targetSumSubsetDP {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int[] arr = new int[n];
	for(int i=0;i<n;i++) {
		arr[i] = sc.nextInt();
	}
	int target = sc.nextInt();
	
	boolean[][] dp = new boolean[n+1][target+1];
	for(int i=0;i<dp.length;i++) {
		for(int j=0;j<dp[0].length;j++) {
			if(i==0 && j==0)        //top left corner , yahan par 0 se 0 jaane se 1 path hai , thats why , its true;
			{
				dp[i][j] = true;    
			}
			else if(i==0)        //top row, zero size ka array only go to zero , uske aagey yeh nhi jaa sakta, no subset of zero size array
			{
				dp[i][j] = false;     //khali array sivaay zero k kuch nhi bana sakta
			}
			else if(j==0)  //left most column , will always have zero as subset , kyuki sabka zero to subset hota hi h.
			{
				dp[i][j] = true;     //saare array mein empty subset to hota hi h
			}
			else
			{
				if(dp[i-1][j]==true)    //i-1 ki team j bana sakti h kya?, agar haan 
				{
					dp[i][j] = true;
				}
				else                     //agar i-1 ki team j nhi bana paayi, to isko batting karani padegi
				{
					int val = arr[i-1];
					if(j >= val) {
						if(dp[i-1][j-val] == true) {
							dp[i][j] = true;
						}
					}
				}
			}
		}
	}
	System.out.println(dp[arr.length][target]);
}
}
