import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[][] board;
    public static class Pos{
        int pos;
        int height;

        public Pos(int pos, int height){
            this.pos = pos;
            this.height = height;
        }

        @Override
        public String toString(){
            return "pos :" + pos + "  height : " + height;
        }
    }


    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if(N == 0)break;

            int[] nums = new int[N];

            for(int i = 0; i < N; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            BigInteger max = new BigInteger("0");

            ArrayDeque<Pos> dq = new ArrayDeque<>();

            dq.addFirst(new Pos(0,nums[0]));
            for(int i = 1 ; i < nums.length; i++){
                if(dq.peekFirst().height < nums[i]){
                    dq.addFirst(new Pos(i,nums[i]));
                }
                else if(dq.peekFirst().height == nums[i]){

                }else{
                    int pos = i;
                    while(!dq.isEmpty() && dq.peekFirst().height > nums[i]){
                        Pos cur = dq.pollFirst();
                        BigInteger num1 = new BigInteger(Integer.toString(i - cur.pos));
                        BigInteger num2 = new BigInteger(Integer.toString(cur.height));
                        BigInteger big = num1.multiply(num2);
                        if(max.compareTo(big) == -1){
                            max = big;
                        }
                        pos = cur.pos;
                    }
                    if(!dq.isEmpty() && dq.peekFirst().height == nums[i]){

                    }else{
                        dq.addFirst(new Pos(pos,nums[i]));
                    }
                }
            }
            while(!dq.isEmpty()){
                Pos cur = dq.pollFirst();
                BigInteger num1 = new BigInteger(Integer.toString(nums.length - cur.pos));
                BigInteger num2 = new BigInteger(Integer.toString(cur.height));
                BigInteger big = num1.multiply(num2);
                if(max.compareTo(big) == -1){
                    max = big;
                }

            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}