import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[][] board;
    public static class Pos{
        int x;
        int y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int count0 = 0;
    public static int count1 = 0;
    public static int count2 = 0;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for(int i = 0; i < N; i++){
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        getQuadTree(N,new Pos(0,0));
        System.out.println(count2);
        System.out.println(count0);
        System.out.println(count1);
    }

    public static void getQuadTree(int size, Pos pos){
        StringBuilder sb = new StringBuilder();

        int init = board[pos.y][pos.x];
        int sum = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j< size; j++){
                sum+=  init == board[pos.y + i][pos.x + j] ? 1 : 0;
                sb.append(board[pos.y + i][pos.x + j]).append(" ");
            }
            sb.append("\n");
        }
//        System.out.println(sb.toString());
//        System.out.println(sum);
//        System.out.println();
        sb = new StringBuilder();
        if(sum == Math.pow(size,2)){
            if(init == 0)count0++;
            else if(init == 1)count1++;
            else if(init == -1)count2++;
        }else{

            getQuadTree(size/3,new Pos(pos.x,pos.y));
            getQuadTree(size/3,new Pos(pos.x + size/3,pos.y));
            getQuadTree(size/3,new Pos(pos.x + size/3*2,pos.y));
            getQuadTree(size/3,new Pos(pos.x,pos.y + size/3));
            getQuadTree(size/3,new Pos(pos.x + size/3,pos.y + size/3));
            getQuadTree(size/3,new Pos(pos.x + size/3*2,pos.y + size/3));
            getQuadTree(size/3,new Pos(pos.x,pos.y + size/3*2));
            getQuadTree(size/3,new Pos(pos.x + size/3,pos.y + size/3*2));
            getQuadTree(size/3,new Pos(pos.x + size/3*2,pos.y + size/3*2));


        }


    }
}