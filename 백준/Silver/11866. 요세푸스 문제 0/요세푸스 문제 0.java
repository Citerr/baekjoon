import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> aList = new ArrayList<>();
		for(int i = 0; i < N; i++) aList.add(i + 1);
		br.close();

		int idx = K - 1;
		ArrayList<Integer> res = new ArrayList<>();
		while (N != 0) {
			res.add(aList.remove(idx));
			if (--N == 0) break;
			idx = (idx + K - 1)%N;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write("<");
		N = res.size();
		for (int i = 0; i < N - 1; i++) bw.write(res.get(i) + ", ");
		bw.write(res.get(N - 1) + ">"); 
		bw.flush();
		bw.close();
	}
}