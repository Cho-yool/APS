import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int yCount = 0;
        int xCount = 0;

        for(int i = 0; i < H; i+=N+1){
            yCount++;
        }
        for(int i = 0; i < W; i+=M+1){
            xCount++;
        }
        System.out.println(yCount * xCount);
    }

}