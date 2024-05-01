import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    HashMap<String, String> hm1 = new HashMap<>();
    HashMap<String, String> hm2 = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    String ip;

    for (int i = 1; i <= N; i++) {
      ip = br.readLine();
      hm1.put(String.valueOf(i), ip);
      hm2.put(ip, String.valueOf(i));
    }

    for (int i = 0; i < M; i++) {
      ip = br.readLine();
      if (hm1.containsKey(ip)) sb.append(hm1.get(ip) + "\n");
      else if(hm2.containsKey(ip)) sb.append(hm2.get(ip) + "\n");
    }
    br.close();

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(sb));
    bw.flush();
    bw.close(); 
  }
}