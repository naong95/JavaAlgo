package study;

import java.util.*;
import java.io.*;
/*
(r-2, c-1), (r-2, c+1)
(r, c-2), (r, c+2)
(r+2, c-1), (r+2, c+1)

카운트 조건을 어떻게 해야할까 ?
클래스 만들지 말고 데스나이트의 좌표 배열에 3번째 인자로 카운트를 넣으면 된다
토마토에서 했던건데 왜 못 할까 ? -> 내가 직접 생각해냈던게 아니기 때문에
*/

class deathKnight {
	int r;
	int c;
	int cnt;
	public deathKnight(int r, int c, int cnt) {
		super();
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}

public class Main_bj_16948_데스나이트_대전_5반_허진혁 {

	static int[] dr = { -2, -2, 0, 0, 2, 2 };// 데스 나이트의 이동
	static int[] dc = { -1, 1, -2, 2, -1, 1 };
	static int N, sr, sc, gr, gc, answer = Integer.MAX_VALUE;
	static boolean[][] v;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_16948.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		v = new boolean[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		gr = Integer.parseInt(st.nextToken());
		gc = Integer.parseInt(st.nextToken());
		
		bfs();
		br.close();
	}
	
	static void bfs() {
		Queue<deathKnight> q = new LinkedList<>();
		v[sr][sc] = true;
		q.offer(new deathKnight(sr, sc, 0));
		while (!q.isEmpty()) {
			deathKnight dk = q.poll();
			for (int d = 0; d < 6; d++) {
				int nr = dk.r + dr[d];
				int nc = dk.c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || v[nr][nc]) continue;// 범위 벗어나거나 방문했다면
				v[nr][nc] = true;
				if(nr == gr && nc == gc) {// 골인지점에 도착하면
					answer = dk.cnt + 1;// 전까지의 이동횟수 + 1
				}
				// 도착하지 않았다면
				v[nr][nc] = true;// 방문처리 하고
				q.offer(new deathKnight(nr, nc, dk.cnt + 1));// 이동횟수 + 1 해주고 그 데스나이트를 큐에 삽입
			}
		}
		if(answer != Integer.MAX_VALUE) System.out.println(answer);// 초기값과 다르다면 답 출력
		else System.out.println(-1);// 같다면 도달하지 못 한 것이므로 -1 출력
	}
}