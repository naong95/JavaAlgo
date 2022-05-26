package a.a0408;

import java.io.*;
import java.util.*;

public class Main_bj_17135_캐슬디펜스_대전_5반_허진혁 {
	/*
	가장 가까운 적이 여럿이면 왼쪽의 적 부터 공격하므로 좌 상 우
	궁수는 조합으로 열 좌표를 뽑아서 배치
	궁수의 공격 범위 체크는 bfs로
	
	조합 함수 안에서 3명이 뽑히면 그 3명을 배치하고 bfs 돌리고
	적 리스트가 0이 되면 리턴
	 */
	
	static int[] di = {0, -1, 0};
	static int[] dj = {-1, 0, 1};
	
	static int N, M, D, map[][], cnt, max;
	static boolean[][] v;
	static int[] archer;
	static List<int []> position;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_17135.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		archer = new int[3];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		position = new LinkedList<>();// 궁수가 배치되는 경우가 담기는 리스트
		
		
		br.close();
	}
	
	private static void setArcher(int idx, int start) {// 궁수 배치
		if(idx == 3) {
			position.add(archer);
		}
		for(int i = start; i < M; i++) {
			archer[idx] = i;
			setArcher(idx + 1, i + 1);
		}
	}
	
	private static void attack(int r, int c) {
		int count = 0;
		Queue<int[]> q = new ArrayDeque<>();
		v[r][c] = true;
		q.offer(new int[] {r, c});
		while(!q.isEmpty()) {
			if(count == D) return;// 사거리 내의 적을 다 탐색 했다면 종료
			int[] cur = q.poll();
			int i = cur[0];
			int j = cur[1];
			for(int d = 3; d < 3; d++) {
				int ni = i + di[d];
				int nj = i + dj[d];
				if(ni < 0 || ni >= N || nj < 0 || nj >= M || v[ni][nj]) continue;
				if(map[nj][nj] == 1) {// 적 하나 잡았으면 더 이상 탐색 x
					v[ni][nj] = true;
					
					cnt++;
					return;
				}
				else if(map[ni][nj] == 0) {// 적이 아니면 더 탐색
					v[ni][nj] = true;
					q.offer(new int[] {ni, nj});
				}
			}
			count++;// 3 방향 다 탐색 했다면 탐색 횟수 증가
		}
	}
	
	private static void turn() {// 턴이 한 번 진행 된다면
		// 적들이 한 칸 다가온다
		for(int i = N - 1; i > 0; i--) {
			map[i] = map[i - 1];
		}
	}
}