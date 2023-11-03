import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static class Score implements Comparable<Score>{
        int score;
        int target = 0;
        public Score(int score){
            this.score=score;
        }
        public Score(int score,int target){
            this.score=score;
            this.target = target;
        }

        @Override
        public int compareTo(Score o){
            if(this.score == o.score)
                return this.target - o.target;
            return o.score - this.score;
        }

        @Override
        public String toString() {
            return "Score{" +
                    "score=" + score +
                    ", target=" + target +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if(N == 0){
            System.out.println(1);
            return;
        }
        PriorityQueue<Score> pq = new PriorityQueue<>();

        pq.add(new Score(S,1));

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            pq.add(new Score(Integer.parseInt(st.nextToken())));
        }

        int count = 1;
        int preNum = 0;
        int rank = 1;
        while(!pq.isEmpty() && count <= P){
            Score cur = pq.poll();


            if(!(preNum == cur.score)){
                rank = count;
            }
            if(cur.target == 1){
                sb.append(rank);
                break;
            }
            count++;
            preNum = cur.score;

            if(pq.isEmpty() || count > P)
                sb.append(-1);
        }

        System.out.print(sb);
    }

}