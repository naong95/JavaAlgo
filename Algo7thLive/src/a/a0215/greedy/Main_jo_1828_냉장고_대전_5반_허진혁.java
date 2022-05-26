package a.a0215.greedy;

import java.io.*;
import java.util.*;

public class Main_jo_1828_냉장고_대전_5반_허진혁 {

	/**
	 * 정렬을 이용하자
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input_jo_1828.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 화학물질 개수
		int[][] xy = new int[N][2];// 각 화학물질 최저x 최대y 온도 0, 1에 넣는 배열
		int cnt = 1;// 냉장고의 개수는 기본 1개

		for (int i = 0; i < N; i++) {// 최저, 최대 온도 대입
			String[] line = br.readLine().split(" ");
			xy[i][0] = Integer.parseInt(line[0]);
			xy[i][1] = Integer.parseInt(line[1]);
		}
		Arrays.sort(xy, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);// 최고온도를 오름차순으로 정렬
			}// 정렬을 하고 나면 다음 원소의 최저온도가 최고 온도보다 크다면 냉장고를 하나 늘리면 된다
		});
		int max = xy[0][1];// 가장 최고 온도가 작은 첫번째 값을 최댓값으로 설정해주고
		for (int i = 0; i < N; i++) {// max는 바로 전 화학물질의 최고 온도가 된다
			if (xy[i][0] <= max) {// 들어온 화학 물질의 최저온도 보다 max가 크거나 같고
				if (xy[i][1] < max) {// 최고온도보다도 크다면
					max = xy[i][1];// 전 화학물질의 최고 온도 갱신
				}
				continue;// 만약 최고온도가 더 커서 max가 화학 물질의 중간이라면 continue
			} else {// 들어왔던 화학 물질들의 최고 온도보다 새로 들어온 화학물질의 최저 온도가 높다면
				max = xy[i][1];// 최고 온도를 갱신하고 현재 있는 냉장고에는 넣을 수 없으므로
				cnt++;// 냉장고 1개 추가
			}
		}
		System.out.println(cnt);
		br.close();
	}
}