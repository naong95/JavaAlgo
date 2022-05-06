package study;

import java.util.*;
import java.io.*;

public class Main_bj_14425_문자열집합_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_14425.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] check = new String[N];
		String[] candi = new String[M];
		int cnt = 0;
		for(int i = 0; i < N; i++) check[i] = br.readLine();
		for(int i = 0; i < M; i++) candi[i] = br.readLine();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(check[i].equals(candi[j])) cnt++;
			}
		}
		System.out.println(cnt);
		br.close();
	}
}