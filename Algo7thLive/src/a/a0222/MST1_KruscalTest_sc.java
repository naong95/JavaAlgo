package a.a0222;

import java.util.*;
import java.io.*;

public class MST1_KruscalTest_sc {
	static int N;
	static int[] parents;
	static int[][] edgeList;

	static void makeSet() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
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
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		edgeList = new int[E][3];
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			edgeList[i] = new int[] { from, to, weight };
		}

		Arrays.sort(edgeList, (o1, o2) -> Integer.compare(o1[2], o2[2]));
		makeSet();

		int result = 0, cnt = 0;
		for (int[] edge : edgeList) {
			if (union(edge[0], edge[1])) {
				result += edge[2];
				if (++cnt == N - 1)
					break;
			}
		}
		System.out.println(result);
	}
}
