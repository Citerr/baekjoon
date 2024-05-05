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
    HashMap<String, String> hm = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    
    //Input data
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      hm.put(st.nextToken(), st.nextToken());
    }

    //Query
    for (int i = 0; i < M; i++) {
      String key = br.readLine();
      if (hm.containsKey(key)) sb.append(hm.get(key) + "\n");
    }

    //Output
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(sb));
    bw.flush();
    bw.close(); 
  }
}