package a0208;

import java.io.*;
import java.util.*;

public class Solution_d3_1215_암호생성기_대전_5반_허진혁 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1215.txt"));
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = sc.nextInt();// 한 줄 날리기
			ArrayDeque<Integer> ad = new ArrayDeque<>();

			for (int i = 0; i < 8; i++) {
				ad.offer(sc.nextInt());
			}
			int tmp = 1;
			while (tmp > 0) {// tmp가 0보다 클때까지
				for(int i = 1; i <= 5; i++) {// 5를 빼주면 1사이클이 끝나므로
					tmp = ad.poll() - i;// tmp에 큐 맨 앞에서 i를 뺀 값을 넣고
					if(tmp <= 0) {// 그게 0이하라면
						tmp = 0;// 0으로 해주고
						ad.offer(tmp);// 마지막에 대입 후
						break;// 중단
					}
					ad.offer(tmp);// 양수라면 마지막에 대입
				}
			}
			
			System.out.print("#" + test_case + " ");
			for(int i = 0; i < 8; i++) {
				System.out.print(ad.poll() + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
