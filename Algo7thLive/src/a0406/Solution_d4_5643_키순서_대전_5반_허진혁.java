package a0406;

import java.io.*;
import java.util.*;
/*
첫 줄에 테스트케이스의 개수 T가 주어진다. (1 ≤ T ≤ 15)
각 테스트 케이스의 첫 번째 줄에 학생들의 수 N이 주어진다. (2 ≤ N ≤ 500)
각 테스트 케이스의 두 번째 줄에 두 학생의 키를 비교한 횟수 M이 주어진다. (0 ≤ M ≤ N*(N-1)/2)
각 테스트 케이스의 세 번째 줄부터 M개의 줄에 걸쳐 두 학생의 키를 비교한 결과를 나타내는 두 양의 정수 a, b가 주어진다.
이는 번호가 a인 학생이 번호가 b인 학생보다 키가 작은 것을 의미한다. 이 때, 입력은 항상 모순이 없도록 주어진다.

생각해본 결과 각 노드마다 from과 to를 담는 큐를 만들고
키 순서를 알고자 하는 노드의 from 간선 개수 + to 간선 개수

흠 재귀를 잘 못 쓰는 것 같다
*/
public class Solution_d4_5643_키순서_대전_5반_허진혁 {
	


	static int[][] adjMatrix;
	static int N;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_5643.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			adjMatrix = new int[N+1][N+1];
			
			StringTokenizer st = null;
			int a, b;
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1;
			}
			int answer = 0;
			
			for (int i = 0; i < N; i++) {
				if(gtBFS(i, new boolean[N + 1]) + ltBFS(i, new boolean[N + 1]) == N - 1) ++answer;
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	static int gtBFS(int start, boolean[] v) {
		
		int cnt = 0;
		Queue<Integer> q = new ArrayDeque<>();
		v[start] = true;
		q.offer(start);

		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= N; i++) {// 모든 학생 보면서 자신보다 큰 학생
				if(adjMatrix[cur][i] != 0 && !v[i]) {
					++cnt;
					v[i] = true;
					q.offer(i);
				}
			}
		}
		
		return cnt;
	}
	static int ltBFS(int start, boolean[] v) {
		int cnt = 0;
		Queue<Integer> q = new ArrayDeque<>();
		v[start] = true;
		q.offer(start);

		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= N; i++) {// 모든 학생 보면서 자신보다 작은 학생
				if(adjMatrix[i][cur] != 0 && !v[i]) {
					++cnt;
					v[i] = true;
					q.offer(i);
				}
			}
		}
		
		return cnt;
	}

	
	
	
//	static int N, M, fromEdge, totoEdge;
//	
//	static class Node{
//		Queue<Integer> from;
//		Queue<Integer> to;
//		public Node(Queue<Integer> from, Queue<Integer> to) {
//			super();
//			this.from = from;
//			this.to = to;
//		}
//	}
//	static Node[] nodes;
//	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input_d4_5643.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
//		for (int tc = 1; tc <= T; tc++) {
//			int ans = 0;
//			N = Integer.parseInt(br.readLine());// 학생 수
//			M = Integer.parseInt(br.readLine());// 비교 횟수
//			nodes = new Node[N + 1];
//			for(int i = 1; i <= N; i++) nodes[i] = new Node(new ArrayDeque<>(), new ArrayDeque<>());
//			StringTokenizer st;
//			for(int i = 0; i < M; i++) {
//				st = new StringTokenizer(br.readLine(), " ");
//				int from = Integer.parseInt(st.nextToken());
//				int toto = Integer.parseInt(st.nextToken());
//				nodes[from].to.offer(toto);// from은 to 보다 작다
//				nodes[toto].from.offer(from);// to는 from 보다 크다
//			}
//			// 노드 각각의 간선 다 넣어주었으므로 노드 배열 for문으로 돌면서 개수 체크
//			for(int i = 1; i <= N; i++) {
//				fromEdge = 0;
//				fromCount(nodes, i);
//				System.out.println(fromEdge);
//			}
//		}
//		br.close();
//	}
//	
//	private static void fromCount(Node[] nodeArr, int index) {
//		if(nodeArr[index].from.isEmpty()) return;
//		
//		fromEdge++;
//		fromCount(nodeArr, nodeArr[index].from.poll());
//	}
}