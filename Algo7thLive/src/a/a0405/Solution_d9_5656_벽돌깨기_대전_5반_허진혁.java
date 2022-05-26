package a.a0405;

import java.io.*;
import java.util.*;

public class Solution_d9_5656_벽돌깨기_대전_5반_허진혁 {
	
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static int W, H, N, ans;
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_5656.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());// 구슬을 떨어뜨리는 횟수
			W = Integer.parseInt(st.nextToken());// 너비
			H = Integer.parseInt(st.nextToken());// 높이
			int brick = 0;
			int[][] map= new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > 0) brick++;
				}
			}
			ans = Integer.MAX_VALUE;
			shot(0, brick, map);
			
			System.out.println("#" + tc + " " + ans);
		}
		br.close();
	}
	private static void clear(int[][] map) {
		for(int j = 0; j < W; j++) {
			int i = H - 1;
			while(i > 0) {
				if(map[i][j] == 0) {
					int ni = i - 1;
					while(ni > 0 && map[i][j] == 0) ni--;
					map[i][j] = map[ni][j];
					map[ni][j] = 0;
				}
				i--;
			}
		}
	}
	static List<Integer> list = new LinkedList<>();
	private static void clearList(int[][] map) {
		for(int j = 0; j < W; j++) {
			int i = H - 1;
			while(i >= 0) {
				if(map[i][j] > 0) {
					list.add(map[i][j]);
					map[i][j] = 0;
				}
				i--;
			}
			i = H - 1;
			for (int a : list) {
				map[i--][j] = a;
			}
			list.clear();
		}
	}
	
	private static boolean shot(int cnt, int remain, int[][] map) {
		if(remain == 0) {
			ans = 0;
			return true;
		}
		if(cnt == N) {
			ans = Math.min(ans, remain);
			return false;
		}
		int[][] newMap = new int[H][W];
		for(int j = 0; j < W; j++) {
			int i = 0;
			while(i < H && map[i][j] == 0) ++i;
			if(i == H) continue;
			
			copy(map, newMap);
			int pangCnt = pang(newMap, i, j);
			clear(newMap);
			if(shot(cnt + 1, remain - pangCnt, newMap)) return true;
		}
		
		return false;
	}
	private static int pang(int[][] map, int r, int c) {
		int cnt = 0;
		Queue<int[]> q = new ArrayDeque<int[]>();
		if(map[r][c] > 1) q.offer(new int[] {r, c, map[r][c]});
		map[r][c] = 0;
		cnt++;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int i = cur[0];
			int j = cur[1];
			for(int d = 0; d < 4; d++) {
				i += di[d];
				j += dj[d];
				for(int k = 0; k < cur[2] - 1; k++) {
					if(0 <= i && i < H && 0 <= j && j < W && map[i][j] > 0) {
						if(map[i][j] > 1) q.offer(new int [] {i, j, map[i][j]});
						map[i][j] = 0;
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
	private static void copy(int[][] map, int[][] newMap) {
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}
}