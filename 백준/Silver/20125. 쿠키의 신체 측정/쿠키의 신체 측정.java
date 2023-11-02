import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static class Pos{
        int x;
        int y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

         int N = Integer.parseInt(br.readLine());

         Pos heart = new Pos(0,0);

         String[][] board = new String[N][N];
         for(int i = 0; i < N; i++){
             board[i] = br.readLine().split("");
         }
         out:
         for(int y =0 ; y < N; y++){
             for(int x = 0; x < N; x++){
                 if(board[y][x].equals("*")){
                     heart = new Pos(x,y+1);
                     sb.append(y+2).append(" ").append(x+1).append("\n");
                     break out;
                 }
             }
         }

         int leftHand = 0;
         while(heart.x - (leftHand + 1) >= 0 && board[heart.y][heart.x - (leftHand + 1)].equals("*")){
            leftHand++;
         }
        int rightHand = 0;
        while(heart.x + (rightHand + 1) < N && board[heart.y][heart.x + (rightHand + 1)].equals("*")){
            rightHand++;
        }
        int waist = 0;
        while(heart.y + (waist+1) < N && board[heart.y + (waist+1)][heart.x].equals("*")){
            waist++;
        }

        int leftLeg = 0;
        while(heart.y + waist + (leftLeg+1) < N && board[heart.y + waist + (leftLeg+1)][heart.x - 1].equals("*")){
            leftLeg++;
        }

        int rightLeg = 0;
        while(heart.y + waist + (rightLeg+1) < N && board[heart.y + waist + (rightLeg+1)][heart.x + 1].equals("*")){
            rightLeg++;
        }

        sb.append(leftHand).append(" ").append(rightHand).append(" ").append(waist).append(" ").append(leftLeg).append(" ").append(rightLeg);
        System.out.print(sb);
    }
}