package a0224;

import java.util.*;
import java.io.*;

public class DijkstraTest1_sc {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] g = new int[N][N];
		int[] distance = new int[N];
		boolean[] v = new boolean[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				g[i][j] = sc.nextInt();
			}
			distance[i] = Integer.MAX_VALUE;
		}

		distance[0] = 0;
		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int current = 0;
			for (int j = 0; j < N; j++) {
				if (!v[j] && min > distance[j]) {
					         min = distance[j];
					         current = j;
				}
			}
			v[current] = true;
			if (current == N - 1) break;
			for (int j = 0; j < N; j++) {
				if (!v[j] && g[current][j] != 0 && distance[j] > distance[current] + g[current][j]) {
												   distance[j] = distance[current] + g[current][j];
				}
			}
		}
		System.out.println(Arrays.toString(distance));
		System.out.println(distance[N - 1]);
		sc.close();
	}
}
