package study;

import java.util.*;
import java.io.*;

public class Main_bj_17413_단어뒤집기2_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_17413.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		Stack<Character> reverse = new Stack<>();
		Queue<Character> check = new ArrayDeque<>();
		for (int i = 0; i < str.length; i++)
			check.offer(str[i]);
		while (!check.isEmpty()) {
			if (check.peek() == '<') {
				while (check.peek() != '>') {
					sb.append(check.poll());
				}
				sb.append(check.poll());
			} else {
				while (!check.isEmpty() && check.peek() != '<' && check.peek() != ' ') {
					reverse.push(check.poll());
				}
				while (!reverse.isEmpty())
					sb.append(reverse.pop());
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}