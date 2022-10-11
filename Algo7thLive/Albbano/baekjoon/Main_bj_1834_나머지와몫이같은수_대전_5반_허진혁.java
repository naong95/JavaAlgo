package baekjoon;
import java.util.*;
import java.io.*;
/*

*/
public class Main_bj_1834_나머지와몫이같은수_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1834.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Integer.parseInt(br.readLine());
		
		long total = 0l;
		for(int i = 0; i < N; i++) {
			total += N * i + i;
		}
		
		System.out.println(total);
		br.close();
	}
}