import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
  static HashMap<String, Integer> hm;
  static String[] categ;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    int N = Integer.parseInt(br.readLine());
    String output = new String();

    for (int test = 0; test < N; test++) {
      int M = Integer.parseInt(br.readLine());
      hm = new HashMap<>(); 
      categ = new String[31];
      int index = 0;

      for (int i = 0; i < M; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        String name = st.nextToken();
        if (!hm.containsKey(name)) {
          categ[index++] = name;
          hm.put(name, 1);
        }
        else hm.put(name, hm.get(name) + 1);
      }

      int res = 1;
      for (int i = 0; i < index; i++) {
        res *= hm.get(categ[i]) + 1;
      }

      output += (res - 1) + "\n";
    }
    
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(output);
    bw.flush();
    bw.close();
  }
}