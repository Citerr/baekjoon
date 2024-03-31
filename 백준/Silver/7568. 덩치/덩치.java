import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] w = new int[N];
		int[] h = new int[N];
		for (int i = 0; i < N; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    w[i] = Integer.parseInt(st.nextToken());
		    h[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		for (int  i = 0; i < N; i++) {
		    int flag = 0;
		    for (int j = 0; j < N; j++) {
		        if (i == j) continue;
		        if (w[i] < w[j] && h[i] < h[j]) flag++;
		    }
		    bw.write(flag + 1 + " ");
		}
		bw.flush();
		bw.close();
	}
}