import java.util.*;
public class FibonacciDP {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int[] qb = new int[n+1];
	
	System.out.println(fibMemoized(n,qb));
	System.out.println(fibonacciRecursion(n));
}
//-----Dynamic Programming------------------------------------Dynamic Programming-------------------------------Dynamic Programming---------------------------------------------
public static int fibMemoized(int n, int[] qb) {
	if(n==0 || n==1) {
		return n;
	}
	if(qb[n]!=0) {                               //checking , if the answer is already present in question bank or not.
		return qb[n];                            //if present , return answer of that question from question bank (don't go to next line for particular this n
	}                                            //If not present , proceed to execute the next Line
	int fibnm1 = fibMemoized(n-1,qb);
	int fibnm2 = fibMemoized(n-2, qb);
	int fibn = fibnm1+fibnm2;
	
	qb[n] = fibn;            //Storing answer in question bank so that we don't have to search same part again and again
	return fibn;
}

//-------Recursion-----------------------------------Recursion-----------------------Recursion---------------------------Recursion---------------------------------
public static int fibonacciRecursion(int n) {
	if(n==0 || n==1) {
		return n;
	}
	int fibnm1 = fibonacciRecursion(n-1);
	int fibnm2 = fibonacciRecursion(n-2);
	int fibn = fibnm1+fibnm2;
	
	return fibn;
}


}
