package study;

import java.util.*;
import java.io.*;

public class Main_bj_5525_IOIOI_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_5525.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = 2*n + 1;
		int cnt = 0;
		StringBuilder sb = new StringBuilder("I");
		for (int i = 0; i < n; i++) sb.append("OI");
		int len = Integer.parseInt(br.readLine());
		String str = br.readLine();
		for(int i = 0; i < len - k; i++) if(str.substring(i, i + k).equals(sb.toString())) cnt++;
		System.out.println(cnt);
		br.close();
	}
}