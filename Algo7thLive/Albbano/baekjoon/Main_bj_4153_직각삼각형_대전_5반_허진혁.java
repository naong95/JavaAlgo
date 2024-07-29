package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_4153_직각삼각형_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_4153.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = -1;
		int b = -1;
		int c = -1;

		StringTokenizer st;
		StringBuilder sb = new StringBuilder("");
		List<Integer> list;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			list = new ArrayList<>();
			list.add(a);
			list.add(b);
			list.add(c);

			Collections.sort(list);

			if (a == 0)
				break;

			if (list.get(0) * list.get(0) + list.get(1) * list.get(1) == list.get(2) * list.get(2)) {
				sb.append("right").append("\n");
			} else {
				sb.append("wrong").append("\n");
			}
		}

		System.out.println(sb.toString());
		br.close();
	}
}