package baekjoon;
import java.util.*;
import java.io.*;
/*

*/
public class Main_bj_30980_여중생파댕이와공부를_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_30980.txt")); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[3*n][8*m];
		
		for(int i = 0; i < 3*n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		Queue<int[]> q = new ArrayDeque<>();
		for(int i = 0; i < 3*n; i++) {
			for(int j = 0; j < 8*m; j++) {
				if(map[i][j] == '+') {
					q.offer(new int[] {i, j});
				}
			}
		}
		
		br.close();
	}
}