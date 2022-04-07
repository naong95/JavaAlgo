package a0407;

import java.io.*;
import java.util.*;
/*
녹색 옷을 입은 애가 젤다지 ?
2차원 배열에서의 다익스트라
*/
public class Solution_d4_1249_보급로_대전_5반_허진혁 {
	
	static class road implements Comparable<road> {
		int i, j, minT;
		public road(int i, int j, int minT) {
			super();
			this.i = i;// 행
			this.j = j;// 열
			this.minT = minT;// 그 좌표까지 오는데 걸리는 최소시간
		}
		@Override
		public int compareTo(road o) {
			return this.minT - o.minT;
		}
	}
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static int N, map[][], repairTime[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1249.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			repairTime = new int[N][N];

			for(int i = 0; i < N; i++) {
				String line = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j) - '0';
					repairTime[i][j] = 987654321;
				}
			}
			System.out.println("#" + tc + " " + minTime());
		}
	}

	private static int minTime() {
		PriorityQueue<road> pq = new PriorityQueue<>();
		repairTime[0][0] = map[0][0];// 시작은 (0, 0) 이므로
		pq.offer(new road(0, 0, map[0][0]));
		
		while(!pq.isEmpty()) {
			road cur = pq.poll();
			for(int d = 0; d < 4; d++) {
				int ni = cur.i + di[d];
				int nj = cur.j + dj[d];
				if(ni < 0 || ni >= N || nj < 0 || nj >= N) continue;
				if(repairTime[ni][nj] > repairTime[cur.i][cur.j] + map[ni][nj]) {
					// 다음 좌표의 총수리비가 현재 수리비 + 다음좌표 수리비라면
					repairTime[ni][nj] = repairTime[cur.i][cur.j] + map[ni][nj];
					// 최솟값 갱신하고 더 진행할 수 있도록 큐에 삽입
					pq.offer(new road(ni, nj, repairTime[ni][nj]));
				}
			}
		}
		return repairTime[N - 1][N - 1];
	}
}