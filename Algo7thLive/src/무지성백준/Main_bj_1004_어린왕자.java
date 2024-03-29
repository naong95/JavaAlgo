package 무지성백준;
import java.util.*;
import java.io.*;
/*
입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 
그 다음 줄부터 각각의 테스트케이스에 대해 첫째 줄에 출발점 (x1, y1)과 도착점 (x2, y2)이 주어진다. 
두 번째 줄에는 행성계의 개수 n이 주어지며, 
세 번째 줄부터 n줄에 걸쳐 행성계의 중점과 반지름 (cx, cy, r)이 주어진다.

각 테스트 케이스에 대해 어린 왕자가 거쳐야 할 최소의 행성계 진입/이탈 횟수를 출력한다.

출발점과 도착점을 모든 원에 대입해보고 외부인지 내부인지 판단 내부에 있다면
출발점 입장에서는 이탈 횟수 + 1, 도착점 입장에서는 진입 횟수 + 1
이탈과 진입의 횟수를 구분하지 않으므로 원 내부 라면 +1을 해주자.
*/
public class Main_bj_1004_어린왕자 {
	static class star {
		int cx;
		int cy;
		int r;
		
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
			int ans = 0;
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				sa[i] = new star(cx, cy, r);
			}
			boolean[] chks = new boolean[n];
			boolean[] chkd = new boolean[n];
			for(int i = 0; i < n; i++) {
				if(area(x1, y1, sa[i]) == 1) chks[i] = true;
				if(area(x2, y2, sa[i]) == 1) chkd[i] = true;
			}
			for(int i = 0; i < n; i++) {
				if(chks[i] != chkd[i]) ans++;
			}
			System.out.println(ans);
		}
		
		br.close();
	}
	static int area(int x, int y, star s) {// 원 내부(1)인지 외부(0)인지
		if(Math.pow(s.cx - x, 2) + Math.pow(s.cy - y, 2) < Math.pow(s.r, 2)) return 1;
		else return 0;
	}
}