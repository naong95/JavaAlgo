package a.a0210.treebfsdfs;

import java.io.*;
import java.util.*;

public class BfsDfs {

	static int[] di = { -1, 0, 1, 0 };// 상우하좌
	static int[] dj = { 0, 1, 0, -1 };
	static int N = 5, C;
	static int[][] a;
	static boolean[][] v;

	static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		v[i][j] = true;
		q.offer(new int[] { i, j });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			i = cur[0];
			j = cur[1];
			a[i][j] = C++;// 대입 후 1증가
			for (int[] ia : a) {
				for (int nums : ia) {
					System.out.print(nums + "\t");
				}
				System.out.println();
				System.out.println();
			}
			System.out.println();
			for (int d = 0; d < 4; d++) {// 4방 탐색(순서는 상우하좌)
				int ni = i + di[d];
				int nj = j + dj[d];
				if (0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj]) {
					v[ni][nj] = true;// 방문처리 후에
					q.offer(new int[] { ni, nj });// 큐에 삽입
				}
			}
		}
	}

	static void dfs(int i, int j) {
		v[i][j] = true;
		a[i][j] = C++;// 대입 후 1증가
		for (int[] ia : a) {
			for (int nums : ia) {
				System.out.print(nums + "\t");
			}
			System.out.println();
			System.out.println();
		}	
		System.out.println();
		for (int d = 0; d < 4; d++) {// 4방 탐색(순서는 상우하좌)
			int ni = i + di[d];
			int nj = j + dj[d];
			if (0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj]) {
				dfs(ni, nj);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		a = new int[N][N];
		v = new boolean[N][N];
		C = 1;

		bfs(N / 2, N / 2);
	}
}
