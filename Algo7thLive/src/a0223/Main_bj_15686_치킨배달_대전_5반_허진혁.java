package a0223;

import java.io.*;
import java.util.*;

public class Main_bj_15686_치킨배달_대전_5반_허진혁 {
	/**
	 * 
	 */
	static int M, choice[][], min;
	static List<int[]> house, chicken;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_15686.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] city = new int[N][N];// 도시의 모습
		house = new LinkedList<>();// 집의 위치
		chicken = new LinkedList<>();// 치킨집의 위치
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if (city[i][j] == 1)
					house.add(new int[] { i, j });
				else if (city[i][j] == 2)
					chicken.add(new int[] { i, j });
			}
		}
		choice = new int[M][2];
		min = Integer.MAX_VALUE;
		combi(0, 0);
		System.out.println(min);

		br.close();
	}

	public static void combi(int cnt, int start) {
		if (cnt == M) {
			int diff = 0;// 선택된 치킨집과 집의 거리
			int distance = 0;// 치킨거리(최솟값)
			int cdSum = 0;// 치킨거리의 합
			for (int i = 0; i < house.size(); i++) {
				distance = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					diff = Math.abs(house.get(i)[1] - choice[j][1]) + Math.abs(house.get(i)[0] - choice[j][0]);
					distance = Math.min(distance, diff);
				}
				cdSum += distance;
			}
			min = Math.min(min, cdSum);
			return;
		}
		for (int i = start; i < chicken.size(); i++) {
			choice[cnt][0] = chicken.get(i)[0];
			choice[cnt][1] = chicken.get(i)[1];
			combi(cnt + 1, i + 1);
		}

	}

}