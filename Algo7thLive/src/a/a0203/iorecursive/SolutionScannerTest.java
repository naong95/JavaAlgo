package a.a0203.iorecursive;

import java.io.*;
import java.util.*;

/*
3
홍길동 65 170.2
손오공 59 159.9
강호동 70 175.5
*/
public class SolutionScannerTest {
	public static void main(String[] args) {
//		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		System.out.println();
		for(int tc = 1; tc <= T; tc++) {
			String name = sc.next();
			int weight = sc.nextInt();
			double height = sc.nextDouble();
			System.out.println("#" + tc + name + " " + weight + " " + height);
		}
		sc.close();
	}

}
