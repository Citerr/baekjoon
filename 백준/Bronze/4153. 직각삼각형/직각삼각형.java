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
		while (true) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int[] tri = new int[3];
		    int sum = 0;
		    for (int i = 0; i < 3; i++) {
		        tri[i] = Integer.parseInt(st.nextToken());
		        sum += tri[i];
		    }
		    if (sum == 0) break;
		    Arrays.sort(tri);
		    if( Math.pow(tri[2], 2) == Math.pow(tri[0], 2) + Math.pow(tri[1], 2) ) 
		        bw.write("right\n");
		    else bw.write("wrong\n");
		    
		    bw.flush();
		}
		br.close();
		bw.close();
	}
}