import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;


    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());

        long[] path = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] oil = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long cur = 0;
        long cost = 0;

        for(int i = 0 ; i < N-1; i++){
//            System.out.println(i + " : cur = " + cur + " cost = " + cost);
            if(cur == 0){
                cur +=path[i];
                cost += path[i] * oil[i];

                for(int x = i+1; x < N-1; x++){
                    if(oil[i] > oil[x]){
                        break;
                    }
                    cur +=path[x];
                    cost += path[x] * oil[i];
                }
            }
            cur -= path[i];
        }
        System.out.println(cost);
    }
}