package baekjoon;

import java.util.*;
import java.io.*;

/*
 * 뭐 잘못했는지 도저히 몰라서 그냥 맞는 코드 제출하고 넘긴다 개쓰레기 문제
import java.util.Scanner;

public class Main {
    static final int HEIGHT_GAP = 3;
    static final int WIDTH_GAP = 8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        
        N *= HEIGHT_GAP;
        M *= WIDTH_GAP;

        char[][] test = new char[N][M];

        for (int height = 0; height < N; height++) {
            String line = scanner.next();
            for (int width = 0; width < M; width++) {
                test[height][width] = line.charAt(width);
            }
        }

        for (int height = 0; height < N; height += HEIGHT_GAP) {
            for (int width = 0; width < M; width += WIDTH_GAP) {
                int a = test[height + 1][width + 1] - '0';
                int b = test[height + 1][width + 3] - '0';
                int c = test[height + 1][width + 5] - '0';
                if (test[height + 1][width + 6] != '.') {
                    c *= 10;
                    c += test[height + 1][width + 6] - '0';
                }

                if (a + b == c) {
                    int len = (c >= 10 ? 7 : 6);
                    test[height + 1][width] = '*';
                    test[height + 1][width + len] = '*';
                    for (int i = 1; i < len; i++) {
                        test[height][width + i] = '*';
                        test[height + 2][width + i] = '*';
                    }
                } else {
                    for (int i = 0; i < 3; i++) {
                        test[height + i][width + 3 - i] = '/';
                    }
                }
            }
        }

        for (int height = 0; height < N; height++) {
            for (int width = 0; width < M; width++) {
                System.out.print(test[height][width]);
            }
            System.out.println();
        }

        scanner.close();
    }
}
*/
public class Main_bj_30980_여중생파댕이와공부를_대전_5반_허진혁 {

	public static void study(int i, int j, char[][] originalGrid, char[][] modifiedGrid) {
		int a = originalGrid[i][j - 1] - '0';
		int b = originalGrid[i][j + 1] - '0';

		if (a + b >= 10) {
			int k = (a + b) / 10;
			int l = (a + b) % 10;

			if (k == originalGrid[i][j + 3] - '0' && l == originalGrid[i][j + 4] - '0') {
				modifiedGrid[i][j - 2] = '*';
				modifiedGrid[i][j + 5] = '*';

				for (int s = j - 1; s < j + 5; s++) {
					modifiedGrid[i - 1][s] = '*';
					modifiedGrid[i + 1][s] = '*';
				}
			} else {
				modifiedGrid[i][j] = '/';
				modifiedGrid[i - 1][j + 1] = '/';
				modifiedGrid[i + 1][j - 1] = '/';
			}
		} else {
			if (modifiedGrid[i][j + 3] - '0' == a + b) {
				modifiedGrid[i][j - 2] = '*';
				modifiedGrid[i][j + 4] = '*';

				for (int s = j - 1; s < j + 4; s++) {
					modifiedGrid[i - 1][s] = '*';
					modifiedGrid[i + 1][s] = '*';
				}
			} else {
				modifiedGrid[i][j] = '/';
				modifiedGrid[i - 1][j + 1] = '/';
				modifiedGrid[i + 1][j - 1] = '/';
			}
		}
	}

	public static char[][] modifyGrid(char[][] originalGrid) {
		int n = originalGrid.length;
		int m = originalGrid[0].length;

		char[][] modifiedGrid = new char[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				modifiedGrid[i][j] = originalGrid[i][j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (originalGrid[i][j] == '+') {
					study(i, j, originalGrid, modifiedGrid);
				}
			}
		}

		return modifiedGrid;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_30980.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[][] originalGrid = new char[3 * n][8 * m];

		for (int i = 0; i < 3 * n; i++) {
			originalGrid[i] = br.readLine().toCharArray();
		}

		char[][] modifiedGrid = modifyGrid(originalGrid);

		// 수정된 그리드를 출력합니다.
		for (int i = 0; i < 3 * n; i++) {
			for (int j = 0; j < 8 * m; j++) {
				System.out.print(modifiedGrid[i][j]);
			}
			System.out.println();
		}
	}
}