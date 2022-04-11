package a0411;

import java.io.*;
import java.util.*;

/*

*/
public class Solution_d4_8458_원점으로집합_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_8458.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		next: for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] a = new int[N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				a[i] = Math.abs(Integer.parseInt(st.nextToken()) + Math.abs(Integer.parseInt(st.nextToken())));
				max = Math.max(max, a[i]);
			}
			for (int i = 1; i < N; i++) {
				if ((a[0] % 2) != (a[i] % 2)) {
					System.out.println("#" + tc + " -1");
					continue next;
				}
			}
			int sum = 0;
			for (int i = 0;; i++) {
				sum += i;
				if(sum >= max && (sum%2) == (max%2)) {
					System.out.println("#" + tc + " " + i);
					break;
				}
			}
		}
		br.close();
	}
}