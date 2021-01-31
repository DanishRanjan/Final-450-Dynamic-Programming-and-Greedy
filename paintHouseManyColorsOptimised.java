import java.util.*;

public class paintHouseManyColorsOptimised {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int building = sc.nextInt();
		int color = sc.nextInt();
		int[][] arr = new int[building][color];
		for (int i = 0; i < building; i++) {
			for (int j = 0; j < color; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int least = Integer.MAX_VALUE;
		int secondLeast = Integer.MAX_VALUE;
		int[][] dp = new int[building][color]; // This way we are finding two least in first row
		for (int j = 0; j < arr[0].length; j++) {
			dp[0][j] = arr[0][j];
			if (arr[0][j] < least) {
				secondLeast = least;
				least = arr[0][j];
			} else if (arr[0][j] < secondLeast) {
				secondLeast = arr[0][j];
			}
		}

		for (int i = 1; i < building; i++) {
			int newLeast = Integer.MAX_VALUE;
			int newSecondLeast = Integer.MAX_VALUE;
			for (int j = 0; j < color; j++) {
				if (least == dp[i - 1][j]) {
					dp[i][j] = secondLeast + arr[i][j];
				} else {
					dp[i][j] = least + arr[i][j];
				}

				if (dp[i][j] <= newLeast) {
					newSecondLeast = newLeast;
					newLeast = dp[i][j];
				} else if (dp[i][j] <= newSecondLeast) {
					newSecondLeast = dp[i][j];
				}

			}
			least = newLeast;
			secondLeast = newSecondLeast;
		}

		System.out.println(least);

	}
}
