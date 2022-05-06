package study;

import java.util.*;
import java.io.*;

public class Main_bj_5525_IOIOI_대전_5반_허진혁2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_5525.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		int len = Integer.parseInt(br.readLine());
		int[] memo = new int[len];
		char[] str = br.readLine().toCharArray();
		for(int i = 1; i < len - 1; i++) {
			if(str[i] == 'O' && str[i + 1] == 'I') {
				memo[i + 1] = memo[i - 1] + 1;
				if(memo[i + 1] >= n && str[i - 2*n + 1] == 'I') cnt++;
			}
		}
		System.out.println(cnt);
		br.close();
	}
}