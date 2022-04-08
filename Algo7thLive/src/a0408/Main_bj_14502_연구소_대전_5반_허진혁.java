package a0408;

import java.io.*;
import java.util.*;

public class Main_bj_14502_연구소_대전_5반_허진혁 {
	/*
	배열 받아와서 0인 자리에 조합으로 벽 세우고
	bfs로 바이러스 퍼뜨리고
	안전영역 크기들 계산해서 최댓값 갱신
	 */
	
	static int N, M, map[][], newMap[][], b[][], ans;
	static boolean[][] v;
	
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	
	
	static List<int[]> zList;// 0의 좌표가 들어갈 리스트(벽 후보)
	static List<int[]> vList;// 2의 좌표가 들어갈 리스트(바이러스)
	static Queue<int[]> bq;// 뽑힌 벽들이 들어가는 큐
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_14502.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());// 세로
		M = Integer.parseInt(st.nextToken());// 가로
		map = new int[N][M];
		newMap = new int[N][M];
		b = new int[3][2];
		zList = new LinkedList<>();
		vList = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) zList.add(new int[] {i, j});
				if(map[i][j] == 2) vList.add(new int[] {i, j});
			}
		}
		ans = 0;
		bq = new ArrayDeque<>();
		shield(0, 0);// 벽들 담아주고
		while(true) {
			copy();// 맵 초기화
			v = new boolean[N][M];
			for(int i = 0; i < 3; i++) {// 벽은 3개로 정해져 있으므로
				int[] cur = bq.poll();// 뽑아서
				newMap[cur[0]][cur[1]] = 1;// 선택된 곳을 벽으로 바꾼다
			}
			virus();// 바이러스 퍼뜨리고
			// 0을 세서 최댓값 갱신
			if(bq.isEmpty()) break;
		}
		for (int[] ia : newMap) {
			System.out.println(Arrays.toString(ia));
		}
		virus();
		System.out.println();
		for (int[] ia : newMap) {
			System.out.println(Arrays.toString(ia));
		}
	}
	private static void shield(int cnt, int start) {// 벽 저장 함수
		if (cnt == 3) {
			for(int i = 0; i < 3; i++) bq.offer(b[i]);
			return;
		}
		for(int i = start; i < zList.size(); i++) {
			b[cnt] = zList.get(i);
			shield(cnt + 1, i + 1);
		}
	}
	private static void virus() {// 바이러스 퍼지게 하는 함수
		int size = vList.size();
		Queue<int[]> q = new ArrayDeque<>();
		for(int i = 0; i < size; i++) {
			v[vList.get(i)[0]][vList.get(i)[1]] = true;
			q.offer(vList.get(i));
		}
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int i = cur[0]; int j = cur[1];
			for(int d = 0; d < 4; d++) {
				int ni = i + di[d]; int nj = j + dj[d];
				if(ni < 0 || nj >= N || nj < 0 || nj >= M || v[i][j] || newMap[i][j] == 1) continue;
				v[i][j] = true;
				q.offer(new int[] {ni, nj});
				System.out.println(ni + ", " + nj + "삽입");
				newMap[i][j] = 2;
			}
		}
	}
	private static void copy() {// 배열 초기화 함수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}
}