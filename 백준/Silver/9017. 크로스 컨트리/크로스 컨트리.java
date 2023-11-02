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

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] rank = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] count = new int[201];
            Map<Integer,Team> team = new HashMap<>();

            for(int x : rank){
                count[x]++;
                if(count[x] == 6){
                    team.put(x,new Team(x,0));
                }
            }



            int score = 1;
            for(int i = 0; i < N; i++){
                int cur = rank[i];
                if(!team.containsKey(cur))continue;

                if(team.get(cur).count == 4){
                    team.get(cur).fifth = score;
                    team.get(cur).count = 5;
                }else if(team.get(cur).count<4){
                    team.get(cur).addScore(score);
                }
                score++;
            }

            Team answer = new Team(-1,Integer.MAX_VALUE);

            for(int k : team.keySet()){
                if(team.get(k).count< 5) continue;
                if(answer.compareTo(team.get(k)) > 0){
                    answer = team.get(k);
                }
            }
            sb.append(answer.no).append("\n");
        }
        System.out.print(sb);
    }
}