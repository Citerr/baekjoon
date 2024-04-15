import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    Deque<Integer> deque = new LinkedList<>();
    int bf = -1;

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      switch (st.nextToken()) {
        case "push_front": 
          deque.offerFirst(Integer.parseInt(st.nextToken()));
          break;
        case "push_back":
          deque.offerLast(Integer.parseInt(st.nextToken()));
          break;
        case "pop_front": 
          if ( !deque.isEmpty() ) bw.write(deque.removeFirst() + "\n");
          else bw.write("-1\n");
          break;
        case "pop_back":
          if ( !deque.isEmpty() ) bw.write(deque.removeLast() + "\n");
          else bw.write("-1\n");
          break;
        case "front": 
          if ( !deque.isEmpty() ) bw.write(deque.peekFirst() + "\n");
          else bw.write("-1\n");
          break;
        case "back":
            if ( !deque.isEmpty() ) bw.write(deque.peekLast() + "\n");
            else bw.write("-1\n");
            break;
        case "empty": 
          if (deque.isEmpty()) bw.write("1\n");
          else bw.write("0\n");
          break;
        default: //size
         bw.write(deque.size() + "\n");
         break;
      }
    }
    br.close();
    bw.flush();
    bw.close();
  }
}