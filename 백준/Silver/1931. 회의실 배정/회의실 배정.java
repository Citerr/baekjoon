import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
    int N = Integer.parseInt(br.readLine());
    int[][] meeting = new int[N][2];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      meeting[i][0] = Integer.parseInt(st.nextToken());
      meeting[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(meeting, (e1, e2) -> {
      if (e1[1] == e2[1]) return e1[0] - e2[0];
      else return e1[1] - e2[1]; 
    });

    int RES = 0;
    int begin = 0;
    for (int i = 0; i < N; i++) {
      if (meeting[i][0] >= begin) {
        RES++;
        begin = meeting[i][1];
      }
    } 
 
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(RES + "");
    bw.flush();
    bw.close();
  }
}