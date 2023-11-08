import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,-1,0,1};

    public static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        public Point rotate(Point center){
            int mx = this.x - center.x;
            int my = this.y - center.y;

            return new Point(center.x - my, center.y + mx);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[101][101];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            ArrayList<Point> pointList = new ArrayList<>();

            pointList.add(new Point(x,y));
            board[y][x] = i;
            pointList.add(new Point(x + dx[d], y + dy[d]));
            board[y+dy[d]][x+dx[d]] = i;

            for(int r = 0; r < g; r++){
                Point center = pointList.get(pointList.size()-1);
                for(int z = pointList.size()-2 ; z >=0 ; z--){
                    Point rotatedPoint = pointList.get(z).rotate(center);
                    pointList.add(rotatedPoint);
                    board[rotatedPoint.y][rotatedPoint.x] = i;
                }
            }
        }

        int answer = 0;

        for(int x = 0;x < 100;x++){
            for (int y = 0; y<100 ; y++){
                if(board[y][x] != 0 &&
                    board[y+1][x] != 0 &&
                    board[y][x+1] != 0 &&
                    board[y+1][x+1] != 0
                )answer++;
            }
        }
        System.out.println(answer);
    }

}