package a.a0222;

import java.io.*;
import java.util.*;

public class Solution_d4_7465_창용마을무리의개수_대전_5반_허진혁 {
	/**
	 * 
	 */

	static int N;
	static int[] parents;

	public static void makeSet() {
		parents = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			parents[i] = i;
		}
	}

	public static int findSet(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = findSet(parents[a]);
	}

	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_7465.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();// 총 원소 개수
			int M = sc.nextInt();// 연산 횟수
			boolean[] flag = new boolean[N + 1];
			makeSet();
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				union(a, b);
			}
			for (int i = 1; i <= N; i++) {
				flag[findSet(i)] = true;
			}
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if (flag[i])
					cnt++;
			}
			System.out.println("#" + tc + " " + cnt);
		}
		sc.close();
	}
}