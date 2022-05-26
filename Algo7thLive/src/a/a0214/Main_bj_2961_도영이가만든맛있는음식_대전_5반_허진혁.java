package a.a0214;

import java.io.*;
import java.util.*;

public class Main_bj_2961_도영이가만든맛있는음식_대전_5반_허진혁 {
	static int N, sin[], ssn[], min;
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input_bj_2961.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());// 재료의 개수
		sin = new int[N];
		ssn = new int[N];
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			sin[i] = Integer.parseInt(str[0]);
			ssn[i] = Integer.parseInt(str[1]);
		}

		min = Integer.MAX_VALUE;
		choice(0);
		System.out.println(min);

		br.close();
	}

	public static void choice(int cnt) {

		if (cnt == N) {
			int sinTotal = 1;
			int ssnTotal = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					sinTotal *= sin[i];
					ssnTotal += ssn[i];
				}
			}
			if (sinTotal > 1 && ssnTotal > 0) {
				min = Math.min(min, Math.abs(sinTotal - ssnTotal));
			}
			return;
		}

		isSelected[cnt] = true;
		choice(cnt + 1);
		isSelected[cnt] = false;
		choice(cnt + 1);

	}
}
