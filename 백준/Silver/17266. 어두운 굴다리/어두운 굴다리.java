import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] loc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        int height = 1;
        while(true){
            int start = 0;
            boolean isPossible = true;
            for(int i = 0; i < M; i++){
                int min = loc[i] - height;
                int max = loc[i] + height;
                if(start >= min){
                    start = max;
                }else{
                    isPossible = false;
                    break;
                }
            }
            if(isPossible && start >= N) break;
            height++;
        }

        System.out.println(height);
    }

}