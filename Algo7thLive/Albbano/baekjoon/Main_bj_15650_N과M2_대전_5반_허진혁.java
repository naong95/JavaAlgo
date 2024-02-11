package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_15650_N과M2_대전_5반_허진혁 {

	static int[] arr;
	static int N, M;
	static StringBuilder sb = new StringBuilder("");
	
	public static void dfs(int start, int depth) {
		
		if(depth == M) {
			for(int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i <= N; i++) {
			arr[depth] = i;
			dfs(i + 1, depth + 1);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_15650.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		
		dfs(1, 0);
		
		System.out.println(sb.toString());
		sc.close();
	}
}