package a0224;
import java.util.*;
import java.io.*;

public class DijkstraTest2_PQ_sc {
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

		PriorityQueue<int[]> pQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		distance[0] = 0;
		pQueue.offer(new int[] {0, distance[0]});
		while(!pQueue.isEmpty()) {
			int[] current = pQueue.poll();
			if(v[current[0]]) continue;
			
			v[current[0]] = true;
			if (current[0] == N - 1) break;
			for (int j = 0; j < N; j++) {
				if (!v[j] && g[current[0]][j] != 0 && distance[j] > distance[current[0]] + g[current[0]][j]) {
													  distance[j] = distance[current[0]] + g[current[0]][j];
													  pQueue.offer(new int[] {j, distance[j]});
				}
			}
		}
		System.out.println(Arrays.toString(distance));
		sc.close();
	}
}
