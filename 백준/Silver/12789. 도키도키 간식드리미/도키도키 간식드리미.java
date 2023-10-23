import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;


    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> line = new ArrayDeque<>();
        ArrayDeque<Integer> stand = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());

        int num = 1;

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(st.nextToken());
            if(num == n){
                line.push(n);
                num++;
            }else{
                while(!stand.isEmpty() && stand.peek() == num){
                    line.push(stand.pop());
                    num++;
                }
                stand.push(n);


            }
        }

        while(!stand.isEmpty()){
            int n = stand.pop();
            if(n == num){
                line.push(n);
                num++;
            }else{
                System.out.println("Sad");
                return;
            }
        }


        System.out.println("Nice");
    }
}