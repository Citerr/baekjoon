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
    StringBuilder sb = new StringBuilder();
    HashSet<Integer> hs = new HashSet<>();
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      switch (st.nextToken()) {
        case "add": 
          hs.add(Integer.parseInt(st.nextToken()));
          break;
        case "remove": 
          hs.remove(Integer.parseInt(st.nextToken()));
          break;
        case "check": 
          if (hs.contains(Integer.parseInt(st.nextToken()))) sb.append("1\n");
          else sb.append("0\n");
          break;
        case "toggle" :
          int tog = Integer.parseInt(st.nextToken());
          if (hs.contains(tog)) hs.remove(tog);
          else hs.add(tog);
          break;
        case "all": 
          hs.clear();
          for (int j = 1; j <= 20; j++) hs.add(j);
          break;
        default: hs.clear();
      }
    }
    br.close();

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(sb));
    bw.flush();
    bw.close();
  }
}