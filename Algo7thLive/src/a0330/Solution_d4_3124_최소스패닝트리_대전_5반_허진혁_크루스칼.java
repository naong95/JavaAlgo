package a0330;

import java.io.*;
import java.util.*;

public class Solution_d4_3124_최소스패닝트리_대전_5반_허진혁_크루스칼 {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}
	
	static int N;
	static int[] parents;
	static Edge[] edgeList;

	static void makeSet() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = findSet(parents[a]);// path compression
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_3124.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());// 테스트케이스 개수
		StringTokenizer st;
		StringBuilder sb = new StringBuilder("");
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());// 정점의 수
			int E = Integer.parseInt(st.nextToken());// 간선의 수
			edgeList = new Edge[E];
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(from, to, weight);
			}
			
			Arrays.sort(edgeList);
			makeSet();
			
			long result = 0, cnt = 0;
			for(Edge edge : edgeList) {
				if(union(edge.from, edge.to)) {
					result += edge.weight;
					if(++cnt == N - 1) break;
				}
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
		
		br.close();
	}
}