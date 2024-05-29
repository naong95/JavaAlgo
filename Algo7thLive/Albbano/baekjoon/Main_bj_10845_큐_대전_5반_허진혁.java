package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_10845_큐_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_10845.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Deque<Integer> q = new ArrayDeque<Integer>();
		StringBuilder sb = new StringBuilder("");

		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String order = st.nextToken();
			int num = 0;

			if (order.equals("push")) {
				num = Integer.parseInt(st.nextToken());
				q.offer(num);
			} else if (order.equals("pop")) {
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q.poll()).append("\n");
				}
			} else if (order.equals("size")) {
				sb.append(q.size()).append("\n");
			} else if (order.equals("empty")) {
				if (q.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else if (order.equals("front")) {
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q.peekFirst()).append("\n");
				}
			} else {
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q.peekLast()).append("\n");
				}
			}
		}

		System.out.println(sb.toString().trim());
		br.close();
	}
}