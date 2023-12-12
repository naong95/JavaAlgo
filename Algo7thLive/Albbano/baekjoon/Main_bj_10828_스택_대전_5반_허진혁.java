package baekjoon;

import java.util.*;
import java.io.*;

/*
push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/
public class Main_bj_10828_스택_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_10828.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();

		StringTokenizer st;
		StringBuilder sb = new StringBuilder("");
		String str = "";
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			str = st.nextToken();
			if (str.equals("push")) {
				s.push(Integer.parseInt(st.nextToken()));
			} else if (str.equals("pop")) {
				if (s.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(s.pop()).append("\n");
				}
			} else if (str.equals("size")) {
				sb.append(s.size()).append("\n");
			} else if (str.equals("empty")) {
				if (s.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else {
				if (s.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(s.peek()).append("\n");
				}
			}
		}
		System.out.println(sb.toString().trim());
		br.close();
	}
}