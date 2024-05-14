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
    st = new StringTokenizer(br.readLine());
    int[] arr = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int stt = Integer.parseInt(st.nextToken()) - 1;
      int end = Integer.parseInt(st.nextToken());

      bw.write((arr[end] - arr[stt]) + "\n");
    } 
    br.close();
    
    bw.flush();
    bw.close();
  }
}