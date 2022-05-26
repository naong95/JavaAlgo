package a.a0406;

import java.io.*;
import java.util.*;
/*
현재 수연이의 위치는 ‘S’, 여신의 공간은 ‘D’, 돌의 위치는 ‘X’, 악마는 ‘*’로 주어진다.
‘.’는 평범한 지역으로, 수연이가 이동할 수도 있으며 “악마의 손아귀” 스킬이 확장될 수도 있다.
전체 지도에서 ‘S’와 ‘D’는 정확히 한 번 나타난다.

수연이 큐, 데빌 큐 2개로 동시에 하나의 bfs에서 될까 ?

되긴 하는데 왜 게임오버가 안 될까 ?

핵심 아이디어: 악마 먼저, 큐 사이즈 만큼
*/

public class Solution_d5_7793_오나의여신님_대전_5반_허진혁 {
	
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	
	static boolean end, size, sv[][], dv[][];
	static char[][] map;
	static int N, M, soo[], devil[], megami[], time;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d5_7793.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());// 세로
			M = Integer.parseInt(st.nextToken());// 가로
			map = new char[N][M];
			sv = new boolean[N][M];
			dv = new boolean[N][M];
			
			for(int i = 0; i < N; i++) {
				String line = br.readLine();
				for(int j = 0; j < M; j++) {
					map[i][j] = line.charAt(j);
					if(map[i][j] == 'S') soo = new int[] {i, j};
					if(map[i][j] == '*') devil = new int[] {i, j};
					if(map[i][j] == 'D') megami = new int[] {i, j};
				}
			}
			end = false;
			bfs();
			if(!end) System.out.println("#" + tc + " GAME OVER");
			else System.out.println("#" + tc + " " + time);
		}
		br.close();
	}
	private static void bfs() {
		
		Queue<int[]> sq = new ArrayDeque<int[]>();// 수연이의 위치 큐
		Queue<int[]> dq = new ArrayDeque<int[]>();// 악마의 손아귀 큐
		
		sq.offer(soo);
		dq.offer(devil);
		
		while(true) {
			int size = dq.size();
			for(int i = 0; i < size; i++) {
				int[] devcur = dq.poll();
				int devi = devcur[0];
				int devj = devcur[1];
				dv[devi][devj] = true;
				for(int d = 0; d < 4; d++) {
					int ni = devi + di[d];
					int nj = devj + dj[d];
					if(ni < 0 || ni >= N || nj < 0 || nj >= M || map[ni][nj] == 'X'  || map[ni][nj] == 'D' || dv[ni][nj]) continue;
					dv[ni][nj] = true;
					dq.offer(new int[] {ni, nj});
					map[ni][nj] = '*';
				}
			}
			size = sq.size();
			for(int i = 0; i < size; i++) {
				int[] soocur = sq.poll();
				int sooi = soocur[0];
				int sooj = soocur[1];
				sv[sooi][sooj] = true;
				if(map[sooi][sooj] == 'D') {
					end = true;
					break;
				}
				for(int d = 0; d < 4; d++) {
					int ni = sooi + di[d];
					int nj = sooj + dj[d];
					if(ni < 0 || ni >= N || nj < 0 || nj >= M || map[ni][nj] == 'X' || map[ni][nj] == '*' || sv[ni][nj]) continue;
					if(map[ni][nj] != 'D') map[ni][nj] = 'S';
					sv[ni][nj] = true;
					sq.offer(new int[] {ni, nj});
				}
			}
			if(end || sq.isEmpty()) break;
			time++;
		}
	}
	
//	private static void endCheck(int[] man) {// 사방이 돌이나 손아귀에 갇힌다면 게임오버
//		int[] check = new int[4];
//		int sum = 0;
//		Arrays.fill(check, 1);
//		int i = man[0];
//		int j = man[1];
//		for(int d = 0; d < 4; d++) {
//			int ni = i + di[d];
//			int nj = j + dj[d];
//			if(0 <= ni && ni < N && 0 <= nj && nj < M) {
//				if(map[ni][nj] != '*' || map[ni][nj] != 'X') check[d] = 1;
//			}
//			else check[d] = 0;
//			sum += check[d];
//		}
//		if(sum == 0) end = true;
//		return;
//	}
}