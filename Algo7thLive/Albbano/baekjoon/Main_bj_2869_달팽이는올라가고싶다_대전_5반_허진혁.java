package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_2869_달팽이는올라가고싶다_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_2869.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		int ans = (V - B) / (A - B);

		if ((V - B) % (A - B) != 0) {
			ans++;
		}
		System.out.println(ans);
		br.close();
	}
}