import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    Queue<Integer> queue = new LinkedList<>();
    int bf = -1;

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      switch (st.nextToken()) {
        case "push": 
          bf = Integer.parseInt(st.nextToken());
          queue.offer(bf);
          break;
        case "pop": 
          if ( !queue.isEmpty() ) bw.write(queue.remove() + "\n");
          else bw.write("-1\n");
          break;
        case "front": 
          if ( !queue.isEmpty() ) bw.write(queue.peek() + "\n");
          else bw.write("-1\n");
          break;
        case "back":
            if ( !queue.isEmpty() ) bw.write(bf + "\n");
            else bw.write("-1\n");
            break;
        case "empty": 
          if (queue.isEmpty()) bw.write("1\n");
          else bw.write("0\n");
          break;
        default: //size
         bw.write(queue.size() + "\n");
         break;
      }
    }
    br.close();
    bw.flush();
    bw.close();
  }
}