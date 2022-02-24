package a0224;

import java.io.*;
import java.util.*;

public class Main_jo_1681_해밀턴순환회로_대전_5반_허진혁 {
	/**
	 * 완탐 돌리고 마지막 지점에서 1번(회사)을 연결 했을때 최소비용 출력
	 */
	static int N, g[][];
	static int min = Integer.MAX_VALUE;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_jo_1681.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		g = new int[N][N];
		v = new boolean[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				g[i][j] = sc.nextInt();
			}
		}
		
		v[0] = true;// 회사에서 출발하므로 방문처리
		dfs(0, 0, 0);
		System.out.println(min);
		sc.close();
	}

	static void dfs(int cnt, int current, int cost) {
		if (cnt == N - 1) {// 정점의 개수보다 하나 작을 때(회사 빼고 다 들린 상황)
			if (g[current][0] == 0)// 회사로 연결하는 간선이 없다면
				return;// 리턴
			cost += g[current][0];// 있다면 회사로 다시 돌아와야 하므로 비용을 더해준다
			min = Math.min(min, cost);
		}
		if (cost > min)// 현재까지 합해진 비용이 최솟값보다 크다면 더 볼 필요 없이
			return;// 리턴

		for (int i = 0; i < N; i++) {
			if (v[i])// 방문처리 돼있으면 
				continue;// 넘어가고
			if (g[current][i] == 0)// 현재 정점에서 다음 정점까지의 간선이 없으면
				continue;// 넘어간다

			v[current] = true;// 방문처리
			dfs(cnt + 1, i, cost + g[current][i]);// 다음 정점으로 진행
			v[current] = false;// 방문처리 해제
		}
	}
}