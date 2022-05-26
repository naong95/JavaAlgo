package a.a0203.iorecursive;

import java.io.*;
import java.util.*;

public class Solution_d3_1289_원재의메모리복구_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1289.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			int count = 0;
			for(int j = 0; j < str.length() - 1; j++) {
				if(str.charAt(j) != str.charAt(j+1)) {
					count++;
				}
			}
			if(str.charAt(0) == '1') count++;
			System.out.println("#" + tc + " " + count);
		}
		sc.close();
	}
}