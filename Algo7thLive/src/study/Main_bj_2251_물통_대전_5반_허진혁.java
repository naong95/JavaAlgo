package study;
import java.util.*;
import java.io.*;
/*
각각 부피가 A, B, C(1≤A, B, C≤200) 리터인 세 개의 물통이 있다.
처음에는 앞의 두 물통은 비어 있고, 세 번째 물통은 가득(C 리터) 차 있다.
이제 어떤 물통에 들어있는 물을 다른 물통으로 쏟아 부을 수 있는데,
이때에는 한 물통이 비거나, 다른 한 물통이 가득 찰 때까지 물을 부을 수 있다.
이 과정에서 손실되는 물은 없다고 가정한다.

이와 같은 과정을 거치다보면 세 번째 물통(용량이 C인)에 담겨있는 물의 양이 변할 수도 있다.
첫 번째 물통(용량이 A인)이 비어 있을 때,
세 번째 물통(용량이 C인)에 담겨있을 수 있는 물의 양을 모두 구해내는 프로그램을 작성하시오.

첫째 줄에 세 정수 A, B, C가 주어진다.
*/
public class Main_bj_2251_물통_대전_5반_허진혁 {
	static int[] bucket;
	static boolean[][] v;
	static Set<Integer> answer;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2251.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		bucket = new int[3];
		v = new boolean[201][201];
		for (int i = 0; i < 3; i++) bucket[i] = Integer.parseInt(st.nextToken());
		answer = new TreeSet<>();
		dfs(0, 0, bucket[2]);
		for (int i : answer) System.out.print(i + " ");
		br.close();
	}
	private static void dfs(int first, int second, int third) {
		if(v[first][second]) return;
		if(first == 0) {
			answer.add(third);
		}
		v[first][second] = true;
		
		// 0 -> 1
		if(first + second > bucket[1]) dfs((first + second) - bucket[1], bucket[1], third);
		else						   dfs(0, first + second, third); 
		// 1 -> 0
		if(first + second > bucket[0]) dfs(bucket[0], first + second - bucket[0], third);
		else						   dfs(first + second, 0, third); 
		// 2 -> 0
		if(first + third > bucket[0])  dfs(bucket[0], second, first + third - bucket[0]);
		else						   dfs(first + third, second, 0); 
		// 2 -> 1
		if(second + third > bucket[1]) dfs(first, bucket[1], second + third - bucket[1]);
		else						   dfs(first, second + third, 0);
		
		dfs(first, 0, second + third);
		dfs(0, second, first + third);
	}
	
	
}