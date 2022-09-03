package 무지성백준;
import java.util.*;
import java.io.*;
/*
이상하게도 가장 가중치가 큰 길을 따라가자 시작 노드랑 끝 노드 가중치는 기본으로 더한다.
*/
public class Main_bj_1005_ACMCraft {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("muji/input_bj_1005.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st;
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());// node
			int K = Integer.parseInt(st.nextToken());// edge
			int[] weight = new int[N + 1];
			int[][] edge = new int[N + 1][N + 1];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= N; i++) weight[i] = Integer.parseInt(st.nextToken());
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				edge[r][c] = 1;
				edge[c][r] = 1;
			}
			int W = Integer.parseInt(br.readLine());
			System.out.println(Arrays.toString(weight));
			System.out.println(Arrays.toString(edge[W]));
			int ans = weight[W];
			System.out.println(ans);
			
		}
		br.close();
	}
}