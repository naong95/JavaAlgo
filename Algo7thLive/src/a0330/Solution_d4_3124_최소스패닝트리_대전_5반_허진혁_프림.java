package a0330;

import java.io.*;
import java.util.*;

public class Solution_d4_3124_최소스패닝트리_대전_5반_허진혁_프림 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_3124.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());// 테스트케이스 개수
		StringTokenizer st;
		StringBuilder sb = new StringBuilder("");
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());// 정점의 수
			int E = Integer.parseInt(st.nextToken());// 간선의 수
			
			int[][] g = new int[N + 1][N + 1];
			int [] minEdge = new int[N + 1];
			boolean[] v = new boolean[N + 1];
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				g[r][c] = w;
				g[c][r] = w;
			}
			for(int i = 1; i <= N; i++) minEdge[i] = Integer.MAX_VALUE;
			
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
			long result = 0, cnt = 0;
			minEdge[0] = 0;
			pq.offer(new int[] {0, 0});
			while(!pq.isEmpty()) {
				int[] minVertex = pq.poll();
				if(v[minVertex[0]])continue;
				
				v[minVertex[0]] = true;
				result += minVertex[1];
				if(cnt++ == N - 1) break;
				
				for(int i = 1; i <= N; i++) {
					if (!v[i] && g[minVertex[0]][i] != 0 && minEdge[i] > g[minVertex[0]][i]) {
				   											minEdge[i] = g[minVertex[0]][i];
				   											pq.offer(new int[] {i,g[minVertex[0]][i]});
					}
				}
			}
			sb.append(result);
			System.out.println(sb.toString());
			br.close();
		}
	}
}