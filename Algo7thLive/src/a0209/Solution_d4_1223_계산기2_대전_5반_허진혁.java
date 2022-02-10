package a0209;

import java.io.*;
import java.util.*;

public class Solution_d4_1223_계산기2_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input_d4_1223.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			String[] middle = br.readLine().split("");
			ArrayList<Object> back = new ArrayList<>();
			ArrayDeque<Character> cals = new ArrayDeque<>();
			for (int i = 0; i < N; i++) {// 중위 표기식을 후위 표기식으로 바꾸는 작업
				String str = middle[i];
				if (str.equals("*")) {// 연산 순위가 가장 높으므로 스택에 푸쉬
					cals.push(str.charAt(0));
				} else if (str.equals("+")) {// 연산 순위가 낮으므로 그 전에 쌓였던 연산자 다 꺼내고 푸쉬
					while (!cals.isEmpty()) {
						back.add(cals.pop());
					}
					cals.push(str.charAt(0));
				} else// 숫자라면 그냥 식에 대입
					back.add(Integer.parseInt(str));
			}
			while (!cals.isEmpty()) {// 마지막 남은 연산자들 다 꺼내서 식에 붙여주기
				back.add(cals.pop());
			}
			Stack<Long> stack = new Stack<>();
			for (int i = 0; i < N; i++) {
				Object o = back.get(i);
				if (o instanceof Integer) {// 정수라면 ? 그냥 푸쉬
					int num = (Integer) o;
					stack.push((long) num);
				} else {// 연산자라면 두 개 거꾸로 꺼내서 연산
					long b = stack.pop();
					long a = stack.pop();
					char oc = (char) o;
					if (oc == '*')
						stack.push(a * b);
					else if (oc == '+')
						stack.push(a + b);
				}
			}
			System.out.println("#" + test_case + " " + stack.pop());
		}
		br.close();
	}
}
