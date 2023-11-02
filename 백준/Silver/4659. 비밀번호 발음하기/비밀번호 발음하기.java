import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static ArrayList<String> moum = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        moum.add("a");
        moum.add("e");
        moum.add("i");
        moum.add("o");
        moum.add("u");

        while(true){
            String str = br.readLine();
            if(str.equals("end"))break;

            if(ruleOne(str) && ruleTwo(str) && ruleThree(str)){
                sb.append("<").append(str).append("> is acceptable.\n");
            }else{
                sb.append("<").append(str).append("> is not acceptable.\n");
            }
        }

        System.out.print(sb);
    }


    public static boolean ruleOne(String str){
        for(String c : str.split("")){
            if(moum.contains(c)){
                return true;
            }
        }
        return false;
    }

    public static boolean ruleTwo(String str){
        int count = 0;
        boolean isMoum = false;

        for(String s : str.split("")){
            if(moum.contains(s)){
                if(isMoum){
                    count++;
                }else{
                    isMoum = true;
                    count = 1;
                }
            }else{
                if(!isMoum){
                    count++;
                }else{
                    isMoum = false;
                    count = 1;
                }
            }
            if(count == 3){
                return false;
            }
        }
        return true;
    }
    public static boolean ruleThree(String str){
        String temp ="";

        for(String s : str.split("")){
            if(s.equals(temp) && !s.equals("e") && !s.equals("o")){
                return false;
            }else{
                temp = s;
            }
        }
        return true;
    }
}