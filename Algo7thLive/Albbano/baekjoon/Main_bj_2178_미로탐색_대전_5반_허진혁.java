package baekjoon;
import java.util.*;
import java.io.*;
/*

*/
public class Main_bj_2178_미로탐색_대전_5반_허진혁 {
	
	static int[] di = {1, 0, -1, 0};
	static int[] dj = {0, 1, 0, -1};	
	static int n, m, ans;
	static int[][] map;
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_2178.txt")); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		v = new boolean[n][m];
		char[] arr;
		for(int i = 0; i < n; i++) {
			arr = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				map[i][j] = arr[j] - '0';
			}
		}
		bfs(0, 0);
		System.out.println(map[n - 1][m - 1]);
		
		br.close();
	}
	
	public static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		v[r][c] = true;
		q.offer(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int i = cur[0];
			int j = cur[1];
			
			for(int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(0 <= ni && ni < n && 0 <= nj && nj < m && !v[ni][nj] && map[ni][nj] != 0) {
					v[ni][nj] = true;
					q.offer(new int[] {ni, nj});
					map[ni][nj] = map[i][j] + 1;
				}
			}
		}
	}
}