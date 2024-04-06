import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.HashSet;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> arr = new HashSet<>();
		for (int i = 0; i < N; i++) arr.add(Integer.parseInt(st.nextToken()));
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] contain = new int[N];
		for (int i = 0; i < N; i++) contain[i] = Integer.parseInt(st.nextToken());
		br.close();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			if (arr.contains(contain[i])) bw.write("1\n");
			else bw.write("0\n");
		}	
		bw.flush();
		bw.close();
	}
}