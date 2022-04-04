package a0404;

import java.io.*;
import java.util.*;

public class Solution_d3_3282_01Knapsack_대전_5반_허진혁 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_3282.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());// 테스트케이스 개수
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			int[] weights = new int[N+1];
			int[] profits = new int[N+1];
			
			int[][] results = new int[N+1][N+1];
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				weights[i] = Integer.parseInt(st.nextToken());
				profits[i] = Integer.parseInt(st.nextToken());
			}
			int itemWeight = 0, itemBenefit = 0;
			for (int item = 1; item <= N; item++) {
				itemWeight = weights[item];
				itemBenefit = profits[item];
				
				for(int weight = 1; weight <= W; weight++) {
					if(itemWeight <= weight) {
						results[item][weight] = Math.max(results[item-1][weight], itemBenefit+results[item-1][weight-itemWeight]);
					}else {
						results[item][weight] = results[item-1][weight];
					}
				}
			}
			System.out.println(results[N][W]);
		}
		br.close();
	}
}