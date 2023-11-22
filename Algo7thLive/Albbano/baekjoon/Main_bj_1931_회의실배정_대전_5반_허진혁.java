package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_1931_회의실배정_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1931.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] time = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});

		int ans = 0;
		int endTime = 0;

		for (int i = 0; i < n; i++) {
			if (endTime <= time[i][0]) {
				ans++;
				endTime = time[i][1];
			}
		}
		System.out.println(ans);
		br.close();
	}
}