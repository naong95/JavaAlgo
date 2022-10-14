package baekjoon;

import java.util.*;
import java.io.*;

/*
그냥 이동을 하면 +1 -1
순간이동을 하면 곱하기 2
*/
public class Main_bj_1697_숨바꼭질_대전_5반_허진혁 {

	static int[] v;
	static int subi, dong;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1697.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		subi = Integer.parseInt(st.nextToken());
		dong = Integer.parseInt(st.nextToken());
		v = new int[100001];
		
		System.out.println(bfs());
		br.close();
	}

	public static int bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		
		v[subi] = 1;
		q.offer(subi);

		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == dong) return v[cur] - 1;
				
			if(cur - 1 >= 0 && v[cur - 1] == 0) {
				v[cur - 1] = v[cur] + 1;
				q.offer(cur - 1);
			}
			if(cur + 1 <= 100000 && v[cur + 1] == 0) {
				v[cur + 1] = v[cur] + 1;
				q.offer(cur + 1);
			}
			if(cur * 2 <= 100000 && v[cur * 2] == 0) {
				v[cur * 2] = v[cur] + 1;
				q.offer(cur * 2);
			}
		}
		return -1;
	}
}