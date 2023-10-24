package baekjoon;

import java.util.*;
import java.io.*;

/*
같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다. 
같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다. 
모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다. 
*/
public class Main_bj_2480_주사위세개_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_2480.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int answer = 0;
		if (f == s && s == t) {
			answer += 10000 + f * 1000;
		} else if (f == s || s == t) {
			answer += 1000 + s * 100;
		} else if (f == t) {
			answer += 1000 + f * 100;
		} else {
			answer += Math.max(f, Math.max(s, t)) * 100;
		}

		System.out.println(answer);
		br.close();
	}
}