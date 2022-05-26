package a.a0224;

import java.util.*;
import java.io.*;

public class DijkstraTest1_sc_list {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int E = sc.nextInt();
		List<int[]>[] g = new List[N];
		for (int i = 0; i < N; i++) g[i] = new ArrayList<int[]>();
		int[] distance = new int[N];
		for (int i = 0; i < N; i++) distance[i] = Integer.MAX_VALUE;
		boolean[] v = new boolean[N];
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			g[from].add(new int[] {to, cost});
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
			for (int[] j : g[current]) {
				if (!v[j[0]] && distance[j[0]] > distance[current] + j[1]) {
								distance[j[0]] = distance[current] + j[1];
				}
			}
		}
		System.out.println(Arrays.toString(distance));
		System.out.println(distance[N - 1]);
		sc.close();
	}
}
