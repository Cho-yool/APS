import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;


    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int hi = 0;
        int lo = 0;
        boolean is = true;
        Map<Integer,Integer> memo = new HashMap<>();
        ArrayList<Integer> over = new ArrayList<>();
        memo.put(arr[0],1);

        while(hi>=lo && hi < N){
            int count = 0;
            if(!over.isEmpty()){
                if(memo.get(arr[lo]) == 1){
                    memo.remove(arr[lo]);
                }else{
                    memo.put(arr[lo],memo.get(arr[lo])-1);
                    if(over.contains(arr[lo]) && memo.get(arr[lo]) <= K)
                        over.remove(over.indexOf(arr[lo]));
                }
                lo++;

            }else{
                if(hi == N-1)break;
                hi++;
                if(memo.containsKey(arr[hi])){
                    memo.put(arr[hi],memo.get(arr[hi])+1);
                    if(!over.contains(arr[hi]) && memo.get(arr[hi]) > K)
                        over.add(arr[hi]);
                }else{
                    memo.put(arr[hi],1);
                }
            }



            if(over.isEmpty()){
                answer = Math.max(answer,hi - lo + 1);
            }
        }


        sb.append(answer);
        System.out.print(sb);
    }

}