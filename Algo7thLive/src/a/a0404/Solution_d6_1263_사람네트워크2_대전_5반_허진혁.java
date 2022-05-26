package a.a0404;

import java.io.*;
import java.util.*;

public class Solution_d6_1263_사람네트워크2_대전_5반_허진혁 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d6_1263.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());// 테스트케이스 개수
		for(int tc = 1; tc <= T; tc++) {
			int ans = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && map[i][j] == 0) map[i][j] = 9999;
				}
			}
			for(int k = 0; k < N; ++k) {
				for(int i = 0; i < N; ++i) {
					if(i == k) continue;
					for(int j = 0; j < N; ++j) {
						if(i == j || k == j) continue;
						if(map[i][j] > map[i][k] + map[k][j])
						   map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
			for(int i = 0; i < N; i++) {
				int sum = 0;
				for(int j = 0; j < N; j++) sum += map[i][j];
				ans = Math.min(ans, sum);
			}
			System.out.println("#" + tc + " " + ans);
		}
		br.close();
	}
}