package a.a0224;

import java.io.*;
import java.util.*;

public class Main_bj_1753_최단경로_대전_5반_허진혁 {
	/**
	 * 
	 */
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1753.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());// 정점의 개수
		int E = Integer.parseInt(st.nextToken());// 간선의 개수
		int start = Integer.parseInt(br.readLine());// 시작점
		List<int[]>[] g = new List[N+1];
		for (int i = 0; i <= N; i++) g[i] = new ArrayList<int[]>();
		int[] distance = new int[N+1];
		for (int i = 0; i <= N; i++) distance[i] = Integer.MAX_VALUE;
		boolean[] v = new boolean[N+1];
		for(int i =0; i< E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			g[from].add(new int[] {to, cost});
		}
		
		distance[start] = 0;
		for (int i = 1; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			int current = 0;
			for (int j = 1; j <= N; j++) {
				if (!v[j] && min > distance[j]) {
					         min = distance[j];
					         current = j;
				}
				continue;
			}
			v[current] = true;
			for (int[] j : g[current]) {
				if (!v[j[0]] && distance[j[0]] > distance[current] + j[1]) {
								distance[j[0]] = distance[current] + j[1];
				}
				continue;
			}
		}
		for(int i = 1; i <= N; i++) {
			if(distance[i] == Integer.MAX_VALUE)sb.append("INF").append("\n");
			else sb.append(distance[i]).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}