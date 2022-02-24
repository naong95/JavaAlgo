package a0222;

import java.util.*;
import java.io.*;

public class MST2_PrimPQTest_sc_vertex {
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
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] g = new int[N][N];
		int[] minEdge = new int[N];
		boolean[] v = new boolean[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				g[i][j] = sc.nextInt();
			}
			minEdge[i] = Integer.MAX_VALUE;
		}

		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		int result = 0, cnt = 0;
		minEdge[0] = 0;
		pq.offer(new Vertex(0, 0));
		while (!pq.isEmpty()) {
			Vertex minVertex = pq.poll();
			if(v[minVertex.no])continue;
			v[minVertex.no] = true;
			result += minVertex.edge;
//			if (++cnt == N) break;
			if (cnt++ == N - 1)
				break;

			for (int i = 0; i < N; i++) {
				if (!v[i] && g[minVertex.no][i] != 0 && minEdge[i] > g[minVertex.no][i]) {
												   		minEdge[i] = g[minVertex.no][i];
												   		pq.offer(new Vertex(i,g[minVertex.no][i]));
				}
			}
		}
		System.out.println(result);
		sc.close();
	}

}
