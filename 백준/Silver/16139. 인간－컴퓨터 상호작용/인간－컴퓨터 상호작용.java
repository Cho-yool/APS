import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static class Test{
        String target;
        int start;
        int end;

    }

    public static void main(String[] args) throws IOException{
        String[] str = br.readLine().split("");
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Map<String,int[]> alpList = new HashMap<>();
        for(int t = 0 ; t < T ; t++){
            st = new StringTokenizer(br.readLine());
            String target = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int[] arr;

            if(alpList.containsKey(target)){
                arr = alpList.get(target);
            }else{
                arr = new int[str.length];
                arr[0] = str[0].equals(target) ? 1 : 0;
                for(int i = 1 ; i < str.length; i++){
                    arr[i] = arr[i-1] + (str[i].equals(target)?1:0);
                }
                alpList.put(target,arr);
            }
            sb.append(arr[end] - (start == 0 ? 0 : arr[start-1])).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}