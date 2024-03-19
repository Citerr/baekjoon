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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		Label: for (int i = M; i > arr[0]; i--) {
		    int sum = 0;
		    for (int a = 0; a < N; a++) {
		        for (int b = a + 1; b < N; b++) {
		            for (int c = b + 1; c < N; c++) {
		                if (arr[a] + arr[b] + arr[c] == i) {
		                    bw.write(i+"\n");
		                    break Label;
		                }
		            }
		        }
		    }
		}
		bw.flush();
		
		br.close();
		bw.close();
	}
}