package baekjoon;
import java.util.*;
import java.io.*;
/*
격자 크기
사과 위치
회전 수 (L왼쪽 90도 D오른쪽 90도)

벽에 부딪히거나 몸에 닿으면 게임 종료
사과를 먹으면 꼬리가 하나 늘어남
*/
public class Main_bj_3190_뱀_대전_5반_허진혁 {
	
	public static class Snake {
		Queue<int[]> body;
		int[] head;
		int[] tail;
		
		public Snake(Queue<int[]> b, int[] h, int[] t) {
			this.body = b;
			this.head = h;
			this.tail = t;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_3190.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int A = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < A; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
		}
		Queue<int[]> b = new ArrayDeque<int[]>();
		int[] h = new int[] {0, 0};
		int[] t = new int[] {0, 0};
		b.offer(h);
		b.offer(t);
		Snake snake = new Snake(b, h, t);
		Map<Integer, String> direction = new HashMap<>();
		int D = Integer.parseInt(br.readLine());
		for(int i = 0; i < D; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sec = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			direction.put(sec, dir);
		}
		int d = 0; // 0right 1down 2left 3up
		int second = 0;
		while(true) {
			second++;
			if(direction.containsKey(second)) {
				if(direction.get(second).equals("D")) {
					d = (d + 1) % 4;
				} else {
					d = Math.abs((d - 1) % 4);
				}
			}
			break;
		}
		System.out.println(second);
		br.close();
	}
}