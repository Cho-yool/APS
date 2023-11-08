import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {-1,0,1,0};

    public static int[][] spreadX = new int[4][9];
    public static int[][] spreadY = new int[4][9];
    public static int[] spreadRate = new int[9];

    public static class Pos{
        int x;
        int y;
        int dir = 3;
        int moveCount = 0;
        int moveLength = 1;

        public Pos(int x,int y){
            this.x = x;
            this.y = y;
        }

        public int[] moveSet(){
            int mx = dx[dir] + x;
            int my = dy[dir] + y;

            x = mx;
            y = my;

            moveCount++;
            if(moveCount == moveLength){
                if(dir == 0)dir = 3;
                else dir--;

                if(dir % 2 == 1) moveLength++;
                moveCount = 0;
            }

            return new int[] {x,y};
        }
    }

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        spreadX[0] = new int[] {0,-1,1,-2,-1,1,2,-1,1};
        spreadY[0] = new int[] {-2,-1,-1,0,0,0,0,1,1};
        spreadX[1] = new int[] {2,1,1,0,0,0,0,-1,-1};
        spreadY[1] = new int[] {0,-1,1,-2,-1,1,2,-1,1};
        spreadX[2] = new int[] {0,-1,1,-2,-1,1,2,-1,1};
        spreadY[2] = new int[] {2,1,1,0,0,0,0,-1,-1};
        spreadX[3] = new int[] {-2,-1,-1,0,0,0,0,1,1};
        spreadY[3] = new int[] {0,-1,1,-2,-1,1,2,-1,1};
        spreadRate = new int[] {5,10,10,2,7,7,2,1,1};


        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for(int i = 0; i < N; i++){
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Pos curPos = new Pos((N-1)/2 , (N-1)/2);

        while(curPos.x != 0 || curPos.y != 0){
//            System.out.println(curPos.x + ","+ curPos.y);
//            for(int[] b : board)
//                System.out.println(Arrays.toString(b));
//            System.out.println("---");
            int preX = curPos.x;
            int preY = curPos.y;
            int dir = curPos.dir;

            curPos.moveSet();

            int postX = curPos.x;
            int postY = curPos.y;
            int sand = board[postY][postX];
            board[postY][postX] = 0;
            if(sand == 0) continue;
            int sum = 0;
            for(int i = 0; i < 9; i++){
                int mx = spreadX[dir][i] + postX;
                int my = spreadY[dir][i] + postY;

                int movedSend = (int) (sand * spreadRate[i] / 100);
                sum += movedSend;

                if(mx < 0 || my < 0 || mx >= N || my >= N){
                    answer += movedSend;
                }else{
                    board[my][mx] += movedSend;
                }

            }

            if(postX + dx[dir] < 0 || postY + dy[dir] <0 || postX + dx[dir] >= N || postY + dy[dir] >=N){
                answer += (sand - sum);
            }else{
                board[ postY + dy[dir]][postX + dx[dir]] += sand - sum;
            }
        }
        System.out.println(answer);
    }

}