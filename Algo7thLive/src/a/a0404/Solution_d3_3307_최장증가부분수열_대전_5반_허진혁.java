package a.a0404;

import java.io.*;
import java.util.*;

public class Solution_d3_3307_최장증가부분수열_대전_5반_허진혁 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_3307.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());// 테스트케이스 개수
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] ia = new int[N];
			int[] LIS = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) ia[i] = Integer.parseInt(st.nextToken());
			
			int ans = 0;
			for(int i = 0; i < N; i++) {
				LIS[i] = 1;
				for(int j = 0; j < i; j++) {
					if(ia[j] < ia[i] && LIS[i] < LIS[j] + 1)
									    LIS[i] = LIS[j] + 1;
				}
				if(ans < LIS[i])
				   ans = LIS[i];
			}
			System.out.println("#" + tc + " " + ans);
		}
		br.close();
	}
}