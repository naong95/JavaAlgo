package a.a0215.greedy;

import java.io.*;
import java.util.*;

public class Main_bj_1074_Z_대전_5반_허진혁 {

	/**
	 * 처음에는 그림과 똑같은 2차원 배열을 만드려고 했는데 그러면 너무 어렵고 굳이 2차원 배열을 완성할 필요가 없다 찾아야 하는 원소가 4
	 * 사분면 중 어디에 있는지 다시 그 사분면 배열에서 4 사분면 중 어디에 있는지 다시 그 사분면 배열에서 4 사분면 중 어디에... 2시간
	 * 고민했는데 절대 못 떠올린다 - > 구글링 후 이해한 내용 주석 첨부 
	 * 마트료시카를 떠올리면 좋을 것 같다
	 */
	static int N, size, value;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input_bj_1074.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);// 격자 크기
		int r = Integer.parseInt(line[1]);// 행
		int c = Integer.parseInt(line[2]);// 열
		size = (int) Math.pow(2, N);
		Z(size, r, c);
		System.out.println(value);
		br.close();
	}

	public static void Z(int size, int r, int c) {

//		0	|	1
//		----*----
//		2	|	3

		if (size == 1)// 사분면을 찾는거라 2로 계속 나누기 때문에 크기가 1이 되면 찾고자 하는 곳이므로
			return;// 리턴

		if (r < size / 2 && c < size / 2) {// 0 사분면
			Z(size / 2, r, c);
		} else if (r < size / 2 && c >= size / 2) {// 1사분면
			value += size * size / 4;// 1사분면에 있다면 0사분면을 z로 훑고 지나왔을 것이므로 사분면 1개의 원소 개수만큼 더한다
			Z(size / 2, r, c - size / 2);// 다시 작은 사이즈의 0사분면으로 보내야 함으로 오른쪽에 있는 것을 왼쪽으로 사분면 크기만큼 이동
		} else if (r >= size / 2 && c < size / 2) {// 2사분면
			value += (size * size / 4) * 2;// 사분면 2개를 훑고 왔기 때문에
			Z(size / 2, r - size / 2, c);// 기준 사분면으로 아래쪽이기 때문에 위로 올려준다
		} else {// 3 사분면
			value += (size * size / 4) * 3;// 사분면 3개
			Z(size / 2, r - size / 2, c - size / 2);// 왼쪽 대각선 위로 올려주기
		}
	}
}