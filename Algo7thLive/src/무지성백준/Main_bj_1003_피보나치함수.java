package 무지성백준;
import java.util.*;
import java.io.*;
/*
dp는 4,5번째 케이스까지 나열해서 규칙이 있는지부터 파악하자 
*/
public class Main_bj_1003_피보나치함수 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("muji/input_bj_1003.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			int zero = 1;
			int one = 0;
			int zero_plus_one = 1;
			 
			for (int j = 0; j < N; j++) {
				zero = one;	
				one = zero_plus_one;	
				zero_plus_one = zero + one;	
			}
			System.out.println(zero + " " + one);
		}
		br.close();
	}
}