package study;

import java.util.*;
import java.io.*;

public class Main_bj_11399_ATM_대전_5반_허진혁 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_11399.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int sum = 0;
		for(int i = 1; i < N; i++) {
			arr[i] += arr[i - 1];
			sum += arr[i];
		}
		sum += arr[0];
		System.out.println(Arrays.toString(arr));
		System.out.println(sum);
		br.close();
	}
}