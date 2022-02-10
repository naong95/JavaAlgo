package a0203.iorecursive;

import java.io.*;
import java.util.*;

/*
3
홍길동 65 170.2
손오공 59 159.9
강호동 70 175.5
*/
public class SolutionBufferedReaderTest {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			int weight = Integer.parseInt(st.nextToken());
			double height = Double.parseDouble(st.nextToken());
			sb.append("#").append(tc).append(" ")
		      .append(name).append(" ")
		      .append(weight).append(" ")
		      .append(height).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

}
