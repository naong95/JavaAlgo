package a0210.treebfsdfs;

import java.io.*;
import java.util.*;

public class Main_bj_1158_요세푸스문제_대전_5반_허진혁 {
//		N: 7, K: 3
//		1 2 3 4 5 6 7 
//		1 2 4 5 6 7    3
//		1 2 4 5 7      6
//		1 4 5 7        2
//		1 4 5          7
//		1 4            5
//		4              1
//		               4
//		3 6 2 7 5 1 4

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input_bj_1158.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder("<");
		LinkedList<Integer> list = new LinkedList<>();
		int num = 1;
		int tmp = 0;
		int cnt = K;
		int n = N;
		for (int i = 1; i <= N; i++) {
			list.add(num++);
		}
		for (int i = 0; i < N; i++) {
			tmp = list.get(K - 1);
			sb.append(tmp).append(", ");
			list.remove(K - 1);
			K = K + cnt - 1;
			n--;
			if(K > n && n != 0) K %= n;
			if(K == 0) K = n;
//			System.out.println(tmp + " remove, next: " + K);
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb);
	}
}
