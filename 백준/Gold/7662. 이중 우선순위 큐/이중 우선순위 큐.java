import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      TreeMap<Integer, Integer> graphic = new TreeMap<>();
      int K = Integer.parseInt(br.readLine());
      for (int k = 0; k < K; k++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        if ( st.nextToken().equals("I") ) {
          int key = Integer.parseInt(st.nextToken());  
          if ( graphic.containsKey( key ) ) graphic.put(key,  graphic.get(key) + 1 );
          else graphic.put(key, 1);
        }
        else { // D
          if ( graphic.isEmpty() ) continue;

          if ( st.nextToken().equals("1") ) {
            if ( graphic.get( graphic.lastKey() ) == 1) graphic.remove( graphic.lastKey() );
            else graphic.put( graphic.lastKey(), graphic.get( graphic.lastKey() ) - 1);
          }
          else { // -1
            if ( graphic.get( graphic.firstKey() ) == 1) graphic.remove( graphic.firstKey() );
            else graphic.put( graphic.firstKey(), graphic.get( graphic.firstKey() ) - 1);
          }
        }
      }

      if ( graphic.isEmpty() ) sb.append("EMPTY\n");
      else sb.append( graphic.lastKey() + " " + graphic.firstKey() + "\n");
    }
    
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb + "");
    bw.flush();
    bw.close();
  }
}