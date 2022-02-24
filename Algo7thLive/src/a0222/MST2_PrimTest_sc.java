package a0222;

import java.util.*;
import java.io.*;

public class MST2_PrimTest_sc {

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

		int result = 0, cnt =0;
		minEdge[0] = 0;
		for (int c = 0; c < N; c++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			for (int i = 0; i < N; i++) {
				if (!v[i] && min > minEdge[i]) {
						     min = minEdge[i];
						     minVertex = i;
				}
			}
			v[minVertex] = true;
			result += min;
//			if (++cnt == N) break;
			if (cnt++ == N - 1) break;

			for (int i = 0; i < N; i++) {
				if (!v[i] && g[minVertex][i] != 0 && minEdge[i] > g[minVertex][i]) {
					 							     minEdge[i] = g[minVertex][i];
				}
			}
		}
		System.out.println(result);
		sc.close();
	}

}
