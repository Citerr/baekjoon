import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static int[] arr;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    int T = Integer.parseInt(br.readLine());
    Label: for (int t = 0; t < T; t++) {
      String p = new String(br.readLine());
      int N = Integer.parseInt(br.readLine());
      String xn = new String( br.readLine() );
      StringTokenizer st = new StringTokenizer( xn.substring(1, xn.length() - 1), "," );

      arr = new int[N];
      for (int n = 0; n < N; n++) arr[n] = Integer.parseInt(st.nextToken());

      int stt = 0;
      int fin = N;
      boolean rev = false;

      int sz = p.length();
      for (int s = 0; s < sz; s++) {
        switch ( p.charAt(s) ) {
          case 'R' -> rev = !rev;
          default -> {
            if ( fin - stt == 0 ) {
              sb.append("error\n");
              continue Label;
            }
            
            if (rev) fin--;
            else stt++;
          }
        }
      }

      sb.append("[");
      if (fin - stt > 0) {
        if (rev) {
          for (int i = fin - 1; i > stt; i--) sb.append(arr[i] + ",");
            sb.append(arr[stt]);
        } 
        else {
          for (int i = stt; i < fin - 1; i++) sb.append(arr[i] + ",");
            sb.append(arr[fin - 1]);
        }
      }
      sb.append("]\n");
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write( sb + "" );
    bw.flush();
    bw.close();
  }
}