package a0222;

import java.util.*;
import java.io.*;

public class MST2_PrimPQTest_sc {
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

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) ->Integer.compare(o1[1], o2[1]));
		int result = 0, cnt = 0;
		minEdge[0] = 0;
		pq.offer(new int[] {0, 0});
		while (!pq.isEmpty()) {
			int[] minVertex = pq.poll();
			if(v[minVertex[0]])continue;
			
			v[minVertex[0]] = true;
			result += minVertex[1];
//			if (++cnt == N) break;
			if (cnt++ == N - 1)
				break;

			for (int i = 0; i < N; i++) {
				if (!v[i] && g[minVertex[0]][i] != 0 && minEdge[i] > g[minVertex[0]][i]) {
												   		minEdge[i] = g[minVertex[0]][i];
												   		pq.offer(new int[] {i,g[minVertex[0]][i]});
				}
			}
		}
		System.out.println(result);
		sc.close();
	}

}
