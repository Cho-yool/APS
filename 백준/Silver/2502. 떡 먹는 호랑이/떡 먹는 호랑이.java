import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static class Day{
        int a;
        int b;

        public Day(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "Day{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }


    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Day[] memo = new Day[D+1];
        memo[1] = new Day(1,0);
        memo[2] = new Day(0,1);

        for(int i = 3; i <= D; i++){
            memo[i] = new Day(memo[i-2].a + memo[i-1].a , memo[i-2].b + memo[i-1].b);
        }

        int A = 1;
        int B = 1;

        for(int i = 1; i*memo[D].a <= K; i++){
            if((K - i * memo[D].a) % memo[D].b == 0){
                System.out.println(i);
                System.out.println((K - i * memo[D].a) / memo[D].b);
                return;
            }
        }
    }


}