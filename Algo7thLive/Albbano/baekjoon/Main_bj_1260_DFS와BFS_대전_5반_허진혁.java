package baekjoon;
import java.util.*;
import java.io.*;
/*

*/
public class Main_bj_1260_DFS와BFS_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1260.txt")); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[r][c] = 1;
		}
		
		for(int[] arr : map) {
			System.out.println(Arrays.toString(arr));
		}
		
		br.close();
	}
}