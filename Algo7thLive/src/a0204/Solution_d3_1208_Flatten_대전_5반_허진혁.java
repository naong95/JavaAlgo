package a0204;

import java.io.*;
import java.util.*;

public class Solution_d3_1208_Flatten_대전_5반_허진혁 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1208.txt"));
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int[] dumps = new int[100];
			int dumpNum = sc.nextInt();

			for (int i = 0; i < dumps.length; i++) {
				dumps[i] = sc.nextInt();
			}

			int diff = 0;

			for (int i = 0; i < dumpNum; i++) {
				Arrays.sort(dumps);
				dumps[dumps.length - 1]--;
				dumps[0]++;
			}
			Arrays.sort(dumps);
			diff = dumps[dumps.length - 1] - dumps[0];

			System.out.println("#" + test_case + " " + diff);

		}
		sc.close();
	}

}
