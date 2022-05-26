package a.a0404;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class Solution_d4_1868_파핑파핑지뢰찾기_대전_5반_허진혁2 {
 
    static int N, res, mCnt[][];
    static char map[][];
    static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }, dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
 
    public static void main(String[] args) throws IOException {
    	System.setIn(new FileInputStream("res/input_d4_1868.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
 
            N = Integer.parseInt(br.readLine());
            res = 0;
            map = new char[N][N];
            mCnt = new int[N][N];
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }
 
            countMine();
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(mCnt[i][j] == 0 && map[i][j] != '*') {
                        click(i, j);
                        res++;
                    }
                }
            }
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(mCnt[i][j] > 0 && map[i][j] != '*') {
                        res++;
                    }
                }
            }
            
            System.out.println("#" + tc + " " + res);
        }
 
    }
 
    private static void click(int x, int y) {
 
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        mCnt[x][y] = -1;
        
        while(!q.isEmpty()) {
            
            Point now = q.poll();
            for (int d = 0; d < 8; d++) {
                int xx = now.x + dx[d];
                int yy = now.y + dy[d];
                if(xx < 0 || xx >= N || yy < 0 || yy >= N 
                        || mCnt[xx][yy] == -1 || map[xx][yy] == '*') continue;
                if(mCnt[xx][yy] == 0) {
                    q.add(new Point(xx, yy));
                }
                mCnt[xx][yy] = -1;
            }
        }
        
    }
    
    private static void countMine() {
        
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if(map[x][y] == '.') {
                    int cnt = 0;
                    for (int d = 0; d < 8; d++) {
                        int xx = x + dx[d];
                        int yy = y + dy[d];
                        if(xx < 0 || xx >= N || yy < 0 || yy >= N || map[xx][yy] != '*') continue;
                        
                        cnt++;
                    }
                    
                    mCnt[x][y] = cnt;
                }
            }
        }
        
    }
 
}