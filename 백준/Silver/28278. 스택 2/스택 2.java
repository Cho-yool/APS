import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;


    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = 0 ; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            switch ( c ){
                case 1 :{
                    int num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    break;
                }
                case 2 :{
                    if(stack.isEmpty()){
                        sb.append(-1);
                    }else{
                        sb.append(stack.pop());
                    }
                    sb.append("\n");
                    break;
                }
                case 3 :{
                    sb.append(stack.size());
                    sb.append("\n");
                    break;
                }
                case 4 : {
                    if(stack.isEmpty()){
                        sb.append(1);
                    }else{
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;
                }
                case 5 :{
                    if(stack.isEmpty()){
                        sb.append(-1);
                    }else{
                        sb.append(stack.peek());
                    }
                    sb.append("\n");
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }
}