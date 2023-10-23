import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;


    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for(int i = 0 ; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());

            if(c == 1){
                int num = Integer.parseInt(st.nextToken());
                dq.addFirst(num);
            }else if(c == 2){
                int num = Integer.parseInt(st.nextToken());
                dq.addLast(num);
            }else if(c == 3){
                if(dq.isEmpty()){
                    sb.append(-1);
                }else{
                    sb.append(dq.pollFirst());
                }
                sb.append("\n");
            }else if(c == 4){
                if(dq.isEmpty()){
                    sb.append(-1);
                }else{
                    sb.append(dq.pollLast());
                }
                sb.append("\n");
            }else if(c == 5){
                sb.append(dq.size());
                sb.append("\n");
            }else if(c == 6){
                sb.append(dq.isEmpty() ? 1 : 0);
                sb.append("\n");
            } else if (c == 7) {
                if(dq.isEmpty()){
                    sb.append(-1);
                }else{
                    sb.append(dq.peekFirst());
                }
                sb.append("\n");
            }else if (c == 8) {
                if(dq.isEmpty()){
                    sb.append(-1);
                }else{
                    sb.append(dq.peekLast());
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}