package a0330;

import java.util.*;
import java.io.*;

public class Main_bj_2667_단지번호붙이기_대전_5반_허진혁 {

	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	
	static int N, map[][], count, danji;
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2667.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];// 입력이 붙어있을 때는 정수보다는 문자형으로 하는 경향이 있다
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		PriorityQueue<Integer> house = new PriorityQueue<>();
		v = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!v[i][j] && map[i][j] == 1) {
					bfs(i, j);
					house.offer(count);
				}
			}
		}
		System.out.println(danji);
		while(!house.isEmpty()) System.out.println(house.poll());
		
		br.close();
	}
	static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		v[r][c] = true;
		q.offer(new int[] {r, c});
		count = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int i = cur[0];
			int j = cur[1];
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if (0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj]) {
					if(map[ni][nj] == 1) {
						v[ni][nj] = true;
						q.offer(new int[] {ni, nj});
						count++;
					}
				}
			}
		}
		if(q.isEmpty()) danji++;
	}
}