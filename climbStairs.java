	import java.util.*;
	public class climbStairs {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(countPathsDynamicMemoisation(n,new int[n+1]));
		System.out.println(countPathsDynamicTabulation(n));
	}
	//-----------------------------------------------Normal Recursion------------------------Normal Recursion-------------------------------------Normal Recursion--------
	public static int countPaths(int n) {
		if(n==0) {
			return 1;
		}else if(n<0) {
			return 0;
		}
		
		int nm1 = countPaths(n-1);
		int nm2 = countPaths(n-2);
		int nm3 = countPaths(n-3);
		int cp = nm1+nm2+nm3;
		
		return cp;
	}
	//-------------------Dynamic Programming----------Memoization--------------Dynamic Programming----------------Memoization--------------------------
	public static int countPathsDynamicMemoisation(int n, int[] qb) {
		if(n==0) {
			return 1;
		}
		else if(n<0) {
			return 0;
		}
		
		if(qb[n]>0) {   //checking whether we have answer in question bank or not
			return qb[n];
		}
		
		int nm1 = countPathsDynamicMemoisation(n-1, qb);
		int nm2 = countPathsDynamicMemoisation(n-2, qb);
		int nm3 = countPathsDynamicMemoisation(n-3, qb);
		int cp = nm1+nm2+nm3;
		
		qb[n] = cp;   //making question bank and storing each question's every time, so that whenever we need , we can take it form here
		return cp;
		
	}
	
	//-----------------Dynamic Programming----------Tabulation-----------Dynamic Programming------------Tabulation--------------------Tabulation
	//Tabulation is not Recursion , but it is ITERATION
	//no recursion , only iteration
	//no question bank
	public static int countPathsDynamicTabulation(int n) {
		int[] dp = new int[n+1];
		dp[0]=1;
		for(int i=1;i<=n;i++) {
			if(i==1) {
				dp[i] = dp[i-1];
			}
			else if(i==2) {
				
				dp[i] = dp[i-1]+dp[i-2];
			}
			else {
				dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
			}
		}
		return dp[n];
	}
	}
