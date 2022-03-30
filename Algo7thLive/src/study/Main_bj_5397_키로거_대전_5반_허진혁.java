package study;

import java.util.*;

import javax.xml.transform.Source;

import java.io.*;
/*
커서의 인덱스를 계속 업데이트
<>: 화살표 방향으로 커서 이동(인덱스 -1, +1)
-: 현재 커서에 글자가 있다면 삭제
삭제가 일어나므로 링크드리스트를 쓰자 -> 인덱스 넘어가는 것 관리가 힘들다

스택을 쓰면 인덱스 관리가 필요 없다
*/
public class Main_bj_5397_키로거_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_5397.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb;
		for(int t = 1; t <= T; t++) {
			String key = br.readLine();
			sb = new StringBuilder();
			Stack<Character> front = new Stack<>();
			Stack<Character> back = new Stack<>();
			
			for(int i = 0; i < key.length(); i++) {
				switch(key.charAt(i)) {
					case '<': if(!front.isEmpty()) back.push(front.pop()); break;
					case '>': if(!back.isEmpty()) front.push(back.pop()); break;
					case '-': if(!front.isEmpty()) front.pop(); break;
					default: front.push(key.charAt(i)); break;
				}
			}
			while(!back.isEmpty()) front.push(back.pop());
//			System.out.println(front);
			for(int i = 0; i < front.size(); i++) sb.append(front.elementAt(i));
			System.out.println(sb.toString());
		}
		br.close();
	}
}