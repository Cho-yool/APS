import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static class Medal implements Comparable<Medal>{
        int gol;
        int sil;
        int bro;
        int no;
        public Medal(int no,int gol, int sil, int bro){
            this.no = no;
            this.gol = gol;
            this.sil = sil;
            this.bro = bro;
        }
        @Override
        public int compareTo(Medal o){
            if(this.gol == o.gol){
                if(this.sil == o.sil){
                    return o.bro - this.bro;
                }
                return o.sil - this.sil;
            }
            return o.gol - this.gol;
        }
    }

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Medal> arr = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr.add(new Medal(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }
        arr.sort(null);
        int rank = 1;
        if(arr.get(0).no == K){
            sb.append(1).append("\n");
        }else{

            for(int i = 1; i < N;i++){
//            System.out.println(arr.get(i).no);
//            System.out.println(arr.get(i).compareTo(arr.get(i-1)));

                if(arr.get(i).compareTo(arr.get(i-1)) > 0){
                    rank = i+1;
                }
                if(K == arr.get(i).no){
                    sb.append(rank).append("\n");
                    break;
                }
            }
        }
        System.out.print(sb);
    }

}