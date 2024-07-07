import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    String str = new String(br.readLine());
    for (int i = 0; i < N; i++) {
      sb.append("IO");
    }
    sb.append("I");
    String Pn = new String( sb.toString() );

    int RES = 0;
    int idx = 0;
    while ( true ) {
      idx = str.indexOf(Pn, idx);
      if (idx++ != -1) RES++;
      else break;
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write( RES + "" );
    bw.flush();
    bw.close();
  }
}