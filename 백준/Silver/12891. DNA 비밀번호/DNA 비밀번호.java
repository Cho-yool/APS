import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;


    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int ACount = 0;
        int CCount = 0;
        int GCount = 0;
        int TCount = 0;

        int answer = 0;

        int lo = 0;
        int hi = P;
        for(String s : str.substring(lo,hi).split("")){
            if(s.equals("A"))ACount++;
            else if(s.equals("C"))CCount++;
            else if(s.equals("G"))GCount++;
            else if(s.equals("T"))TCount++;
        }
        if(ACount >= A && CCount >= C && GCount >= G && TCount >= T)answer++;

        for(int i = 1; i <= S-P; i++){



            String s = str.substring(lo + i - 1, lo + i);
            if(s.equals("A"))ACount--;
            else if(s.equals("C"))CCount--;
            else if(s.equals("G"))GCount--;
            else if(s.equals("T"))TCount--;

            s = str.substring(hi+i-1, hi + i);
            if(s.equals("A"))ACount++;
            else if(s.equals("C"))CCount++;
            else if(s.equals("G"))GCount++;
            else if(s.equals("T"))TCount++;

            if(ACount >= A && CCount >= C && GCount >= G && TCount >= T)answer++;

        }
        sb.append(answer);
        System.out.println(sb);
    }

}