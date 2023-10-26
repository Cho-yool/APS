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

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for(int i = 0; i < N; i++){
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(getQuadTree(N,new Pos(0,0)));
    }

    public static String getQuadTree(int size, Pos pos){
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j< size; j++){
                sum+= board[pos.y + i][pos.x + j];
                sb.append(board[pos.y + i][pos.x + j]).append(" ");
            }
            sb.append("\n");
        }
//        System.out.println(sb.toString());
        sb = new StringBuilder();
        if(sum == 0){
            return "0";
        }else if(sum == Math.pow(size,2)){
            return "1";
        }else{
            sb
                    .append("(")
                    .append(getQuadTree(size/2,new Pos(pos.x,pos.y)))
                    .append(getQuadTree(size/2,new Pos(pos.x + size/2,pos.y)))
                    .append(getQuadTree(size/2,new Pos(pos.x,pos.y + size/2)))
                    .append(getQuadTree(size/2,new Pos( pos.x + size/2,pos.y + size/2)))
                    .append(")")
            ;
            return sb.toString();
        }


    }
}