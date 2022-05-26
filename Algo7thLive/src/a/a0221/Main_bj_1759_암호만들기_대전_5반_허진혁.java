package a.a0221;

import java.io.*;
import java.util.*;

public class Main_bj_1759_암호만들기_대전_5반_허진혁 {
	/**
	 * 최소 1개의 모음, 최소 2개의 자음, 사전 순으로
	 */
	static int L, C;
	static String[] input;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1759.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());// 암호의 길이
		C = Integer.parseInt(st.nextToken());// 사용할 수 있는 문자의 개수
		input = br.readLine().split(" ");
		Arrays.sort(input);// 정렬
		dfs("", 0, 0, 0);
		br.close();
	}

	public static void dfs(String password, int cnt, int mo, int ja) {
		if (cnt == C) {// 사용할 수 있는 문자의 개수만큼 돌았다면
			if (password.length() == L && mo >= 1 && ja >= 2) {// 모음이 한 개 이상 자음이 두 개 이상이면
				System.out.println(password);// 출력
			}
			return;
		}
		String current = input[cnt];// 현재에 카운트 인덱스에 있는 문자 넣어주고

		if ("aeiou".contains(current)) {// 현재 문자가 모음이라면
			dfs(password + current, cnt + 1, mo + 1, ja);// 현재 문자를 포함, 모음 개수 증가
			dfs(password, cnt + 1, mo, ja);// 현재 문자를 미포함
		} else {// 자음이라면
			dfs(password + current, cnt + 1, mo, ja + 1);
			dfs(password, cnt + 1, mo, ja);
		}
	}

}