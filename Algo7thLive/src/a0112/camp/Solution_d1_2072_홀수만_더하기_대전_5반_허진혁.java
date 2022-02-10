package a0112.camp;

import java.io.*;
import java.util.*;

public class Solution_d1_2072_홀수만_더하기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d1_2072.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++){
			int total = 0;
			for(int i = 0; i < 10; i++) {
				int a = sc.nextInt();
				if(a % 2 == 1) {
					total = total + a;
				}
			}
			System.out.println("#" + tc + " " + total);
		}
		sc.close();
	}
}
