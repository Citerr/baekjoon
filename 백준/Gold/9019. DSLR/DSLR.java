import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int goal = Integer.parseInt(st.nextToken());

      HashMap<Integer, Integer> register = new HashMap<>();
      boolean[] visited = new boolean[10000];
      visited[start] = true;

      Queue<Integer> srchQ = new LinkedList<>();
      srchQ.offer(start);
      label: while ( !srchQ.isEmpty() ) {
        int sz = srchQ.size();
        for (int s = 0; s < sz; s++) {
          int num = srchQ.poll();
          //D
          int calc = (2 * num) % 10000;
          if ( !visited[calc] ) {
            visited[calc] = true;
            register.put(calc, num + 10000 * 1);
            if (calc == goal) break label;
            srchQ.offer( calc );
          }
          //S
          calc = num == 0 ? 9999 : num - 1;
          if (!visited[calc]) {
            visited[calc] = true;
            register.put(calc, num + 10000 * 2);
            if (calc == goal) break label;
            srchQ.offer( calc );
          }
          //L
          calc = (num % 1000) * 10 + num / 1000;
          if (!visited[calc]) {
            visited[calc] = true;
            register.put(calc, num + 10000 * 3);
            if (calc == goal) break label;
            srchQ.offer( calc );
          }
          //R
          calc = num / 10 + (num % 10) * 1000;
          if (!visited[calc]) {
            visited[calc] = true;
            register.put(calc, num + 10000 * 4);
            if (calc == goal) break label;
            srchQ.offer( calc );
          }
        }
      }
      
      StringBuilder caseStr = new StringBuilder();
      int key = goal;
      while (key != start) {
        int temp = register.get(key);
        key = temp%10000;
        temp /= 10000;
        if (temp == 1) caseStr.append("D");
        else if ( temp == 2 ) caseStr.append("S");
        else if ( temp == 3 ) caseStr.append("L");
        else /* temp == 4 */ caseStr.append("R");
      }
      caseStr.reverse();
      sb.append(caseStr + "\n");
    }
    
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb + "");
    bw.flush();
    bw.close();
  }
}