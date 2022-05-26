package a.a0330;

import java.io.*;
import java.util.*;

public class Solution_d4_3124_최소스패닝트리_대전_5반_허진혁_프림 {
	
	static class Vertex implements Comparable<Vertex> {
		int no, edge;

		public Vertex(int no, int edge) {
			super();
			this.no = no;
			this.edge = edge;
		}
		@Override
		public int compareTo(Vertex o) {
			return this.edge - o.edge;
		}

	}
	
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
			List<Vertex>[] g = new ArrayList[N];
			for(int i = 0; i < N; i++) g[i] = new ArrayList<>();
			
			int [] minEdge = new int[N];
			boolean[] v = new boolean[N];
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;
				int weight = Integer.parseInt(st.nextToken());
				g[from].add(new Vertex(to, weight));
				g[to].add(new Vertex(from, weight));
			}
			for(int i = 0; i < N; i++) minEdge[i] = Integer.MAX_VALUE;
			
			long result = 0, cnt = 0;
			minEdge[0] = 0;
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			pq.offer(new Vertex(0, 0));
			
			while (!pq.isEmpty()) {
				Vertex minVertex = pq.poll();
				if(v[minVertex.no])continue;
				
				v[minVertex.no] = true;
				result += minVertex.edge;
				if (cnt++ == N - 1)	break;

				for (Vertex vertex : g[minVertex.no]) {
					if (!v[minVertex.no] && vertex.edge != 0 && minEdge[minVertex.no] > vertex.edge) {
													   		minEdge[minVertex.no] = vertex.edge;
													   		pq.offer(vertex);
					}
				}
				sb.append(result);
			}
			System.out.println(sb.toString());
			br.close();
		}
	}
}