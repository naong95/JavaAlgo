package a.a0224;
import java.util.*;
import java.io.*;

public class DijkstraTest2_PQ_sc_vertex {

	static class Vertex implements Comparable<Vertex> {
		int no, minDistance;// 정점번호, 출발지에서 자신으로의 최소비용

		public Vertex(int no, int minDistance) {
			super();
			this.no = no;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.minDistance - o.minDistance;
		}

	}

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

		PriorityQueue<Vertex> pQueue = new PriorityQueue<>();
		distance[0] = 0;
		pQueue.offer(new Vertex(0, distance[0]));
		while(!pQueue.isEmpty()) {
			Vertex current = pQueue.poll();
			if(v[current.no]) continue;
			
			v[current.no] = true;
			if (current.no == N - 1) break;
			for (int j = 0; j < N; j++) {
				if (!v[j] && g[current.no][j] != 0 && distance[j] > distance[current.no] + g[current.no][j]) {
													  distance[j] = distance[current.no] + g[current.no][j];
													  pQueue.offer(new Vertex(j, distance[j]));
				}
			}
		}
		System.out.println(Arrays.toString(distance));
		sc.close();
	}
}
