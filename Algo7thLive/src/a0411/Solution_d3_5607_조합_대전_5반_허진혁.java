package a0411;

import java.io.*;
import java.util.*;

/*

*/
public class Solution_d3_5607_조합_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_5607.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			System.out.println("#" + tc + " " + nCr(n, r, 1234567891));
		}
		br.close();
	}

	public static long nCr(int n, int r, int p) {
		if (r == 0)
			return 1L;
		long[] fac = new long[n + 1];
		fac[0] = 1;
		for (int i = 1; i <= n; i++) {
			fac[i] = fac[i - 1] * i % p;
		}
		return (fac[n] * power(fac[r], p - 2, p) % p * power(fac[n - r], p - 2, p) % p) % p;
	}

	private static long power(long x, int y, int p) {
		long res = 1L;
		x = x % p;
		while (y > 0) {
			if (y % 2 == 1)
				res = (res * x) % p;
			y = y >> 1;
			x = (x * x) % p;
		}

		return res;
	}
}