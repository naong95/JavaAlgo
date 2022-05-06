package study;

import java.util.*;
import java.io.*;
/*
첫째 줄에 테스트 케이스의 개수 T가 주어진다. T는 1000보다 작거나 같은 자연수이다.
둘째 줄부터 T개의 줄에 각각의 종이가 어떻게 접혀있는지가 주어진다.
종이의 정보는 문자열로 주어지며, 1은 위의 그림에서 OUT을 의미하고 0은 위의 그림에서 IN을 의미한다.
예를 들어, 위의 그림과 같은 모양은 100으로 나타낼 수 있다.
문자열의 길이는 3000보다 작으며, 항상 2N-1꼴이다. (N ≥ 1)
*/
public class Main_bj_1802_종이접기_대전_5반_허진혁 {
	
	static boolean answer;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1802.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			String paper = br.readLine();
			answer = true;
			접어버리기(paper);
			if(answer) System.out.println("YES");
			else System.out.println("NO");
		}
		br.close();
	}
	private static void 접어버리기(String str) {
		int len = str.length();// 7
		if(len == 0) return;
		int middle = len / 2;// 3
		for(int i = 1; i <= middle; i++) {
			if(str.charAt(middle - i) == str.charAt(middle + i)) {
				answer = false;
				break;
			}
		}
		접어버리기(str.substring(0, middle));
		접어버리기(str.substring(middle + 1, str.length()));
	}
}