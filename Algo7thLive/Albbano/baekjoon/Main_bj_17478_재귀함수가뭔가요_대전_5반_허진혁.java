package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_17478_재귀함수가뭔가요_대전_5반_허진혁 {

	static String bar = "";

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_17478.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cnt = Integer.parseInt(br.readLine());

		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		recursion(cnt);

		br.close();
	}

	public static void recursion(int cnt) {
		String tmp = bar;

		if (cnt == 0) {
			System.out.println(tmp + "\"재귀함수가 뭔가요?\"");
			System.out.println(tmp + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			System.out.println(tmp + "라고 답변하였지.");
			return;
		}

		System.out.println(tmp + "\"재귀함수가 뭔가요?\"");
		System.out.println(tmp + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		System.out.println(tmp + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		System.out.println(tmp + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

		bar += "____";
		recursion(cnt - 1);
		System.out.println(tmp + "라고 답변하였지.");
	}
}