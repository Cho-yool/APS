import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i < N; i++){
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        int answer = arr[C-1];
//        System.out.println(Arrays.toString(arr));
        for(int i = 0 ; i < N - C; i++){
//            System.out.println(i);
//            System.out.println(arr[i+C] + " " + arr[i]);
//            System.out.println(arr[i+C] - arr[i]);
            answer = Math.max(answer, arr[i+C] - arr[i]);
        }
        System.out.println(answer);

    }
}