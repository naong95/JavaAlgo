import java.util.*;
import java.io.*;
/*
왕실의 기사 대결

3차원 배열 2차원(지도) + 1차원(기사번호)

명령 수행(dfs) -> 데미지 체크
*/
public class solution1 {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int L, N, Q;
	static int[][][] map;
	static Knight[] knights;
	static int damage;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		L = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		map = new int[L][L][2];
		knights = new Knight[N];
		
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < L; j++) {
				map[i][j][0] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			knights[i] = new Knight(Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = knights[i].r; j < knights[i].r + knights[i].h; j++) {
				for(int k = knights[i].c; k < knights[i].c + knights[i].w; k++) {
					map[j][k][1] = i + 1;
				}
			}
		}
		
		for(int j = 0; j < Q; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			
			push(i, d);
		}
		
		System.out.println(damage);
		
		for(int i = 0; i < L; i++) {
			for(int j = 0; j < L; j++) {
				System.out.print(map[i][j][1] + " ");
			}
			System.out.println();
		}
		
		br.close();
	}
	
	public static void push(int i, int d) {
		
		
	}

	public static class Knight {
		int r;
		int c;
		int h;
		int w;
		int k;
		
		public Knight(int r, int c, int h, int w, int k) {
			super();
			this.r = r;
			this.c = c;
			this.h = h;
			this.w = w;
			this.k = k;
		}	
	}
}
