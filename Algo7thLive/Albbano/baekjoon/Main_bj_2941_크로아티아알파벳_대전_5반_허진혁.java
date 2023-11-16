package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_2941_크로아티아알파벳_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_2941.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String[] arr = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		for (int i = 0; i < arr.length; i++) {
			if (str.contains(arr[i])) {
				str = str.replace(arr[i], "*");
			}
		}

		System.out.println(str.length());
		br.close();
	}
}