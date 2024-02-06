package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_15650_N과M2_대전_5반_허진혁 {

	static int[] arr;
	static int N, M;
	static StringBuilder sb = new StringBuilder("");
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_15650.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		
		dfs(0, 1);
		
		System.out.println(sb.toString());
		sc.close();
	}
	
	public static void dfs(int depth, int start) {
		if(depth == M) {
			for(int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");			
			return;
		}
		
		for(int i = start; i <= N; i++) {
			arr[depth] = i;
			dfs(depth + 1, start + 1);
		}
	}
}