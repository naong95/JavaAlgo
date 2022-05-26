package a.a0204;

import java.io.*;
import java.util.*;

public class Main_bj_1244_스위치켜고끄기_대전_5반_허진혁 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1244.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// 스위치 개수
		int[] sw = new int[n];// 스위치 행렬
		for (int i = 0; i < n; i++) {
			sw[i] = sc.nextInt();
		}

		int m = sc.nextInt();// 학생 수

		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();// 학생 성별
			int num = sc.nextInt();// 부여받은 번호
			int cnt = num;
			if (s == 1) {
				while (num <= n) {
					sw[num - 1] = (sw[num - 1] == 1) ? 0 : 1;
					num += cnt;
				}
			} // 남자면 번호의 배수 스위치들 전환
			else if (s == 2) {
				int left = num - 1;// 인덱스에서 왼쪽
				int right = num - 1;// 인덱스에서 오른쪽
				sw[num - 1] = (sw[num - 1] == 1) ? 0 : 1;
				while (left > 0 && (n - 1) > right) {
					left--;
					right++;
					if (sw[left] == sw[right]) {
						sw[left] = (sw[left] == 1) ? 0 : 1;
						sw[right] = (sw[right] == 1) ? 0 : 1;
					}else break;
				}
			} // 여자면 번호 양 옆으로 대칭이면 모두 전환
		}
		for (int i = 0; i < n; i++) {
			System.out.print(sw[i] + " ");
			if ((i + 1) % 20 == 0) {
				System.out.println();
			}
		}

		sc.close();
	}

}
