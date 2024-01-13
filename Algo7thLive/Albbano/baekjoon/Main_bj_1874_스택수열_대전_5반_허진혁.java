package baekjoon;
import java.util.*;
import java.io.*;
/*

*/
public class Main_bj_1874_스택수열_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1874.txt")); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		StringBuilder sb = new StringBuilder("");
		
		Stack<Integer> s = new Stack<>();
		for(int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 1; i < n+1; i++) {
			if(!s.isEmpty()) {
				if(s.peek() == arr[i]) {
					s.pop();
					sb.append("-").append("\n");
				} else {
					s.push(i);
					sb.append("+").append("\n");
				}
			} else {
				s.push(i);
				sb.append("+").append("\n");
			}
		}
		
		System.out.println(s);
		System.out.println(sb.toString());
		br.close();
	}
}