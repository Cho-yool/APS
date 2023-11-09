import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] numList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sumList = new int[N+1];

        sumList[0] = numList[0];
        for(int i = 1; i <= N; i++){
            sumList[i] = sumList[i-1] + numList[i-1];
        }
        int max = 0;
        int maxCount = 0;

        for(int i = 0; i <= N-X; i++){
            int sum = sumList[i+X] - sumList[i];
            if(max < sum){
                max = sum;
                maxCount = 1;
            }else if(max == sum){
                maxCount++;
            }
        }
        if(max == 0){
            System.out.println("SAD");
            return;
        }
        System.out.println(max);
        System.out.println(maxCount);

    }

}