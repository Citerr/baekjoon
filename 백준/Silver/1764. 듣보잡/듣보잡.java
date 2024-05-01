import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    HashSet<String> hs = new HashSet<>();
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    StringBuilder sb = new StringBuilder();
    String[] dictOrder = new String[M];

    for (int i = 0; i < N; i++)
      hs.add(br.readLine());

    for (int i = 0; i < M; i++) {
      dictOrder[i] = br.readLine();
    }
    br.close();
    Arrays.sort(dictOrder);

    int ctr = 0;
    for (String str : dictOrder) {
      if (hs.contains(str)) {
        sb.append(str + "\n");
        ctr++;
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(ctr + "\n" + String.valueOf(sb));
    bw.flush();
    bw.close(); 
  }
}