import java.io.*;
import java.util.*;

public class Main {

	static int[] arr, brr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		
		while(true) {
			String N = br.readLine();
			
			if(N.equals("0")) break;
			arr = new int[N.length()];
			brr = new int[N.length()];
			
			for(int i=0; i<N.length(); i++) {
				arr[i] = N.charAt(i)-'0';
			}
			
			for(int i=0; i<arr.length; i++) {
				brr[arr.length-1-i] = arr[i]; 
			}
			
			String result = "yes";
			for(int i=0; i<arr.length; i++) {
				if(arr[i] != brr[i]) {
					result = "no";
					break;
				}
			}
			sb.append(result).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
	}
}