package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_2164_카드2_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_2164.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			q.add(i + 1);
		}

		while (q.size() != 1) {
			q.poll();
			q.add(q.poll());
		}
		System.out.println(q.poll());
		br.close();
	}
}