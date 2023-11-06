import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;


    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        Map<String,Boolean> memo = new HashMap<>();

        for(int s = 1; s<= str.length(); s++){
            for(int i = 0; i <= str.length() - s; i++){
                String temp = str.substring(i,i+s);
                if(memo.containsKey(temp))continue;
                memo.put(temp,true);
            }
        }
        sb.append(memo.keySet().size());

        System.out.print(sb);
    }


}