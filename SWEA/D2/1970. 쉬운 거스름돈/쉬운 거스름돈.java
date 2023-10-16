import java.io.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] money = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int input = Integer.parseInt(br.readLine());
			int[] answer = new int[8];

			for(int i=0; i<8; i++) {
				answer[i] = input/money[i];
				input %= money[i];
			}

			System.out.println("#" + tc);
			for (int i = 0; i < 8; i++) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
		} // tc
	}// main
}