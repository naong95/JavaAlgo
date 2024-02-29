package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_17952_과제는끝나지않아_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_17952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<int[]> s = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		int score = 0;

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int h = Integer.parseInt(st.nextToken());

			if (h == 1) {
				int a = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				s.push(new int[] { a, t - 1 });
				
				if (s.peek()[1] == 0) {
					score += s.pop()[0];
				}
			} else {
				if (!s.isEmpty()) {
					int[] tmp = s.pop();
					tmp[1] -= 1;
					s.push(tmp);

					if (s.peek()[1] == 0) {
						score += s.pop()[0];
					}
				}
			}
		}

		System.out.println(score);
		br.close();
	}
}