package a0207;

import java.io.*;
import java.util.*;

public class Main_bj_2493_탑_대전_5반_허진혁 {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input_bj_2493.txt"));
//		Scanner sc = new Scanner(System.in);// 스캐너로 했다가 처음으로 메모리 초과
//		int n = sc.nextInt();// 탑 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input_bj_2493.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Stack<int[]> towers = new Stack<>();// int 배열이 들어갈 스택
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			int t = Integer.parseInt(st.nextToken());// 레이저 발사하는 탑
			while (!towers.isEmpty()) {// 스택 빌때까지
				if (towers.peek()[1] >= t) {
					// [탑 번호, 탑 높이]로 이루어진 배열이므로 스택의 탑의 1번 인덱스는 직전에 푸쉬된 바로 왼쪽 탑
					System.out.print(towers.peek()[0] + " ");// 왼쪽 탑이 더 높다면 출력(레이저 수신 했으므로)
					break;// 바로 탈출(처음 만나는 수신탑의 번호를 구했으므로)
				}
				towers.pop();// 만약 왼쪽 탑이 더 낮다면 팝해서 그 다음 왼쪽 탑과 비교할 수 있도록
			}
			if (towers.isEmpty()) {// 스택이 비었다면(첫번째 탑)
				System.out.print("0 ");// 수신할 탑이 없으므로 바로 0 출력
			}
			towers.push(new int[] { i, t });// [탑 번호, 탑 높이] 푸쉬해서 넣어준다
		}
	}
}
