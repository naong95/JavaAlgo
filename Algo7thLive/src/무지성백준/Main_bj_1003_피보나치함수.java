package 무지성백준;
import java.util.*;
import java.io.*;
/*

*/
public class Main_bj_1003_피보나치함수 {
	static int[] zero;
	static int[] one;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("muji/input_bj_1003.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			zero = new int[41];
			one = new int[41];
			fibo(N);
			System.out.println(zero + " " + one);
		}
		br.close();
	}
	static int fibo(int n) {
		if(n == 0) {
			zero[n]++;
			return 0;
		}
		else if(n == 1) {
			one[n]++;
			return 1;
		}
		else return fibo(n - 1) + fibo(n - 2);
	}
}