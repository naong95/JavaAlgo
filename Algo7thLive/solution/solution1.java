import java.util.*;
import java.io.*;

public class solution1 {
	public static final int MAX_N = 31;
	public static final int MAX_L = 41;

	public static int l, n, q;
	public static int[][] info = new int[MAX_L][MAX_L];
	public static int[] bef_k = new int[MAX_N];
	public static int[] r = new int[MAX_N], c = new int[MAX_N], h = new int[MAX_N], w = new int[MAX_N],
			k = new int[MAX_N];
	public static int[] nr = new int[MAX_N], nc = new int[MAX_N];
	public static int[] dmg = new int[MAX_N];
	public static boolean[] is_moved = new boolean[MAX_N];

	public static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };

	public static boolean tryMovement(int idx, int dir) {
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			dmg[i] = 0;
			is_moved[i] = false;
			nr[i] = r[i];
			nc[i] = c[i];
		}

		q.add(idx);
		is_moved[idx] = true;

		while (!q.isEmpty()) {
			int t = q.poll();

			nr[t] += dr[dir];
			nc[t] += dc[dir];

			if (nr[t] < 1 || nc[t] < 1 || nr[t] + h[t] - 1 > l || nc[t] + w[t] - 1 > l) {
				return false;
			}

			for (int i = nr[t]; i <= nr[t] + h[t] - 1; i++) {
				for (int j = nc[t]; j <= nc[t] + w[t] - 1; j++) {
					if (info[i][j] == 1)
						dmg[t]++;
					if (info[i][j] == 2)
						return false;
				}
			}

			for (int i = 1; i <= n; i++) {
				if (is_moved[i] || k[i] <= 0)
					continue;
				if (r[i] > nr[t] + h[t] - 1 || nr[t] > r[i] + h[i] - 1)
					continue;
				if (c[i] > nc[t] + w[t] - 1 || nc[t] > c[i] + w[i] - 1)
					continue;

				is_moved[i] = true;
				q.add(i);
			}
		}

		dmg[idx] = 0;
		return true;
	}

	public static void movePiece(int idx, int dir) {
		if (k[idx] <= 0)
			return;

		if (tryMovement(idx, dir)) {
			for (int i = 1; i <= n; i++) {
				r[i] = nr[i];
				c[i] = nc[i];
				k[i] -= dmg[i];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		l = sc.nextInt();
		n = sc.nextInt();
		q = sc.nextInt();

		for (int i = 1; i <= l; i++) {
			for (int j = 1; j <= l; j++) {
				info[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= n; i++) {
			r[i] = sc.nextInt();
			c[i] = sc.nextInt();
			h[i] = sc.nextInt();
			w[i] = sc.nextInt();
			k[i] = sc.nextInt();
			bef_k[i] = k[i];
		}

		for (int i = 1; i <= q; i++) {
			int idx = sc.nextInt();
			int dir = sc.nextInt();
			movePiece(idx, dir);
		}

		long ans = 0;
		for (int i = 1; i <= n; i++) {
			if (k[i] > 0) {
				ans += bef_k[i] - k[i];
			}
		}

		System.out.println(ans);
		sc.close();
	}
}