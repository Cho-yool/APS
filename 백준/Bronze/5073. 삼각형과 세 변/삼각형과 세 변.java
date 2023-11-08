import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(A == 0)break;

            if(A+B+C <= 2*Math.max(Math.max(A,B),C)){
                sb.append("Invalid").append("\n");
                continue;
            }

            int count = 0;

            if(A == B) count++;
            if(A == C) count++;
            if(B == C) count++;
            if(B == A) count++;
            if(C == A) count++;
            if(C == B) count++;

            if(count == 6){
                sb.append("Equilateral").append("\n");
            }else if(count == 2){
                sb.append("Isosceles").append("\n");
            }else{
                sb.append("Scalene").append("\n");
            }

        }
        System.out.print(sb);
    }

}