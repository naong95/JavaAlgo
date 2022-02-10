package a0209;

import java.io.*;
import java.util.*;

public class Solution_d3_3499_퍼펙트셔플_대전_5반_허진혁 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input_d3_3499.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			ArrayDeque<String> left = new ArrayDeque<>();
			ArrayDeque<String> right = new ArrayDeque<>();
			ArrayDeque<String> merge = new ArrayDeque<>();
			int Lhalf = 0;
			int Rhalf = 0;
			if (n % 2 == 0) {
				Lhalf = n / 2;
				Rhalf = n / 2;
			} else if (n % 2 == 1) {
				Lhalf = n / 2 + 1;
				Rhalf = n / 2;
			}

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < Lhalf; i++) {
				left.add(st.nextToken());
			}
			for (int i = 0; i < Rhalf; i++) {
				right.add(st.nextToken());
			}
			StringBuilder sb = new StringBuilder("#").append(test_case);
			while (!left.isEmpty()) {
				sb.append(" " + left.poll()).append(" " + right.poll());
			}
			if(n % 2 == 1) {
				sb.setLength(sb.length() - 5);
				System.out.println(sb);
			}
			else System.out.println(sb);
		}
		br.close();
	}
}
