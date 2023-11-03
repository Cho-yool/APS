import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;


    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        int answer = 0;
        int member = 0;
        int maxMem = game.equals("Y") ? 1 : game.equals("F") ? 2 : 3;
        Map<String,Boolean> mem = new HashMap<>();

        for(int i = 0; i < T; i++){
            String user = br.readLine();

            if(mem.containsKey(user))continue;

            mem.put(user,true);
            member++;
            if(member == maxMem){
                answer++;
                member = 0;
            }

        }
        sb.append(answer);
        System.out.print(sb);
    }

}