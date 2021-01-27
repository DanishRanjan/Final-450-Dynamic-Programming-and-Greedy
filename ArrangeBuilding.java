import java.util.*;
public class ArrangeBuilding {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	
	int[] dp = new int[n+1];
	dp[0] = 0;
	
	int oldBuildingCount = 1;
	int oldSpaceCount = 1;
	for(int i=2;i<=n;i++) {
		int newBuildingCount = oldSpaceCount;
		int newSpaceCount = oldSpaceCount+oldBuildingCount;
		
		oldBuildingCount = newBuildingCount;
		oldSpaceCount = newSpaceCount;
	}
	long totalWay = oldBuildingCount+oldSpaceCount;
	System.out.println(totalWay*totalWay);
}
}
