package study;

import java.util.*;
import java.io.*;
/*
석환이는 응애다.

1. x번 카드와 y번 카드를 골라 그 두 장에 쓰여진 수를 더한 값을 계산한다. (x ≠ y)
2. 계산한 값을 x번 카드와 y번 카드 두 장 모두에 덮어 쓴다.

이 카드 합체를 총 m번 하면 놀이가 끝난다. m번의 합체를 모두 끝낸 뒤,
n장의 카드에 쓰여있는 수를 모두 더한 값이 이 놀이의 점수가 된다.
이 점수를 가장 작게 만드는 것이 놀이의 목표이다.
*/
public class Main_bj_15903_카드합체놀이_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_15903.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());// 카드의 개수
		int M = Integer.parseInt(st.nextToken());// 합체 횟수
		
		st = new StringTokenizer(br.readLine(), " ");
		long card[] = new long[N];
		for(int i = 0; i < N; i++) card[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < M; i++) {
			Arrays.sort(card);
			long nCard = card[0] + card[1];
			card[0] = nCard;
			card[1] = nCard;
		}
		long sum = 0;
		for(int i = 0; i < N; i++) sum += card[i];
		System.out.println(sum);
		br.close();
	}
}