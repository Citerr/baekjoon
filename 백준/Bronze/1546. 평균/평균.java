import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		
		int[] sc = new int[T];
		for (int i = 0; i < T; i++) sc[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(sc);
		
		double sum = 0;
		for (double i : sc) sum += i / sc[T - 1] * 100;
		bw.write(sum/T + "\n");
		bw.flush();
		bw.close();
	}
}