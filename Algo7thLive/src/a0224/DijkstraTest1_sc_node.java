package a0224;

import java.util.*;
import java.io.*;

public class DijkstraTest1_sc_node {
	static class Node {
		int vertex, cost;
		Node link;

		public Node(int vertex, int cost, Node link) {
			super();
			this.vertex = vertex;
			this.cost = cost;
			this.link = link;
		}
		@Override
		public String toString() {
			return (char)(vertex+'A')+"("+vertex+")->"+link;
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int E = sc.nextInt();
		Node[] g = new Node[N];
		int[] distance = new int[N];
		for (int i = 0; i < N; i++) distance[i] = Integer.MAX_VALUE;
		boolean[] v = new boolean[N];
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			g[from] = new Node (to, cost, g[from]);
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
			
			for (Node j = g[current]; j !=null; j = j.link) {
				if (!v[j.vertex] && distance[j.vertex] > distance[current] + j.cost) {
									distance[j.vertex] = distance[current] + j.cost;
				}
			}
		}
		System.out.println(Arrays.toString(distance));
		System.out.println(distance[N - 1]);
		sc.close();
	}
}
