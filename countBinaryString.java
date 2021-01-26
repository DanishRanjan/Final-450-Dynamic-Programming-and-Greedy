import java.util.*;
public class countBinaryString {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	
	
//	This method takes extra spcae , but easily understandable
	//-----------------------------------//------------------------------
	int[] dp0 = new int[n+1];
	int[] dp1 = new int[n+1];
	
	dp0[1] = 1;
	dp1[1] = 1;
	for(int i=2;i<=n;i++) {
		dp1[i] = dp1[i-1]+dp0[i-1];  //pichle level k dono contribute kar rhe h answer mein
		dp0[i] = dp1[i-1]; // pichle level ka only once is contributing not zeroes
	}
	System.out.println(dp1[n]+dp0[n]);
	
	
	
	
	//----------------------------------------------------------------------------
	//With no extra space
	int oldCountZero = 1;
	int oldCountOne = 1;
	
	for(int i=2;i<=n;i++) {
		int newCountZero = oldCountOne;
		int newCountOne = oldCountOne+oldCountZero;
		
		oldCountZero = newCountZero;	
		oldCountOne = newCountOne;
	}
	
	System.out.println(oldCountZero+oldCountOne);
	
}
}
