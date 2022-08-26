package 무지성백준;
import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
/*
입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 
그 다음 줄부터 각각의 테스트케이스에 대해 첫째 줄에 출발점 (x1, y1)과 도착점 (x2, y2)이 주어진다. 
두 번째 줄에는 행성계의 개수 n이 주어지며, 
세 번째 줄부터 n줄에 걸쳐 행성계의 중점과 반지름 (cx, cy, r)이 주어진다.

각 테스트 케이스에 대해 어린 왕자가 거쳐야 할 최소의 행성계 진입/이탈 횟수를 출력한다.
*/
public class Main_bj_1004_어린왕자 {
	static class star {
		int cx;
		int cy;
		int r;
		public int getCx() {
			return cx;
		}
		public int getCy() {
			return cy;
		}
		public int getR() {
			return r;
		}
		public star(int cx, int cy, int r) {
			this.cx = cx;
			this.cy = cy;
			this.r = r;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("muji/input_bj_1004.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int n = Integer.parseInt(br.readLine());
			star[] sa = new star[n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				sa[i] = new star(cx, cy, r);
			}
			
			for (star star : sa) {
				System.out.println(star.cx + " " + star.cy + " " + star.r);
			}
		}
		
		br.close();
	}
}