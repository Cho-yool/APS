import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static class Team implements Comparable<Team>{
        int fifth;
        int score;
        int count = 0;
        int no;

        public Team(int no ,int score){
            this.no = no;
            this.score = score;
        }
        public void addScore(int score){
            this.score+= score;
            count++;
        }
        @Override
        public int compareTo(Team o){
            if(o.score == this.score){
                return this.fifth - o.fifth;
            }
            return this.score - o.score;
        }

        @Override
        public String toString() {
            return "Team{" +
                    "fifth=" + fifth +
                    ", score=" + score +
                    ", count=" + count +
                    ", no=" + no +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        int answer = 0;
        int T = Integer.parseInt(br.readLine());
        String str = br.readLine();

        for(int i = 1; i < T; i++){
            String temp = br.readLine();

            int same = checkSameChar(str,temp);
            if(str.length() == temp.length()){
                if(str.length() == same || str.length() -1 == same){
                    answer++;
                }
            }else{
                if(str.length() - same == 1 && temp.length() == same){
                    answer++;
                }
                if(str.length() - same == 0 && temp.length() -1 == str.length()){
                    answer++;
                }
            }

        }
        sb.append(answer);
        System.out.print(sb);
    }

    public static int checkSameChar(String str1, String str2){
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(int i = 0; i < str1.length(); i++){
            arr1[str1.charAt(i)-'A']++;
        }
        for(int i = 0; i < str2.length(); i++){
            arr2[str2.charAt(i)-'A']++;
        }

        int result = 0;
        for(int i = 0 ; i < 26; i++){
            result += Math.min(arr1[i],arr2[i]);
        }
        return result;
    }
}