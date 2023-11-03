import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int INF = Integer.MAX_VALUE;
    public static int[] dx = {1,2,2,1,-1,-2,-2,-1};
    public static int[] dy = {-2,-1,1,2,2,1,-1,-2};
    public static class Pos{
        int x;
        int y;
        int count = 0;

        public Pos(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count= count;
        }
        public Pos(String x, String y){
            this.x = Integer.parseInt(x);
            this.y = Integer.parseInt(y);
        }
        public boolean equals(Pos o){
            if(this.x == o.x && this.y == o.y)return true;
            else return false;
        }
    }

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] board=  new int[N][N];
            for(int i = 0 ; i < N; i++){
                Arrays.fill(board[i],INF);
            }

            st = new StringTokenizer(br.readLine());
            Pos start = new Pos(st.nextToken(),st.nextToken());

            st = new StringTokenizer(br.readLine());
            Pos target = new Pos(st.nextToken(),st.nextToken());

            Queue<Pos> qu = new ArrayDeque<>();
            qu.add(start);
            while(!qu.isEmpty()){
                Pos cur = qu.poll();

                if(board[cur.y][cur.x] != INF) continue;

                board[cur.y][cur.x] = cur.count;

                if(cur.equals(target)){
                    sb.append(board[cur.y][cur.x]).append("\n");
                    break;
                }

                for(int i = 0; i < 8; i++){
                    int mx = cur.x + dx[i];
                    int my = cur.y + dy[i];
                    if(mx < 0 || my < 0 || mx >= N || my >= N || board[my][mx] != INF) continue;

                    qu.add(new Pos(mx,my,cur.count+1));
                }
            }

        }

        System.out.print(sb);
    }

}