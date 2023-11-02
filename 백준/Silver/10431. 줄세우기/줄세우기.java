import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;


    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int answer = 0;
            ArrayList<Integer> arr = new ArrayList<>();

            for(int i = 0 ; i < 20; i++){
                arr.add(Integer.parseInt(st.nextToken()));
            }

            for(int i = 1; i < 20; i++){
                for(int x = 0; x< i; x++){
                    if(arr.get(x) > arr.get(i)){
                        arr.add(x,arr.remove(i));
                        answer+= i-x;
                        break;
                    }
                }
            }
            sb.append(t).append(" ").append(answer).append("\n");

        }
        System.out.print(sb);

    }

}