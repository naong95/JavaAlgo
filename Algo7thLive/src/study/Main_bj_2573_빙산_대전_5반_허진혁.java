package study;
import java.util.*;
import java.io.*;
/*
첫 줄에는 이차원 배열의 행의 개수와 열의 개수를 나타내는 두 정수 N과 M이 한 개의 빈칸을 사이에 두고 주어진다. 
N과 M은 3 이상 300 이하이다.

빙산의 높이는 바닷물에 많이 접해있는 부분에서 더 빨리 줄어들기 때문에, 
배열에서 빙산의 각 부분에 해당되는 칸에 있는 높이는 
일년마다 그 칸에 동서남북 네 방향으로 붙어있는 0이 저장된 칸의 개수만큼 줄어든다. 

첫 줄에 빙산이 분리되는 최초의 시간(년)을 출력한다. 
만일 빙산이 다 녹을 때까지 분리되지 않으면 0을 출력한다.
*/
public class Main_bj_2573_빙산_대전_5반_허진혁 {
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	
	static int N, M, map[][], island;
	static boolean[][] v;
	static Queue<int[]> q;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2573.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		int year = 0;
		while(!check()) {
			for (int i = 0; i < N; i++) {// 녹일 거 담기
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 0) continue;
					melt(i, j);
				}
			}
			while(!q.isEmpty()) {// 녹이기
				int[] now = q.poll();
				int r = now[0]; int c = now[1]; int m = now[2];
				if(map[r][c] >= m) map[r][c] -= m;
				else map[r][c] = 0;
			}
			island = 0;
			v = new boolean[N][M];
			for (int i = 0; i < N; i++) {// 빙산 개수 세기
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 0 || v[i][j]) continue;
					bfs(i, j);
				}
			}
			if(island >= 2) {// 빙산이 2개 이상이면 멈춰
				year++; 
				break;
			}
			else {// 아직 1덩어리거나 끝까지 1덩어리 상태로 동시에 녹았다면
				if(check()) year = 0;// 햇수를 0으로(한 번도 2덩어리 이상으로 나눠지지 않음)
				else year++;// 햇수 늘리기
			}
		}
		System.out.println(year);
		br.close();
	}
	private static void melt(int i, int j) {// 얼마나 줄어들지 큐에 담는 함수
		int cnt = 0;
		for(int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni < 0 || ni >= N || nj < 0 || nj >= M) continue;
			if(map[ni][nj] == 0) cnt++;
		}
		q.offer(new int[] {i, j, cnt});
	}
	
	private static void bfs(int i, int j) {// 빙산 개수 체크
		Queue<int[]> q = new LinkedList<>();
		v[i][j] = true;
		q.offer(new int[] {i, j});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			i = cur[0];
			j = cur[1];
			for(int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni < 0 || ni >= N || nj < 0 || nj >= M || v[ni][nj]) continue;
				if(map[ni][nj] != 0) {
					v[ni][nj] = true;
					q.offer(new int[] {ni, nj});
				}
			}
		}
		island++;
	}
	
	private static boolean check() {// 빙산이 없으면 true, 빙산이 있으면 false
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 0) return false;
			}
		}
		return true;
	}
}