import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;


    public static class Balloon{
        int no;
        int contents;
        boolean visited = false;

        public Balloon(int no, int contents){
            this.no = no;
            this.contents = contents;
        }

        @Override
        public String toString() {
            return "Balloon{" +
                    "no=" + no +
                    ", contents=" + contents +
                    ", visited=" + visited +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        ArrayDeque<Balloon> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        Arrays.stream(br.readLine().split(" "))
                .forEach((x)->{

                    dq.addLast(new Balloon(dq.size()+1,Integer.parseInt(x)));
                });
        int count = 1;

        while(count < T){
            Balloon cur = dq.peekFirst();
            cur.visited=true;

            if(cur.contents < 0){
                while(cur.contents != 0){
                    dq.addFirst(dq.pollLast());
                    if(!dq.peekFirst().visited)cur.contents++;
                }
            }else if(cur.contents > 0){
                while(cur.contents != 0){
                    dq.addLast(dq.pollFirst());
                    if(!dq.peekFirst().visited)cur.contents--;
                }
            }

            sb.append(cur.no).append(" ");
            count++;
        }
        sb.append(dq.getFirst().no);
        System.out.println(sb.toString().trim());

    }
}