import java.util.*;

public class paintFence {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int k = sc.nextInt();
	
	long same = k*1;
	long different = k* (k-1);
	long total = same+different;
	for(int i=2;i<n;i++) {
		same = different *1;
		different = total * (k-1);
		total = same + different;
	}
	System.out.println(total);
	
}
}
