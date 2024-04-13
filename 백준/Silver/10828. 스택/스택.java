import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      switch (st.nextToken()) {
        case "push": 
          stack.push(Integer.parseInt(st.nextToken()));
          break;
        case "pop": {
          if ( !stack.isEmpty() ) bw.write(stack.pop() + "\n");
          else bw.write("-1\n");
          break;
        }
        case "top": {
          if ( !stack.isEmpty() ) bw.write(stack.peek() + "\n");
          else bw.write("-1\n");
          break;
        }
        case "empty": {
          if (stack.isEmpty()) bw.write("1\n");
          else bw.write("0\n");
          break;
        }
        default:
         bw.write(stack.size() + "\n");
         break;
      }
    }
    br.close();
    bw.flush();
    bw.close();
  }
}