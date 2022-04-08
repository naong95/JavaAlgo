package a0407;

import java.io.*;
import java.util.*;
/*
bfs라는게 이제 조금 보인다
세로N, 가로M, 맨홀행R, 맨홀열C, 시간L

근데 왜 항상 최솟값보다 클까 ?

--> 자고 일어나서 보니 시간 조건을 안 넣었다
*/
public class Solution_d9_1953_탈주범검거_대전_5반_허진혁 {
	
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static int N, M, R, C, L, map[][], ans;
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_1953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());// 세로
			M = Integer.parseInt(st.nextToken());// 가로
			R = Integer.parseInt(st.nextToken());// 맨홀 행
			C = Integer.parseInt(st.nextToken());// 맨홀 열
			L = Integer.parseInt(st.nextToken());// 경과시간
			
			map = new int[N][M];
			v = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = 0;
			bfs();
			System.out.println(ans);
		}
	}
	
	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		v[R][C] = true;
		int time = 0;
		q.offer(new int[] {R, C});
		
		while(!q.isEmpty()) {
			if(time == L) break;
			int[] cur = q.poll();
			int i = cur[0]; int j = cur[1];
			int pipe = map[i][j];// 현재 파이프의 모양
			
			for(int d = 0; d < 4; d++) {
				int ni = i + di[d]; int nj = j + dj[d];
				if(ni < 0 || ni >= N || nj < 0 || nj >= M) continue;// 범위 벗어나면 패스
				if(v[ni][nj] || map[ni][nj] == 0) continue;// 방문 했거나 0이라면 패스
				
				int next = map[ni][nj];// 패스가 안 됐다면 다음 파이프의 모양으로 조건 체크
				/*
				1 상하좌우	5 하우
				2 상하		6 하좌
				3 좌우		7 상좌
				4 상우
				
				상 1247
				우 1345
				하 1256
				좌 1367
				*/
				switch(d) {// 상우하좌
				case 0:// 위로 진행하는 경우 --> 다음 파이프가 아래로 뚫려있는지 ?
					if(pipe == 1 || pipe == 2 || pipe == 4 || pipe == 7) {// 위로 갈 수 있는 파이프면서~
						if(next == 1 || next == 2 || next == 5 || next == 6) {// 다음 파이프 아래가 뚫려있다면
							v[ni][nj] = true;
							q.offer(new int[] {ni, nj});
							ans++;
							time++;
						}
					}
					break;
				case 1:// 오른쪽 진행하는 경우 --> 다음 파이프가 왼쪽으로 뚫려있는지 ?
					if(pipe == 1 || pipe == 3 || pipe == 4 || pipe == 5) {// 오른쪽로 갈 수 있는 파이프면서~
						if(next == 1 || next == 3 || next == 6 || next == 7) {// 다음 파이프 왼쪽이 뚫려있다면
							v[ni][nj] = true;
							q.offer(new int[] {ni, nj});
							ans++;
							time++;
						}
					}
					break;
				case 2:// 아래로 진행하는 경우 --> 다음 파이프가 위로 뚫려있는지 ?
					if(pipe == 1 || pipe == 2 || pipe == 5 || pipe == 6) {// 아래로 갈 수 있는 파이프면서~
						if(next == 1 || next == 2 || next == 4 || next == 7) {// 다음 파이프 위가 뚫려있다면
							v[ni][nj] = true;
							q.offer(new int[] {ni, nj});
							ans++;
							time++;
						}
					}
					break;
				case 3:// 왼쪽 진행하는 경우 --> 다음 파이프가 오른쪽으로 뚫려있는지 ?
					if(pipe == 1 || pipe == 3 || pipe == 6 || pipe == 7) {// 왼쪽으로 갈 수 있는 파이프면서~
						if(next == 1 || next == 3 || next == 4 || next == 5) {// 다음 파이프 오른쪽이 뚫려있다면
							v[ni][nj] = true;
							q.offer(new int[] {ni, nj});
							ans++;
							time++;
						}
					}
					break;
				}
			}
		}
	}
}